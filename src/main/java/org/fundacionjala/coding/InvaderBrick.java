package org.fundacionjala.coding;

import java.util.ArrayList;
import java.util.List;

public class InvaderBrick implements IBrick {

    private Position position;
    private List<ISpaceShip> spaceShipList;

    public InvaderBrick(Position position) {
        this.position = position;
        spaceShipList = new ArrayList<>();
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public void setPosition(int row, int column) {
        this.position.setRow(row);
        this.position.setColumn(column);
    }

    @Override
    public List<ISpaceShip> getSpaceShips() {
        return spaceShipList;
    }

    @Override
    public void addSpaceShip(ISpaceShip spaceShip) {
        spaceShipList.add(spaceShip);
    }

    @Override
    public void removeSpaceShip(ISpaceShip spaceShip) {
        spaceShipList.remove(spaceShip);
    }
}
