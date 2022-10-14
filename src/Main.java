import java.util.Arrays;
import java.util.Random;

/**
 * Created by Mihran Galstyan
 * All rights reserved
 */
public class Main {
    public static void main(final String[] args) {
        int[] array = new int[40];

        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(1, 9);
        }
        System.out.println("Source array of random numbers");
        System.out.println(Arrays.toString(array));

        int[][] result = getUniqueElements(array);

        System.out.println("Unique elements");
        for (int i = 0; i < result[0].length; i++) {
            System.out.print(result[0][i] + "\t");
        }
        System.out.println();
        System.out.println("Elements count");
        for (int i = 0; i < result[0].length; i++) {
            System.out.print(result[1][i] + "\t");
        }
    }

    private static int[][] getUniqueElements(int[] array) {
        int[] uniqueElements = new int[array.length];
        int[] elementsCount = new int[array.length];
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            if (!isUnique(current, uniqueElements)) {
                uniqueElements[index] = current;
                int count = 1;

                for (int j = i + 1; j < array.length; j++) {
                    if (array[j] == current) {
                        count++;
                    }
                }
                elementsCount[index++] = count;
            }
        }

        int[][] result = new int[2][index];

        for (int i = 0; i < index; i++) {
            result[0][i] = uniqueElements[i];
            result[1][i] = elementsCount[i];
        }
        return result;
    }


    private static boolean isUnique(int value, int[] array) {
        for (final int i : array) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }
}
