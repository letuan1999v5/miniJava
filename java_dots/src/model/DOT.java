package model;

import java.util.ArrayList;

public enum DOT {

    BLUE("view/resources/dotchooser/0blue_tick.png"),
    GREEN("view/resources/dotchooser/0green_tick.png");
//    RED("./view/resources/dotschooser/red_dot.png"),
//    YELLOW("./view/resources/dotschooser/1yellow_dot.png");


    private String urlDot;
    public Vector position;
//    double a,y;

//    public static ArrayList<DOT> dots = new ArrayList<>();


    DOT(String urlDot){
        this.urlDot = urlDot;
//        setPosition(this.position);

    }

    public String getUrl(){
        return this.urlDot;
    }

    public void setPosition(Vector position) {
        this.position.set(this.position.x,this.position.y);
        System.out.println("position.x" + this.position.x);

    }

}
