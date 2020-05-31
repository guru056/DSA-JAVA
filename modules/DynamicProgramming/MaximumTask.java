package DynamicProgramming;

public class MaximumTask {

    public static void main(String[] args) {
        int[] day = {1,2,3,4,5};
        int[] low = {1,5,4,5,3};
        int[] high = {3,6,8,7,6};

        System.out.println(maxTaskUtil(day, low, high,1, false));
    }

//    public static int maxTask(int[] day, int[] low, int[] high)
//    {
//
//    }

    /**
     * No task for current day and max tqsk for next day
     * low task for current day
     * high task for current day
     *
     * No. of days (n) = 5
     * Day      L.E.   H.E
     * 1        1       3
     * 2        5       6
     * 3        4       8
     * 4        5       7
     * 5        3       6
     * @param day
     * @param low
     * @param high
     * @param currentDay
     * @return
     */
    public static int maxTaskUtil(int[] day, int[] low, int[] high, int currentDay, boolean takeMaxTask)
    {
        if (currentDay > day.length)
            return 0;
        if (takeMaxTask)
            return high[currentDay-1] + maxTaskUtil(day, low, high, currentDay + 1 , false);

        return
                    Math.max(
                        low[currentDay-1] + maxTaskUtil(day, low, high, currentDay+1, false),
                            maxTaskUtil(day, low, high, currentDay+1, true)
                    );

    }
}
