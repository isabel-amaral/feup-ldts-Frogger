package pt.up.fe.ldts.frogger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateTreeTrunk extends MovableElementsFactory {

    public CreateTreeTrunk(int level, int row) {
        super(level, row);
    }

    //number of tree trunks in each section (row) of the water decreases with the level
    public int numElements() {
        Random random = new Random();
        if (level == 1)
            return random.nextInt(12 - 9) + 9;
        if (level == 2)
            return random.nextInt(9 - 6) + 6;
        else //level == 3
            return random.nextInt(6 - 3) + 3;
    }

    //check if the random method isn't accidentally creating two tree trunks at the same position
    public boolean checkOverlapping(List<MovableElement> treeTrunks, Position position) {
        for (MovableElement treeTrunk: treeTrunks)
            if (treeTrunk.getPosition().equals(position))
                return true;
        return false;
    }

    @Override
    public List<MovableElement> create() {
        Random random = new Random();
        List<MovableElement> treeTrunks = new ArrayList<>();

        int numElements = numElements();
        for (int i = 0; i < numElements; i++) {
            int x;
            do {
                x = random.nextInt(59);
            } while (checkOverlapping(treeTrunks, new Position(x, row)));
            TreeTrunk treeTrunk = new TreeTrunk(x, row);
            treeTrunks.add(treeTrunk);
        }
        return treeTrunks;
    }
}
