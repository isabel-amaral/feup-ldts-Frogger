package pt.up.fe.ldts.frogger;

import java.io.IOException;

public interface State {

    public default void onPlay(Game game) throws IOException {
        State state = new GameState(game);
        game.setState(state);
    }

    public default void onMenu(Game game) throws IOException {
        State state = new MenuState(game);
        game.setState(state);
    }

    public default void onWin(Game game) throws IOException {
        State state = new WinState(game);
        game.setState(state);
    }

    public default void onLose(Game game) throws IOException {
        State state = new LoseState(game);
        game.setState(state);
    }
}
