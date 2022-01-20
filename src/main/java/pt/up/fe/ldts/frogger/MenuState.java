package pt.up.fe.ldts.frogger;

import java.io.IOException;

public class MenuState implements State {
    private Menu menu;
    private boolean menuWasCreated = false;

    public MenuState(Game game) throws IOException {
        game.setState(this);
        menu = new Menu(game);
        menuWasCreated = true;
    }

    public boolean getMenuWasCreated(){
        return menuWasCreated;
    }

    @Override
    public void onWin(Game game) throws IOException {
        throw new IllegalStateException("Cannot win while on menu state");
    }

    @Override
    public void onLose(Game game) throws IOException {
        throw new IllegalStateException("Cannot lose while on menu state");
    }

}
