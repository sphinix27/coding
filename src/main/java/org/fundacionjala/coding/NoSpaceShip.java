package org.fundacionjala.coding;

public class NoSpaceShip implements ISpaceShip{

    private MovementSpeed movementSpeed;
    private Direction direction;

    public NoSpaceShip() {
        movementSpeed = new MovementSpeed();
        direction = new Direction();
    }

    @Override
    public MovementSpeed getMovementSpeed() {
        return movementSpeed;
    }

    @Override
    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed.setMovementSpeed(movementSpeed);
    }

    @Override
    public void setDirection(boolean direction) {
        this.direction.setDirection(direction);
    }

    @Override
    public void setMovementSpeed(MovementSpeed movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    @Override
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
