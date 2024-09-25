import medChek.enums.Gender;
import medChek.models.Department;
import medChek.models.Hospital;
import medChek.models.Patient;
import medChek.service.impl.DepartmentServiceImpl;
import medChek.service.impl.DoctorServiceImpl;
import medChek.service.impl.HospitalServiceImpl;
import medChek.service.impl.PatientServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
        DoctorServiceImpl doctorService = new DoctorServiceImpl();
        HospitalServiceImpl hospitalService = new HospitalServiceImpl();
        PatientServiceImpl patientService = new PatientServiceImpl();
        DepartmentServiceImpl departmentService = new DepartmentServiceImpl();


        Hospital hospital = new Hospital("New Health Center", "New Street 101", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        System.out.println(hospitalService.addHospital(hospital));



        Department department1 = new Department("Surgery", new ArrayList<>());
        System.out.println("Add department");
        System.out.println(departmentService.add(1L, department1));


        Patient patient7 = new Patient( "Adilet", "Abdyrazakov",29, Gender.MALE);
        Patient patient8 = new Patient( "Akylai", "Abdyrazakova",33, Gender.FEMALE);


        System.out.println("All Hospitals:");
        System.out.println(hospitalService.getAllHospital());
        System.out.println("~~~~~~~~~~~~~~~~");

        departmentService.removeById(2L);

        System.out.println("Departments in City Hospital:");
        departmentService.getAllDepartmentByHospital(1L).forEach(department -> System.out.println(department.getDepartmentName()));



        List<Patient> patients = new ArrayList<>();
        patients.add(patient7);
        patients.add(patient8);
        System.out.println(patientService.addPatientsToHospital(1L, patients));



            System.out.println("Patient by ID (1): " + patientService.getPatientById(7L));


        System.out.println("Update 7 patient  age ");
        patient7.setAge(40);
        System.out.println(patientService.updateById(7L, patient7));
        System.out.println(patientService.getPatientById(7L));

        System.out.println("remove patient by id");
            patientService.removeById(123L);

        System.out.println("sort patient by age  ASC");

        patientService.sortPatientsByAge("asc").forEach(patient -> System.out.println(patient.getFirstName() + " - Age: " + patient.getAge()));
    }




}
