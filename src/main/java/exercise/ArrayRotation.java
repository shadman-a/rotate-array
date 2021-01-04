package exercise;

public class ArrayRotation {

    public static void rotateArray(){
        String[] items = {
                "tree",
                "house",
                "boat",
                "cup",
                "water"
        };
        int rotateBy = 1;
        String[] rotatedItems = new String[items.length];
        for (int i = 0; i< items.length; i++) {
            String item = items[i];
            int newIndex = i + rotateBy;
            newIndex = newIndex % items.length;
            rotatedItems[newIndex] = item;
        }

        System.out.println("Original Array");
        for (String original : items) {
            System.out.println(original);
        }

        System.out.println("================");

        System.out.println("Rotated Array ");
        for (String rotated : rotatedItems) {
            System.out.println(rotated);
        }
    }
}
