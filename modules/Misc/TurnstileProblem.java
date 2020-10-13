package Misc;

import Utils.ArrayUtils;

import java.util.*;

public class TurnstileProblem {

    public static void main(String[] args) {
        int[] time = {0,0,1,5};
        int[] direction = {0,1,1,0};

        int[] time1         = {0,0,1,1,1,2,2};
        int[] direction1    = {0,1,1,1,1,0,0};

//        System.out.println(Arrays.toString(getTimes(time, direction)));
        System.out.println(Arrays.toString(getTimesV2(time, direction)));
        System.out.println(Arrays.toString(getTimesV2(time1, direction1)));

    }

    /**
     * time         = [0, 0, 1, 5]
     * direction    = [0, 1, 1, 0]
     *
     * tsState = [ 1 , 1 , 0 , -1, -1, 0 ]
     * result =  [ 2 , 0 , 1 , 5]
     *
     *
     * @param time
     * @param direction
     * @return
     */
    public static int[] getTimes(int[] time, int[] direction) {
        int n = time.length;

        int maxTime = ArrayUtils.getMaximum(time);
        int[] tsState = new int[maxTime+1];
        Arrays.fill(tsState, -1);
        int[] result = new int[n];

        Queue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.timestamp - o2.timestamp;
            }
        });

        for (int i = 0; i < time.length; i++) {
            queue.add(new Pair(time[i], i));
        }

        while (!queue.isEmpty()) {
            Pair currentPair = queue.poll();
            int tsStateAtPreviousTs = currentPair.timestamp == 0 ? -1: tsState[currentPair.timestamp - 1];
            if (queue.isEmpty() || (!queue.isEmpty() && currentPair.timestamp!= queue.peek().timestamp) ){ // only one person at that timestamp
                tsState[currentPair.timestamp] = direction[currentPair.index];
                result[currentPair.index] = currentPair.timestamp;
            } else { // multiple people at the same time
                Pair pairToConsider = null;
                int priorityDirection = 1;
                if (tsStateAtPreviousTs != -1) { // not free at previous ts
                    priorityDirection = tsStateAtPreviousTs;
                }

                List<Pair> allCandidates = new ArrayList<>();
                allCandidates.add(currentPair);
                while (!queue.isEmpty() && queue.peek().timestamp == currentPair.timestamp) {
                    allCandidates.add(queue.poll());
                }
                for (Pair p: allCandidates) {
                    if (direction[p.index] == priorityDirection) {
                        pairToConsider = p;
                        break;
                    }
                }
                if (pairToConsider == null) {
                    priorityDirection = priorityDirection == 1 ? 0: 1;
                    for (Pair p: allCandidates) {
                        if (direction[p.index] == priorityDirection) {
                            pairToConsider = p;
                            break;
                        }
                    }
                }

                tsState[currentPair.timestamp] = direction[pairToConsider.index];
                result[pairToConsider.index] = currentPair.timestamp;
                allCandidates.remove(pairToConsider);

                for (Pair p: allCandidates) {
                    queue.add(new Pair(p.timestamp+1, p.index));
                }

            }
        }
        return result;
    }

    static class Pair {
        int timestamp;
        int index;

        public Pair(int timestamp, int index) {
            this.timestamp = timestamp;
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return timestamp == pair.timestamp &&
                    index == pair.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(timestamp, index);
        }
    }


    /**
     * Idea is to have 2 queue, one for people waiting to get out, one for people waiting to get in.
     * Keep your own global timer, and add people into the corresponding queue according to the time they arrive.
     * What this mean is, at any given moment, people in the queue are waiting in line in real time.
     * At every iteration, you increase the timer, and process one person from the queue.
     * Since you have your own global timer, you don't need to keep track of the time for each person.
     * You also have the person's direction from the type of queue.
     * You only need to store the person's index into the queue to produce output.
     *
     * ref: https://leetcode.com/discuss/interview-question/393226/Akuna-Capital-or-OA-2019-or-Quant/406205
     * @param time
     * @param direction
     * @return
     */
    public static int[] getTimesV2(int[] time, int[] direction) {
        int n = time.length;
        int[] result = new int[time.length];

        Queue<Integer> inQueue = new LinkedList<>();
        Queue<Integer> outQueue = new LinkedList<>();

        int index = 0, timer = 0;
        boolean gateUsedAtPrevTimestamp = false;
        boolean gateUsedForOut = false;

        while (index < n || !inQueue.isEmpty() || !outQueue.isEmpty()) {
            while (index < n && time[index] == timer) {
                if (direction[index] == 0) {
                    inQueue.add(index);
                } else {
                    outQueue.add(index);
                }
                index++;
            }

            if (!inQueue.isEmpty() || !outQueue.isEmpty()) {
                if (!gateUsedAtPrevTimestamp) {
                    if (!outQueue.isEmpty()) {
                        result[outQueue.poll()] = timer;
                        gateUsedForOut = true;
                    } else {
                        result[inQueue.poll()] = timer;
                        gateUsedForOut = false;
                    }
                } else {
                    //second condition because when the last used operation was for entry and entry queue becomes empty
                    // but exit queue still has customers then exit queue will not be polled unless we change the condition
                    if (gateUsedForOut && !outQueue.isEmpty() || (!gateUsedForOut && inQueue.isEmpty())) {
//                        if (gateUsedForOut && !outQueue.isEmpty()) {
                        result[outQueue.poll()] = timer;
                        gateUsedForOut = true;
                    } else {
                        result[inQueue.poll()] = timer;
                        gateUsedForOut = false;
                    }
                }
                gateUsedAtPrevTimestamp = true;
            } else {
                gateUsedAtPrevTimestamp = false;
                gateUsedForOut = false;
            }
            timer++;
        }
        return result;
    }
}
