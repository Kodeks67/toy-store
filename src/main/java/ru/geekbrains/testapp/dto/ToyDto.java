package ru.geekbrains.testapp.dto;

public class ToyDto {

    private int id;
    private String name;
    private int quantity;
    private double weight;

    public ToyDto(int id, String name, int quantity, double weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void reduceQuantity() {
        if (quantity > 0) {
            quantity--;
        }
    }
}
