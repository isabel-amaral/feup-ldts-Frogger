package pt.up.fe.ldts.frogger;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.function.DoubleToIntFunction;

public class Game {
    private Screen screen;
    private TextGraphics graphics;
    private Arena arena = new Arena(1, 60, 30);
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

    public void setLevel(int newLevel) {
        level.setLevel(newLevel);
    }

    //for testing purposes only
    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    //for testing purposes only
    public void setArena(Arena arena) {
        this.arena = arena;
    }

    //for testing purposes only
    public void setGraphics(TextGraphics graphics) {
        this.graphics = graphics;
    }

    public void draw() throws IOException {
        screen.clear();
        arena.draw(graphics);
        screen.refresh();
    }

    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }

    public void closeScreen() throws IOException {
        screen.close();
        System.out.println("Screen closed!");
    }

    public void processKey(KeyStroke key) {
        if (key == null)
            return;

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
        //TODO: change velocity according ot the level
        int FPS = 2;
        int frameTime = 1000/FPS;

        while(true) {
            long startTime = System.currentTimeMillis();

            this.draw();
            KeyStroke key = screen.pollInput();
            this.processKey(key);
            if (key != null && key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') {
                screen.close();
                break;
            }
            else if (key != null && key.getKeyType() == KeyType.EOF)
                break;
            arena.moveMovableElements();

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }
    }
}
