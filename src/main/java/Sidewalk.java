import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Sidewalk {
    private final PositionRange position;

    public Sidewalk(int min, int max) {
        this.position = new PositionRange(min, max);
    }

    public PositionRange getPosition() {
        return position;
    }

    public void draw(TextGraphics graphics){
        for (int y = position.getYMin(); y <= position.getYMax(); y++) {
            graphics.setForegroundColor(TextColor.Factory.fromString("#b175ff"));
            for (int x = 1; x <= 60; x++)
                graphics.putString(x, y, String.valueOf(Symbols.BLOCK_SOLID));
        }
    }
}
