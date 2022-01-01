
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ArenaTest {
    private Screen screen;
    private Arena arena;
    private TextGraphics graphics;

    @BeforeEach
    void setUp() {
        screen = Mockito.mock(Screen.class);
        graphics = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(graphics);

        arena = new Arena(screen);
    }

    @Test
    void drawTextTest() {
        arena.drawText(new Position(1, 1), "Hello Frog Friends!", "#336699");

        //TODO: ver se funciona
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#336699"));
        //Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153));
        Mockito.verify(graphics, Mockito.times(1)).putString(1, 1, "Hello Frog Friends!");
    }

    @Test
    void drawFrogTest() {
        arena.drawFrog(new Position(1, 1));
        //TODO: ver se funciona
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#33cc33"));
        //Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(51, 204, 51));
        Mockito.verify(graphics, Mockito.times(1)).putString(1, 2, "F");
    }

    ///////////////////////////////////////////////////////////////////////

    @Test
    void drawArenaTest() {
        arena.drawArena(new Position(1, 1));
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#000000"));
        Mockito.verify(graphics, Mockito.times(1)).putString(1, 2, "A");
    }

    @Test
    void drawCarTest() {
        arena.drawFrog(new Position(1, 1));
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#cb4335"));
        Mockito.verify(graphics, Mockito.times(1)).putString(1, 2, "C");
    }

    @Test
    void drawTurtleTest() {
        arena.drawFrog(new Position(1, 1));
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#e67e22"));
        Mockito.verify(graphics, Mockito.times(1)).putString(1, 2, "T");
    }

    @Test
    void drawTreeTrunkTest() {
        arena.drawFrog(new Position(1, 1));
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#7e5109"));
        Mockito.verify(graphics, Mockito.times(1)).putString(1, 2, "TT");
    }

    @Test
    void drawWaterTest() {
        arena.drawFrog(new Position(1, 1));
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#5dade2"));
        Mockito.verify(graphics, Mockito.times(1)).putString(1, 2, "W");
    }

    @Test
    void drawGrassTest() {
        arena.drawFrog(new Position(1, 1));
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#1e8449"));
        Mockito.verify(graphics, Mockito.times(1)).putString(1, 2, "G");
    }

    @Test
    void drawSideWalkTest() {
        arena.drawFrog(new Position(1, 1));
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#b175ff"));
        Mockito.verify(graphics, Mockito.times(1)).putString(1, 2, "SDW");
    }


    //TODO: completar testes draw para os outros elementos
}
