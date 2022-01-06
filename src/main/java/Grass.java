import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Grass {
    private PositionRange position;

    public Grass(int min, int max) {
        this.position = new PositionRange(min, max);
    }

    public PositionRange getPosition() {
        return position;
    }

    public void draw(TextGraphics graphics){
        //TODO: corrigir
        /*
        graphics.setForegroundColor(TextColor.Factory.fromString("#1e8449"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getYMin(), position.getYMax()),"G");*/
    }
}
