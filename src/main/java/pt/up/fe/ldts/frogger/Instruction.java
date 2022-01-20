package pt.up.fe.ldts.frogger;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.*;
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
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));

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
        String empty = "                                                                            ";

        reader.close();

        graphics.putString(new TerminalPosition(0, 0), empty);
        graphics.putString(new TerminalPosition(0, 1), Title);
        graphics.putString(new TerminalPosition(0, 2), empty);
        graphics.putString(new TerminalPosition(0, 3), r1);
        graphics.putString(new TerminalPosition(0, 4), r1c);
        graphics.putString(new TerminalPosition(0, 5), empty);
        graphics.putString(new TerminalPosition(0, 6), r2);
        graphics.putString(new TerminalPosition(0, 7), r2c);
        graphics.putString(new TerminalPosition(0, 8), empty);
        graphics.putString(new TerminalPosition(0, 9), r3);
        graphics.putString(new TerminalPosition(0, 10), r3c);
        graphics.putString(new TerminalPosition(0, 11), empty);
        graphics.putString(new TerminalPosition(0, 12), r4);
        graphics.putString(new TerminalPosition(0, 13), r4c);
        graphics.putString(new TerminalPosition(0, 14), empty);
        graphics.putString(new TerminalPosition(0, 15), r5);
        graphics.putString(new TerminalPosition(0, 16), empty);
        graphics.putString(new TerminalPosition(0, 17), r6);

        for (int y = 18; y < height; y++)
            for (int x = 0; x < width; x++)
                graphics.putString(new TerminalPosition(x, y), " ");


        screen.refresh();
    }
}

