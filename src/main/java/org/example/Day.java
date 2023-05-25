package org.example;

import java.time.LocalDate;

public class Day {
    public int id;
    public int id_planned_menu;
    public LocalDate date;
    public Day(int id, int id_planned_menu, LocalDate date){
        this.id = id;
        this.id_planned_menu = id_planned_menu;
        this.date = date;
    }

    public Day() {

    }
}
