package pt.up.fe.ldts.cars;

public abstract class NonMovableElement implements Element{
    protected PositionRange position;

    public NonMovableElement(int min, int max){
        position = new PositionRange(min,max);
    }

    public PositionRange getPosition() {
        return position;
    }
}
