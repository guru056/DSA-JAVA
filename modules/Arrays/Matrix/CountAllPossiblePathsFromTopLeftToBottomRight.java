package Arrays.Matrix;

public class CountAllPossiblePathsFromTopLeftToBottomRight {

//    https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/

    public static void main(String[] args) {
        System.out.println(countPossiblePaths(2,2));
        System.out.println(countPossiblePaths(2,3));
        System.out.println(countPossiblePaths(3,3));

        System.out.println(countPossiblePathsRecursive2(2,2));
        System.out.println(countPossiblePathsRecursive2(2,3));
        System.out.println(countPossiblePathsRecursive2(3,3));

        System.out.println(countPossiblePathsRecursive3(0,0,2,2));
        System.out.println(countPossiblePathsRecursive3(0,0,2,3));
        System.out.println(countPossiblePathsRecursive3(0,0,3,3));

    }

    public static int countPossiblePaths(int m, int n )
    {
        return countPossiblePathsRecursive(0, 0 , m , n );
    }

    public static int countPossiblePathsRecursive( int i , int j, int m , int n)
    {
        if (i > m - 1 || j > n - 1)
            return 0;
        if (i == m - 1 && j == n - 1)
            return 1;

        return countPossiblePathsRecursive(i, j + 1, m , n) + countPossiblePathsRecursive( i + 1, j , m , n);
    }

    //thinking backwards
    public static int countPossiblePathsRecursive2(int m, int n)
    {
        if (m == 1 || n == 1){
            return 1;
        }
        return countPossiblePathsRecursive2(m ,n -1 ) + countPossiblePathsRecursive2(m -1 , n);
            //+countPossiblePathsRecursive2(m-1,n-1) --> required when diagonal movements are allowed
    }

    public static int countPossiblePathsRecursive3(int i, int j , int m , int n )
    {
        if (i == m - 1 || j == n - 1)
            return 1;

        return countPossiblePathsRecursive(i, j + 1, m , n) + countPossiblePathsRecursive( i + 1, j , m , n);
    }

}
