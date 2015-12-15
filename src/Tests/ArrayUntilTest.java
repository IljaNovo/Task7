import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ArrayUntilTest {

    @Test
    public void testResizeIncreasing() throws Exception {
        int[] array = {1, 2, 3, 4, 5};
        int[] patternAnswer = {1, 2, 3, 4, 5, 0, 0};

        assertTrue(Arrays.equals(patternAnswer, ArrayUntil.resize(array, 7)));
    }

    @Test
    public void testDecreaseIncreasing() throws Exception {
        int[] array = {1, 2, 3, 4, 5};
        int[] patternAnswer = {1, 2, 3};

        assertTrue(Arrays.equals(patternAnswer, ArrayUntil.resize(array, 3)));
    }

    @Test
    public void testNegativeSizeInParams() throws Exception {
        int[] array = {1, 2, 3, 4, 5};
        int[] patternAnswer = {1, 2, 3, 4, 5};

        assertTrue(Arrays.equals(patternAnswer, ArrayUntil.resize(array, -7)));
    }

    @Test
    public void testResizeNullInParams() throws Exception {
        try {
            ArrayUntil.resize(null, -7);
        }
        catch (ArrayNullExeption e) {
            assertTrue(true);
        }
    }
}