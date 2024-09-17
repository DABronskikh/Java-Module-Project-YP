import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        game();
    }

    public static void game() {
        final int NUMBER_PLAYERS = 3;
        final int SPEED_MIN = 0;
        final int SPEED_MAX = 250;
        Race race = new Race();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Начинаем гонку!");
        for (int i = 0; i < NUMBER_PLAYERS; i++) {
            String carName;
            int carSpeed;

            System.out.println(String.format("Введите название машины №%d:", i + 1));
            String name = scanner.next();
            carName = name.trim();

            System.out.println(String.format("Введите скорость машины №%d:", i + 1));
            while (true) {
                if (!scanner.hasNextInt()) {
                    scanner = new Scanner(System.in);
                    System.out.println("Введите целое число");
                    continue;
                }
                int speed = scanner.nextInt();

                if (speed <= SPEED_MIN || speed > SPEED_MAX) {
                    System.out.println(String.format("Скорость должна быть >%d и ⩽%d", SPEED_MIN, SPEED_MAX));
                    continue;
                }

                carSpeed = speed;
                break;
            }

            Car newCar = new Car(carName, carSpeed);
            race.addCar(newCar);
        }

        scanner.close();
        System.out.println(String.format("Самая быстрая машина: %s", race.getLeader().name));
        System.out.println(String.format("пройденая дистанция: %d", race.getDistance()));
    }
}
