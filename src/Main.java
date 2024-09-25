import medChek.service.impl.DepartmentServiceImpl;
import medChek.service.impl.DoctorServiceImpl;
import medChek.service.impl.HospitalServiceImpl;
import medChek.service.impl.PatientServiceImpl;

public class Main {
    public static void main(String[] args) {
        DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
        DoctorServiceImpl doctorService = new DoctorServiceImpl();
        HospitalServiceImpl hospitalService = new HospitalServiceImpl();
        PatientServiceImpl patientService = new PatientServiceImpl();


        System.out.println(hospitalService.getAllHospital());
        System.out.println("~~~~~~~~~~~~~~~~");
        
        departmentService.removeById(2L);



    }
}