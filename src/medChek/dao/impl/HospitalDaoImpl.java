package medChek.dao.impl;

import medChek.dao.HospitalDao;
import medChek.database.Database;
import medChek.exceptions.NotFoundException;
import medChek.models.Hospital;
import medChek.models.Patient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HospitalDaoImpl implements HospitalDao {
    @Override
    public String addHospital(Hospital hospital) {
        Database.hospitals.add(hospital);
        return "Successfully added";
    }

    @Override
    public Hospital findHospitalById(Long id) {
        for (Hospital hospital : Database.hospitals) {
            if(hospital.getId().equals(id)){
                return hospital;
            }
        }
        throw new NotFoundException("Hospital with id " + id + " not found");
    }

    @Override
    public List<Hospital> getAllHospital() {

        return Database.hospitals;
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        Hospital targetHospital = findHospitalById(id);
        if (targetHospital != null) {
            return targetHospital.getPatients();
        }
        throw new NotFoundException("Hospital with id " + id + " not found");
    }

    @Override
    public String deleteHospitalById(Long id) {
        Hospital targetHospital = findHospitalById(id);
        if(targetHospital != null){
            Database.hospitals.remove(targetHospital);
            return "Hospital with " + id + "successfully deleted!";
        }
        return "failed to delete hospital";
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        Map<String,Hospital> hospitalsByAddress = new HashMap<>();
        for (Hospital hospital : Database.hospitals) {
            if(hospital.getAddress().equalsIgnoreCase(address)){
                hospitalsByAddress.put(address,hospital);
            }
        }
        return hospitalsByAddress;
    }
}
