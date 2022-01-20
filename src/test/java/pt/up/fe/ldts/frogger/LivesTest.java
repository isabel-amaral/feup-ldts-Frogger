package pt.up.fe.ldts.frogger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class LivesTest {

    @Test
    public void NewGameLivesTest() throws IOException, URISyntaxException, FontFormatException {
        Game game = new Game();
        int lives = game.getLives();
        Assertions.assertEquals(3, lives);
    }

    @Test
    public void LostOneLife() throws IOException, URISyntaxException, FontFormatException {
        Game game = new Game();
        game.setState(new GameState(game));

        Arena newArena = new Arena(1, 60, 30);
        java.util.List<Car> cars = new ArrayList<>();
        cars.add(new Car(30, 28, "left"));
        newArena.setCars(cars);

        Frog frog = new Frog(1,1);
        newArena.setFrog(frog);
        game.setArena(newArena);

        newArena.moveFrog(new Position(30, 28));

        int lives = game.getLives();
        Assertions.assertEquals(2, lives);
    }

    @Test
    public void LostTwoLives() throws IOException, URISyntaxException, FontFormatException {
        Game game = new Game();
        game.setState(new GameState(game));

        Arena newArena = new Arena(1, 60, 30);
        java.util.List<Car> cars = new ArrayList<>();
        cars.add(new Car(30, 28, "left"));
        newArena.setCars(cars);

        Frog frog = new Frog(1,1);
        newArena.setFrog(frog);
        game.setArena(newArena);

        newArena.moveFrog(new Position(30, 28));
        newArena.moveFrog(new Position (30, 5));

        int lives = game.getLives();
        Assertions.assertEquals(1, lives);
    }

    @Test
    public void LostTheGame() throws IOException, URISyntaxException, FontFormatException {
        Game game = new Game();
        game.setState(new GameState(game));

        Arena newArena = new Arena(1, 60, 30);
        java.util.List<Car> cars = new ArrayList<>();
        cars.add(new Car(30, 28, "left"));
        newArena.setCars(cars);

        Frog frog = new Frog(1,1);
        newArena.setFrog(frog);
        game.setArena(newArena);

        newArena.moveFrog(new Position(30, 28));
        newArena.moveFrog(new Position (30, 5));
        newArena.moveFrog(new Position (30, 6));

        int lives = game.getLives();

        Assertions.assertEquals(0, lives);
        LoseState lostGame = (LoseState) game.getState();
        Assertions.assertTrue(lostGame.getGameWasLost());
    }
}
