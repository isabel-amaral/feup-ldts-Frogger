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
    public void moveFrogTest() {
        //can move
        //TODO: confirmar se funciona
        Mockito.when(arena.canFrogMove(Mockito.any())).thenReturn(true);

        arena.getFrog().setPosition(new Position(2, 1));
        //positions the frog will be moving to
        Position availablePosition1 = new Position (2, 2); //move up
        Position availablePosition2 = new Position(1, 1);  //move left
        Position availablePosition3 = new Position(3, 1);  //move right

        arena.moveFrog(availablePosition1);
        Mockito.verify(arena, Mockito.times(1).canFrogMove(availablePosition1));
        Mockito.verify(arena.getFrog(), Mockito.times(1).setPosition(availablePosition1));
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
        //TODO: confirmar se funciona
        Mockito.when(arena.canFrogMove(Mockito.any())).thenReturn(false);

        arena.getFrog().setPosition(new Position(2, 1));
        //positions the frog will be trying to move to
        Position unavailablePosition1 = new Position (2, 2); //try to move up
        Position unavailablePosition2 = new Position(1, 1);  //try to move left
        Position unavailablePosition3 = new Position(3, 1);  //try to move right
        Position expectedPosition = new Position(2, 1);

        arena.moveFrog(unavailablePosition1);
        Mockito.verify(arena, Mockito.times(1).canFrogMove(unavailablePosition1));
        Mockito.verify(arena.getFrog(), Mockito.times(1).setPosition(unavailablePosition1));
        Assertions.assertEquals(arena.getFrog().getPosition(), expectedPosition);

        arena.getFrog().setPosition(new Position(2, 1));
        arena.moveFrog(unavailablePosition2);
        Assertions.assertEquals(arena.getFrog().getPosition(), expectedPosition);

        arena.getFrog().setPosition(new Position(2, 1));
        arena.moveFrog(unavailablePosition3);
        Assertions.assertEquals(arena.getFrog().getPosition(), expectedPosition);
    }

    @Test
    public void verifyCarCollisionTest() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(2, 2));
        cars.add(new Car(4, 6));
        cars.add(new Car(1, 2));
        Mockito.when(arena.getCars().thenReturn(cars));

        Assertions.assertEquals(arena.verifyCarCollision(new Position(3, 3)), false);
        Assertions.assertEquals(arena.verifyCarCollision(new Position(7, 4)), false);
        Assertions.assertEquals(arena.verifyCarCollision(new Position(1, 1)), false);
        Assertions.assertEquals(arena.verifyCarCollision(new Position(2, 2)), true);
        Assertions.assertEquals(arena.verifyCarCollision(new Position(4, 6)), true);
        Assertions.assertEquals(arena.verifyCarCollision(new Position(1, 2)), true);
    }

    @Test
    public void verifyWaterCollision() {
        //TODO
    }

    @Test
    public void verifyGrassCollision() {
        //TODO
    }

    @Test
    public void canFrogMove1() {
        Mockito.when(arena.verifyCarCollision(Mockito.any())).thenReturn(false);
        Mockito.when(arena.verifyWaterCollision(Mockito.any())).thenReturn(false);
        Mockito.when(arena.verifyGrassCollision(Mockito.any())).thenReturn(false);

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
        Mockito.when(arena.verifyCarCollision(Mockito.any())).thenReturn(true);
        Mockito.when(arena.verifyWaterCollision(Mockito.any())).thenReturn(false);
        Mockito.when(arena.verifyGrassCollision(Mockito.any())).thenReturn(false);

        Assertions.assertEquals(canFrogMove(new Position(1, 2)), false);
        Assertions.assertEquals(canFrogMove(new Position(3, 3)), false);
        Assertions.assertEquals(canFrogMove(new Position(12, 9)), false);
    }

    @Test
    public void canFrogMove3() {
        Mockito.when(arena.verifyCarCollision(Mockito.any())).thenReturn(false);
        Mockito.when(arena.verifyWaterCollision(Mockito.any())).thenReturn(true);
        Mockito.when(arena.verifyGrassCollision(Mockito.any())).thenReturn(false);

        Assertions.assertEquals(canFrogMove(new Position(1, 2)), false);
        Assertions.assertEquals(canFrogMove(new Position(3, 3)), false);
        Assertions.assertEquals(canFrogMove(new Position(12, 9)), false);
    }

    @Test
    public void canFrogMove4() {
        Mockito.when(arena.verifyCarCollision(Mockito.any())).thenReturn(false);
        Mockito.when(arena.verifyWaterCollision(Mockito.any())).thenReturn(false);
        Mockito.when(arena.verifyGrassCollision(Mockito.any())).thenReturn(true);

        Assertions.assertEquals(canFrogMove(new Position(1, 2)), false);
        Assertions.assertEquals(canFrogMove(new Position(3, 3)), false);
        Assertions.assertEquals(canFrogMove(new Position(12, 9)), false);
    }
}
