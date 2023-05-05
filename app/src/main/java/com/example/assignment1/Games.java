package com.example.assignment1;



public class Games {

    private String name;
    private int imageID;

    public static final Games[] games = {
            new Games("Math Quiz", R.drawable.img_2),
            new Games("Colors Game", R.drawable.img_3),
            new Games("Code Game", R.drawable.img_4),
            new Games("Animals Game", R.drawable.img_5),
            new Games("Physics Game", R.drawable.img_6),
            new Games("Speed Game", R.drawable.img_7),
    };



    public Games(String name, int imageID) {
        this.name = name;
        this.imageID = imageID;

    }


    public String getName(){return name;}
    public int getImageID(){return imageID;}


}
