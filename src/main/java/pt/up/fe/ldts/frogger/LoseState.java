package pt.up.fe.ldts.frogger;

import java.io.IOException;

public class LoseState implements State{
    private Lose lose;
    private Game game;

    public LoseState(Game newGame){
        game = newGame;
        lose = new Lose();
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
    public void onWin(Game game) {
        State state = new WinState(game);
        game.setState(state);
    }

    @Override
    public void onLose(Game game) {
        State state = new LoseState(game);
        game.setState(state);

    }
}
