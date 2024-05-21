/**
 * Purpose:           Part1. String Calculator Test <br />
 * Data Submitted:    10/3/2024 <br />
 * Assignment Number: Assigment 1 <br />
 * Course Name:       COSC 603 <br />
 * Instructor Name:   Michael Grzesina <br />
 * File Path:         StringCalculatorTest.java<br />
 * @author Laura Sofia Buitrago Cardona <br />
 * @version 1.0.0 <br />
 */
import static org.junit.jupiter.api.Assertions.*;
class StringCalculatorTest {

//    REQUIREMENT 1: The method can take 0, 1 or 2 numbers separated by comma (,).
//    @org.junit.jupiter.api.Test
//    void whenMoreThan2NumbersAreUsed() {
//        assertThrows(RuntimeException.class,
//                () -> StringCalculator.add("1,2,3"));
//    }
    @org.junit.jupiter.api.Test
    void when2NumberAreUsedException(){
        StringCalculator.add("1,2");
        assertTrue(true);
    }

//    @org.junit.jupiter.api.Test
//    void whenNonNumberIsUsed(){
//        assertThrows(RuntimeException.class,
//                () ->StringCalculator.add("1,X"));
//    }

    //REQUIREMENT 2: For an empty string the method will return 0
    @org.junit.jupiter.api.Test
    void whenEmptyStringIsUsedReturn0(){
        assertEquals(0, StringCalculator.add(""));
    }

    //REQUIREMENT 3: Method will return their sum of numbers
    @org.junit.jupiter.api.Test
    void whenOneNumberIsUsedReturnTheSameNumber(){
        assertEquals(3, StringCalculator.add("3"));
    }

    @org.junit.jupiter.api.Test
    void whenTwoNumbersAreUsedReturnTheirSum(){
        assertEquals(3+6, StringCalculator.add("3,6"));
    }

    //REQUIREMENT 4: Allow the Add method to handle an unknown amount of numbers
    @org.junit.jupiter.api.Test
    void whenAnyNumberOfNumbersIsUsedThenReturnTheirSums(){
        assertEquals(3+6+15+18+46+33,StringCalculator.add("3,6,15,18,46,33"));
    }

    //REQUIREMENT 5: Allow the Add method to handle new lines between numbers (instead of commas)
    @org.junit.jupiter.api.Test
    void whenNewLineIsUsedBetweenNumberReturnTheirSum(){
        assertEquals(3+6+15, StringCalculator.add("3,6n15"));
    }

//    REQUIREMENT 6: Support different delimiters
//    @org.junit.jupiter.api.Test
//    void whenDelimiterIsSpecifiedThenItIsUsedToSeperateNumbers(){
//        assertEquals(3+6+15,
//                StringCalculator.add("//;\n3;6;15"));
//    }

    //REQUIREMENT 7: Negative numbers will throw an exception
    @org.junit.jupiter.api.Test
    void whenNegativeNumberIsUsedThenRunTimeException(){
        RuntimeException e = assertThrows(RuntimeException.class, () -> {
                StringCalculator.add("3,-6,15,18,46,33");
        });

        assertEquals("Negatives not allowed: [-6]", e.getMessage());
    }
    @org.junit.jupiter.api.Test
    void whenNegativeNumbersAreUsedThenRuntimeExceptionIsThrown(){
        RuntimeException exception = null;
        try {
            StringCalculator.add("3,-6,15,-18,46,33");
        }catch (RuntimeException e){
            exception = e;
        }
        assertNotNull(exception);
        assertEquals("Negatives not allowed: [-6, -18]", exception.getMessage());
    }

    //REQUIREMENT 8: Numbers bigger than 1000 should be ignored
    @org.junit.jupiter.api.Test
    void whenOneMoreNumberAreGreaterThan1000(){
        assertEquals(3+1000+6, StringCalculator.add("3,1000,1001,1234,6"));
    }

    //REQUIREMENT 9: Delimiters can be of any length //[delimiter]\n
    @org.junit.jupiter.api.Test
    void whenDelimiterCanHaveAnyLength(){
        assertEquals(1+2+3, StringCalculator.add("//[;;;]\n1;;;2;;;3"));
        assertEquals(1+2+3, StringCalculator.add("//[--]\n1--2--3"));
    }

    //REQUIREMENT 10: Allow multiple delimiters  “//[delim1][delim2]\n”
    @org.junit.jupiter.api.Test
    void whenAllowMultipleDelimiters(){
        assertEquals(1+2+3, StringCalculator.add("//[-][%]\n1-2%3"));
        assertEquals(1+2+3, StringCalculator.add("//[;][%]\n1%2;3"));
    }

    //REQUIREMENT 11: Make sure you can also handle multiple delimiters with
    // length longer than one char. You may or may not have taken care of this with the previous requirements, but you must explicitly test for it here.
    @org.junit.jupiter.api.Test
    void whenAllowMultipleDelimitersWithMultipleLength(){
        assertEquals(1+2+3, StringCalculator.add("//[---][%%]\n1---2%%3"));
        assertEquals(1+2+3, StringCalculator.add("//[;][%%]\n1;2%%3"));
    }
}