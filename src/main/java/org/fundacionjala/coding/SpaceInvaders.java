package org.fundacionjala.coding;

import java.util.*;
import java.util.stream.Collectors;

public class SpaceInvaders {

    private List<IBrick> brickList;
    private Position ship;
    private List<Integer> resultList;
    private int colSize;

    public SpaceInvaders(int[][] aliens, int[] position) {
        colSize = aliens[0].length;
        this.ship = new Position(position[0], position[1]);
        this.resultList = new ArrayList<>();
        this.brickList = new ArrayList<>();
        for (int i = 0; i < aliens.length; i++) {
            for (int j = 0; j < colSize; j++) {
                if (aliens[i][j] != 0) {
                    IBrick invaderBrick = new InvaderBrick(new Position(i, j));
                    ISpaceShip spaceShip = new SpaceShip(Math.abs(aliens[i][j]), aliens[i][j] > 0);
                    invaderBrick.addSpaceShip(spaceShip);
                    brickList.add(invaderBrick);
                }
            }
        }
    }

    public List<Integer> blastSequence() {
        int turn = 0;
        boolean gameOver;
        do {
            move();
            shoot(turn);
            turn++;
            gameOver = brickList.stream().anyMatch(t -> t.getPosition().getRow() == ship.getRow());
        } while (!gameOver && brickList.size() != 0);
        return resultList;
    }

    public void move() {
        List<IBrick> newBrickList = new ArrayList<>();
        brickList.forEach(brick -> {
            Position currentPosition = brick.getPosition();
            List<ISpaceShip> currentSpaceShipList = brick.getSpaceShips();
            currentSpaceShipList.forEach(spaceShips -> {
                Direction currentDirection = spaceShips.getDirection();
                MovementSpeed currentMovementSpeed = spaceShips.getMovementSpeed();
                int moveRight = currentPosition.getColumn() + currentMovementSpeed.getMovementSpeed();
                int moveLeft = currentPosition.getColumn() - currentMovementSpeed.getMovementSpeed();
                Position newPosition = new Position();
                Direction newDirection = new Direction();
                if (currentDirection.isDirection() && (moveRight < colSize)) {
                    newPosition = new Position(currentPosition.getRow(), moveRight);
                    newDirection = currentDirection;
                }
                if (!currentDirection.isDirection() && (moveLeft >= 0)) {
                    newPosition = new Position(currentPosition.getRow(), moveLeft);
                    newDirection = currentDirection;
                }
                if (currentDirection.isDirection() && (moveRight >= colSize)) {
                    int remainSquares = moveRight - (colSize - 1);
                    newPosition = new Position(currentPosition.getRow() + 1, colSize - remainSquares);
                    newDirection = new Direction(!currentDirection.isDirection());
                }
                if (!currentDirection.isDirection() && (moveLeft < 0)) {
                    int remainSquares = Math.abs(moveLeft);
                    newPosition = new Position(currentPosition.getRow() + 1, remainSquares - 1);
                    newDirection = new Direction(!currentDirection.isDirection());
                }
                ISpaceShip spaceShip = new SpaceShip(currentMovementSpeed, newDirection);
                Position finalNewPosition = newPosition;
                if (newBrickList.stream().anyMatch(t -> t.getPosition().equals(finalNewPosition))) {
                    newBrickList.stream().filter(t -> t.getPosition().equals(finalNewPosition)).findFirst().get()
                            .addSpaceShip(spaceShip);
                } else {
                    IBrick invaderBrick = new InvaderBrick(newPosition);
                    invaderBrick.addSpaceShip(spaceShip);
                    newBrickList.add(invaderBrick);
                }
            });
        });
        brickList = newBrickList;
    }

    private void shoot(int turn) {
        Comparator<IBrick> comparator = Comparator.comparingInt(p -> p.getPosition().getRow());
        IBrick brick = brickList.stream().filter(t -> t.getPosition().getColumn() == ship.getColumn())
                .max(comparator)
                .orElseGet(EmptyBrick::new);
        if (brick.getSpaceShips().size() > 0) {
            if (brick.getSpaceShips().size() == 1) {
                brickList.remove(brick);
            } else {
                Comparator<ISpaceShip> comp = Comparator.comparingInt(p -> p.getMovementSpeed().getMovementSpeed());
                int maxMovementSpeed = brick.getSpaceShips().stream().max(comp).get().getMovementSpeed()
                        .getMovementSpeed();
                List<ISpaceShip> spaceShipList = brick.getSpaceShips().stream().filter(t -> t.getMovementSpeed()
                        .getMovementSpeed() == maxMovementSpeed).collect(Collectors.toList());
                if (spaceShipList.size() == 1) {
                    brick.getSpaceShips().remove(spaceShipList.get(0));
                } else {
                    ISpaceShip spaceship = spaceShipList.stream().filter(t -> t.getDirection().isDirection())
                            .findFirst().get();
                    brick.getSpaceShips().remove(spaceship);
                }
            }
            resultList.add(turn);
        }
    }
}
