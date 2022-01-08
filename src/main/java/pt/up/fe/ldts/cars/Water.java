package pt.up.fe.ldts.cars;

import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Water extends NonMovableElement {
    public Water(int min, int max) {
        super(min, max);
    }

    public void draw(TextGraphics graphics){
        for (int y = position.getYMin(); y <= position.getYMax(); y++) {
            graphics.setForegroundColor(TextColor.Factory.fromString("#5dade2"));
            for (int x = 1; x <= 60; x++)
                graphics.putString(x, y, String.valueOf(Symbols.BLOCK_SOLID));
        }
    }
}
