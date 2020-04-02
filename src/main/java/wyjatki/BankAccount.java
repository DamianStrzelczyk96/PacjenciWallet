package wyjatki;

public class BankAccount {

    private Person owner;
    private Double amount;

    public BankAccount(Person person) {
        owner = person;
        amount = 0.0;
    }

    public void deposit(double money) {
        amount += money;
    }

    public void withdraw(double money) throws  InsufficientFundsException {
        if(money>amount){
            throw new InsufficientFundsException();
        }
        else
            amount -=money;
    }

    public Double getAmount() {
        return amount;
    }

    public static void main(String[] args) {
        BankAccount bankAccount =  new BankAccount(new Person("Jakub","Dąbrowski","8123456"));
        bankAccount.deposit(100);
        System.out.println(bankAccount.getAmount());

        try {
            bankAccount.withdraw(1000);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
