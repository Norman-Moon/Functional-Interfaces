package example.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LambdaPracticeTest {

    // MokitoExtension
    // injectMocks
    // @Spy

    public void setup() {

        MockitoAnnotations.openMocks(this);
    }

    //A mock in mockito is a normal mock in other mocking frameworks (allows you to stub invocations; that is, return specific values out of method calls).
    //
    //A spy in mockito is a partial mock in other mocking frameworks (part of the object will be mocked and part will use real method invocations).


    // @Mock makes an instance variable, u can use these anywhere in the test class
    // A good way of thinking about it is, ur 'mocking' a LambdaPractice class, its not really making a LambdaPractice
    @Mock
    LambdaPractice lambdaPractice;

    // This lenient line should work, not sure why, figure this out yo
    // lenient().when(lambdaPractice.printArray(Arrays.asList(1, 2, 3, 4))).thenReturn("Hello");


    @Test // Chatgpt wrote this test
    void testAddArray() {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 6); // even numbers are 2, 4, 6
        int expectedSum = (2 * 2) + (4 * 2) + (6 * 2); // expected output is 24

        final int returnedInt = LambdaPractice.addArray(arr); // Make sure this matches the actual class with addArray

        assertEquals(expectedSum, returnedInt);

    }

    @Test
    void testPrintArray() {
        final List<Integer> inputArray = Arrays.asList(1, 2, 3, 4);

        final String correctString = "1 2 3 4 ";
        final String resultingString = LambdaPractice.printArray(inputArray);

        assertEquals(correctString, resultingString);
    }

    @Test
    void testNullArray() {

        LambdaPractice.printArray(null);
        assertNull(null);
    }

    @Test
    void testSubtractArray() {
        final List<Integer> inputArray = Arrays.asList(1,3,5,7);
        final int expectedSum = 0;
        final int resultingInt = LambdaPractice.subtractArray(inputArray);
        assertEquals(expectedSum, resultingInt);
    }

    @Test
    void testSubtractArrayEmptyArray() {
        final List<Integer> inputArray = new ArrayList<>();
        final int returnedInt = LambdaPractice.subtractArray(inputArray);
        assertEquals(0, returnedInt);
    }

}

