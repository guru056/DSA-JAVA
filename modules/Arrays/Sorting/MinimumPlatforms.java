package Arrays.Sorting;

import java.util.Arrays;

//https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
//https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station-set-2-map-based-approach/
public class MinimumPlatforms {

    public static void main(String[] args) {
        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };

        System.out.println(getMinimumPlatforms(arr,dep));
        System.out.println(getMinPlatformsV2(arr,dep));
    }

    /**
     * Input:  arr[]  = {9:00,  9:40, 9:50,  11:00, 15:00, 18:00}
     * dep[]  = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
     * Output: 3
     * There are at-most three trains at a time
     * (time between 11:00 to 11:20)
     * <p>
     * Assumptions:
     * 1. Length of arrival and departure arrays is same ie, all trains depart on the same day
     * 2. If a train arrives at 900 and a train departs at 900, min platforms required is 2 [not 1]
     *
     * @param arrival
     * @param departure
     * @return
     */
    public static int getMinimumPlatforms(int[] arrival, int[] departure) {
        int n = arrival.length;
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int i = 0, j = 0;
        int platformsRequired = 0;
        int minPlatformsRequired = 0;
        while (i < n && j < n) {
            if (arrival[i] <= departure[j]) {
                platformsRequired++;
                i++;
                minPlatformsRequired = Math.max(minPlatformsRequired, platformsRequired);
            } else {
                platformsRequired--;
                j++;
            }
        }
        return minPlatformsRequired;
    }

    /**
     * Approach: Find number of platforms required in each minute.
     * O(N), 0(1)
     * @param arrival
     * @param departure
     * @return
     */
    public static int getMinPlatformsV2(int[] arrival, int[] departure) {
        int[] platforms = new int[2361];
        int n = arrival.length;

        for (int i = 0; i < n; i++) {
            platforms[arrival[i]]++;
            platforms[departure[i] + 1]--; //According to Assumption 2
        }

        int minPlatformsRequired = 0;
        for (int i = 1; i < 2361; i++) {
            platforms[i] += platforms[i - 1];
            minPlatformsRequired = Math.max(platforms[i], minPlatformsRequired);
        }

        return minPlatformsRequired;
    }
}
