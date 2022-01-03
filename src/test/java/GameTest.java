import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class GameTest {
    private Screen screen;
    private Game game;
    private Arena arena;
    //private TextGraphics graphics;

    @BeforeEach
    public void setUp() {
        //???
        //screen = Mockito.mock(Screen.class);
        //graphics = Mockito.mock(TextGraphics.class);
        //arena = Mockito.mock(Arena.class);
        //Mockito.when(screen.newTextGraphics()).thenReturn(graphics);

        game = new Game();
        screen = game.getScreen();
        arena = game.getArena();
    }

    @Test
    public void drawTest() {
        game.draw();

        Mockito.verify(screen, Mockito.times(1)).clear();
        Mockito.verify(arena, Mockito.times(1)).draw(screen.newTextGraphics());
        try {
            Mockito.verify(screen, Mockito.times(1)).refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  @Test
    public void processArrowUpTest() {
        Frog frog = arena.getFrog();
        arena.moveFrog(frog.moveUp());
        Mockito.verify(frog, Mockito.times(1)).moveUp();
    }

    @Test
    public void processArrowDownTest() {
        Frog frog = arena.getFrog();
        arena.moveFrog(frog.moveDown());
        Mockito.verify(frog, Mockito.times(1)).moveDown();
    }

    @Test
    public void processArrowRightTest() {
        Frog frog = arena.getFrog();
        game.moveFrog(frog.moveRight());
        Mockito.verify(frog, Mockito.times(1)).moveRight();
    }

    @Test
    public void processArrowLeftTest() {
        Frog frog = arena.getFrog();
        game.moveFrog(frog.moveLeft());
        Mockito.verify(frog, Mockito.times(1)).moveLeft();
    }
}
