import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveFrogTest {

    private Frog frog;
    private Position position;

    @BeforeEach
    public void setUp(){
        Frog frog = new Frog();
        position = frog.getPosition();
    }


    @Test
    void moveUpTest(){
        Assertions.assertEquals(position.getY()-1, frog.moveUp().getY());   // y diminui
        Assertions.assertEquals(position.getX(), frog.moveUp().getX());   // x mantém-se
    }

    @Test
    void moveDownTest(){
        assertEquals(position.getY()+1, frog.moveUp().getY());  // y aumenta
        assertEquals(position.getX(), frog.moveUp().getX());   // x mantém-se
    }

    @Test
    void moveRight(){
        assertEquals(position.getY(), frog.moveUp().getY());   // y mantém-se
        assertEquals(position.getX()+1, frog.moveUp().getX());  // x aumenta
    }

    @Test
    void moveLeft(){
        assertEquals(position.getY(), frog.moveUp().getY());  // y mantém-se
        assertEquals(position.getX()-1, frog.moveUp().getX());   // x diminui
    }

}
