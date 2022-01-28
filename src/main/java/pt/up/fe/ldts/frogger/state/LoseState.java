package pt.up.fe.ldts.frogger.state;

import pt.up.fe.ldts.frogger.Game;
import pt.up.fe.ldts.frogger.menus.Lose;

import java.io.IOException;

public class LoseState implements State {
    private Game game;
    private boolean gameWasLost;

    public LoseState(Game newGame) throws IOException {
        game = newGame;
        new Lose(game);
        gameWasLost = true;
    }

    //for testing purposes only
    public boolean getGameWasLost(){
        return gameWasLost;
    }

    @Override
    public void onWin(Game game) throws IOException {
        throw new IllegalStateException("Cannot win while on lose state");
    }

    @Override
    public void onLose(Game game) throws IOException {
        throw new IllegalStateException("Cannot lose while on lose state");
    }

    @Override
    public void onPlay(Game game) throws IOException {
        throw new IllegalStateException("Cannot play while on lose state");
    }

}
