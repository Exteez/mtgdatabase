package com.mtgdb.mtgdatabase.cards;

import com.mtgdb.mtgdatabase.cards.attributes.*;

import java.util.ArrayList;
import java.util.List;

public class Card {


    private int serial;
    private String name;
    private List<Cost> cost;
    private int cmc;
    private List<SuperType> superType;
    private List<Type> type;
    private List<SubType> subType;
    private String textbox;
    private int power;
    private int thoughness;
    private ArrayList<String> color = new ArrayList<>();

    public Card(String name, List<Cost> cost, List<SuperType> superType, List<Type> type, List<SubType> subType,
                String textbox, int power, int thoughness) {
        this.name = name;
        this.cost = cost;
        this.superType = superType;
        this.type = type;
        this.subType = subType;
        this.textbox = textbox;
        this.power = power;
        this.thoughness = thoughness;



        //calculates the cmc from the user's input.
        for (Cost symbol : cost) {
            cmc+=symbol.manaAsValue;
        }



        //calculates color from cost.
        for (Cost costColor : cost) {
            if(!costColor.colorOfMana.equals("none")){
                color.add(costColor.colorOfMana);
            }
        }
        if(color.size() == 0){
            color.add("colorless");
        }

    }




    public String getName() {
        return name;
    }


    public List<Cost> getCost() {
        return cost;
    }


    public int getCmc() {
        return cmc;
    }


    public List<SuperType> getSuperType() {
        return superType;
    }


    public List<Type> getType() {
        return type;
    }

    public List<SubType> getSubType() {
        return subType;
    }

    public String getTextbox() {
        return textbox;
    }

    public int getPower() {
        return power;
    }

    public int getThoughness() {
        return thoughness;
    }

    public List<String> getColor() {
        return color;
    }


    @Override
    public String toString() {
        return "Card{" +
                "serial=" + serial +
                ",\n name='" + name + '\'' +
                ",\n cost=" + cost +
                ",\n cmc=" + cmc +
                ",\n superType=" + superType +
                ",\n type=" + type +
                ",\n subType=" + subType +
                ",\n textbox='" + textbox + '\'' +
                ",\n power=" + power +
                ",\n thoughness=" + thoughness +
                ",\n color=" + color +
                '}';
    }
}
