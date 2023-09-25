import java.util.*;

public class Toy implements Comparable<Toy> {
    private final int id;
    private final String name; 
    private final int weight; 
    public Toy(int id, String name, int weight) throws RuntimeException {
        this.id = id;
        if (name.length() == 0) {
            throw new RuntimeException("Toy: name.length() == 0");
        }
        this.name = name;

        if (weight < 1 || weight > 99) {
            throw new RuntimeException("Toy: set weight out of range [1; 99]");
        }
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        return String.format("(id: %d, name: %s, weight: %d)", id, name, weight);
    }

    public int compareTo(Toy o){
        int deltaWeigths = o.getWeight() - this.weight;
        if(deltaWeigths != 0) return deltaWeigths;
        return this.getName().compareTo(o.getName());
    }
}