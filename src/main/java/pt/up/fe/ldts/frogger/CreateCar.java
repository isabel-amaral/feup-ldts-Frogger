package pt.up.fe.ldts.frogger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateCar extends MovableElementsFactory {

    public CreateCar(int level, int row) {
        super(level, row);
    }

    //number of obstacles in each traffic lane increases with the level
    public int numElements() {
        Random random = new Random();
        if (level == 1)
            return random.nextInt(8 - 5) + 5; //for level 1 the number of cars in a traffic lane will be between 5 and 7
        if (level == 2)
            return random.nextInt(12 - 8) + 8; //for level 2 the number of cars in a traffic lane will be between 8 and 11
        else //level == 3
            return random.nextInt(16 - 12) + 12; //for level 3 the number of cars in a traffic lane will be between 12 and 15
    }

    //check if the random method isn't accidentally creating two cars at the same position
    public boolean checkOverlapping(List<MovableElement> cars, Position position) {
        for (MovableElement car: cars)
            if (car.getPosition().equals(position))
                return true;
        return false;
    }

    @Override
    public List<MovableElement> create() {
        Random random = new Random();
        List<MovableElement> cars = new ArrayList<>();

        int numElements = numElements();
        for (int i = 0; i < numElements; i++) {
            int x;
            do {
                x = random.nextInt(60);
            } while (checkOverlapping(cars, new Position(x, row)));
            Car car = new Car(x, row);
            cars.add(car);
        }
        return cars;
    }
}
