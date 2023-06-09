package org.example.DTO;

import lombok.Data;
import org.example.datastructure.INode;

@Data
public class Contract implements INode {

    private int key;

    private String contractType;
    private int[] employeeID;
    private int shipID;

    public Contract(int key, String contractType, int[] employeeID, int shipID) {
        this.key = key;
        this.contractType = contractType;
        this.employeeID = employeeID;
        this.shipID = shipID;
    }

    public int getKey() {
        return key;
    }

    public String getData() {
        return contractType;
    }
}
