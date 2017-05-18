package org.fundacionjala.coding;

/**
 * Created by Zero on 18/5/2017.
 */
public class Number {

    private String stringRepresentation;
    private int intValue;

    public Number(String stringRepresentation, int intValue)
    {
        this.stringRepresentation = stringRepresentation;
        this.intValue = intValue;
    }

    public String getStringRepresentation() {
        return stringRepresentation;
    }

    public int getIntValue() {
        return intValue;
    }
}
