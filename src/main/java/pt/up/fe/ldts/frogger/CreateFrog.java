package pt.up.fe.ldts.frogger;

import java.util.ArrayList;
import java.util.List;

public class CreateFrog extends MovableElementsFactory {

    public CreateFrog(int level) {
        super(level);
    }

    @Override
    public List<MovableElement> create() {
        List<MovableElement> frog = new ArrayList<>();
        if (level == 1)
            frog.add(new Frog(30, 29));
        if (level == 2)
            frog.add(new Frog(45, 27));
        else //level == 3
            frog.add(new Frog(3, 27));
        return frog;
    }
}
