package org.fundacionjala.coding;

public class Position {
    private int row;
    private int column;

    public Position() {
        this.row = 0;
        this.column = 0;
    }

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        boolean rowEquals = false;
        boolean columnEquals = false;
        if (o instanceof Position) {
            Position position = (Position) o;
            rowEquals = position.row == row;
            columnEquals = position.column == column;
        }
        return rowEquals && columnEquals;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
