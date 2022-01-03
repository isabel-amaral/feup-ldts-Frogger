import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
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
    public void setUp() {
        graphics = Mockito.mock(TextGraphics.class);
        Mockito.when(screen.newTextGraphics()).thenReturn(graphics);

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
    public void processKey() {
        //TODO
        KeyType keyType = KeyType.ArrowUp;
        game.processKey();
    }
}
