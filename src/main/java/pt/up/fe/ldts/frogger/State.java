package pt.up.fe.ldts.frogger;

import java.io.IOException;

public interface State {

    public void onPlay(Game game) throws IOException;

    public void onMenu(Game game) throws IOException;

    public void onWin(Game game);

    public void onLose(Game game);
}
