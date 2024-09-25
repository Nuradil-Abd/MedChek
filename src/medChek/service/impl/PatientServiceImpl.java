package medChek.service.impl;

import medChek.dao.GenericDao;
import medChek.dao.PatientDao;
import medChek.dao.impl.PatientDaoImpl;
import medChek.models.Patient;
import medChek.service.GenericService;
import medChek.service.PatientService;

import java.util.List;
import java.util.Map;

public class PatientServiceImpl implements PatientService, GenericService<Patient> {
    PatientDao patientDao = new PatientDaoImpl();
    private final GenericDao<Patient> genericDao = new PatientDaoImpl();




    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        return patientDao.addPatientsToHospital(id, patients);
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientDao.getPatientById(id);
    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {
        return patientDao.getPatientByAge();
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        return patientDao.sortPatientsByAge(ascOrDesc);
    }

    @Override
    public String add(Long hospitalId, Patient patient) {
        return genericDao.add(hospitalId, patient);
    }

    @Override
    public void removeById(Long id) {
        genericDao.removeById(id);
    }

    @Override
    public String updateById(Long id, Patient patient) {
        return genericDao.updateById(id, patient);
    }
}
