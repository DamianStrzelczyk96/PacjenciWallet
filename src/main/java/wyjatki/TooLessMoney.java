package wyjatki;

public class TooLessMoney extends Exception {
    @Override
    public String getMessage() {
        return "Pacjent ma za malo kasy";
    }
}
