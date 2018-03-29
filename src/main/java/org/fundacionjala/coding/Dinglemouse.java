package org.fundacionjala.coding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Dinglemouse {
    public static int[] theLift(int[][] queues, int capacity) {
        List<Integer> stoppedFloors = new ArrayList<>();
        List<Integer> nextFloors = new ArrayList<>();
        stoppedFloors.add(0);
        int counter = 0;
        for (int i = 0; i < queues.length; i++) {
            if (queues[i].length > 0 && queues[i].length <= capacity) {
                Map<Integer, Boolean> currentCount = checkPassengers(nextFloors, true, i, queues, counter);
                counter = (int)currentCount.keySet().toArray()[0];
                boardingPassengers(stoppedFloors, i, currentCount.get(counter));
            }
            nextFloors = leavingPassengers(stoppedFloors, nextFloors, i);
        }

        if (counter > 0) {
            for (int i = queues.length - 1; i > 0; i--) {
                if (queues[i].length > 0 && queues[i].length <= capacity) {
                    Map<Integer, Boolean> currentCount = checkPassengers(nextFloors, false, i, queues, counter);
                    counter = (int)currentCount.keySet().toArray()[0];
                    boardingPassengers(stoppedFloors, i, currentCount.get(counter));
                }
                nextFloors = leavingPassengers(stoppedFloors, nextFloors, i);
            }
        }
        stoppedFloors.add(0);
        return stoppedFloors.stream().mapToInt(i -> i).toArray();
    }

    private static Map<Integer, Boolean> checkPassengers(List<Integer> nextFloors, boolean comparator, int i, int[][] queues, int counter) {
        boolean currentCount = false;
        for (int j = 0; j < queues[i].length; j++) {
            if (compare(comparator, queues[i][j], i)) {
                nextFloors.add(queues[i][j]);
                currentCount = true;
            } else {
                counter++;
            }
        }
        Map<Integer, Boolean> result = new HashMap<>();
        result.put(counter, currentCount);
        return result;
    }

    private static boolean compare(boolean comparator, int value, int floor) {
        return comparator ? value > floor : value < floor;
    }

    private static void boardingPassengers(List<Integer> stoppedFloors, int i, boolean currentCount) {
        if (currentCount) {
            stoppedFloors.add(i);
        }
    }

    private static List<Integer> leavingPassengers(List<Integer> stoppedFloors, List<Integer> nextFloors, int i) {
        if (nextFloors.contains(i) && stoppedFloors.get(stoppedFloors.size() - 1) != i) {
            stoppedFloors.add(i);
        }
        nextFloors = nextFloors.stream().distinct().collect(Collectors.toList());
        if (nextFloors.indexOf(i) != -1) {
            nextFloors.remove(nextFloors.indexOf(i));
        }
        return nextFloors;
    }
}
