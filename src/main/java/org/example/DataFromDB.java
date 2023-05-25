package org.example;

import java.time.LocalDate;

public class DataFromDB {
    public int planned_menu_id;
    public String group_pm_name;
    public LocalDate day_date;
    public String meal_name;
    public String dish_name;

    public DataFromDB(){

    }
    public DataFromDB(int planned_menu_id, String group_pm_name, LocalDate day_date, String meal_name, String dish_name){
        this.planned_menu_id = planned_menu_id;
        this.group_pm_name = group_pm_name;
        this.day_date = day_date;
        this.meal_name = meal_name;
        this.dish_name = dish_name;
    }

    public void setPlanned_menu_id(int planned_menu_id) {
        this.planned_menu_id = planned_menu_id;
    }

    public void setGroup_pm_name(String group_pm_name) {
        this.group_pm_name = group_pm_name;
    }

    public void setDay_date(LocalDate day_date) {
        this.day_date = day_date;
    }

    public void setMeal_name(String meal_name) {
        this.meal_name = meal_name;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }
}
