package org.fundacionjala.coding;

import java.util.ArrayList;
import java.util.List;

public class SpaceInvaders {

    private int[][] aliens;
    private int[] position;
    private int[][] board;
    private List<Integer> result;
    private IBoard invaders;

    public SpaceInvaders(int[][] aliens, int[] position) {
        this.aliens = aliens;
        this.position = position;
        this.board = new int[position[0] + 1][aliens[0].length];
        for (int i = 0; i < aliens.length; i++) {
            board[i] = this.aliens[i];
        }
        result = new ArrayList<>();

        invaders = new Invaders();
        for (int i = 0; i < position[0]; i++) {
            for (int j = 0; j < aliens[0].length; j++) {
                Position currentPos = new Position(i, j);
                Velocity currentVel = new Velocity(0);
                IBrick currentAlien = new Aliens(currentPos, currentVel);
                this.invaders.addInvaders(currentAlien);
            }
        }
        for (int i = 0; i < aliens.length; i++) {
            for (int j = 0; j < aliens[0].length; j++) {
                Position currentPos = new Position(i,j);
                Velocity currentVel = new Velocity(aliens[i][j]);
                IBrick currentAlien = new Aliens(currentPos, currentVel);
                invaders.
            }
        }

    }

    public List<Integer> blastSequence() {
        for (int i = 0; i < position[0] * aliens[0].length; i++) {
            move();
            if (shoot()) {
                result.add(i);
            }
        }
        return result;
    }

    public boolean shoot() {

        for (int i = position[0]; i > 0; i--) {
            if (board[i][position[1]] != 0) {
                board[i][position[1]] = 0;
                return true;
            }
        }
        return false;
    }

    public int[][] move() {
        int columnLength = aliens[0].length;
        int[][] newAliens = new int[position[0] + 1][columnLength];
        for (int i = 0; i < position[0]; i++) {
            for (int j = 0; j < columnLength; j++) {
                int squareToMove = Math.abs(board[i][j]);
                boolean sideToMove = board[i][j] > 0;
                boolean boardNotZero = board[i][j] != 0;
                if (sideToMove && boardNotZero && (squareToMove + j) < columnLength) {
                    newAliens[i][squareToMove + j] = board[i][j];
                }
                if (!sideToMove && boardNotZero && (j - squareToMove) >= 0) {
                    newAliens[i][j - squareToMove] = board[i][j];
                }
                if (sideToMove && boardNotZero && (squareToMove + j) >= columnLength) {
                    int remainSquares = squareToMove + j - columnLength;
                    newAliens[i + 1][columnLength - remainSquares - 1] = (-1) * board[i][j];
                }
                if (!sideToMove && boardNotZero && (j - squareToMove) < 0) {
                    int remainSquares = Math.abs(j - squareToMove);
                    newAliens[i + 1][remainSquares - 1] = (-1) * board[i][j];
                }
            }
        }
        board = newAliens;
        return board;
    }

    public interface IBrick {
        Position getPosition();

        void setPosition(int i, int j);

        Velocity getVelocity();

        void setVelocity(int speed);
    }

    private static class Position {
        private int row;
        private int column;

        public Position(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public boolean equals(Object o) {
            boolean rowCheck = false;
            boolean colCheck = false;
            if (o instanceof Position) {
                Position cuPos = (Position)o;
                rowCheck = cuPos.row == row;
                colCheck =  cuPos.column ==column;
            }
            return rowCheck && colCheck;
        }
    }

    private static class Velocity {
        private int speed;
        private boolean direction;

        public Velocity(int speed) {
            this.speed = Math.abs(speed);
            this.direction = speed > 0;
        }
    }

    private static class Aliens implements IBrick {
        private Position pos;
        private Velocity vel;

        public Aliens(Position pos, Velocity vel) {
            this.pos = pos;
            this.vel = vel;
        }

        @Override
        public Position getPosition() {
            return pos;
        }

        @Override
        public void setPosition(int i, int j) {
            pos = new Position(i, j);
        }

        @Override
        public Velocity getVelocity() {
            return vel;
        }

        @Override
        public void setVelocity(int speed) {
            vel = new Velocity(speed);
        }        
    }

    public interface IBoard {
        List<IBrick> getInvaders();

        void addInvaders(IBrick alien);

        void setInvader(IBrick alien);
    }

    private static class Invaders implements IBoard {
        private List<IBrick> aliens;

        @Override
        public List<IBrick> getInvaders() {
            return aliens;
        }

        public IBrick getInvader(Position pos) {
            return aliens.stream().filter(t -> t.getPosition().equals(pos)).findFirst().get();
        }

        @Override
        public void addInvaders(IBrick alien) {
            aliens.add(alien);
        }

        @Override
        public void setInvader(IBrick alien) {
            int index = aliens.indexOf(getInvader(alien.getPosition()));
            aliens.remove(index);
            aliens.add(index, alien);
        }
    }
}
