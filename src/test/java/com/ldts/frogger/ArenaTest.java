package com.ldts.frogger;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.ldts.frogger.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    public void drawArenaTest() {
        Water water = arena.getWater();
        Grass grass = arena.getGrass();
        Sidewalk sidewalkFirst = arena.getSidewalkFirst();
        Sidewalk sidewalkSecond = arena.getSidewalkSecond();

        Mockito.verify(water, Mockito.times(1)).draw(screen.newTextGraphics());
        Mockito.verify(grass, Mockito.times(1)).draw(screen.newTextGraphics());
        Mockito.verify(sidewalkFirst, Mockito.times(1)).draw(screen.newTextGraphics());
        Mockito.verify(sidewalkSecond, Mockito.times(1)).draw(screen.newTextGraphics());

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