package org.fundacionjala.coding;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SpaceInvadersTest {

    private static final int[][][] exampleAliens = {
            {{3,1,2,-2,2,3,6,-3,7,1}},
            {{5,2,-2,3,1,0,4,8,3,-2,5}, {1,4,-1,0,3,6,1,-3,1,2,-4}},
            {{4,1,-7,-5,1,6,3,-2,1,0,2,6,5}, {2,0,3,-4,0,2,-1,5,-8,-3,-2,-5,1}, {1,2,0,-6,4,7,-2,4,-4,2,-5,0,4}},
    };

    private static final int[][] examplePositions = {{6,4}, {10,2}, {15,6}};

    private static final List<List<Integer>> exampleSolutions = Arrays.asList(
            Arrays.asList(0,2,3,4,5,9,10,13,19,22),
            Arrays.asList(1,4,5,6,8,9,10,12,14,15,16,18,19,20,21,26,27,30,32,36),
            Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,12,13,14,15,17,18,19,21,22,23,25,27,30,31,32,35,36,38,40,43,45,56,58)
    );

    @Test
    public void exampleTests() {
        for (int i=0 ; i < exampleAliens.length ; i++) {
            int[][]       aliens = exampleAliens[i];
            int[]         pos    = examplePositions[i];
            List<Integer> exp    = exampleSolutions.get(i);
            assertEquals(exp, new SpaceInvaders(aliens,pos).blastSequence());
        }
    }

    @Test
    public void testMove() {
        int[][]       aliens = exampleAliens[0];
        int[]         pos    = examplePositions[0];
        assertEquals(new int[pos[0]][aliens[0].length], new SpaceInvaders(aliens,pos).move());
    }
}
