package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderStatistics {

    public static void meanMedianAge() {
        List<Integer> ages = new ArrayList<>();
        ages.add(23);
        ages.add(32);
        ages.add(42);
        ages.add(21);
        ages.add(54);
        ages.add(21);
        ages.add(24);
        ages.add(33);

        Double totalAge = 0D;
        for(Integer age: ages){
            totalAge += age;
        }

        double meanAge = totalAge / ages.size();

       Collections.sort(ages);

       float medianAge = 0F;

       Collections.sort(ages);
       if (ages.size() % 2 == 0) {
           medianAge = ages.get(ages.size() / 2);
       } else {
           int smallerIndex = ages.size() / 2;
           int smallerAge = ages.get(smallerIndex);
           int biggerAge = ages.get(smallerIndex + 1);
           medianAge = (smallerAge + biggerAge) / 2f;
       }

        System.out.println("Mean age " + meanAge);
        System.out.println("Median age " + medianAge);
    }
}
