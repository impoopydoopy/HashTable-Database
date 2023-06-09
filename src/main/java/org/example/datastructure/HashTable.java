package org.example.datastructure;

public class HashTable {

    public INode[] database;
    public static final int TABLE_SIZE = 10;

    public HashTable() {
        database = new INode[TABLE_SIZE];
    }

    public void addNode(INode node) {
        int key = node.getKey();
        int index = hashFunction(key);

        if (database[index] == null) {
            database[index] = node;
        } else {
            int newIndex = (index + 1) % TABLE_SIZE;

            while (newIndex != index && database[newIndex] != null) {
                newIndex = (newIndex + 1) % TABLE_SIZE;
            }

            if (database[newIndex] == null) {
                database[newIndex] = node;
            } else {
                throw new RuntimeException("Hash table is full. Cannot add the node.");
            }
        }
    }

    public INode getNode(int key) {
        int index = hashFunction(key);

        if (database[index] != null && database[index].getKey() == key) {
            return database[index];
        } else {
            int newIndex = (index + 1) % TABLE_SIZE;

            while (newIndex != index) {
                if (database[newIndex] != null && database[newIndex].getKey() == key) {
                    return database[newIndex];
                }
                newIndex = (newIndex + 1) % TABLE_SIZE;
            }

            throw new RuntimeException("Node with key " + key + " not found in the hash table.");
        }
    }

    public void updateNode(INode updatedNode) {
        int key = updatedNode.getKey();
        int index = hashFunction(key);

        if (database[index] != null && database[index].getKey() == key) {
            database[index] = updatedNode;
        } else {
            int newIndex = (index + 1) % TABLE_SIZE;

            while (newIndex != index) {
                if (database[newIndex] != null && database[newIndex].getKey() == key) {
                    database[newIndex] = updatedNode;
                    return;
                }
                newIndex = (newIndex + 1) % TABLE_SIZE;
            }

            throw new RuntimeException("Node with key " + key + " not found in the hash table. Cannot update.");
        }
    }

    public void deleteNode(int key) {
        int index = hashFunction(key);

        if (database[index] != null && database[index].getKey() == key) {
            database[index] = null;
        } else {
            int newIndex = (index + 1) % TABLE_SIZE;

            while (newIndex != index) {
                if (database[newIndex] != null && database[newIndex].getKey() == key) {
                    database[newIndex] = null;
                    return;
                }
                newIndex = (newIndex + 1) % TABLE_SIZE;
            }

            throw new RuntimeException("Node with key " + key + " not found in the hash table. Cannot delete.");
        }
    }

    private int hashFunction(int key) {
        return key % TABLE_SIZE;
    }

    public void printTable() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            if (database[i] != null) {
                System.out.println("Index " + i + ":");
                System.out.println(database[i].getData());
            }
        }
    }

    public INode findNodeByKey(int key) {
        int index = hashFunction(key);

        if (database[index] != null && database[index].getKey() == key) {
            return database[index];
        } else {
            int newIndex = (index + 1) % TABLE_SIZE;

            while (newIndex != index) {
                if (database[newIndex] != null && database[newIndex].getKey() == key) {
                    return database[newIndex];
                }
                newIndex = (newIndex + 1) % TABLE_SIZE;
            }
        }
        return null;
    }
}