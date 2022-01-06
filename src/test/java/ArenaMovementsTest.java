import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class ArenaMovementsTest {
    private Arena arena;
    @BeforeAll
    public void setUp() {
        arena = Mockito.mock(Arena.class);
    }

    @Test
    public void canMoveFrogTest() {
        //can move
        Mockito.when(arena.canFrogMove(Mockito.any())).thenReturn(true);

        arena.getFrog().setPosition(new Position(2, 1));
        //positions the frog will be moving to
        Position availablePosition1 = new Position (2, 2); //move up
        Position availablePosition2 = new Position(1, 1);  //move left
        Position availablePosition3 = new Position(3, 1);  //move right

        arena.moveFrog(availablePosition1);
        Mockito.verify(arena, Mockito.times(1)).canFrogMove(availablePosition1);
        Mockito.verify(arena.getFrog(), Mockito.times(1)).setPosition(availablePosition1);
        Assertions.assertEquals(arena.getFrog().getPosition(), availablePosition1);

        arena.getFrog().setPosition(new Position(2, 1));
        arena.moveFrog(availablePosition2);
        Assertions.assertEquals(arena.getFrog().getPosition(), availablePosition2);

        arena.getFrog().setPosition(new Position(2, 1));
        arena.moveFrog(availablePosition3);
        Assertions.assertEquals(arena.getFrog().getPosition(), availablePosition3);
    }

    @Test
    public void cantMoveFrogTest() {
        //can't move
        Mockito.when(arena.canFrogMove(Mockito.any())).thenReturn(false);

        arena.getFrog().setPosition(new Position(2, 1));
        //positions the frog will be trying to move to
        Position unavailablePosition1 = new Position (2, 2); //try to move up
        Position unavailablePosition2 = new Position(1, 1);  //try to move left
        Position unavailablePosition3 = new Position(3, 1);  //try to move right
        Position expectedPosition = new Position(2, 1);

        arena.moveFrog(unavailablePosition1);
        Mockito.verify(arena, Mockito.times(1)).canFrogMove(unavailablePosition1);
        Mockito.verify(arena.getFrog(), Mockito.times(1)).setPosition(unavailablePosition1);
        Assertions.assertEquals(arena.getFrog().getPosition(), expectedPosition);

        arena.getFrog().setPosition(new Position(2, 1));
        arena.moveFrog(unavailablePosition2);
        Assertions.assertEquals(arena.getFrog().getPosition(), expectedPosition);

        arena.getFrog().setPosition(new Position(2, 1));
        arena.moveFrog(unavailablePosition3);
        Assertions.assertEquals(arena.getFrog().getPosition(), expectedPosition);
    }

    @Test
    public void verifyCarCollision() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(2, 2));
        cars.add(new Car(4, 6));
        cars.add(new Car(1, 2));
        Mockito.when(arena.getCars()).thenReturn(cars);

        Assertions.assertEquals(arena.verifyCarCollision(new Position(3, 3)), false);
        Assertions.assertEquals(arena.verifyCarCollision(new Position(7, 4)), false);
        Assertions.assertEquals(arena.verifyCarCollision(new Position(1, 1)), false);
        Assertions.assertEquals(arena.verifyCarCollision(new Position(2, 2)), true);
        Assertions.assertEquals(arena.verifyCarCollision(new Position(4, 6)), true);
        Assertions.assertEquals(arena.verifyCarCollision(new Position(1, 2)), true);
    }

    @Test
    public void verifyTreeTrunkCollision() {
        List<TreeTrunk> treeTrunks = new ArrayList<>();
        treeTrunks.add(new TreeTrunk(35, 24));
        treeTrunks.add(new TreeTrunk(24, 24));
        treeTrunks.add(new TreeTrunk(4, 24));
        treeTrunks.add(new TreeTrunk(15, 15));
        Mockito.when(arena.getTreeTrunks()).thenReturn(treeTrunks);

        Assertions.assertEquals(arena.verifyTreeTrunkCollision(new Position(1, 1)), false);
        Assertions.assertEquals(arena.verifyTreeTrunkCollision(new Position(15, 14)), false);
        Assertions.assertEquals(arena.verifyTreeTrunkCollision(new Position(14, 15)), false);
        Assertions.assertEquals(arena.verifyTreeTrunkCollision(new Position(35, 24)), true);
        Assertions.assertEquals(arena.verifyTreeTrunkCollision(new Position(24, 24)), true);
        Assertions.assertEquals(arena.verifyTreeTrunkCollision(new Position(4, 24)), true);
        Assertions.assertEquals(arena.verifyTreeTrunkCollision(new Position(15, 15)), true);
    }

    @Test
    public void verifyTurtleCollision() {
        List<Turtle> turtles = new ArrayList<>();
        turtles.add(new Turtle(36, 19));
        turtles.add(new Turtle(19, 24));
        turtles.add(new Turtle(15, 25));
        Mockito.when(arena.getTurtles()).thenReturn(turtles);

        Assertions.assertEquals(arena.verifyTurtleCollision(new Position(1, 1)), false);
        Assertions.assertEquals(arena.verifyTurtleCollision(new Position(15, 14)), false);
        Assertions.assertEquals(arena.verifyTurtleCollision(new Position(14, 15)), false);
        Assertions.assertEquals(arena.verifyTurtleCollision(new Position(36, 18)), false);
        Assertions.assertEquals(arena.verifyTurtleCollision(new Position(36, 19)), true);
        Assertions.assertEquals(arena.verifyTurtleCollision(new Position(19, 24)), true);
        Assertions.assertEquals(arena.verifyTurtleCollision(new Position(15, 25)), true);
    }

    @Test
    public void verifyWaterCollision1() {
        //water is always at yMin = 15 and yMax = 25
        //the frog never collides with either a tree trunk or a turtle, therefore it always collides with water
        Mockito.when(arena.verifyTreeTrunkCollision()).thenReturn(false);
        Mockito.when(arena.verifyTurtleCollision()).thenReturn(false);

        Assertions.assertEquals(arena.verifyWaterCollision(new Position(25, 25)), true);
        Assertions.assertEquals(arena.verifyWaterCollision(new Position(15, 25)), true);
        Assertions.assertEquals(arena.verifyWaterCollision(new Position(25, 24)), true);
        Assertions.assertEquals(arena.verifyWaterCollision(new Position(15, 24)), true);
        Assertions.assertEquals(arena.verifyWaterCollision(new Position(25, 19)), true);
        Assertions.assertEquals(arena.verifyWaterCollision(new Position(40, 19)), true);
        Assertions.assertEquals(arena.verifyWaterCollision(new Position(1, 1)), false);
        Assertions.assertEquals(arena.verifyWaterCollision(new Position(40, 1)), false);
        Assertions.assertEquals(arena.verifyWaterCollision(new Position(20, 13)), false);
        Assertions.assertEquals(arena.verifyWaterCollision(new Position(15, 7)), false);
    }

    @Test
    public void verifyWaterCollision2() {
        //water is always at yMin = 15 and yMax = 25
        //the frog always collides with either a tree trunk or a turtle, therefore it never collides with water
        Mockito.when(arena.verifyTreeTrunkCollision()).thenReturn(true);
        Mockito.when(arena.verifyTurtleCollision()).thenReturn(true);

        Assertions.assertEquals(arena.verifyWaterCollision(new Position(25, 25)), false);
        Assertions.assertEquals(arena.verifyWaterCollision(new Position(15, 25)), false);
        Assertions.assertEquals(arena.verifyWaterCollision(new Position(25, 24)), false);
        Assertions.assertEquals(arena.verifyWaterCollision(new Position(15, 24)), false);
        Assertions.assertEquals(arena.verifyWaterCollision(new Position(25, 19)), false);
        Assertions.assertEquals(arena.verifyWaterCollision(new Position(40, 19)), false);
        Assertions.assertEquals(arena.verifyWaterCollision(new Position(1, 1)), false);
        Assertions.assertEquals(arena.verifyWaterCollision(new Position(40, 1)), false);
        Assertions.assertEquals(arena.verifyWaterCollision(new Position(20, 13)), false);
        Assertions.assertEquals(arena.verifyWaterCollision(new Position(15, 7)), false);
    }

    @Test
    public void verifyGrassCollision() {
        //grass is always at yMin = 26 and yMax = 30
        Assertions.assertEquals(arena.verifyGrassCollision(new Position(25, 5)), false);
        Assertions.assertEquals(arena.verifyGrassCollision(new Position(26, 10)), false);
        Assertions.assertEquals(arena.verifyGrassCollision(new Position(27, 15)), false);
        Assertions.assertEquals(arena.verifyGrassCollision(new Position(28, 20)), false);
        Assertions.assertEquals(arena.verifyGrassCollision(new Position(29, 25)), false);
        Assertions.assertEquals(arena.verifyGrassCollision(new Position(30, 26)), true);
        Assertions.assertEquals(arena.verifyGrassCollision(new Position(1, 27)), true);
        Assertions.assertEquals(arena.verifyGrassCollision(new Position(13, 28)), true);
        Assertions.assertEquals(arena.verifyGrassCollision(new Position(13, 29)), true);
        Assertions.assertEquals(arena.verifyGrassCollision(new Position(30, 30)), true);
    }

    @Test
    public void verifySidewalkCollision() {
        //TODO: pensar se vamos ter mais do que um passeio
        //one of the sidewalks is always at yMin = 12 and yMax = 14
        Assertions.assertEquals(arena.verifySidewalkCollision(new Position(25, 5)), false);
        Assertions.assertEquals(arena.verifySidewalkCollision(new Position(26, 10)), false);
        Assertions.assertEquals(arena.verifySidewalkCollision(new Position(12, 30)), false);
        Assertions.assertEquals(arena.verifySidewalkCollision(new Position(30, 11)), false);
        Assertions.assertEquals(arena.verifySidewalkCollision(new Position(30, 15)), false);
        Assertions.assertEquals(arena.verifySidewalkCollision(new Position(1, 12)), true);
        Assertions.assertEquals(arena.verifySidewalkCollision(new Position(1, 13)), true);
        Assertions.assertEquals(arena.verifySidewalkCollision(new Position(1, 14)), true);
    }

    @Test
    public void canFrogMove1() {
        //the frog doesn't collide with either a car, with water or with grass therefore it can move
        Mockito.when(arena.verifyCarCollision(Mockito.any())).thenReturn(false);
        Mockito.when(arena.verifyWaterCollision(Mockito.any())).thenReturn(false);
        Mockito.when(arena.verifyGrassCollision(Mockito.any())).thenReturn(false); //the game ends when the frog moves to grass

        arena.canFrogMove(new Position(1, 2));
        Mockito.verify(arena, Mockito.times(1)).verifyCarCollision();
        Mockito.verify(arena, Mockito.times(1)).verifyWaterCollision();
        Mockito.verify(arena, Mockito.times(1)).verifyGrassCollision();

        Assertions.assertEquals(canFrogMove(new Position(1, 2)), true);
        Assertions.assertEquals(canFrogMove(new Position(3, 3)), true);
        Assertions.assertEquals(canFrogMove(new Position(12, 9)), true);
    }

    @Test
    public void canFrogMove2() {
        //the frog collides with a car therefore it can't move
        Mockito.when(arena.verifyCarCollision(Mockito.any())).thenReturn(true);
        Mockito.when(arena.verifyWaterCollision(Mockito.any())).thenReturn(false);
        Mockito.when(arena.verifyGrassCollision(Mockito.any())).thenReturn(false);

        Assertions.assertEquals(canFrogMove(new Position(1, 2)), false);
        Assertions.assertEquals(canFrogMove(new Position(3, 3)), false);
        Assertions.assertEquals(canFrogMove(new Position(12, 9)), false);
    }

    @Test
    public void canFrogMove3() {
        //the frog collides with water therefore it can't move
        Mockito.when(arena.verifyCarCollision(Mockito.any())).thenReturn(false);
        Mockito.when(arena.verifyWaterCollision(Mockito.any())).thenReturn(true);
        Mockito.when(arena.verifyGrassCollision(Mockito.any())).thenReturn(false);

        Assertions.assertEquals(canFrogMove(new Position(1, 2)), false);
        Assertions.assertEquals(canFrogMove(new Position(3, 3)), false);
        Assertions.assertEquals(canFrogMove(new Position(12, 9)), false);
    }
}

