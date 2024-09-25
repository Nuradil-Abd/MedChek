package medChek.service.impl;

import medChek.dao.DepartmentDao;
import medChek.dao.GenericDao;
import medChek.dao.impl.DepartmentDaoImpl;
import medChek.models.Department;
import medChek.service.DepartmentService;
import medChek.service.GenericService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService, GenericService<Department> {
    DepartmentDao departmentDao = new DepartmentDaoImpl();

    private final  GenericDao<Department> genericDao  = new DepartmentDaoImpl();

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        return departmentDao.getAllDepartmentByHospital(id) ;

    }

    @Override
    public Department findDepartmentByName(String name) {
        return departmentDao.findDepartmentByName(name);
    }


    @Override
    public String add(Long hospitalId, Department department) {
        return genericDao.add(hospitalId,department);
    }

    @Override
    public void removeById(Long id) {
        genericDao.removeById(id);
    }

    @Override
    public String updateById(Long id, Department department) {
        return genericDao.updateById(id, department);
    }
}
