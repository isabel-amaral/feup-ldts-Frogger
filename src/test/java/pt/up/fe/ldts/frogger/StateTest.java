package pt.up.fe.ldts.frogger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StateTest {
    private static State state;

    @BeforeAll
    public static void setUp() {
        state = Mockito.mock(State.class);
    }

    @Test
    public void MenuStateTest() throws IOException {
        state = new MenuState();
        //Mockito.verify(state, Mockito.times(1)).MenuState();
    }

    @Test
    public void fromMenuToGame(){
        //TODO
    }

    @Test
    public void GameStateTest() throws IOException {
        state = new GameState();
        //Mockito.verify(state, Mockito.times(1)).GameState();
    }

    @Test
    public void fromGameToMenu(){
        //TODO
    }

    @Test
    public void fromGameToWin(){
        //TODO
    }

    @Test
    public void fromGameToLose(){
        //TODO
    }

    @Test
    public void LoseStateTest() throws IOException {
        state = new LoseState();
        //Mockito.verify(state, Mockito.times(1)).LoseState();
    }

    @Test
    public void fromLoseToMenu(){
        //TODO
    }

    @Test
    public void WinStateTest() throws IOException {
        state = new WinState();
        //Mockito.verify(state, Mockito.times(1)).MenuState();
    }

    @Test
    public void fromWinToMenu(){
        //TODO
    }
}
