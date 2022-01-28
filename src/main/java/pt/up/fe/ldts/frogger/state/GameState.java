package pt.up.fe.ldts.frogger.state;

import pt.up.fe.ldts.frogger.Game;

public class GameState implements State {
    private Game game;
    private boolean gameWasPlayed;

    public GameState(Game newGame) {
        game = newGame;
        gameWasPlayed = true;
    }

    //for testing purposes only
    public boolean getGameWasPlayed(){
        return gameWasPlayed;
    }
}
