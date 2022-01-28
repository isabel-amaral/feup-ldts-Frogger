package pt.up.fe.ldts.frogger.state;

import pt.up.fe.ldts.frogger.Game;
import pt.up.fe.ldts.frogger.menus.Win;

import java.io.IOException;

public class WinState implements State {
    private Game game;
    private boolean gameWasWon;

    public WinState(Game newGame) throws IOException {
        game = newGame;
        new Win(game);
        gameWasWon = true;
    }

    //for testing purposes only
    public boolean getGameWasWon(){
        return gameWasWon;
    }

    @Override
    public void onWin(Game game) throws IOException {
        throw new IllegalStateException("Cannot win while on win state");
    }

    @Override
    public void onLose(Game game) throws IOException {
        throw new IllegalStateException("Cannot lose while on win state");
    }

    @Override
    public void onPlay(Game game) throws IOException {
        throw new IllegalStateException("Cannot play while on win state");
    }
}
