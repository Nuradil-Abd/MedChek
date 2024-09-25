package medChek.dao.impl;

import medChek.dao.DepartmentDao;
import medChek.dao.GenericDao;
import medChek.dao.HospitalDao;
import medChek.database.Database;
import medChek.exceptions.NotFoundException;
import medChek.models.Department;
import medChek.models.Hospital;


import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao, GenericDao<Department> {
    HospitalDao hospitalDao = new HospitalDaoImpl();

    @Override
    public String add(Long hospitalId, Department department) {
        Hospital hospital = hospitalDao.findHospitalById(hospitalId);
        if (hospital != null) {

            for (Department existingDepartment : hospital.getDepartments()) {
                if (existingDepartment.getDepartmentName().equalsIgnoreCase(department.getDepartmentName())) {
                    return "Department with name " + department.getDepartmentName() + " already exists in the hospital.";
                }
            }
            hospital.getDepartments().add(department);
            return "Department successfully added to the hospital.";
        }
        return "Hospital with ID " + hospitalId + " not found.";
    }


    @Override
    public void removeById(Long id) {
        for (Hospital hospital : Database.hospitals) {

            hospital.getDepartments().removeIf(department -> department.getId().equals(id));
        }
    }


    @Override
    public String updateById(Long id, Department updatedDepartment) {
        for (Hospital hospital : Database.hospitals) {
            for (int i = 0; i < hospital.getDepartments().size(); i++) {
                Department existingDepartment = hospital.getDepartments().get(i);
                if (existingDepartment.getId().equals(id)) {
                    hospital.getDepartments().set(i, updatedDepartment);
                    return "Department successfully updated.";
                }
            }
        }
        return "Department with ID " + id + " not found.";
    }
    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        for (Hospital hospital : Database.hospitals) {
            if(hospital.getId().equals(id)){
                return hospital.getDepartments();
            }
        }
        return null;
    }

    @Override
    public Department findDepartmentByName(String name) {
        for (Hospital hospital : Database.hospitals) {
            for (Department department : hospital.getDepartments()) {
                if (department.getDepartmentName().equalsIgnoreCase(name)) {
                    return department;
                }
            }
        }
       throw new NotFoundException("Department with name " + name + "not found");
    }




}
