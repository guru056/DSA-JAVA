package Arrays.ArrayRearrangement;

import Utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RearrangeArrayToFormBiggestNumber {

//    https://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/
    public static void main(String[] args) {

        ArrayList<String> arr = new ArrayList<String>();
        arr.add("54");
        arr.add("546");
        arr.add("548");
        arr.add("60");
        rearrange(arr);

        ArrayList<String> arr2 = new ArrayList<String>();
        arr2.add("1");
        arr2.add("34");
        arr2.add("3");
        arr2.add("98");
        arr2.add("9");
        arr2.add("76");
        arr2.add("45");
        arr2.add("4");
        rearrange(arr2);

        String[] arr3 = {"54","546","548","60"};
        rearrangeWithoutComparator(arr3);

        String[] arr4 = {"1","34","3","98","9","76","45","4"};
        rearrangeWithoutComparator(arr4);
    }


    public static void rearrange(ArrayList<String> arr)
    {
        Collections.sort(arr, new MyComparator());
        for (int i = 0 ; i < arr.size(); i++){
            System.out.print(arr.get(i));
        }
        System.out.println();
    }

    public static void rearrangeWithoutComparator(String[] arr)
    {
        int n = arr.length;
        String XY = "";
        String YX = "";
        for (int i = 0 ; i < n - 1; i++){
            for (int j = 0; j < n - 1 - i ; j++){
                XY = arr[j] + arr[j + 1];
                YX = arr[j + 1] + arr[j];
                if (YX.compareTo(XY) > 0){
                    String temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for (int i = 0 ; i < n ; i++){
            System.out.print(arr[i]);
        }
        System.out.println();
    }

}

class MyComparator implements Comparator<String >{
    @Override
    public int compare(String X, String Y) {
        String XY = X + Y;
        String YX = Y + X;

        return XY.compareTo(YX) > 0 ? -1 : 1;
    }
}
