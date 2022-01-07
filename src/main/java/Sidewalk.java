import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Sidewalk extends NonMovableElement{

    public Sidewalk(int min, int max) {
        super(min,max);
    }

    public void draw(TextGraphics graphics){
        //TODO: corrigir
        /*
        graphics.setForegroundColor(TextColor.Factory.fromString("#b175ff"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getYMin(), position.getYMax()),"SDW");*/
    }
}
