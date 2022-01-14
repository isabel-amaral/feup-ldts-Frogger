package pt.up.fe.ldts.frogger;

public class MoveRight extends Command{

    public Position execute(Position position) {
        if (position.getX() == 60)
            return new Position(1, position.getY());
        return new Position(position.getX() + 1, position.getY());
    }
}
