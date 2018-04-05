package org.fundacionjala.coding;

public class Direction {

    private boolean direction;

    public Direction() {
    }

    public Direction(boolean direction) {
        this.direction = direction;
    }

    public boolean isDirection() {
        return direction;
    }

    public void setDirection(boolean direction) {
        this.direction = direction;
    }

    public void changeDirection() {
        this.direction = !this.direction;
    }
}
