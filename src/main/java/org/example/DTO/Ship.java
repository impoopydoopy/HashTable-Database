package org.example.DTO;

import lombok.Data;
import org.example.datastructure.INode;

@Data
public class Ship implements INode {

    private int key;
    private String shipName;
    private String shipType;

    public Ship(int key, String shipName, String shipType) {
        this.key = key;
        this.shipName = shipName;
        this.shipType = shipType;
    }

    public int getKey() {
        return key;
    }

    public String getData() {
        return shipName + " " + shipType;
    }
}
