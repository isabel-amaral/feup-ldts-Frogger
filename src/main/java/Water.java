import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Water {
    private PositionRange position;

    public Water(int min, int max) {
        this.position = new PositionRange(min, max);
    }

    public void draw(TextGraphics graphics){
        //TODO: corrigir
        /*
        graphics.setForegroundColor(TextColor.Factory.fromString("#5dade2"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()),"W");*/
    }
}
