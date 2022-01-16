package pt.up.fe.ldts.frogger;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;
    private TextGraphics graphics;
    private Arena arena = new Arena(60, 30);
    private State state;
    private Level level;

    public Game() throws IOException {
        TerminalSize terminalSize = new TerminalSize(60, 30);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null); // we don't need a cursor
        screen.startScreen(); // screens must be started
        screen.doResizeIfNecessary(); // resize screen if necessary

        graphics = screen.newTextGraphics();

        Level newLevel = new Level(this);
        level = newLevel;
        state = new MenuState(this);

    }

    public Screen getScreen() {
        return screen;
    }

    public TextGraphics getGraphics() {
        return graphics;
    }

    public Arena getArena() {
        return arena;
    }

    public State getState(){
        return state;
    }

    public void setState(State newState){
        state = newState;
    }

    public void setLevel(int newLevel){
        level.setLevel(newLevel);
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
