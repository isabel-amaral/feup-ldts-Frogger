package pt.up.fe.ldts.frogger;

import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DrawElementsTest {
    private Screen screen;
    private TextGraphics graphics;

    @BeforeEach
    public void setUp() {
        screen = Mockito.mock(Screen.class);
        graphics = Mockito.mock(TextGraphics.class);
        Mockito.when(screen.newTextGraphics()).thenReturn(graphics);
    }

    @Test
    public void drawFrogTest() {
        Frog frog = new Frog(1, 2);
        frog.draw(screen.newTextGraphics());

        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#33cc33"));
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(1, 2),  "F");
    }

    @Test
    public void drawCarTest() {
        Car car = new Car(1, 2, "left");
        car.draw(screen.newTextGraphics());

        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#cb4335"));
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(1, 2), "C");
    }

    @Test
    public void drawTurtleTest() {
        Turtle turtle = new Turtle(1, 2, "left");
        turtle.draw(screen.newTextGraphics());

        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#e67e22"));
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(1, 2), "T");
    }

    @Test
    public void drawTreeTrunkTest() {
        TreeTrunk treeTrunk = new TreeTrunk(1, 2, "left");
        treeTrunk.draw(screen.newTextGraphics());

        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#7e5109"));
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(1, 2), "TT");
    }

    @Test
    public void drawWaterTest() {
        Water water = new Water(1, 2);
        water.draw(screen.newTextGraphics());

        Mockito.verify(graphics, Mockito.times(2)).setForegroundColor(TextColor.Factory.fromString("#5dade2"));
        //Blocks in line y=1
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(1, 1), String.valueOf(Symbols.BLOCK_SOLID));
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(2, 1), String.valueOf(Symbols.BLOCK_SOLID));
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(3, 1), String.valueOf(Symbols.BLOCK_SOLID));
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(4, 1), String.valueOf(Symbols.BLOCK_SOLID));
        //Blocks in line y=2
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(1, 2), String.valueOf(Symbols.BLOCK_SOLID));
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(2, 2), String.valueOf(Symbols.BLOCK_SOLID));
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(3, 2), String.valueOf(Symbols.BLOCK_SOLID));
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(4, 2), String.valueOf(Symbols.BLOCK_SOLID));
    }

    @Test
    public void drawGrassTest() {
        Grass grass = new Grass(1, 2);
        grass.draw(screen.newTextGraphics());

        Mockito.verify(graphics, Mockito.times(2)).setForegroundColor(TextColor.Factory.fromString("#1e8449"));

        //Blocks in line y=1
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(1, 1), String.valueOf(Symbols.BLOCK_SOLID));
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(2, 1), String.valueOf(Symbols.BLOCK_SOLID));
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(3, 1), String.valueOf(Symbols.BLOCK_SOLID));
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(4, 1), String.valueOf(Symbols.BLOCK_SOLID));
        //Blocks in line y=2
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(1, 2), String.valueOf(Symbols.BLOCK_SOLID));
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(2, 2), String.valueOf(Symbols.BLOCK_SOLID));
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(3, 2), String.valueOf(Symbols.BLOCK_SOLID));
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(4, 2), String.valueOf(Symbols.BLOCK_SOLID));
    }

    @Test
    public void drawSideWalkTest() {
        Sidewalk sidewalk = new Sidewalk(1, 2);
        sidewalk.draw(screen.newTextGraphics());

        Mockito.verify(graphics, Mockito.times(2)).setForegroundColor(TextColor.Factory.fromString("#b175ff"));

        //Blocks in line y=1
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(1, 1), String.valueOf(Symbols.BLOCK_SOLID));
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(2, 1), String.valueOf(Symbols.BLOCK_SOLID));
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(3, 1), String.valueOf(Symbols.BLOCK_SOLID));
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(4, 1), String.valueOf(Symbols.BLOCK_SOLID));
        //Blocks in line y=2
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(1, 2), String.valueOf(Symbols.BLOCK_SOLID));
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(2, 2), String.valueOf(Symbols.BLOCK_SOLID));
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(3, 2), String.valueOf(Symbols.BLOCK_SOLID));
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(4, 2), String.valueOf(Symbols.BLOCK_SOLID));
    }
}
