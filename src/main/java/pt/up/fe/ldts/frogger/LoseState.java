package pt.up.fe.ldts.frogger;

import java.io.IOException;

public class LoseState implements State{
    private Lose lose;
    private Game game;
    private boolean gameWasLost = false;

    public LoseState(Game newGame) throws IOException {
        game = newGame;
        lose = new Lose(game);
        gameWasLost = true;
    }

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
