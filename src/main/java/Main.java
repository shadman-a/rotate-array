import exercise.OurCircularLinkedList;
import exercise.OurDoublyLinkedList;
import exercise.OurSinglyLinkedList;

import java.io.IOException;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        final Queue<String> lineAtCarwash = new ArrayBlockingQueue<>(200);

        /** Carwash manager watching line */
        new Thread(() -> {
            while(true) {
                System.out.println("Line is " + lineAtCarwash.size() + " long");
                if (lineAtCarwash.size() > 20) {
                    System.out.println("hurry up");
                }
                try {
                    Thread.sleep(3000l);
                } catch (InterruptedException e) { }
            }
        }).start();

        /** Cars arriving at the carwash */
        new Thread(() -> {
            while(true) {
                lineAtCarwash.add("Dodge Ram");
                lineAtCarwash.add("Nissan");
                lineAtCarwash.add("Charger");
                lineAtCarwash.add("Chevy Camero");
                lineAtCarwash.add("Honda Civic");
                lineAtCarwash.add("Buggy");
                lineAtCarwash.add("Jeep");
                try {
                    Thread.sleep(3000l);
                } catch (InterruptedException e) { }
            }
        }).start();

        /** Carwash washing cars */
        new Thread(() -> {
            while (true) {
                if (Math.random() > 0.5) {
                    System.out.println("Tom is washing : " + lineAtCarwash.poll());
                } else {
                    System.out.println("Suzy is washing: " + lineAtCarwash.poll());
                    System.out.println("Sally is washing: " + lineAtCarwash.poll());
                    System.out.println("Barry is washing: " + lineAtCarwash.poll());
                }
                try {
                    Thread.sleep(1000l);
                } catch (InterruptedException e) { }
            }
        }).start();

    }

    public static void stackExample() {
        /** FILO */
//        Stack<String> favoriteClothes = new Stack<>();
//        favoriteClothes.push("jeans");
//        favoriteClothes.push("hoodie");
//        favoriteClothes.push("cap");
//        favoriteClothes.push("cap");
//        favoriteClothes.push("cap");
//        favoriteClothes.push("cap");
//        while(!favoriteClothes.empty()) {
//            System.out.println(favoriteClothes.pop());
//        }

        String[] words = {
                "banana",
                "lion",
                "liger",
                "giraffe",
                "elephant",
                "dog",
                "fish",
                "tiger",
        };

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!stack.empty()) {
                String previous = stack.peek();
                if (previous.length() < word.length()) {
                    stack.push(word);
                } else {
                    printItemsInStack(stack);
                    stack.removeAllElements();
                    stack.push(word);
                }
            } else {
                stack.push(word);
            }
        }

        printItemsInStack(stack);
    }

    private static void printItemsInStack(Stack<String> stack) {
        System.out.println("==========");
        for (Object entry: stack.toArray()) {
            System.out.println(entry);
        }
    }

    public static void doublyLinkedListExample() {
        OurDoublyLinkedList<String> list = new OurDoublyLinkedList<>();
        list.add("Narges");
        list.add("Nazmul");
        list.add("Mustafa");
        list.add("Nate");
        list.add("Benjamin");
        list.add("Dan");
        list.add("Indra");
        list.add("James");
        list.printAllValues();
    }

    public static void ourCircularLinkedListExample() {
        //        OurCircularLinkedList<String> playList = new OurCircularLinkedList<>();
//        playList.add("Fly me to the moon");
//        playList.add("Take Five");
//        playList.add("Boys of Summer");
//        playList.add("Dirty Laundry");
//        playList.add("wonderful life");
//        playList.add("Hells Bells");
//        playList.add("Reptilia");
//        playList.add("Living on a Prayer");
//        playList.printSomeEntries(1000);

        OurSinglyLinkedList<String> ourNames = new OurSinglyLinkedList<>();
        ourNames.add("Narges");
        ourNames.add("Nazmul");
        ourNames.add("Mustafa");
        ourNames.add("Nate");
        ourNames.add("Benjamin");
        ourNames.add("Dan");
        ourNames.add("Indra");
        ourNames.add("James");
        ourNames.printAllValues();

        OurCircularLinkedList<String> ourCircularNames = new OurCircularLinkedList<>(ourNames);
        ourCircularNames.printSomeEntries(300);
    }

    public static void ourSinglyLinkedListExample() {
        OurSinglyLinkedList<String> ourNames = new OurSinglyLinkedList<>();
        ourNames.add("Narges");
        ourNames.add("Nazmul");
        ourNames.add("Mustafa");
        ourNames.add("Nate");
        ourNames.add("Benjamin");
        ourNames.add("Dan");
        ourNames.add("Indra");
        ourNames.add("James");
        ourNames.printAllValues();
    }
}
