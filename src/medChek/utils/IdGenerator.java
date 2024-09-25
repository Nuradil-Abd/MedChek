package medChek.utils;

public class IdGenerator {

    private static Long genDepartment = 0L;
    private static Long genDoctor = 0L;
    private static Long genHospital = 0L;
    private static Long genPatient = 0L;

    public static Long genDepartment() {
        genDepartment++;
        return genDepartment;
    }
    public static Long genGenDoctor() {
        genDoctor++;
        return genDoctor;
    }
    public static Long genGenHospital() {
        genHospital++;
        return genHospital;
    }
    public static Long genPatient() {
        genPatient++;
        return genPatient;
    }


}
