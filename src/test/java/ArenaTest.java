import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArenaTest {
    private Screen screen;
    private Arena arena;
    private TextGraphics graphics;

    @BeforeEach
    public void setUp() {
        screen = Mockito.mock(Screen.class);
        graphics = Mockito.mock(TextGraphics.class);
        Mockito.when(screen.newTextGraphics()).thenReturn(graphics);

        arena = new Arena(screen);
    }

    @Test
    public void drawTextTest() {
        arena.drawText(screen.newTextGraphics(), new Position(1, 1), "Hello Frog Friends!", "#336699");

        //TODO: ver se funciona
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#336699"));
        //Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153));
        Mockito.verify(graphics, Mockito.times(1)).putString(1, 1, "Hello Frog Friends!");
    }

    @Test
    public void drawArenaTest() {
        Water water = arena.getWater();
        Grass grass = arena.getGrass();
        List<Sidewalk> sidewalks = arena.getSidewalks();

        Mockito.verify(water, Mockito.times(1)).draw(screen.newTextGraphics());
        Mockito.verify(grass, Mockito.times(1)).draw(screen.newTextGraphics());
        for (Sidewalk sidewalk: sidewalks)
            Mockito.verify(sidewalk, Mockito.times(1)).draw(screen.newTextGraphics());

        Frog frog = arena.getFrog();
        Mockito.verify(frog, Mockito.times(1)).draw(screen.newTextGraphics());

        List<Car> cars = arena.getCars();
        List<Turtle> turtles = arena.getTurtles();
        List<TreeTrunk> treeTrunks = arena.getTreeTrunks();

        for (Car car: cars)
            Mockito.verify(car, Mockito.times(1)).draw(screen.newTextGraphics());
        for (Turtle turtle: turtles)
            Mockito.verify(turtle, Mockito.times(1).draw(screen.newTextGraphics()));
        for (TreeTrunk treeTrunk: treeTrunks)
            Mockito.verify(treeTrunk, Mockito.times(1).draw(screen.newTextGraphics()));
    }

    @Test
    public void moveFrogTest() {
        //can move
        Position availablePosition = new Position (2, 2);
        arena.moveFrog(availablePosition);
        Mockito.verify(arena, Mockito.times(1).canFrogMove(availablePosition));
        Mockito.verify(frog, Mockito.times(1).setPosition(availablePosition));

        //can't move
        Position unavailablePosition = new Position (2, 2);
        arena.moveFrog(unavailablePosition);
        Mockito.verify(arena, Mockito.times(1).canFrogMove(unavailablePosition));
        Mockito.verify(frog, Mockito.times(0).setPosition(unavailablePosition));
    }

    @Test
    public void verifyCollision() {
        arena.draw();
        Frog frog = arena.getFrog();
        Position frogPosition = frog.getPosition();
        Car car = arena.getCars().get(1);

        //assume that car is in position (2,2) and frog starts at position (1,1)
        frog.moveFrog(3,3);
        Mockito.verify(arena, Mockito.times(1).verifyCollision());
        assertEquals(false, arena.verifyCollision());

        frog.moveFrog(2,2);
        Mockito.verify(arena, Mockito.times(1).verifyCollision());
        assertEquals(true, arena.verifyCollision());
    }
}
