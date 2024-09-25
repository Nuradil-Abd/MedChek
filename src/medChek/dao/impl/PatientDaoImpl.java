package medChek.dao.impl;

import medChek.dao.GenericDao;
import medChek.dao.HospitalDao;
import medChek.dao.PatientDao;
import medChek.database.Database;
import medChek.exceptions.NotFoundException;
import medChek.models.Hospital;
import medChek.models.Patient;


import java.util.*;

public class PatientDaoImpl implements PatientDao, GenericDao<Patient> {
    HospitalDao hospitalDao = new HospitalDaoImpl();
    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        Hospital hospital = hospitalDao.findHospitalById(id);
        if(hospital != null){
            hospital.setPatients(patients);
            return "Patients successfully added";
        }
        return "failed ";
    }

    @Override
    public Patient getPatientById(Long id) {
        for (Hospital hospital : Database.hospitals) {
            for (Patient patient : hospital.getPatients()) {
                if(patient.getId().equals(id)){
                    return patient;
                }
            }

        }
       throw new NotFoundException("Patient with id " + id + " not found");
    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {
        Map<Integer,Patient> patientByAge = new HashMap<>();
        for (Hospital hospital : Database.hospitals) {
            for (Patient patient : hospital.getPatients()) {
                int age = patient.getAge();
                patientByAge.put(age,patient);
            }
        }
        return patientByAge;
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        List<Patient> allPatients = new ArrayList<>();

        for (Hospital hospital : Database.hospitals) {
            allPatients.addAll(hospital.getPatients());

        }
        if("asc".equalsIgnoreCase(ascOrDesc)){
            allPatients.sort(Comparator.comparing(Patient::getAge));
        }else if ("desc".equalsIgnoreCase(ascOrDesc)){
            allPatients.sort(Comparator.comparing(Patient::getAge).reversed());
        }else {
            throw new IllegalArgumentException("Invalid order. Use 'asc' or 'desc'");
        }


        return allPatients;
    }


    @Override
    public String add(Long hospitalId, Patient patient) {
        Hospital hospital = hospitalDao.findHospitalById(hospitalId);
        if (hospital != null) {

            for (Patient existingPatient : hospital.getPatients()) {
                if (existingPatient.getId().equals(patient.getId())) {
                    return "Patient with ID " + patient.getId() + " already exists in the hospital.";
                }
            }
            hospital.getPatients().add(patient);
            return "Patient successfully added to the hospital.";
        }
        return "Hospital with ID " + hospitalId + " not found.";
    }


    @Override
    public void removeById(Long id) {
        for (Hospital hospital : Database.hospitals) {

            hospital.getPatients().removeIf(patient -> patient.getId().equals(id));
        }
    }


    @Override
    public String updateById(Long id, Patient updatedPatient) {
        for (Hospital hospital : Database.hospitals) {
            for (int i = 0; i < hospital.getPatients().size(); i++) {
                Patient existingPatient = hospital.getPatients().get(i);
                if (existingPatient.getId().equals(id)) {
                    hospital.getPatients().set(i, updatedPatient);
                    return "Patient successfully updated.";
                }
            }
        }
        return "Patient with ID " + id + " not found.";
    }

}
