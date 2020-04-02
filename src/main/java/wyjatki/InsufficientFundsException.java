package wyjatki;

public class InsufficientFundsException extends Exception {

    @Override
    public String getMessage() {
        return "Nie masz wystarczających środków";
    }

}
