import java.util.Random;

class Car {
    private String name;
    private int speed;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public void move() {
        System.out.println(name + " is moving at " + getSpeed() + " mph");
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
}

class FastCar extends Car {
    public FastCar(String name, int speed) {
        super(name, speed);
    }

    // Override move method for faster cars
    @Override
    public void move() {
        System.out.println(getName() + " is moving at " + (getSpeed() + 20) + " mph");
    }
}

class Race {
    public static void main(String[] args) {
        Car car1 = new Car("Car 1", 60);
        FastCar fastCar1 = new FastCar("Fast Car 1", 80);

        raceEvent(car1, fastCar1);
    }

    public static void raceEvent(Car... cars) {
        int raceDistance = 10; // 10 miles
        Random random = new Random();

        for (int mile = 1; mile <= raceDistance; mile++) {
            System.out.println("Mile " + mile);

            for (Car car : cars) {
                car.move();
            }

            try {
                Thread.sleep(2000); // 1 second per mile
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(); // Separate miles with an empty line
        }

        System.out.println("Race finished!");
    }
}
