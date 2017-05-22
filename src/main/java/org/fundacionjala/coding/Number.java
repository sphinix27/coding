package org.fundacionjala.coding;

/**
 * Created by Zero on 18/5/2017.
 */
public class Number {

    private String stringRepresentation;
    private int intValue;

    /**
     *
     * @param stringRepresentation format
     * @param intValue number
     */
    public Number(String stringRepresentation, int intValue) {
        this.stringRepresentation = stringRepresentation;
        this.intValue = intValue;
    }

    /**
     *
     * @return representation
     */
    public String getStringRepresentation() {
        return stringRepresentation;
    }

    /**
     *
     * @return number
     */
    public int getIntValue() {
        return intValue;
    }
}
