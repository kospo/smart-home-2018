package me.kospo.smarthome.entity.alarm.state;

public enum AlarmState {
    ARMED {
        @Override
        public boolean arm() {
            return false;
        }

        @Override
        public boolean disarm() {
            return true;
        }

        @Override
        public boolean trigger() {
            return true;
        }
    },
    DISARMED {
        @Override
        public boolean arm() {
            return true;
        }

        @Override
        public boolean disarm() {
            return false;
        }

        @Override
        public boolean trigger() {
            return false;
        }
    },
    TRIGGERED {
        @Override
        public boolean arm() {
            return false;
        }

        @Override
        public boolean disarm() {
            return true;
        }

        @Override
        public boolean trigger() {
            return true;
        }
    }
    ;

    public abstract boolean arm();
    public abstract boolean disarm();
    public abstract boolean trigger();
}
