package org.fundacionjala.coding;

public class SpaceShip implements ISpaceShip{

    private MovementSpeed movementSpeed;
    private Direction direction;

    public SpaceShip(MovementSpeed movementSpeed, Direction direction) {
        this.movementSpeed = movementSpeed;
        this.direction = direction;
    }

    public SpaceShip(int movementSpeed, boolean direction) {
        this.movementSpeed = new MovementSpeed(movementSpeed);
        this.direction = new Direction(direction);
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
