import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class GameTest {
    private Screen screen;
    private Game game;
    private Arena arena;
    private TextGraphics graphics;

    @BeforeEach
    void setUp() {
        screen = Mockito.mock(Screen.class);
        graphics = Mockito.mock(TextGraphics.class);
        arena = Mockito.mock(Arena.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(graphics);

        game = new Game();
    }

    @Test
    void drawTest() {
        game.draw();

        Mockito.verify(screen, Mockito.times(1)).clear();
        Mockito.verify(arena, Mockito.times(1)).draw();
        try {
            Mockito.verify(screen, Mockito.times(1)).refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void moveFrogTest() {
        Position position = new Position(1,1);
        game.moveFrog(position);
        Mockito.verify(arena, Mockito.times(1)).moveFrog(position);
    }

    @Test
    void processArrowUpTest() {
        game.moveFrog(arena.moveUp());
        Mockito.verify(arena, Mockito.times(1)).moveUp();
    }

    @Test
    void processArrowDownTest() {
        game.moveFrog(arena.moveDown());
        Mockito.verify(arena, Mockito.times(1)).moveDown();
    }

    @Test
    void processArrowRightTest() {
        game.moveFrog(arena.moveRight());
        Mockito.verify(arena, Mockito.times(1)).moveRight();
    }

    @Test
    void processArrowLeftTest() {
        game.moveFrog(arena.moveLeft());
        Mockito.verify(arena, Mockito.times(1)).moveLeft();
    }
}
