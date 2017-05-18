package org.fundacionjala.coding;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Zero on 16/5/2017.
 */
public class BankOCR {

    private static final String ZERO  = " _ | ||_|";
    private static final String ONE   = "     |  |";
    private static final String TWO   = " _  _||_ ";
    private static final String THREE = " _  _| _|";
    private static final String FOUR  = "   |_|  |";
    private static final String FIVE  = " _ |_  _|";
    private static final String SIX   = " _ |_ |_|";
    private static final String SEVEN = " _   |  |";
    private static final String EIGHT = " _ |_||_|";
    private static final String NINE  = " _ |_| _|";

    private static final List<Number> ALL_NUMBERS = Arrays.asList(
                                        new Number(ZERO, 0),
                                        new Number(ONE, 1),
                                        new Number(TWO, 2),
                                        new Number(THREE, 3),
                                        new Number(FOUR, 4),
                                        new Number(FIVE, 5),
                                        new Number(SIX, 6),
                                        new Number(SEVEN, 7),
                                        new Number(EIGHT, 8),
                                        new Number(NINE, 9));

    public static String convertEntryToNumber(String entry) {
        char[] charArray = entry.toCharArray();

        String[] positionNumbers = getPositionNumbers(charArray);

        String result = "";

        for (String string: positionNumbers)
        {
            result += checkString(string);
        }

        return result;
    }

    private static String[] getPositionNumbers(char[] charArray){
        String[] positionNumbers = new String[9];

        for (int i = 0; i < 9; i++)
        {
            positionNumbers[i] = extractNumbers(charArray, i);
        }

        return positionNumbers;
    }

    private static String checkString(String string) {
        String result = "";
        for (int i = 0; i < 9; i++)
        {
            result = getNumberValue(string);
        }
        return result;
    }

    private static String getNumberValue(String string) {
        Number result = ALL_NUMBERS.stream()
                .filter(number -> string.equals(number.getStringRepresentation()))
                .findAny()
                .orElse(null);

        return String.valueOf(result.getIntValue());
    }


    private static String extractNumbers(char[] charArray, int position) {
        return  charArray[0 + position * 3] + "" + charArray[1 + position * 3] + "" + charArray[2 + position * 3] + "" +
                charArray[27 + position * 3] + "" + charArray[28 + position * 3] + "" + charArray[29 + position * 3] + "" +
                charArray[54 + position * 3] + "" + charArray[55 + position * 3] + "" + charArray[56 + position * 3];
    }
}
