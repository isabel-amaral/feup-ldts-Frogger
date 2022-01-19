package pt.up.fe.ldts.frogger;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Instruction {
    TextGraphics graphics;
    Game game;
    Screen screen;
    File instructionsFile;
    Scanner reader;
    private int width= 60;
    private int height = 30;

    public Instruction(Game option2) throws FileNotFoundException {
        instructionsFile =  new File("src/main/resources/Instructions.txt");
        reader = new Scanner(instructionsFile);
        game = option2;
        screen = game.getScreen();
        graphics = game.getGraphics();
    }

    public void show() throws IOException {
        screen.clear();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));

        //graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

        String Title = reader.nextLine();
        String r1 = reader.nextLine();
        String r1c = reader.nextLine();
        String r2 = reader.nextLine();
        String r2c = reader.nextLine();
        String r3 = reader.nextLine();
        String r3c = reader.nextLine();
        String r4 = reader.nextLine();
        String r4c = reader.nextLine();
        String r5 = reader.nextLine();
        String r6 = reader.nextLine();
        reader.close();

        graphics.putString(new TerminalPosition(1, 1), Title);
        graphics.putString(new TerminalPosition(1, 3), r1);
        graphics.putString(new TerminalPosition(1, 4), r1c);
        graphics.putString(new TerminalPosition(1, 6), r2);
        graphics.putString(new TerminalPosition(1, 7), r2c);
        graphics.putString(new TerminalPosition(1, 9), r3);
        graphics.putString(new TerminalPosition(1, 10), r3c);
        graphics.putString(new TerminalPosition(1, 12), r4);
        graphics.putString(new TerminalPosition(1, 13), r4c);
        graphics.putString(new TerminalPosition(1, 15), r5);
        graphics.putString(new TerminalPosition(1, 17), r6);

        screen.refresh();
    }
}

