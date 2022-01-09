package pt.up.fe.ldts.frogger;

public abstract class MovableElement implements Element {

    protected Position position;

    public MovableElement(int x, int y){
        position = new Position(x,y);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}