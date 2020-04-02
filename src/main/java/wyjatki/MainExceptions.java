package wyjatki;

import java.util.ArrayList;
import java.util.List;

public class MainExceptions {

    public static void main(String[] args) {
        List<Integer> arrayOfInts = new ArrayList<>();
        arrayOfInts.add(1);
        arrayOfInts.add(6);
        arrayOfInts.add(9);
        arrayOfInts.add(10);
        try {
            for (int i = 0; i < 5; i++){
                System.out.println(arrayOfInts.get(i));
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("ojoj przekroczyłeś zakres tablicy");
        }
        System.out.println("Ale program nadal działą!");
    }
}
