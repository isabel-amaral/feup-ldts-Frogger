package pt.up.fe.ldts.frogger;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArenaTest {
    private TextGraphics graphics;
    private Arena arena;
    private Frog frog;
    private List<Car> cars = new ArrayList<>();
    private List<TreeTrunk> treeTrunks = new ArrayList<>();
    private List<Turtle> turtles = new ArrayList<>();
    private Water water;
    private Grass grass;
    private Sidewalk firstSidewalk, secondSidewalk;

    @BeforeEach
    public void setUp() throws IOException {
        TerminalSize terminalSize = new TerminalSize(60, 30);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();
        Screen screen = new TerminalScreen(terminal);
        graphics = screen.newTextGraphics();

        arena = Mockito.mock(Arena.class);
        frog = Mockito.mock(Frog.class);
        arena.setFrog(frog);
        water = new Water(4, 13);
        arena.setWater(water);
        grass = new Grass(0, 3);
        arena.setGrass(grass);
        firstSidewalk = new Sidewalk(27, 29);
        arena.setFirstSidewalk(firstSidewalk);
        secondSidewalk = new Sidewalk(14, 16);
        arena.setSecondSidewalk(secondSidewalk);

        Car car1 = new Car(13, 20, "left");
        Car car2 = new Car(14, 19, "right");
        Car car3 = new Car(13, 20, "left");
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        arena.setCars(cars);

        TreeTrunk treeTrunk1 = new TreeTrunk(13, 13, "left");
        TreeTrunk treeTrunk2 = new TreeTrunk(14, 14, "right");
        TreeTrunk treeTrunk3 = new TreeTrunk(15, 13, "left");
        treeTrunks.add(treeTrunk1);
        treeTrunks.add(treeTrunk2);
        treeTrunks.add(treeTrunk3);
        arena.setTreeTrunks(treeTrunks);

        Turtle turtle1 = new Turtle(15, 15, "left");
        Turtle turtle2 = new Turtle(12, 12, "right");
        Turtle turtle3 = new Turtle(12, 15, "left");
        turtles.add(turtle1);
        turtles.add(turtle2);
        turtles.add(turtle3);
        arena.setTurtles(turtles);
    }

    @Test
    public void drawArenaTest() {
        arena.draw(graphics);

        Mockito.verify(water, Mockito.times(1)).draw(graphics);
        Mockito.verify(grass, Mockito.times(1)).draw(graphics);
        Mockito.verify(firstSidewalk, Mockito.times(1)).draw(graphics);
        Mockito.verify(secondSidewalk, Mockito.times(1)).draw(graphics);
        Mockito.verify(frog, Mockito.times(1)).draw(graphics);

      for (Car car: cars)
            Mockito.verify(car, Mockito.times(1)).draw(graphics);
        for (Turtle turtle: turtles)
            Mockito.verify(turtle, Mockito.times(1)).draw(graphics);
        for (TreeTrunk treeTrunk: treeTrunks)
            Mockito.verify(treeTrunk, Mockito.times(1)).draw(graphics);
    }
}