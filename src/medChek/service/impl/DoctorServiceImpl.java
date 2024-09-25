package medChek.service.impl;

import medChek.dao.DoctorDao;
import medChek.dao.GenericDao;
import medChek.dao.impl.DoctorDaoImpl;
import medChek.models.Doctor;
import medChek.service.DoctorService;
import medChek.service.GenericService;

import java.util.List;

public class DoctorServiceImpl implements DoctorService, GenericService<Doctor> {
    DoctorDao doctorDao = new DoctorDaoImpl();
    private final GenericDao<Doctor> genericDao = new DoctorDaoImpl();





    @Override
    public Doctor findDoctorById(Long id) {
        return doctorDao.findDoctorById(id);
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        return doctorDao.assignDoctorToDepartment(departmentId,doctorsId);
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        return doctorDao.getAllDoctorsByHospitalId(id);
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        return doctorDao.getAllDoctorsByDepartmentId(id);
    }

    @Override
    public String add(Long hospitalId, Doctor doctor) {
        return genericDao.add(hospitalId, doctor);
    }

    @Override
    public void removeById(Long id) {
        genericDao.removeById(id);
    }

    @Override
    public String updateById(Long id, Doctor doctor) {
        return genericDao.updateById(id, doctor);
    }
}
