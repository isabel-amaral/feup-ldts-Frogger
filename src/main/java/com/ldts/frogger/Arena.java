package com.ldts.frogger;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    private int width;
    private int height;
    private Frog frog;
    private List<Car> cars;
    private List<TreeTrunk> treeTrunks;
    private List<Turtle> turtles;
    private Water water;
    private Grass grass;
    private Sidewalk sidewalkSecond;
    private Sidewalk sidewalkFirst;

    public Arena (int width, int height){
        this.width = width;
        this.height = height;
        //later to be created using the factory method!
        this.frog = new Frog(30, 29);
        this.cars = createCars();
        this.treeTrunks = createTreeTrunks();
        this.turtles = createTurtles();

        this.water = new Water(5, 15);
        this.grass = new Grass(1, 4);
        this.sidewalkFirst = new Sidewalk(27, 29);
        this.sidewalkSecond = new Sidewalk(14, 16);
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
    public Sidewalk getSidewalkFirst(){
        return sidewalkFirst;
    }
    public Sidewalk getSidewalkSecond(){
        return sidewalkSecond;
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

        water.draw(graphics);
        sidewalkFirst.draw(graphics);
        sidewalkSecond.draw(graphics);
        grass.draw(graphics);
        frog.draw(graphics);
        for (Car car: cars)
            car.draw(graphics);
        for(TreeTrunk treeTrunk: treeTrunks)
            treeTrunk.draw(graphics);
        for(Turtle turtle: turtles)
            turtle.draw(graphics);
    }

    //Later we will use a random method to create the cars, treeTrunks and Turtles
    public List<Car> createCars() {
        //TODO: arranjar forma de apenas criar os carros dentro das estradas
        List<Car> cars = new ArrayList<>();
        List<Position> positions = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Car car = new Car(i, i);
            if((!positions.contains(car.getPosition())) && car.getPosition()!=frog.getPosition()) {
                cars.add(car);
                positions.add(car.getPosition());
            }
        }
        return cars;
    }

    //Later we will use a random method to create the cars, treeTrunks and Turtles
    public List<TreeTrunk> createTreeTrunks() {
        //TODO: arranjar forma de apenas criar os troncos dentro da água
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

    //Later we will use a random method to create the cars, treeTrunks and Turtles
    public List<Turtle> createTurtles() {
        //TODO: arranjar forma de apenas criar as tartarugas dentro da água
        List<Turtle> turtles = new ArrayList<>();
        List<Position> positions = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Turtle turtle = new Turtle(i, i);
            if ((!positions.contains(turtle.getPosition())) && turtle.getPosition()!=frog.getPosition()) {
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

        if (x <= 0 || x > width || y <= 0 || y > height)
            return false;

        if (this.verifyCarCollision(position))
            return false;
        if (this.verifyWaterCollision(position))
            return false;
        if (this.verifyGrassCollision(position))
            return true;
        if (this.verifyTreeTrunkCollision(position))
            return true;
        if (this.verifyTurtleCollision(position))
            return true;
        //TODO: ldts.frogger.Water restriction and ldts.frogger.Grass restriction
        return true;
    }

    //Possibly to change after implementing the state pattern
    public boolean verifyCarCollision(Position frogNewPosition) {
        for(Car car: cars) {
            if (car.getPosition().equals(frogNewPosition)) {
                //State = lose
                System.out.println("GAME OVER");
                return true;
            }
        }
        return false;
    }

    //Possibly to change after implementing the state pattern
    public boolean verifyTurtleCollision(Position frogNewPosition) {
        for(Turtle turtle : turtles) {
            if (turtle.getPosition().equals(frogNewPosition))
                return true;
        }
        return false;
    }

    //Possibly to change after implementing the state pattern
    public boolean verifyTreeTrunkCollision(Position frogNewPosition) {
        for (TreeTrunk treeTrunk : treeTrunks) {
            if (treeTrunk.getPosition().equals(frogNewPosition))
                return true;
        }
        return false;
    }

    //Possibly to change after implementing the state pattern
    public boolean verifyWaterCollision(Position frogNewPosition) {
        if (water.getPosition().equals(frogNewPosition)) {
            //State = lose
            System.out.println("GAME OVER");
            return true;
        }
        return false;
    }

    //Possibly to change after implementing the state pattern
    public boolean verifyGrassCollision(Position frogNewPosition) {
        if (grass.getPosition().equals(frogNewPosition)) {
            //State = win
            System.out.println("YOU WON");
            return true;
        }
        return false;
    }
}
