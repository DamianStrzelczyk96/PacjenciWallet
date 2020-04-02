import wyjatki.TooManyPatientException;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Patient> patientList = new ArrayList<>();
        patientList.add(new Patient("Jakub", "Dąbrowski", new BigInteger("99087666341"), 123.0, "Idź na badanie"));
        patientList.add(new Patient("Mikołaj", "Romanowski", new BigInteger("12345678910"), 320, "Idź na badanie"));
        patientList.add(new Patient("Jan", "Kowalski", new BigInteger("82345678910"), 700, "Idź na badanie"));

        ApachePOIExcelWrite apachePOIExcelWrite = new ApachePOIExcelWrite();

        apachePOIExcelWrite.createExcel(patientList);

        PatientService patientService = new PatientService(patientList);

        System.out.println(patientService.isRegistered(new BigInteger("99087666341"))); // true

        System.out.println(patientService.isRegistered(new BigInteger("123"))); // false

        System.out.println(patientService.isRegistered("Asd", "Asd")); //false
        System.out.println(patientService.isRegistered("Jakub", "Dąbrowski")); //true

        System.out.println("-------------------------------");
        Patient patient = new Patient("Test", "Kowalski", new BigInteger("82345678910"), 123, "Idź na badanie");
        System.out.println(patientService.isRegistered("Test", "Kowalski")); //false

        patientList.add(patient);

        apachePOIExcelWrite.createExcel(patientList);

        System.out.println(patientService.isRegistered("Test", "Kowalski")); //false
        System.out.println(patientList);
    }
}
