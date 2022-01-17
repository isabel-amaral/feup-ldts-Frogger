package pt.up.fe.ldts.frogger;

import java.io.IOException;

public class MenuState implements State {
    private Menu menu;
    private Game game;
    private boolean menuWasCreated = false;

    public MenuState(Game newGame) throws IOException {
        game = newGame;
        menu = new Menu(game);
        menuWasCreated = true;
    }

    public boolean getMenuWasCreated(){
        return menuWasCreated;
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
