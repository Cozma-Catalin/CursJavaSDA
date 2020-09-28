package persistance.dao.structures;

import bussiness.config.HibernateUtil;
import bussiness.dto.products.chemicals.CementDTO;
import bussiness.dto.structures.DepartmentDTO;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import persistance.entities.products.Chemicals.Cement;
import persistance.entities.structures.Department;


@Repository
public class DepartmentDAO {


    public void insertDepartment(Department department) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(department);
        session.getTransaction().commit();
        session.close();
    }

    public void extractDepartmentDTOFromCement(CementDTO cementDTO, Cement cement) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setName(cement.getDepartment().getName());
        cementDTO.setDepartmentDTO(departmentDTO);
    }


    public Department findDepartmentByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findDepartmentQuery = session.createNamedQuery("findDepartmentByName");
        findDepartmentQuery.setParameter("name", name);
        Department departmentFound = (Department) findDepartmentQuery.uniqueResult();
        session.getTransaction().commit();
        session.close();
        Department department = new Department();
        if (departmentFound == null) {
            department.setName(" ");
            return department;
        } else
            return departmentFound;
    }

    public int deleteDepartmentByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deleteDepartmentByNameQuery = session.createNamedQuery("deleteDepartmentByName");
        deleteDepartmentByNameQuery.setParameter("name", name);
        int result = deleteDepartmentByNameQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public int updateDepartmentName(String newName,String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query updateDepartmentNameQuery = session.createNamedQuery("updateDepartmentName");
        updateDepartmentNameQuery.setParameter("newName",newName);
        updateDepartmentNameQuery.setParameter("name",name);
        int result = updateDepartmentNameQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }
}

