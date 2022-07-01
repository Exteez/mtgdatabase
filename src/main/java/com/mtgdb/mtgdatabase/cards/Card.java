package com.mtgdb.mtgdatabase.cards;

import com.mtgdb.mtgdatabase.cards.attributes.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
public class Card {
    @Id
    @Column(name = "id_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Transient
    private List<Cost> cost;
    private String costInString;
    private int cmc;

    @Transient
    private Set<SuperType> superType;
    private String superTypeInString;

    @Transient
    private Set<Type> type;
    private String typeInString;

    @Transient
    private Set<SubType> subType;
    private String subTypeInString;
    private String textbox;
    private int power;
    private int thoughness;

    @Transient //will not be a column in the database
    private ArrayList<String> color;
    private String colorInString;




    public Card(String name, List<Cost> cost, Set<SuperType> superType, Set<Type> type, Set<SubType> subType,
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
        for (Cost symbol : cost) { cmc+=symbol.manaAsValue;}
        calculateColor(cost);
        costInString = String.join(", ", cost.toString());
        calculateTypes(superType, type, subType);

    }

    private void calculateTypes(Set<SuperType> superType, Set<Type> type, Set<SubType> subType) {
        superTypeInString = String.join(", ", superType.toString());
        typeInString = String.join(", ", type.toString());
        subTypeInString = String.join(", ", subType.toString());
    }

    private void calculateColor(List<Cost> cost) {
        if(color.size() == 0){
            color.add("colorless");
        }
        for (Cost value : cost) {
            if (!Objects.equals(value.colorOfMana, "none") && !colorInString.contains(value.colorOfMana)) {
                colorInString = String.join(", ", value.colorOfMana);
            }
        }
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
