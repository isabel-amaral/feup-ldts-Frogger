package pt.up.fe.ldts.frogger;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Turtle extends MovableElement {
    //either left or right
    private String movementDirection;

    public Turtle(int x, int y, String direction) {
        super(x,y);
        this.movementDirection = direction;
    }

    public String getElementType() {
        return "Turtle";
    }

    public String getMovementDirection() {
        return movementDirection;
    }

    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#e67e22"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()),"T");
    }

    public void move(Command command) {
        this.position = command.execute(position);
    }
}
