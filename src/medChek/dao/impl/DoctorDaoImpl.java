package medChek.dao.impl;


import medChek.dao.DoctorDao;
import medChek.dao.GenericDao;
import medChek.dao.HospitalDao;
import medChek.database.Database;
import medChek.exceptions.NotFoundException;
import medChek.models.Department;
import medChek.models.Doctor;
import medChek.models.Hospital;

import java.util.ArrayList;
import java.util.List;

public class DoctorDaoImpl implements DoctorDao, GenericDao<Doctor> {
    HospitalDao hospitalDao = new HospitalDaoImpl();

    @Override
    public String add(Long hospitalId, Doctor doctor) {
        Hospital hospital = hospitalDao.findHospitalById(hospitalId);
        if (hospital != null) {

            for (Doctor existingDoctor : hospital.getDoctors()) {
                if (existingDoctor.getId().equals(doctor.getId())) {
                    return "Doctor with ID " + doctor.getId() + " already exists in the hospital.";
                }
            }
            hospital.getDoctors().add(doctor);
            return "Doctor successfully added to the hospital.";
        }
        return "Hospital with ID " + hospitalId + " not found.";
    }


    @Override
    public void removeById(Long id) {
        for (Hospital hospital : Database.hospitals) {
            hospital.getDoctors().removeIf(doctor -> doctor.getId().equals(id));
        }
    }


    @Override
    public String updateById(Long id, Doctor updatedDoctor) {
        for (Hospital hospital : Database.hospitals) {
            for (int i = 0; i < hospital.getDoctors().size(); i++) {
                Doctor existingDoctor = hospital.getDoctors().get(i);
                if (existingDoctor.getId().equals(id)) {
                    hospital.getDoctors().set(i, updatedDoctor);
                    return "Doctor successfully updated.";
                }
            }
        }
        return "Doctor with ID " + id + " not found.";
    }


    @Override
    public Doctor findDoctorById(Long id) {
        for (Hospital hospital : Database.hospitals) {
            for (Doctor doctor : hospital.getDoctors()) {
                if (doctor.getId().equals(id)) {
                    return doctor;
                }
            }
        }
        throw new NotFoundException("Doctor with id " + id + " not found!");
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        Department department = null;
        Long hospitalID = null;
        for (Hospital hospital : Database.hospitals) {
            for (Department hospitalDepartment : hospital.getDepartments()) {
                if (hospitalDepartment.getId().equals(departmentId)) {
                    department = hospitalDepartment;
                    hospitalID = hospital.getId();
                    break;
                }
            }
            if(department != null) break;
        }
        if (department == null) {
            return "Department with the given ID not found.";
        }
        for (Long doctorId : doctorsId) {
            Doctor doctor = null;
            for (Doctor doc : hospitalDao.findHospitalById(hospitalID).getDoctors()) {
                if (doc.getId().equals(doctorId)){
                    doctor = doc;
                    break;
                }
            }
            if(doctor != null){
                if(!department.getDoctors().contains(doctor)){
                    department.getDoctors().add(doctor);
                }else {
                    return "Doctor with ID " + doctorId + " is already assigned to the department";
                }
            }else {
                return "Doctor with ID " + doctorId + " not found in the hospital";
            }
        }

        return "Doctors successfully assigned to the department";
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        List<Doctor> doctorsInHospital = new ArrayList<>();
        Hospital hospital = hospitalDao.findHospitalById(id);
        if (hospital != null) {
            doctorsInHospital.addAll(hospital.getDoctors());
        }
        return doctorsInHospital;
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        List<Doctor> doctorsInDepartment = new ArrayList<>();

        for (Hospital hospital : Database.hospitals) {
            for (Department department : hospital.getDepartments()) {
                if (department.getId().equals(id)) {
                    doctorsInDepartment.addAll(department.getDoctors());
                    break;
                }
            }
        }
        return doctorsInDepartment;
    }


}
