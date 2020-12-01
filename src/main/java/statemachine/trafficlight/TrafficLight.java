package statemachine.trafficlight;

public enum TrafficLight {

    RED {
        @Override
        TrafficLight next() {
            return RED_YELLOW;
        }
    },
    RED_YELLOW {
        @Override
        TrafficLight next() {
            return GREEN;
        }
    },
    YELLOW {
        @Override
        TrafficLight next() {
            return RED;
        }
    },
    GREEN {
        @Override
        TrafficLight next() {
            return YELLOW;
        }
    };

    abstract TrafficLight next();


}
