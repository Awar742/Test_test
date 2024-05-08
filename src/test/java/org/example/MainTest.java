package org.example;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Test;

import static org.example.Main.missing;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MainTest{
    @Test
    void testMissing_whenOneNumberMissing_shouldReturnCorrectMissingValue() {
        String inputValue = "123567";
        var expectedResult = 4;
        var actualResult = missing(inputValue);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testMissing_whenTwoNumbersMissing_shouldReturnCorrectMissingValue() {
        String inputValue = "899091939495";
        var expectedResult = 92;
        var actualResult = missing(inputValue);
        assertEquals(expectedResult, actualResult);}

    @Test
    void testMissing_whenThreeNumbersMissing_shouldReturnCorrectMissingValue() {
        String inputValue = "9899101102";
        var expectedResult = 100;
        var actualResult = missing(inputValue);
        assertEquals(expectedResult, actualResult);    }

    @Test
    void testMissing_whenNoNumberMissing_haveReturnCorrectMissingValue() {
        String inputValue = "599600601602";
        var expectedResult = -1;
        var actualResult = missing(inputValue);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testMissing_whenErrorInSequence_haveReturnCorrectMissingValue()  {
        String inputValue = "8990919395";
        var expectedResult = -1;
        var actualResult = missing(inputValue);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testMissing_whenEmptySequence_haveReturnCorrectMissingValue()  {
        String inputValue = "";
        var expectedResult = -1;
        var actualResult = missing(inputValue);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testMissing_sequenceWithOneNumber_haveReturnCorrectMissingValue()  {
        String inputValue = "8";
        var expectedResult = -1;
        var actualResult = missing(inputValue);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testMissing_whenSequenceIsNull_shouldThrowNullPointerException()  {

        assertThrows(NullPointerException.class,()->missing(null) );
    }
}