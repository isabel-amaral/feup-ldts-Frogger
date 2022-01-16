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
    public void onPlay(Game game) throws IOException {
        State state = new GameState(game);
        game.setState(state);
    }

    @Override
    public void onMenu(Game game) throws IOException {
        State state = new MenuState(game);
        game.setState(state);
    }

    @Override
    public void onWin(Game game) throws IOException {
        State state = new WinState(game);
        game.setState(state);
    }

    @Override
    public void onLose(Game game) throws IOException {
        State state = new LoseState(game);
        game.setState(state);

    }
}
