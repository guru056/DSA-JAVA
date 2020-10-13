package SystemDesign.ElevatorDesign;

public class ElevatorConstants {


    enum HallCarButton{
        UP, DOWN
    }

    enum DoorState {
        OPEN, CLOSE
    }

    enum ElevatorDirectionOfMotion{
        UP, DOWN, STATIONARY
    }

    enum State {
        MAINTENANCE, STAND, UP, DOWN
    }
}
