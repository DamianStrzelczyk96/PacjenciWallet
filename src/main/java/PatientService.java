import lombok.AllArgsConstructor;
import lombok.Data;
import wyjatki.TooLessMoney;
import wyjatki.TooManyPatientException;

import java.math.BigInteger;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@AllArgsConstructor
public class PatientService {

    private List<Patient> patientList;

    public boolean isRegistered(BigInteger pesel) {
        boolean isRegistered = false;

        for (Patient patient : patientList) {
            if (patient.getPesel().equals(pesel)) {
                isRegistered = Boolean.TRUE;
            }
        }
        return isRegistered;
    }

    public boolean isRegistered(String name, String surname) {
        boolean isRegistered = false;

        for (Patient patient : patientList) {
            if (patient.getName().equals(name) && patient.getSurname().equals(surname)) {
                isRegistered = Boolean.TRUE;
            }
        }
        return isRegistered;
    }

    public Patient findPatientOrNull(String name, String surname) {
        Patient patientTemp = null;

        for (Patient patient : patientList) {
            if (patient.getName().equals(name) && patient.getSurname().equals(surname)) {
                patientTemp = patient;
            }
        }
        return patientTemp;
    }

    public Patient findPatientOrNull(BigInteger pesel) {
        Patient patientTemp = null;

        for (Patient patient : patientList) {
            if (patient.getPesel().equals(pesel)) {
                patientTemp = patient;
            }
        }

        return patientTemp;
    }

    public void  koronaWirusService(int koszt) throws TooLessMoney {
        Random random = new Random();

        List<String> choryLubnie= new ArrayList();
        choryLubnie.add("Wynik testu na obecność korona wirusa pozytywny");
        choryLubnie.add("Wynik testu na obecność korona wirusa negatywny ");
        Patient patientTemp = null;
        List<Patient>withMoney = new ArrayList<>();
        List<Patient>withNoMoney = new ArrayList<>();
        for (Patient patient : patientList) {
            double zmienna;
            zmienna = patient.getWallet();
            if (zmienna>koszt){
                withMoney.add(patient);
            }else{
                withNoMoney.add(patient);
            }
        }
        System.out.println("pacjenci z kasa :\n" + withMoney);
        System.out.println("pacjenci bez kasy :\n" + withNoMoney);

        for (Patient patient: withMoney) {
            double kasa;
            kasa  = patient.getWallet();
            if (koszt>kasa){
                throw new TooLessMoney();

            }
            Integer losowyIndex = random.nextInt(2);
            kasa = kasa - koszt;
            patient.setWallet(kasa);
           patient.setKoronawirus(choryLubnie.get(losowyIndex));
//i śmiga elegancko :) problem byłz tym konfigiem właśnie że trzeba było usunąć stary i odpalić

        }
        for (Patient patient :
                withNoMoney) {
            patient.setKoronawirus("Nie stać Cię na test - GIŃ");

        }
        System.out.println("pacjenci po zabiegu :\n" + withMoney);
        System.out.println(patientList);
    }
}
