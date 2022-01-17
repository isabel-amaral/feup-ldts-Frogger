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
