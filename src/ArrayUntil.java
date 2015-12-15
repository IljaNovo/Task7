import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class ArrayUntil {

    public static  <T> T[] filter(T[] array, Predicate<? super T> pred) {
        if (array == null) {
            return null;
        }

        T[] foundItems = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length);
        int countElems = 0;

        for (int i = 0; i < foundItems.length; ++i) {
            if (pred.checkCondition(array[i])) {
                foundItems[countElems++] = array[i];
            }
        }
        T[] foundItemsCopy = null;

        if (foundItems.length != countElems) {
            foundItemsCopy = Arrays.copyOfRange(foundItems, 0, countElems);
        }
        return foundItemsCopy;
    }

    public static int[] resize(int[] elems, int newSize) throws ArrayNullException {
        if (elems == null) {
            throw new ArrayNullException();
        }

        if (newSize == elems.length || newSize < 0) {
            return  elems.clone();
        }
        return Arrays.copyOf(elems,  newSize);
    }

    public static boolean compare(int[] arrayFirst, int[] arraySecond) {
        if (arrayFirst == null || arraySecond == null) {
            return false;
        }
        if (arrayFirst.length != arraySecond.length) {
            return false;
        }
        return equals(arrayFirst, arraySecond);
    }

    private static boolean equals(int[] arrayFirst, int[] arraySecond) {
        boolean[] viewedItems = new boolean[arraySecond.length];
        int countSimilarItems = 0;

        for(int i = 0; i < arrayFirst.length; ++i) {
            for (int j = 0; j < arraySecond.length; ++j) {

                if ( (!viewedItems[j]) && (arrayFirst[i] == arraySecond[j]) ) {
                    viewedItems[j] = true;
                    ++countSimilarItems;
                    break;
                }
            }
        }
        if (countSimilarItems == arrayFirst.length) {
            return true;
        }
        else {
            return false;
        }
    }

    public static int[] shuffle(int[] array, int countMixings) {
        if (array == null) {
            return new int[0];
        }
        int[] mixingsArray = array.clone();
        Random r = new Random();
        int temp = 0;
        int indexFirstItem = 0;
        int indexSecondItem = 0;

        for (int i = 0; i < countMixings; ++i) {
            indexFirstItem = r.nextInt(mixingsArray.length - 1);
            indexSecondItem = r.nextInt(mixingsArray.length - 1);

            temp = mixingsArray[indexFirstItem];
            mixingsArray[indexFirstItem] = mixingsArray[indexSecondItem];
            mixingsArray[indexSecondItem] = temp;
        }
        return mixingsArray;
    }

    public static String print(int[] array) {
        if (array == null) {
            return "";
        }
        String answer = "";

        for (int i = 0; i < array.length - 1; ++i) {
            answer += String.format("array[%d] = %d;%n", i, array[i]);
        }
        answer += String.format("array[%d] = %d.", array.length - 1, array[array.length - 1]);

        return answer;
    }
}