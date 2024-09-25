package medChek.database;

import medChek.enums.Gender;
import medChek.models.Department;
import medChek.models.Doctor;
import medChek.models.Hospital;
import medChek.models.Patient;

import java.util.LinkedList;
import java.util.List;

public class Database {

    public static List<Hospital> hospitals = new LinkedList<>(List.of(
            new Hospital( "City Hospital", "Ibraimova 33", new LinkedList<>(), new LinkedList<>(), new LinkedList<>()),
            new Hospital( "County Hospital", "Moskovskaya 123", new LinkedList<>(), new LinkedList<>(), new LinkedList<>()),
            new Hospital( "General Hospital", "Logvinenko 45", new LinkedList<>(), new LinkedList<>(), new LinkedList<>())

    ));

    static {


            Department cardiology = new Department( "Cardiology", new LinkedList<>());
            Department neurology = new Department( "Neurology", new LinkedList<>());

            Doctor doctor1 = new Doctor( "Akyl", "Damirbekov", medChek.enums.Gender.MALE, 10);
            Doctor doctor2 = new Doctor( "Alina", "Mambetalieva", medChek.enums.Gender.FEMALE, 5);
            Doctor doctor3 = new Doctor( "Akylay", "Baktybekova", medChek.enums.Gender.FEMALE, 7);
            Doctor doctor4 = new Doctor( "Aslan", "Aliev", medChek.enums.Gender.MALE, 5);

            Patient patient1 = new Patient( "Aliya", "Turusbekova", 30, medChek.enums.Gender.FEMALE);
            Patient patient2 = new Patient( "Bektur", "Janywbekov", 45, medChek.enums.Gender.MALE);
            Patient patient3 = new Patient( "Atai", "Abdyrazakov", 19, medChek.enums.Gender.MALE);
            Patient patient4 = new Patient( "Baysalbek", "Dastanov", 33, medChek.enums.Gender.MALE);
            Patient patient5 = new Patient( "Kaytar", "Nurtas", 28, medChek.enums.Gender.MALE);
            Patient patient6 = new Patient( "Daliya", "Atabekova", 26, Gender.FEMALE);


            cardiology.getDoctors().add(doctor1);
            cardiology.getDoctors().add(doctor3);
            neurology.getDoctors().add(doctor2);
            neurology.getDoctors().add(doctor4);




            hospitals.getFirst().getDepartments().add(cardiology);
            hospitals.getFirst().getDepartments().add(neurology);
            hospitals.getFirst().getDoctors().add(doctor1);
            hospitals.getFirst().getDoctors().add(doctor2);
            hospitals.getFirst().getDoctors().add(doctor3);
            hospitals.getFirst().getDoctors().add(doctor4);


            hospitals.getFirst().getPatients().add(patient1);
            hospitals.getFirst().getPatients().add(patient2);
            hospitals.get(1).getPatients().add(patient3);
            hospitals.get(1).getPatients().add(patient4);
            hospitals.get(2).getPatients().add(patient5);
            hospitals.get(2).getPatients().add(patient6);

    }
}
