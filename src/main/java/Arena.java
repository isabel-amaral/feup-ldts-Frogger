import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int width;
    private int height;
    private Frog frog = new Frog(10, 10);
    private List<Car> cars;
    private List<TreeTrunk> treeTrunks;
    private List<Turtle> turtles;
    private Water water;
    private Grass grass;
    private Sidewalk sidewalk;

    public Arena (int new_width, int new_height){
        width = new_width;
        height = new_height;
        this.cars = createCars();
        this.treeTrunks = createTreeTrunks();
        this.turtles = createTurtles();
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public Frog getFrog(){
        return frog;
    }

    public List<Car> getCars(){
        return cars;
    }

    public List<TreeTrunk> getTreeTrunks(){
        return treeTrunks;
    }

    public List<Turtle> getTurtles(){
        return turtles;
    }

    public Water getWater(){
        return water;
    }

    public Grass getGrass(){
        return grass;
    }

    public Sidewalk getSidewalks(){
        return sidewalk;
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        frog.draw(graphics);
        for (Car car : cars)
            car.draw(graphics);
        for(TreeTrunk treeTrunk : treeTrunks){
            treeTrunk.draw(graphics);
        }
        for(Turtle turtle : turtles)
            turtle.draw(graphics);
    }

    public void drawText(TextGraphics graphics, Position position, String text, String color){

    }

    public List<Car> createCars() {
        List<Car> cars = new ArrayList<>();
        List<Position> positions = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Car car = new Car(i, i);
            if((!positions.contains(car.getPosition())) && car.getPosition()!=frog.getPosition()){
                cars.add(car);
                positions.add(car.getPosition());
            }
        }
        return cars;
    }

    public List<TreeTrunk> createTreeTrunks() {
        List<TreeTrunk> treeTrunks = new ArrayList<>();
        List<Position> positions = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            TreeTrunk treeTrunk = new TreeTrunk(i, i);
            if((!positions.contains(treeTrunk.getPosition())) && treeTrunk.getPosition()!=frog.getPosition()){
                treeTrunks.add(treeTrunk);
                positions.add(treeTrunk.getPosition());
            }
        }
        return treeTrunks;
    }

    public List<Turtle> createTurtles() {
        List<Turtle> turtles = new ArrayList<>();
        List<Position> positions = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Turtle turtle = new Turtle(i, i);
            if((!positions.contains(turtle.getPosition())) && turtle.getPosition()!=frog.getPosition()){
                turtles.add(turtle);
                positions.add(turtle.getPosition());
            }
        }
        return turtles;
    }

    public void moveFrog(Position position) {
        if (canFrogMove(position))
            frog.setPosition(position);
    }

    public boolean canFrogMove(Position position) {
        int x = position.getX();
        int y = position.getY();
        if((x >= 0 && x < width) && ( y >= 0 && y < height)){
            for(int i = 0; i < cars.size(); i++){
                if (cars.get(i).getPosition().equals(position)){
                    return false;
                }
            }
            for(int i = 0; i < turtles.size(); i++){
                if (turtles.get(i).getPosition().equals(position)){
                    return false;
                }
            }
           //Water restriction
            //Grass restriction
            return true;
        }
        return false;
    }

    public boolean verifyCarCollisions(){
        for(Car car : cars){
            if(car.getPosition().equals(frog.getPosition())){
                //State = lose
                System.out.println("GAME OVER");
                return true;
            }
        }
        return false;
    }

    public boolean verifyTurtleCollisions(){
        for(Turtle turtle : turtles){
            if(turtle.getPosition().equals(frog.getPosition())){
                return true;
            }
        }
        return false;
    }

    public boolean verifyTreeTrunksCollisions(){
        for(TreeTrunk treeTrunk : treeTrunks){
            if(treeTrunk.getPosition().equals(frog.getPosition())){
                return true;
            }
        }
        return false;
    }

    public boolean verifyWaterCollisions(){
        if(water.getPosition().equals(frog.getPosition())){
            //State = lose
            System.out.println("GAME OVER");
            return true;
        }
        return false;
    }

    public boolean verifyGrassCollisions(){
        if(grass.getPosition().equals(frog.getPosition())){
            //State = win
            System.out.println("YOU WON");
            return true;
        }
        return false;
    }

}
