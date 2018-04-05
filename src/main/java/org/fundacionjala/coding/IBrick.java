package org.fundacionjala.coding;

import java.util.List;

public interface IBrick {

    Position getPosition();

    void setPosition(Position position);

    void setPosition(int row, int column);

    List<ISpaceShip> getSpaceShips();

    void addSpaceShip(ISpaceShip spaceShip);

    void removeSpaceShip(ISpaceShip spaceShip);
}
