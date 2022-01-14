package pt.up.fe.ldts.frogger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class FactoryTest {

    @BeforeAll
    public static void setUp() {
        //TODO: initialize mocks
    }

    @Test
    public void createFrogElement() {
        MovableElementsFactory factory = new MovableElementsFactory(1, "Frog");
        CreateFrog createFrog = new CreateFrog(1);
        factory.create();

        Mockito.verify(createFrog, Mockito.times(1)).create();
    }

    @Test
    public void createCarElement() {
        MovableElementsFactory factory = new MovableElementsFactory(1, "Car");
        CreateCar createCar = new CreateCar(1, 24);
        factory.create();

        Mockito.verify(createCar, Mockito.times(1)).create();
    }

    @Test
    public void createTreeTrunkElement() {
        MovableElementsFactory factory = new MovableElementsFactory(1, "TreeTrunk");
        CreateTreeTrunk createTreeTrunk = new CreateTreeTrunk(1, 10);
        factory.create();

        Mockito.verify(createTreeTrunk, Mockito.times(1)).create();
    }

    @Test
    public void createTurtleElement() {
        MovableElementsFactory factory = new MovableElementsFactory(1, "Turtle");
        List<MovableElement> treeTrunks = new ArrayList<>();
        CreateTurtle createTurtle = new CreateTurtle(1, 10, treeTrunks);
        factory.create();

        Mockito.verify(createTurtle, Mockito.times(1)).create();
    }

    @Test
    public void createFrog() {
        CreateFrog createFrog1 = new CreateFrog(1);
        CreateFrog createFrog2 = new CreateFrog(2);
        CreateFrog createFrog3 = new CreateFrog(3);
        List<MovableElement> frog = createFrog1.create();
        Frog frog1 = (Frog) frog.get(0);
        frog = createFrog2.create();
        Frog frog2 = (Frog) frog.get(0);
        frog = createFrog3.create();
        Frog frog3 = (Frog) frog.get(0);

        Assertions.assertEquals(frog1.getPosition().getX(), 30);
        Assertions.assertEquals(frog1.getPosition().getY(), 29);
        Assertions.assertEquals(frog2.getPosition().getX(), 45);
        Assertions.assertEquals(frog2.getPosition().getY(), 27);
        Assertions.assertEquals(frog3.getPosition().getX(), 3);
        Assertions.assertEquals(frog2.getPosition().getY(), 27);
    }

    @Test
    //also tests numElements indirectly
    public void createCars() {
        CreateCar createCar1 = new CreateCar(1, 17);
        List<MovableElement> cars1 = createCar1.create();
        CreateCar createCar2 = new CreateCar(2, 18);
        List<MovableElement> cars2 = createCar2.create();
        CreateCar createCar3 = new CreateCar(3, 20);
        List<MovableElement> cars3 = createCar3.create();

        Assertions.assertTrue(cars1.size() >= 5);
        Assertions.assertTrue(cars1.size() < 8);
        for (MovableElement car: cars1) {
            Assertions.assertTrue(car.getPosition().getX() >= 0);
            Assertions.assertTrue(car.getPosition().getX() < 60);
            Assertions.assertEquals(car.getPosition().getY(), 17);
        }

        Assertions.assertTrue(cars2.size() >= 8);
        Assertions.assertTrue(cars2.size() < 12);
        for (MovableElement car: cars2) {
            Assertions.assertTrue(car.getPosition().getX() >= 0);
            Assertions.assertTrue(car.getPosition().getX() < 60);
            Assertions.assertEquals(car.getPosition().getY(), 18);
        }

        Assertions.assertTrue(cars3.size() >= 12);
        Assertions.assertTrue(cars3.size() < 16);
        for (MovableElement car: cars3) {
            Assertions.assertTrue(car.getPosition().getX() >= 0);
            Assertions.assertTrue(car.getPosition().getX() < 60);
            Assertions.assertEquals(car.getPosition().getY(), 20);
        }
    }

    @Test
    //also tests numElements indirectly
    public void createTreeTrunks() {
        CreateTreeTrunk createTreeTrunk1 = new CreateTreeTrunk(1, 4);
        List<MovableElement> treeTrunk1 = createTreeTrunk1.create();
        CreateTreeTrunk createTreeTrunk2 = new CreateTreeTrunk(2, 7);
        List<MovableElement> treeTrunk2 = createTreeTrunk2.create();
        CreateTreeTrunk createTreeTrunk3 = new CreateTreeTrunk(3, 10);
        List<MovableElement> treeTrunk3 = createTreeTrunk3.create();

        Assertions.assertTrue(treeTrunk1.size() >= 9);
        Assertions.assertTrue(treeTrunk1.size() < 12);
        for (MovableElement treeTrunk: treeTrunk1) {
            Assertions.assertTrue(treeTrunk.getPosition().getX() >= 0);
            Assertions.assertTrue(treeTrunk.getPosition().getX() < 60);
            Assertions.assertEquals(treeTrunk.getPosition().getY(), 4);
        }

        Assertions.assertTrue(treeTrunk2.size() >= 6);
        Assertions.assertTrue(treeTrunk2.size() < 9);
        for (MovableElement treeTrunk: treeTrunk2) {
            Assertions.assertTrue(treeTrunk.getPosition().getX() >= 0);
            Assertions.assertTrue(treeTrunk.getPosition().getX() < 60);
            Assertions.assertEquals(treeTrunk.getPosition().getY(), 7);
        }

        Assertions.assertTrue(treeTrunk3.size() >= 3);
        Assertions.assertTrue(treeTrunk3.size() < 6);
        for (MovableElement treeTrunk: treeTrunk3) {
            Assertions.assertTrue(treeTrunk.getPosition().getX() >= 0);
            Assertions.assertTrue(treeTrunk.getPosition().getX() < 60);
            Assertions.assertEquals(treeTrunk.getPosition().getY(), 10);
        }
    }

    @Test
    //also tests numElements indirectly
    public void createTurtles() {
        List<MovableElement> treeTrunks = new ArrayList<>();
        CreateTurtle createTurtle1 = new CreateTurtle(1, 5, treeTrunks);
        List<MovableElement> turtle1 = createTurtle1.create();
        CreateTurtle createTurtle2 = new CreateTurtle(2, 8, treeTrunks);
        List<MovableElement> turtle2 = createTurtle2.create();
        CreateTurtle createTurtle3 = new CreateTurtle(3, 11, treeTrunks);
        List<MovableElement> turtle3 = createTurtle3.create();

        Assertions.assertTrue(turtle1.size() >= 9);
        Assertions.assertTrue(turtle1.size() < 12);
        for (MovableElement turtle: turtle1) {
            Assertions.assertTrue(turtle.getPosition().getX() >= 0);
            Assertions.assertTrue(turtle.getPosition().getX() < 60);
            Assertions.assertEquals(turtle.getPosition().getY(), 5);
        }

        Assertions.assertTrue(turtle2.size() >= 6);
        Assertions.assertTrue(turtle2.size() < 9);
        for (MovableElement turtle: turtle2) {
            Assertions.assertTrue(turtle.getPosition().getX() >= 0);
            Assertions.assertTrue(turtle.getPosition().getX() < 60);
            Assertions.assertEquals(turtle.getPosition().getY(), 8);
        }

        Assertions.assertTrue(turtle3.size() >= 3);
        Assertions.assertTrue(turtle3.size() < 6);
        for (MovableElement turtle: turtle3) {
            Assertions.assertTrue(turtle.getPosition().getX() >= 0);
            Assertions.assertTrue(turtle.getPosition().getX() < 60);
            Assertions.assertEquals(turtle.getPosition().getY(), 11);
        }
    }
}