package org.fundacionjala.coding;

public interface ISpaceShip {

    MovementSpeed getMovementSpeed();

    void setMovementSpeed(MovementSpeed movementSpeed);

    void setMovementSpeed(int movementSpeed);

    Direction getDirection();

    void setDirection(Direction direction);

    void setDirection(boolean direction);
}
