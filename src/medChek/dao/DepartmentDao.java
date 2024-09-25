package medChek.dao;

import medChek.models.Department;

import java.util.List;

public interface DepartmentDao {
    List<Department> getAllDepartmentByHospital(Long id);
    Department findDepartmentByName(String name);
}
