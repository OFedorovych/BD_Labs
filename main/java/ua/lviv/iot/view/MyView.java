package ua.lviv.iot.view;

import ua.lviv.iot.controller.CategoriesController;
import ua.lviv.iot.controller.CharacteristicController;
import ua.lviv.iot.controller.CountryController;
import ua.lviv.iot.model.CategoryEntity;
import ua.lviv.iot.model.CharacteristicEntity;
import ua.lviv.iot.model.CountryEntity;
import ua.lviv.iot.model.implementation.CategoryEntityImpl;
import ua.lviv.iot.model.implementation.CharacteristicEntityImpl;
import ua.lviv.iot.model.implementation.CountryEntityImpl;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MyView {

    private Map<String, String> menu;
    private Map<String, Printable> methodsMenu;
    private static Scanner input = new Scanner(System.in);

    public MyView(){
        menu = new LinkedHashMap<>();
        menu.put("1", "1 - Table: Categories");
        menu.put("11", "11 - Show all categories");
        menu.put("12", "12 - Create category");
        menu.put("13", "13 - Delete category");
        menu.put("14", "14 - Find category by id");
        menu.put("15", "15 - Update category");

        menu.put("2", "2 - Table: Characteristics");
        menu.put("21", "21 - Show all characteristics");
        menu.put("22", "22 - Find characteristic by id");
        menu.put("23", "23 - Create characteristic");
        menu.put("24", "24 - Update characteristic");
        menu.put("25", "25 - Delete characteristic");

        menu.put("3", "3 - Table: Characteristics");
        menu.put("31", "31 - Show all characteristics");
        menu.put("32", "32 - Find characteristic by id");
        menu.put("33", "33 - Create characteristic");
        menu.put("34", "34 - Update characteristic");
        menu.put("35", "35 - Delete characteristic");
        
        menu.put("Q", "Q - quit");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("11", this::showCategories);
        methodsMenu.put("12", this::createCategory);
        methodsMenu.put("13", this::deleteCategory);
        methodsMenu.put("14", this::findCategoryById);
        methodsMenu.put("15", this::updateCategory);

        methodsMenu.put("21", this::showCharacteristics);
        methodsMenu.put("22", this::findCharacteristicById);
        methodsMenu.put("23", this::createCharacteristic);
        methodsMenu.put("24", this::updateCharacteristic);
        methodsMenu.put("25", this::deleteCharacteristic);

        methodsMenu.put("31", this::showCountries);
        methodsMenu.put("32", this::findCountryById);
        methodsMenu.put("33", this::createCountry);
        methodsMenu.put("34", this::updateCountry);
        methodsMenu.put("35", this::deleteCountry);
        
    }
//--------------------------------------------------------------------------------------------------------
    private void showCategories() throws SQLException {
        CategoriesController categoriesController = new CategoriesController();
        List<CategoryEntity> items = categoriesController.findAll();
        for(CategoryEntity entity: items){
            System.out.println(entity);
        }
    }

    private void createCategory() throws SQLException{
        CategoryEntityImpl entity = new CategoryEntityImpl();
        System.out.print("Input category name: ");
        entity.setCatName(input.nextLine());
        CategoriesController categoriesController = new CategoriesController();
        int count = categoriesController.create(entity);
        System.out.printf("There ere created %d rows\n", count);
    }

    private void deleteCategory() throws SQLException{
        String id;
        System.out.print("Input category ID to delete: ");
        id = input.nextLine();
        CategoriesController categoriesController = new CategoriesController();
        int count = categoriesController.delete(id);
        System.out.printf("There ere deleted %d rows\n", count);
    }

    private void findCategoryById() throws SQLException {
        String id;
        System.out.print("Input category ID to show: ");
        id = input.nextLine();
        CategoriesController categoriesController = new CategoriesController();
        CategoryEntity item = new CategoryEntityImpl();
        item = categoriesController.findByID(id);
        if (item.getCatName() == null){
            System.out.print("There is no such item\n");
        }else{
            System.out.println(item);
        }
    }

    private void updateCategory() throws SQLException {
        CategoryEntityImpl entity = new CategoryEntityImpl();
        System.out.print("Input category id: ");
        entity.setCatID(Integer.parseInt(input.nextLine()));
        System.out.print("Input category name: ");
        entity.setCatName(input.nextLine());
        CategoriesController categoriesController = new CategoriesController();
        int count = categoriesController.update(entity);
        System.out.printf("There ere updated %d rows\n", count);
    }
//--------------------------------------------------------------------------------------------------------
    private void showCharacteristics() throws SQLException {
        CharacteristicController characteristicController = new CharacteristicController();
        List<CharacteristicEntity> items = characteristicController.findAll();
        for(CharacteristicEntity entity: items){
            System.out.println(entity);
        }
    }
    
    private void findCharacteristicById() throws SQLException {
         String id;
         System.out.print("Input category ID to show: ");
         id = input.nextLine();
         CharacteristicController сharacteristicController = new CharacteristicController();
        CharacteristicEntity item = new CharacteristicEntityImpl();
         item = сharacteristicController.findByID(id);
         if (item.getCharacName() == null){
             System.out.print("There is no such item\n");
         }else{
             System.out.println(item);
         }
    }
    
    private void createCharacteristic() throws SQLException{
         CharacteristicEntityImpl entity = new CharacteristicEntityImpl();
         System.out.print("Input category name: ");
         entity.setCharacName(input.nextLine());
         CharacteristicController characteristicController = new CharacteristicController();
         int count = characteristicController.create(entity);
         System.out.printf("There ere created %d rows\n", count);
    }
    
    private void updateCharacteristic() throws SQLException {
        CharacteristicEntityImpl entity = new CharacteristicEntityImpl();
        System.out.print("Input category id: ");
        entity.setCharacID(Integer.parseInt(input.nextLine()));
        System.out.print("Input category name: ");
        entity.setCharacName(input.nextLine());
        CharacteristicController characteristicController = new CharacteristicController();
        int count = characteristicController.update(entity);
        System.out.printf("There ere updated %d rows\n", count);
    }
    
    private void deleteCharacteristic() throws SQLException {
        String id;
        System.out.print("Input category ID to delete: ");
        id = input.nextLine();
        CharacteristicController characteristicController = new CharacteristicController();
        int count = characteristicController.delete(id);
        System.out.printf("There ere deleted %d rows\n", count);
    }
    //--------------------------------------------------------------------------------------------------------
    private void showCountries() throws SQLException {
        CountryController countryController = new CountryController();
        List<CountryEntity> items = countryController.findAll();
        for(CountryEntity entity: items){
            System.out.println(entity);
        }
    }
    
    private void findCountryById() throws SQLException { 
        String id;
        System.out.print("Input category ID to show: ");
        id = input.nextLine();
        CountryController countryController = new CountryController();
        CountryEntity item = new CountryEntityImpl();
        item = countryController.findByID(id);
        if (item.getCountryName() == null){
            System.out.print("There is no such item\n");
        }else{
            System.out.println(item);
        }
    }
    
    private void createCountry() throws SQLException{ 
        CountryEntityImpl entity = new CountryEntityImpl();
        System.out.print("Input category name: ");
        entity.setCountryName(input.nextLine());
        CountryController countryController = new CountryController();
        int count = countryController.create(entity);
        System.out.printf("There ere created %d rows\n", count);
    }
    
    private void updateCountry() throws SQLException {
        CountryEntityImpl entity = new CountryEntityImpl();
        System.out.print("Input category id: ");
        entity.setCountryID(Integer.parseInt(input.nextLine()));
        System.out.print("Input category name: ");
        entity.setCountryName(input.nextLine());
        CountryController countryController = new CountryController();
        int count = countryController.update(entity);
        System.out.printf("There ere updated %d rows\n", count);
    }

    private void deleteCountry() throws SQLException {
        String id;
        System.out.print("Input category ID to delete: ");
        id = input.nextLine();
        CountryController countryController = new CountryController();
        int count = countryController.delete(id);
        System.out.printf("There ere deleted %d rows\n", count);
    }
//--------------------------------------------------------------------------------------------------------
    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet()) {
            if (key.length() == 1) System.out.println(menu.get(key));
        }
    }

    private void outputSubMenu(String mainMenu){
        System.out.println("\nSUB MENU for " + menu.get(mainMenu));
        for (String key : menu.keySet()) {
            if (key.length() != 1 && key.substring(0, 1).equals(mainMenu)) System.out.println(menu.get(key));
        }
    }

    public void showMenu() {
        String keyMenu;
        do {
            outputMenu();
            System.out.print("Please, select menu point ");
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.matches("^\\d")){
                outputSubMenu(keyMenu);
                System.out.print("Please, select menu point ");
                keyMenu = input.nextLine().toUpperCase();
            }
            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
            }
        } while (!keyMenu.equals("Q"));
    }
}
