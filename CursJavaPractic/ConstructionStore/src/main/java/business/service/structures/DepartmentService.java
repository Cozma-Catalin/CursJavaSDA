package business.service.structures;

import business.dto.structures.DepartmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistance.dao.structures.DepartmentDAO;
import persistance.entities.structures.Department;

@Service
public class DepartmentService {

    @Autowired
    DepartmentDAO departmentDAO;



    public DepartmentDTO findDepartmentDTOByName(String name){
        Department department = departmentDAO.findDepartmentByName(name);
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setName(department.getName());
        return departmentDTO;
    }

    public int deleteDepartmentByName(String name){
        int result = departmentDAO.deleteDepartmentByName(name);
        return result;
    }

    public int renameDepartment(String newName,String name){
        int result = departmentDAO.renameDepartment(newName,name);
        return result;
    }
}
