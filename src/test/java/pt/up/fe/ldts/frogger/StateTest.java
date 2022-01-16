package pt.up.fe.ldts.frogger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StateTest {

    @Test
    public void MenuStateTest() throws IOException {
        //TODO close new terminal
        Game game = new Game();
        MenuState menuState = new MenuState(game);
        Assertions.assertTrue(menuState.getMenuWasCreated());
    }

    @Test
    public void fromMenuToGame() throws IOException {
        //TODO close new terminal
        Game game = new Game();
        MenuState state = new MenuState(game);
        state.onPlay(game);
        GameState gameState = (GameState) game.getState();
        Assertions.assertTrue(gameState.gameWasPlayed());
    }

    @Test
    public void GameStateTest() throws IOException {
        //TODO close new terminal
        Game game = new Game();
        GameState gameState = new GameState(game);
        Assertions.assertTrue(gameState.gameWasPlayed());
    }

    @Test
    public void fromGameToMenu() throws IOException {
        //TODO close new terminal
        Game game = new Game();
        GameState gameState = new GameState(game);
        gameState.onMenu(game);
        MenuState menuState = (MenuState) game.getState();
        Assertions.assertTrue(menuState.getMenuWasCreated());
    }

    @Test
    public void fromGameToWin() throws IOException {
        //TODO close new terminal
        Game game = new Game();
        GameState gameState = new GameState(game);
        gameState.onWin(game);
        WinState winState = (WinState) game.getState();
        Assertions.assertTrue(winState.getGameWasWon());
    }

    @Test
    public void fromGameToLose() throws IOException {
        //TODO close new terminal
        Game game = new Game();
        GameState gameState = new GameState(game);
        gameState.onLose(game);
        LoseState loseState = (LoseState) game.getState();
        Assertions.assertTrue(loseState.getGameWasLost());
    }

    @Test
    public void LoseStateTest() throws IOException {
        //TODO close new terminal
        Game game = new Game();
        LoseState loseState = new LoseState(game);
        Assertions.assertTrue(loseState.getGameWasLost());
    }

    @Test
    public void fromLoseToMenu() throws IOException {
        //TODO close new terminal
        Game game = new Game();
        LoseState loseState = new LoseState(game);
        loseState.onMenu(game);
        MenuState menuState = (MenuState) game.getState();
        Assertions.assertTrue(menuState.getMenuWasCreated());
    }

    @Test
    public void WinStateTest() throws IOException {
        //TODO close new terminal
        Game game = new Game();
        WinState winState = new WinState(game);
        Assertions.assertTrue(winState.getGameWasWon());
    }

    @Test
    public void fromWinToMenu() throws IOException {
        //TODO close new terminal
        Game game = new Game();
        WinState winState = new WinState(game);
        winState.onMenu(game);
        MenuState menuState = (MenuState) game.getState();
        Assertions.assertTrue(menuState.getMenuWasCreated());
    }
}
