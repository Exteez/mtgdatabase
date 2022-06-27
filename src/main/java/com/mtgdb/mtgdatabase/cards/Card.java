package com.mtgdb.mtgdatabase.cards;

import com.mtgdb.mtgdatabase.cards.attributes.*;
import net.bytebuddy.implementation.bind.annotation.Super;

import java.util.ArrayList;
import java.util.EnumSet;
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
    private List<Color> color;

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

        for(int i = 0; i<cost.size(); i++){
            cmc+=cost.get(i).manaAsValue;
        };
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cost> getCost() {
        return cost;
    }

    public void setCost(List<Cost> cost) {
        this.cost = cost;
    }

    public int getCmc() {
        return cmc;
    }


    public List<SuperType> getSuperType() {
        return superType;
    }

    public void setSuperType(List<SuperType> superType) {
        this.superType = superType;
    }

    public List<Type> getType() {
        return type;
    }

    public void setType(List<Type> type) {
        this.type = type;
    }

    public List<SubType> getSubType() {
        return subType;
    }

    public void setSubType(List<SubType> subType) {
        this.subType = subType;
    }

    public String getTextbox() {
        return textbox;
    }

    public void setTextbox(String textbox) {
        this.textbox = textbox;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getThoughness() {
        return thoughness;
    }

    public void setThoughness(int thoughness) {
        this.thoughness = thoughness;
    }

    public List<Color> getColor() {
        return color;
    }

    public void setColor(List<Color> color) {
        this.color = color;
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
