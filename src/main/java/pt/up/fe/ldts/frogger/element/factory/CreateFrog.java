package pt.up.fe.ldts.frogger.element.factory;

import pt.up.fe.ldts.frogger.element.movable.Frog;
import pt.up.fe.ldts.frogger.element.movable.MovableElement;

import java.util.ArrayList;
import java.util.List;

public class CreateFrog extends MovableElementsFactory {

    public CreateFrog(int level) {
        super(level);
    }

    @Override
    public List<MovableElement> create() {
        List<MovableElement> frog = new ArrayList<>();
        frog.add(new Frog(30, 29));
        return frog;
    }
}
