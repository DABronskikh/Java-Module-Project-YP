public class Race {
    private Car leader = new Car("", 0);
    private int distance;
    private static final int DURATION_RACE = 24;

    public void addCar(Car car) {
        int distance = car.speed * DURATION_RACE;
        if (distance > this.distance) {
            this.leader = car;
            this.distance = distance;
        }
    }

    public Car getLeader() {
        return this.leader;
    }

    public int getDistance() {
        return this.distance;
    }

}
