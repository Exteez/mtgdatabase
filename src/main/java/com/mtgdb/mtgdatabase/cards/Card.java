package com.mtgdb.mtgdatabase.cards;

import com.mtgdb.mtgdatabase.cards.attributes.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Card {

    public String getSuperTypeInString() {
        return superTypeInString;
    }

    @Id
    @SequenceGenerator(
            name = "card_sequence",
            sequenceName = "card_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "card_sequence"
    )

    private Long id;
    private String name;

    @Transient //will not be a column in the database
    private List<Cost> cost;
    private String costInString = new String();

    private int cmc;

    @Transient //will not be a column in the database
    private List<SuperType> superType;
    private String superTypeInString = new String();

    @Transient //will not be a column in the database
    private List<Type> type;
    private String typeInString = new String();

    @Transient //will not be a column in the database
    private List<SubType> subType;
    private String subTypeInString = new String();

    private String textbox;
    private int power;
    private int thoughness;

    @Transient //will not be a column in the database
    private ArrayList<String> color = new ArrayList<>();
    private String colorInString = new String();




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


        //if the card does not have an explicit color, it is considered to be colorless
        //else calculates color from cost, ignoring duplicate symbols.
        if(color.size() == 0){
            color.add("colorless");
        }
        for (int i = 0; i < cost.size(); i++) {
            if(cost.get(i).colorOfMana != Cost.NONE.colorOfMana && !colorInString.contains(cost.get(i).colorOfMana)){
                if(colorInString.isBlank()){
                    colorInString += cost.get(i).colorOfMana;
                }else{
                    colorInString +=", "+ cost.get(i).colorOfMana;
                }
            }
        }


        //puts the cost in one string
        for (int i = 0; i < superType.size(); i++) {
            if(i == 0){
                costInString += cost.get(i).colorOfMana;
            }else{
                costInString +=", "+ cost.get(i).colorOfMana;
            }
        }


        //puts the SuperTypes, Types and SubTypes in one string
        for (int i = 0; i < superType.size(); i++) {
            if(i == 0){
                superTypeInString += superType.get(i);
            }else{
                superTypeInString +=", "+ superType.get(i);
            }
        }

        for (int i = 0; i < type.size(); i++) {
            if(i == 0){
                typeInString += type.get(i);
            }else{
                typeInString +=", "+ type.get(i);
            }
        }

        for (int i = 0; i < subType.size(); i++) {
            if(i == 0){
                subTypeInString += subType.get(i);
            }else{
                subTypeInString +=", "+ subType.get(i);
            }
        }






    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @OneToMany(targetEntity=Card.class, mappedBy="Cost",
            fetch=FetchType.EAGER)
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

    public String getCostInString() {
        return costInString;
    }

    public String getColorInString() {
        return colorInString;
    }

    public int getThoughness() {
        return thoughness;
    }

    public ArrayList<String> getColor() {
        return color;
    }
    public String getTypeInString() {
        return typeInString;
    }

    public String getSubTypeInString() {
        return subTypeInString;
    }

    @Override
    public String toString() {
        return "Card{" +
                ",\n id='" + id + '\'' +
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
