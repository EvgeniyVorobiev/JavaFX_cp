package org.example;

public class Dish {
    public int id;
    public String name;
    public float dish_weight;
    public String dish_processing;
    public String dish_characteristic;
    public String dish_technology;

    public Dish(int id, String name, float dish_weight, String dish_processing,
                String dish_characteristic, String dish_technology) {
        this.id = id;
        this.name = name;
        this.dish_weight = dish_weight;
        this.dish_processing = dish_processing;
        this.dish_characteristic = dish_characteristic;
        this.dish_technology = dish_technology;
    }

    public Dish() {

    }

    @Override
    public String toString() {
        return  String.format("ID: %s | Название: %s | Вес: %s | Тип обработки: %s | Характеристика на выходе: %s" +
                        " | Технология приготовления: %s",
                this.id, this.name, this.dish_weight, this.dish_processing, this.dish_characteristic, this.dish_technology);
    }
}
