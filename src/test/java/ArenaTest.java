import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.List;

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

        arena = new Arena(30, 60);
        arena.draw(graphics);
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
        List<Sidewalk> sidewalks = (List<Sidewalk>) arena.getSidewalks();

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
            Mockito.verify(turtle, Mockito.times(1)).draw(screen.newTextGraphics());
        for (TreeTrunk treeTrunk: treeTrunks)
            Mockito.verify(treeTrunk, Mockito.times(1)).draw(screen.newTextGraphics());
    }
}
