package Misc;

public class MarioJumps {

    public static void main(String[] args) {
        int[] arr = {0,1,-1,1,2,3,0};
        int[] arr1 = {0,3,0};
        int[] arr2 = {1,2,3,4,1,4,0};
        int[] arr3 = {1,-1,1};
        int[] arr4 = {0,2,4,0,3,1};

        System.out.println(canMarioCompleteLevel(arr));
        System.out.println(canMarioCompleteLevel(arr1));
        System.out.println(canMarioCompleteLevel(arr2));
        System.out.println(canMarioCompleteLevel(arr3));
        System.out.println(canMarioCompleteLevel(arr4));

    }

    public static boolean canMarioCompleteLevel(int[] arr) {
        int n = arr.length;
        int maxJump = 2;
        int i;
        for (i = 0; i < n - 2; i++ ) {

            //pit at next step
            if (arr[i+1] == -1 && arr[i+2] == -1)
                return false;
            if (arr[i + 1] == -1) {
                i++;
                continue;
            }

            if (arr[i] < arr[i+1]) { // next building is higher
                if (arr[i+1] - arr[i] > 2)
                    return false;
                continue;
            }

            if (arr[i] == arr[i+1]) // equal buildings, just walk
                continue;

            if (i + 2 < n) {
                if (arr[i+2] == arr[i]) { // jump a pit that comes along, if you can
                    i++;
                    continue;
                } else if (arr[i+2] > arr[i]) { // if next building is smaller and next to next building is larger, only one option
                    continue;
                } else {
                    continue;
                }
            } else
                break;
        }

        if (i == n - 2) {
            if (arr[n-1] < arr[n-2])
                return true;
            if (arr[n-1] - arr[n-2] > 2)
                return false;
        }

//        if (i == n-1) {
//            return true;
//        }
//

        return true;
    }
}
