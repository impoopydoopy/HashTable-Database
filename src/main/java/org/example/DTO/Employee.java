package org.example.DTO;

import lombok.Data;
import org.example.datastructure.INode;


@Data
public class Employee implements INode {

    private int key;
    private String name;
    private String position;

    public Employee(int key, String name, String position) {
        this.key = key;
        this.name = name;
        this.position = position;
    }

    public int getKey() {
        return key;
    }

    public String getData() {
        return "ПІБ: " + name + " Посада: " + position;
    }
}