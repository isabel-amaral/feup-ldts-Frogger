package pt.up.fe.ldts.frogger;

import java.util.ArrayList;
import java.util.List;

public class MovableElementsFactory {
    protected int level;
    private String elementType;
    protected int row; //the row (y in Position) where the list of elements will be created is decided previously in the arena
    //a list of tree trunks previously created will be needed to correctly create the list of turtles
    protected List<MovableElement> treeTrunks = new ArrayList<>();

    public MovableElementsFactory(int level) {
        this.level = level;
    }

    public MovableElementsFactory(int level, int row) {
        this.level = level;
        this.row = row;
    }

    public MovableElementsFactory(int level, String elementType) {
        this.level = level;
        this.elementType = elementType;
    }

    public MovableElementsFactory(int level, int row, String elementType) {
        this.level = level;
        this.row = row;
        this.elementType = elementType;
    }

    public MovableElementsFactory(int level, int row, List<MovableElement> treeTrunks) {
        this.level = level;
        this.row = row;
        this.treeTrunks = treeTrunks;
    }

    //this method will be called once for every row of elements we want to create in Arena
    //TODO: change elementType to an enum type
    public List<MovableElement> create() {
        if (elementType.equals("Car"))
            return new CreateCar(level, row).create();
        if (elementType.equals("TreeTrunk"))
            return new CreateTreeTrunk(level, row).create();
        if (elementType.equals("Turtle"))
            return new CreateTurtle(level, row, treeTrunks).create();
        else //elementType.equals("Frog")
            return new CreateFrog(level).create();
    }
}
