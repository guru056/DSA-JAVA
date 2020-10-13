package Utils;

public class ArrayUtils {

	public static void printArr(int[] arr){
		int n = arr.length;
		for(int i = 0 ; i < n ; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
	}

	public static void printArr(Integer[] arr){
		int n = arr.length;
		for(int i = 0 ; i < n ; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
	}

	public static void reverse(int[] arr, int start, int end){
		while(start < end){
			swap(arr, start, end);
			start++;
			end--;
		}
	}

	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void printSubArray(int[] arr, int start, int end){
		for(int i = start ; i <= end ; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
	}

	public static int getSum(int[] arr)
	{
		int sum = 0;
		for (int i = 0 ; i < arr.length ; i++){
			sum += arr[i];
		}
		return sum;
	}

	public static int getProduct(int[] arr)
	{
		int product = 1;
		for (int i = 0; i < arr.length; i++){
			product *= arr[i];
		}
		return product;
	}

	public static int getMinimum(int[] arr)
	{
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++){
			min = Math.min(min, arr[i]);
		}
		return min;
	}

	public static int getMaximum(int[] arr)
	{
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++){
			max = Math.max(max, arr[i]);
		}
		return max;
	}

}