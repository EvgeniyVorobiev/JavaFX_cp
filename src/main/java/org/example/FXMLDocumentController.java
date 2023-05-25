package org.example;

import java.net.URL;
import java.time.LocalDate;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.postgresql.*;
import java.sql.*;

import javafx.scene.control.TableColumn;

public class FXMLDocumentController implements Initializable{
    @FXML
    private Label label;
    private  ObservableList<DataFromDB> plannedMenuData = FXCollections.observableArrayList();
    @FXML
    private TableView<DataFromDB> tablePlannedMenu;
    @FXML
    private TableColumn<DataFromDB, Integer> id_planned_menu;
    @FXML
    private TableColumn<DataFromDB, String> group_pm_name;
    @FXML
    private TableColumn<DataFromDB, LocalDate> day_date;
    @FXML
    private TableColumn<DataFromDB, String> meal_name;
    @FXML
    private TableColumn<DataFromDB, String> dish_name;
    @FXML
    private void handleButtonAction(ActionEvent event){
        System.out.println("You clicked me!");
        System.out.println();
        System.out.println(tablePlannedMenu.getItems().get(0).group_pm_name);
        label.setText("Hello!");
    }
    @Override
    @FXML
    public void initialize(URL url, ResourceBundle rb){
        initData();
        id_planned_menu.setCellValueFactory(new PropertyValueFactory<DataFromDB, Integer>("id_planned_menu"));
        group_pm_name.setCellValueFactory(new PropertyValueFactory<DataFromDB, String>("group_pm_name"));
        day_date.setCellValueFactory(new PropertyValueFactory<DataFromDB,LocalDate>("day_date"));
        meal_name.setCellValueFactory(new PropertyValueFactory<DataFromDB, String>("meal_name"));
        dish_name.setCellValueFactory(new PropertyValueFactory<DataFromDB, String>("dish_name"));
        tablePlannedMenu.setItems(plannedMenuData);

    }
    private void initData(){
        try {
            Properties props = new Properties();
            props.setProperty("options", "-c search_path=cp,public,pg_catalog -c statement_timeout=90000");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/balancednutrition?user=postgres&ssl=false",props);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select planned_menu.id_planned_menu, group_pm.name group_pm_name," +
                    " day.day_date, meal.name meal_name," +
                    " dish.name dish_name from group_pm join planned_menu on group_pm.id_group_pm = planned_menu.id_group_pm" +
                    " join day on planned_menu.id_planned_menu = day.id_planned_menu" +
                    " join meal on day.id_day = meal.id_day" +
                    " join meal_dish on meal_dish.id_meal = meal.id_meal" +
                    " join dish on meal_dish.id_dish = dish.id_dish;");
            while (rs.next()){
                DataFromDB dataFromDB = new DataFromDB();
                dataFromDB.setPlanned_menu_id(rs.getInt("id_planned_menu"));
                dataFromDB.setGroup_pm_name(rs.getString("group_pm_name"));
                dataFromDB.setDay_date(rs.getDate("day_date").toLocalDate());
                dataFromDB.setMeal_name(rs.getString("meal_name"));
                dataFromDB.setDish_name(rs.getString("dish_name"));

                plannedMenuData.add(dataFromDB);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
