package wyjatki;

public class TooManyPatientException extends Exception {

    @Override
    public String getMessage() {
        return "Jest już taki pacjent w rejestrze";
    }
}
