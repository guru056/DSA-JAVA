package SystemDesign.ElevatorDesign;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class ElevatorCar {
    public class Defaults {
        private static final int MIN_FLOOR = 1;
        private static final int MAX_FLOOR = 20;
        private static final int MAX_LOAD = 2000;
    }
    private static ElevatorCar elevatorCar = null;
    private int minFloor = Defaults.MIN_FLOOR;
    private int maxFloor = Defaults.MAX_FLOOR;
    private int floor = minFloor;
    private int load = 0;
//    private int maxLoad = Defaults.MAX_LOAD;
    private ElevatorConstants.State state = ElevatorConstants.State.STAND;
    private boolean isDoorOpen = false;
    private ElevatorConstants.DoorState doorState = ElevatorConstants.DoorState.CLOSE;
    private String id = null;
    private Queue<Integer> upHeap = new PriorityQueue<>(maxFloor);
    private Queue<Integer> downHeap = new PriorityQueue<>(maxFloor, Collections.reverseOrder());

    public int getFloor() {
        return floor;
    }

    ElevatorConstants.ElevatorDirectionOfMotion movingDirection;

    public String getId() {
        return id;
    }

    public ElevatorCar(String id) {
        this.id = id;
    }

    protected boolean isUpHeapEmpty() {
        return upHeap.isEmpty();
    }

    protected void enqueueFloorUpward(int floor) {
        if (upHeap.contains(floor)) {
            return;
        }
        upHeap.add(floor);
    }

    protected void enqueueFloorDownward(int floor) {
        if (this.downHeap.contains(floor)) {
            return;
        }
        this.downHeap.add(floor);
    }

    protected boolean isDownHeapEmpty() {
        return downHeap.isEmpty();
    }

    public boolean isMoving(){
        return this.movingDirection != ElevatorConstants.ElevatorDirectionOfMotion.STATIONARY;
    }

    public ElevatorConstants.ElevatorDirectionOfMotion getMovingDirection()
    {
        return movingDirection;
    }

    public void setMovingDirection(ElevatorConstants.ElevatorDirectionOfMotion direction)
    {
        this.movingDirection = direction;
    }

    public void halt()
    {
        this.movingDirection = ElevatorConstants.ElevatorDirectionOfMotion.STATIONARY;
    }

    public void goToFloor(int floorNumber)
    {
        this.floor = floorNumber;
    }

    public void openDoor()
    {
        if (this.isDoorOpen)
            return;
        this.doorState = ElevatorConstants.DoorState.OPEN;
    }

    public void closeDoor()
    {
        if (!this.isDoorOpen)
            return;
        this.doorState = ElevatorConstants.DoorState.CLOSE;
    }

    public void carButtonPressed(int floorNumber)
    {
        /**
         * if currentFloor is less than requested floorNumber add in upHeap otherwise in downHeap
         */
        if (this.floor < floorNumber){
            this.enqueueFloorUpward(floorNumber);
        } else{
            this.enqueueFloorDownward(floor);
        }
    }

    public void initiate()
    {
        /**
         * Initiate the motion of the lift when it is in standing state
         * moving direction has to be set before initiating the motion of the lift
         */
        Queue<Integer> primaryQueue = this.movingDirection == ElevatorConstants.ElevatorDirectionOfMotion.UP
                                                    ? this.upHeap
                                                    : this.downHeap;
        Queue<Integer> secondaryQueue = primaryQueue == this.upHeap
                                        ? this.downHeap
                                        : this.upHeap;
        //add sleep and sout
        while (!primaryQueue.isEmpty()){
            try {
                int haltFloor = primaryQueue.poll();
                this.goToFloor(haltFloor);
                this.halt();
                this.openDoor();
                TimeUnit.SECONDS.sleep(2);
                this.closeDoor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (!secondaryQueue.isEmpty()){
            try {
                int haltFloor = secondaryQueue.poll();
                this.goToFloor(haltFloor);
                this.halt();
                this.openDoor();
                TimeUnit.SECONDS.sleep(2);
                this.closeDoor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isElevatorStandingIdleAtFloor()
    {
        return this.isUpHeapEmpty() &&
                this.isDownHeapEmpty() &&
                this.movingDirection == ElevatorConstants.ElevatorDirectionOfMotion.STATIONARY;
    }
}
