package pt.up.fe.ldts.frogger;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class TreeTrunk extends MovableElement {

    public TreeTrunk(int x, int y) {
        super(x,y);
    }

    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#7e5109"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()),"v"); //Depois adiciona-se t e u antes
    }

    public String getElementType() {
        return "TreeTrunk";
    }
}
