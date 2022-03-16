import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PriorityQueueTest {
    static Stream<Arguments> streamProvider() {
//        return Stream.of(
//                Arguments.of(new int[] {5, 3, 2, 6}, new int[] {2, 3, 5, 6}),
//                Arguments.of(new int[] {-5, -3, -2, -6}, new int[] {-6, -5, -3, -2}),
//                Arguments.of(new int[] {-9, 6, -1, 4}, new int[] {-9, -1, 4, 6}),
//                Arguments.of(new int[] {10, -1, -2, 6, 2}, new int[] {-2, -1, 2, 6, 10}),
//                Arguments.of(new int[] {9, 7, 2, 1, 8}, new int[] {1, 2, 7, 8, 9})
//        );

        //Failed
        return Stream.of(
                Arguments.of(new int[] {5, 3, 2, 6}, new int[] {3, 2, 5, 6}),
                Arguments.of(new int[] {-5, -3, -2, -6}, new int[] {-5, -6, -3, -2}),
                Arguments.of(new int[] {-9, 6, -1, 4}, new int[] {-1, -9, 4, 6}),
                Arguments.of(new int[] {10, -1, -2, 6, 2}, new int[] {-1, -2, 2, 6, 10}),
                Arguments.of(new int[] {9, 7, 2, 1, 8}, new int[] {2, 1, 7, 8, 9})
        );
    }

    @ParameterizedTest(name="#{index} - Test with Argument = {0}, {1}")
    @MethodSource("streamProvider")
    public void PriorityQueue_RunTest(int[] random_array, int[] correct_array) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        int[] result = new int[random_array.length];

        //Get input
        for (int i = 0; i < random_array.length; i++)
        {
            pq.add(random_array[i]);
        }

        //Gen output
        for (int i = 0; i < random_array.length; i++)
        {
            result[i] = pq.poll();
        }

        //Check output
        assertArrayEquals(correct_array, result);
    }

    //Exceptions
    @Test
    public void initialTest_IllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new PriorityQueue(-1, null);
        });
    }

    @Test
    public void addTest_NullPointerException() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new PriorityQueue().add(null);
        });
    }

    @Test
    public void offerTest_NullPointerException() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new PriorityQueue().offer(null);
        });
    }
}