import Utils.ArrayUtils;

public class ArrayRotations {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
//        leftRotateByOne(arr);
//        rightRotateByOne(arr);
//        leftRotateReversal(arr, 1);
		rightRotateReversal(arr, 4);
        ArrayUtils.printArr(arr);
    }

    public static void leftRotateByOne(int[] arr) {
        int n = arr.length;
        if (n <= 1) return;
        int temp = arr[0];
        for (int i = 0; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[n - 1] = temp;
        return;
    }

    public static void leftRotateReversal(int[] arr, int d) {
        int n = arr.length;
        d = d % n;
        ArrayUtils.reverse(arr, 0, d - 1);
        ArrayUtils.reverse(arr, d, n - 1);
        ArrayUtils.reverse(arr, 0, n - 1);
    }

    public static void rightRotateReversal(int[] arr, int d){
		int n = arr.length;
		d = d % n;
		ArrayUtils.reverse(arr, 0, n - 1);
		ArrayUtils.reverse(arr, 0, d - 1);
		ArrayUtils.reverse(arr, d, n - 1);
	}

    public static void rightRotateByOne(int[] arr){
    	int n = arr.length;
    	if ( n <= 1 )
    		return;
    	int temp = arr[n-1];
		for ( int i = n -1 ; i > 0; i--){
			arr[i] = arr[i-1];
		}
		arr[0] = temp;
		return;
	}

}