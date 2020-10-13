package Misc;

import java.util.*;

public class LoungeStocking {

    public static void main(String[] args) {
        int[] onHand = {0, 1, 1, 2, 2, 2};
        int[] supplier = {0, 0, 0, 2, 2, 2};
        int demand = 2;

        int[] onHand1 = {0, 2, 2};
        int[] supplier1 = {0, 0, 2};
        int demand1 = 2;

        System.out.println(loungeStockingV2(onHand, supplier, demand));
        System.out.println(loungeStockingV2(onHand1, supplier1, demand1));

        /**
         * 4,3
         * 1,9,1,6
         * 1,1
         * 1,2
         * 1,3
         * 6,7
         * 2,3,5,6,2,6
         * 1,2
         * 1,5
         * 2,6
         * 6,6
         * 5,5
         * 5,5
         * 3,5
         */
        int[] A = {1,9,1,6};
        int[][] R = {{1,1}, {1,2},{1,3}};
        int N = 4;
        int M = 3;

//        System.out.println(maxSumArrangement(A,R,N,M));
    }
    public static int loungeStocking(int[] onHand, int[] supplier, int demand) {

        Map<Integer, Integer> supplierMap = new HashMap<>();
        Map<Integer, Integer> onHandMap = new HashMap<>();
        for (int i = 0; i < supplier.length; i++) {
            supplierMap.put(supplier[i], supplierMap.getOrDefault(supplier[i], 0) + 1);
        }

        for (int i = 0; i < onHand.length; i++) {
            onHandMap.put(onHand[i], onHandMap.getOrDefault(onHand[i], 0) + 1);
        }

        Set<Integer> settled = new HashSet<>();

        int totalCount = 0;
        int prevCount = 0;
        for (Map.Entry<Integer, Integer> entry: onHandMap.entrySet()) {
            int currentElem = entry.getKey();
            int currentElemCount = entry.getValue();

            int maxCountAllowed = (currentElem + 1) * 2 - prevCount;
            if (currentElemCount > maxCountAllowed)
                return -1;

            prevCount += currentElemCount;

            int countAllowed = maxCountAllowed - currentElemCount;
            int countToBeAdded = 0;
            if (supplierMap.containsKey(currentElem)) {
                countToBeAdded = Math.min(countAllowed, supplierMap.get(currentElem));
                supplierMap.remove(currentElem);
            }
            totalCount += countToBeAdded;
            prevCount += countToBeAdded;
        }

//        for (Map.Entry<Integer, Integer> entry: supplierMap.entrySet()) {
//
//        }

        return 0;

    }

    public static int loungeStockingV2(int[] onHand, int[] supplier, int demand) {
        Arrays.sort(onHand);
        Arrays.sort(supplier);

        Map<Integer, Integer> supplierMap = new HashMap<>();
        Map<Integer, Integer> onHandMap = new HashMap<>();
        for (int i = 0; i < supplier.length; i++) {
            supplierMap.put(supplier[i], supplierMap.getOrDefault(supplier[i], 0) + 1);
        }

        for (int i = 0; i < onHand.length; i++) {
            onHandMap.put(onHand[i], onHandMap.getOrDefault(onHand[i], 0) + 1);
        }

        int i = 0;
        int j = 0;
        int prevCount = 0;
        int totalCount = 0;

        for (int k = 0; k < onHand.length; k++) {
            int maxAllowed = (onHand[k] + 1) * demand - prevCount;
            if (onHandMap.get(onHand[k]) > maxAllowed) {
                return -1;
            }
            prevCount += onHandMap.get(onHand[k]);
            while (k < onHand.length - 1 && onHand[k] == onHand[k+1]) {
                k++;
            }
        }
        prevCount = 0;

        while (i < onHand.length && j < supplier.length) {
            if (onHand[i] <= supplier[j]) {
                int currCount = onHandMap.get(onHand[i]);
                int maxCountAllowed = (onHand[i] + 1) * demand - prevCount;
                if (currCount > maxCountAllowed) {
                    prevCount -= (currCount - maxCountAllowed);
                    totalCount -= (currCount - maxCountAllowed);
                } else {
                    int countCanBeAdded = maxCountAllowed - currCount;
                    int countAdded = 0;
                    if (supplierMap.containsKey(onHand[i])) {
                        countAdded = Math.min(supplierMap.get(onHand[i]), countCanBeAdded);
                    }
                    prevCount += (countAdded + currCount);
                    totalCount += countAdded;
                }
                while (i < onHand.length - 1 && onHand[i] == onHand[i+1]) {
                    i++;
                }
                while (j < supplier.length  && supplier[j] == onHand[i]) {
                    j++;
                }
                i++;
            } else {
                int maxCountAllowed = (supplier[j] + 1) * demand - prevCount;
                int currCount = supplierMap.get(supplier[j]);
                int countAllowed = maxCountAllowed - currCount;
                int countToBeAdded = Math.min(countAllowed, currCount);
                prevCount += countToBeAdded;
                totalCount += countToBeAdded;

                while (j < supplier.length - 1 && supplier[j] == supplier[j+1]) {
                    j++;
                }
                j++;
            }
        }
        while (i < onHand.length) {
            int currCount = onHandMap.get(onHand[i]);
            int maxCountAllowed = (onHand[i] + 1) * demand - prevCount;
            if (currCount > maxCountAllowed) {
                prevCount -= (currCount - maxCountAllowed);
                totalCount -= (currCount - maxCountAllowed);
            }
            while (i < onHand.length - 1 && onHand[i] == onHand[i+1]) {
                i++;
            }
            i++;
        }

        while (j < supplier.length) {
            int maxCountAllowed = (supplier[j] + 1) * demand - prevCount;
            int currCount = supplierMap.get(supplier[j]);
            int countAllowed = maxCountAllowed - currCount;
            int countToBeAdded = Math.min(countAllowed, currCount);
            prevCount += countToBeAdded;
            totalCount += countToBeAdded;

            while (j < supplier.length - 1 && supplier[j] == supplier[j+1]) {
                j++;
            }
            j++;
        }

        return totalCount;
    }

}
