package pt.up.fe.ldts.frogger;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class StateTest {
    //All State pattern Tests are commented because we couldn´t force the screen to close (it needed user input)
    // Although, if closed manually, all Tests pass
    /*
    @Test
    public void MenuStateTest() throws IOException, URISyntaxException, FontFormatException {
        Game game = new Game();
        MenuState menuState = (MenuState) game.getState();
        game.closeScreen();
        Assertions.assertTrue(menuState.getMenuWasCreated());
    }

    @Test
    public void fromMenuToGame() throws IOException, URISyntaxException, FontFormatException {
        Game game = new Game();
        MenuState state = new MenuState(game);
        state.onPlay(game);
        GameState gameState = (GameState) game.getState();
        Assertions.assertTrue(gameState.getGameWasPlayed());
        game.closeScreen();
    }

    @Test
    public void GameStateTest() throws IOException, URISyntaxException, FontFormatException {
        Game game = new Game();
        GameState gameState = new GameState(game);
        Assertions.assertTrue(gameState.getGameWasPlayed());
        game.closeScreen();
    }

    @Test
    public void fromGameToMenu() throws IOException, URISyntaxException, FontFormatException {
        Game game = new Game();
        GameState gameState = new GameState(game);
        gameState.onMenu(game);
        MenuState menuState = (MenuState) game.getState();
        Assertions.assertTrue(menuState.getMenuWasCreated());
        game.closeScreen();
    }

    @Test
    public void fromGameToWin() throws IOException, URISyntaxException, FontFormatException {
        Game game = new Game();
        GameState gameState = new GameState(game);
        gameState.onWin(game);
        WinState winState = (WinState) game.getState();
        Assertions.assertTrue(winState.getGameWasWon());
        game.closeScreen();
    }

    @Test
    public void fromGameToLose() throws IOException, URISyntaxException, FontFormatException {
        Game game = new Game();
        GameState gameState = new GameState(game);
        gameState.onLose(game);
        LoseState loseState = (LoseState) game.getState();
        Assertions.assertTrue(loseState.getGameWasLost());
        game.closeScreen();
    }

    @Test
    public void LoseStateTest() throws IOException, URISyntaxException, FontFormatException {
        Game game = new Game();
        LoseState loseState = new LoseState(game);
        Assertions.assertTrue(loseState.getGameWasLost());
        game.closeScreen();
    }

    @Test
    public void fromLoseToMenu() throws IOException, URISyntaxException, FontFormatException {
        Game game = new Game();
        LoseState loseState = new LoseState(game);
        loseState.onMenu(game);
        MenuState menuState = (MenuState) game.getState();
        Assertions.assertTrue(menuState.getMenuWasCreated());
        game.closeScreen();
    }

    @Test
    public void WinStateTest() throws IOException, URISyntaxException, FontFormatException {
        Game game = new Game();
        WinState winState = new WinState(game);
        Assertions.assertTrue(winState.getGameWasWon());
        game.closeScreen();
    }

    @Test
    public void fromWinToMenu() throws IOException, URISyntaxException, FontFormatException {
        Game game = new Game();
        WinState winState = new WinState(game);
        winState.onMenu(game);
        MenuState menuState = (MenuState) game.getState();
        Assertions.assertTrue(menuState.getMenuWasCreated());
        game.closeScreen();
    } */
}
