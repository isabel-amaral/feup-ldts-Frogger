package pt.up.fe.ldts.frogger;

import java.io.IOException;

public class GameState implements State{
    private Game game;
    private boolean gameWasPlayed = false;

    public GameState(Game newGame) throws IOException {
        game = newGame;
        newGame.playGame();
        gameWasPlayed = true;
    }

    public boolean gameWasPlayed(){
        return gameWasPlayed;
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
