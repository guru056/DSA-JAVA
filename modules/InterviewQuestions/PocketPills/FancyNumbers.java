package InterviewQuestions.PocketPills;

public class FancyNumbers {

    public static void main(String[] args) {

        String mobileNumber = "9988664321";
        System.out.println(isFancyNumber(mobileNumber));
    }
    public static boolean isFancyNumber(String mobileNumber)
    {
        int[] count = new int[10];
        int prevDigit = -1;
        int digit ;
        int consecutiveCount = 1;

        for (int i = 0 ; i < 10; i++){
            digit = Integer.parseInt(String.valueOf(mobileNumber.charAt(i)));

            count[digit] += 1;

            if (count[digit] > 3)
                return true;

            if (prevDigit == digit){
                consecutiveCount += 1;
                if (consecutiveCount == 3)
                    return true;
            } else {
                consecutiveCount = 1;
            }
            prevDigit = digit;
        }

        return false;
    }
}
