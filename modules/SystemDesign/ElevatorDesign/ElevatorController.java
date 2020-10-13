package SystemDesign.ElevatorDesign;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {

    private List<ElevatorCar> availableElevatorCars;
    private static ElevatorController elevatorController;

    public void initializeElevatorConfig()
    {
        this.availableElevatorCars = new ArrayList<>();
        this.availableElevatorCars.add(new ElevatorCar("1"));
        this.availableElevatorCars.add(new ElevatorCar("2"));
        this.availableElevatorCars.add(new ElevatorCar("3"));
        this.availableElevatorCars.add(new ElevatorCar("4"));
    }
    private ElevatorController(){

    }
    public static ElevatorController getElevatorController()
    {
        if (elevatorController == null) {
            elevatorController = new ElevatorController();
            elevatorController.availableElevatorCars = new ArrayList<>();
            elevatorController.availableElevatorCars.add(new ElevatorCar("1"));
            elevatorController.availableElevatorCars.add(new ElevatorCar("2"));
            elevatorController.availableElevatorCars.add(new ElevatorCar("3"));
            elevatorController.availableElevatorCars.add(new ElevatorCar("4"));
            return elevatorController;
        }
        return elevatorController;
    }

    public ElevatorCar getNearestElevator(int floorNum, ElevatorConstants.HallCarButton button)
    {
        return this.availableElevatorCars.get(0);
    }

    //Up button pressed by a passenger standing on floor floorNum
    public void upHallCarButtonPressed(int floorNum)
    {
        ElevatorCar car = this.getNearestElevator(floorNum, ElevatorConstants.HallCarButton.UP);
        if (car.getFloor() < floorNum){
            car.enqueueFloorUpward(floorNum);
        } else if(car.getFloor() > floorNum){
            car.enqueueFloorDownward(floorNum);
        } else{
            car.openDoor();
            return;
        }
        if (car.isElevatorStandingIdleAtFloor()){
            ElevatorConstants.ElevatorDirectionOfMotion motionOfDirection = car.getFloor() < floorNum
                                                            ? ElevatorConstants.ElevatorDirectionOfMotion.UP
                                                            : ElevatorConstants.ElevatorDirectionOfMotion.DOWN;
            car.setMovingDirection(motionOfDirection);
            car.initiate();
        }
    }

    //Down button pressed by a passenger standing on floor floorNum
    public void downHallCarButtonPressed(int floorNum)
    {
        ElevatorCar car = this.getNearestElevator(floorNum, ElevatorConstants.HallCarButton.DOWN);
        boolean isIdle = car.isElevatorStandingIdleAtFloor();
        if (car.getFloor() < floorNum){
            car.enqueueFloorUpward(floorNum);
        } else if(car.getFloor() > floorNum){
            car.enqueueFloorDownward(floorNum);
        } else{
            car.openDoor();
            return;
        }
        if (isIdle){
            ElevatorConstants.ElevatorDirectionOfMotion motionOfDirection = car.getFloor() < floorNum
                    ? ElevatorConstants.ElevatorDirectionOfMotion.UP
                    : ElevatorConstants.ElevatorDirectionOfMotion.DOWN;
            car.setMovingDirection(motionOfDirection);
            car.initiate();
        }
    }

    //carButton pressed inside an elevator for floor floorNum
    public void carButtonPressed(ElevatorCar car, int floorNum)
    {
        boolean isIdle = car.isElevatorStandingIdleAtFloor();
        car.carButtonPressed(floorNum);
        if (isIdle) {
            ElevatorConstants.ElevatorDirectionOfMotion motionOfDirection = car.getFloor() < floorNum
                    ? ElevatorConstants.ElevatorDirectionOfMotion.UP
                    : ElevatorConstants.ElevatorDirectionOfMotion.DOWN;
            car.setMovingDirection(motionOfDirection);
            car.initiate();
        }
    }

    private ElevatorCar getElevatorCarById(String id)
    {
        return this.availableElevatorCars.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }
}
