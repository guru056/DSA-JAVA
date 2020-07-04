package Queue;

class PetrolPump{
    int capacity;
    int distanceToNextPump;

    public PetrolPump(int capacity, int distanceToNextPump) {
        this.capacity = capacity;
        this.distanceToNextPump = distanceToNextPump;
    }
}

//https://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/
public class CircularTour {
    public static final int UNIT_PETROL_REQUIRED_PER_UNIT_DISTANCE = 1;

    public static void main(String[] args) {
        PetrolPump[] arr = getMockInput();
        System.out.println(circularTour(arr));
    }
    /**
     * {4, 6}, {6, 5}, {7, 3} and {4, 5}
     * {6, 4}, {4, 5}, {7, 9} and {6, 5}
     *
     * {3,3}, {3,4}, {4,4}
     *
     * @param arr
     * @return
     */
    public static int circularTour(PetrolPump[] arr)
    {
        int n = arr.length;
        if (n == 1)
            return arr[0].capacity - (arr[0].distanceToNextPump * UNIT_PETROL_REQUIRED_PER_UNIT_DISTANCE) < 0 ? -1 : 0;

        int startIndex = 0;
        int currentIndex = 1;

        int remainingPetrol = arr[startIndex].capacity - (arr[startIndex].distanceToNextPump * UNIT_PETROL_REQUIRED_PER_UNIT_DISTANCE);
        while (startIndex != currentIndex ){

            if (remainingPetrol < 0){ //Logic comment 1 below
                if (currentIndex < startIndex)
                    return -1;
                startIndex = currentIndex;
                currentIndex = ( currentIndex + 1 ) % n ;
                remainingPetrol = arr[startIndex].capacity - ( arr[startIndex].distanceToNextPump * UNIT_PETROL_REQUIRED_PER_UNIT_DISTANCE);
                continue;
            }
            remainingPetrol += arr[currentIndex].capacity - ( arr[currentIndex].distanceToNextPump * UNIT_PETROL_REQUIRED_PER_UNIT_DISTANCE);
            currentIndex = (currentIndex + 1) % n;
        }
        return remainingPetrol < 0 ? -1 : startIndex;
    }

    /**
     * post comments
     * comment 1 : If a truck cannot reach from a -> b -> c , it can defintely not reach from b -> c
     * @return
     */

    private static PetrolPump[] getMockInput()
    {
//        {4, 6}, {6, 5}, {7, 3} and {4, 5}
        return new PetrolPump[]{
                new PetrolPump(6,6),
                new PetrolPump(6,5),
                new PetrolPump(7,3),
                new PetrolPump(4,5)
        };

    }

    private static PetrolPump[] getMockInputV2()
    {
        //{3,3}, {3,4}, {4,4}
        return new PetrolPump[]{
                new PetrolPump(3,3),
                new PetrolPump(3,4),
                new PetrolPump(4,4)
        };
    }

}
