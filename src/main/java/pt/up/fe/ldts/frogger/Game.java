package pt.up.fe.ldts.frogger;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class Game {
    private Screen screen;
    private TextGraphics graphics;
    private Arena arena = new Arena(1,60, 30); //TODO: change level initiallization
    //Add ldts.frogger.Game State

    public Game() throws IOException, FontFormatException, URISyntaxException {
        URL resource = getClass().getClassLoader().getResource("FroggerFont.ttf");
        File fontFile = new File(resource.toURI());
        Font font =  Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        DefaultTerminalFactory factory = new DefaultTerminalFactory();

        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        factory.setTerminalEmulatorFontConfiguration(fontConfig);
        factory.setForceAWTOverSwing(true);
        factory.setInitialTerminalSize(new TerminalSize(60, 30));

        Terminal terminal = factory.createTerminal();
        ((AWTTerminalFrame)terminal).addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().dispose();
            }
        });

        Screen screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary

        graphics = screen.newTextGraphics();
        screen.refresh();
    }

    public Screen getScreen() {
        return screen;
    }

    public Arena getArena() {
        return arena;
    }

    public void draw() throws IOException {
        screen.clear();
        arena.draw(graphics);
        screen.refresh();
    }

    public void processKey(KeyStroke key) {
        switch(key.getKeyType()){
            case ArrowRight:
                arena.moveFrog(arena.getFrog().moveRight());
                break;
            case ArrowLeft:
                arena.moveFrog(arena.getFrog().moveLeft());
                break;
            case ArrowUp:
                arena.moveFrog(arena.getFrog().moveUp());
                break;
            case ArrowDown:
                arena.moveFrog(arena.getFrog().moveDown());
                break;
            default:
                break;
        }
    }

        public void playGame() throws IOException {
        //later to run with the state pattern
        while(true) {
            this.draw();
            KeyStroke key = screen.readInput();
            this.processKey(key);
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q')
                screen.close();
            if (key.getKeyType() == KeyType.EOF)
                break;
        }
    }
}
