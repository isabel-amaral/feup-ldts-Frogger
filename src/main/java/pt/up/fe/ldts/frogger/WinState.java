package pt.up.fe.ldts.frogger;

import java.io.IOException;

public class WinState implements State{
    private Win win;
    private Game game;
    private boolean gameWasWon = false;

    public WinState(Game newGame) throws IOException {
        game = newGame;
        win = new Win(game);
        gameWasWon = true;
    }

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
