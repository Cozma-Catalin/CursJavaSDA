package bussiness.service.structures;

import bussiness.dto.structures.DepartmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistance.dao.structures.DepartmentDAO;
import persistance.entities.structures.Department;

@Service
public class DepartmentService {

    @Autowired
    DepartmentDAO departmentDAO;

    public void insertDepartmentDTO(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setName(departmentDTO.getName());
        departmentDAO.insertDepartment(department);
    }

    public int deleteDepartmentByName(String name){
        int result = departmentDAO.deleteDepartmentByName(name);
        return result;
    }

    public int updateDepartmentName(String newName,String name){
        int result = departmentDAO.updateDepartmentName(newName,name);
        return result;
    }
}
