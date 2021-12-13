package ua.lviv.iot.view;

import ua.lviv.iot.controller.*;
import ua.lviv.iot.model.*;

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

        menu.put("3", "3 - Table: County");
        menu.put("31", "31 - Show counties");
        menu.put("32", "32 - Find county by id");
        menu.put("33", "33 - Create county");
        menu.put("34", "34 - Update county");
        menu.put("35", "35 - Delete county");
        
        menu.put("4", "4 - Table: Producer");
        menu.put("41", "41 - Show producers");
        menu.put("42", "42 - Find producer by id");
        menu.put("43", "43 - Create producer");
        menu.put("44", "44 - Update producer");
        menu.put("45", "45 - Delete producer");

        menu.put("5", "5 - Table: Good");
        menu.put("51", "51 - Show goods");
        menu.put("52", "52 - Find good by id");
        menu.put("53", "53 - Create good");
        menu.put("54", "54 - Update good");
        menu.put("55", "55 - Delete good");

        menu.put("6", "6 - Table: Warehouse");
        menu.put("61", "61 - Show warehouses");
        menu.put("62", "62 - Find warehouse by id");
        menu.put("63", "63 - Create warehouse");
        menu.put("64", "64 - Update warehouse");
        menu.put("65", "65 - Delete warehouse");;
        
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

        methodsMenu.put("41", this::showProducers);
        methodsMenu.put("42", this::findProducerById);
        methodsMenu.put("43", this::createProducer);
        methodsMenu.put("44", this::updateProducer);
        methodsMenu.put("45", this::deleteProducer);

        methodsMenu.put("51", this::showGoods);
        methodsMenu.put("52", this::findGoodById);
        methodsMenu.put("53", this::createGood);
        methodsMenu.put("54", this::updateGood);
        methodsMenu.put("55", this::deleteGood);

        methodsMenu.put("61", this::showWarehouses);
        methodsMenu.put("62", this::findWarehouseById);
        methodsMenu.put("63", this::createWarehouse);
        methodsMenu.put("64", this::updateWarehouse);
        methodsMenu.put("65", this::deleteWarehouse);

    }
//--------------------------------------------------------------------------------------------------------
    private void showCategories() throws SQLException {
        CategoriesController categoriesController = new CategoriesController();
        List<Categories> items = categoriesController.findAll();
        for(Categories entity: items){
            System.out.println(entity);
        }
    }

    private void createCategory() throws SQLException{
        Categories entity = new Categories();
        System.out.print("Input category name: ");
        entity.setName(input.nextLine());
        CategoriesController categoriesController = new CategoriesController();
        int count = categoriesController.create(entity);
        System.out.printf("There ere created %d rows\n", count);
    }

    private void deleteCategory() throws SQLException{
        String id;
        System.out.print("Input category ID to delete: ");
        id = input.nextLine();
        Categories categories;
        categories = CategoriesController.findByID(id);
        CategoriesController categoriesController = new CategoriesController();
        int count = categoriesController.delete(categories);
        System.out.printf("There ere deleted %d rows\n", count);
    }

    private void findCategoryById() throws SQLException {
        String id;
        System.out.print("Input category ID to show: ");
        id = input.nextLine();
        CategoriesController categoriesController = new CategoriesController();
        Categories item = new Categories();
        item = categoriesController.findByID(id);
        if (item.getName() == null){
            System.out.print("There is no such item\n");
        }else{
            System.out.println(item);
        }
    }

    private void updateCategory() throws SQLException {
        Categories entity = new Categories();
        System.out.print("Input category id: ");
        entity.setId(Integer.parseInt(input.nextLine()));
        System.out.print("Input category name: ");
        entity.setName(input.nextLine());
        CategoriesController categoriesController = new CategoriesController();
        int count = categoriesController.update(entity);
        System.out.printf("There ere updated %d rows\n", count);
    }
//--------------------------------------------------------------------------------------------------------
    private void showCharacteristics() throws SQLException {
        CharacteristicController characteristicController = new CharacteristicController();
        List<Characteristics> items = characteristicController.findAll();
        for(Characteristics entity: items){
            System.out.println(entity);
        }
    }
    
    private void findCharacteristicById() throws SQLException {
         String id;
         System.out.print("Input characteristic ID to show: ");
         id = input.nextLine();
         CharacteristicController сharacteristicController = new CharacteristicController();
         Characteristics item = new Characteristics();
         item = сharacteristicController.findByID(id);
         if (item.getName() == null){
             System.out.print("There is no such item\n");
         }else{
             System.out.println(item);
         }
    }
    
    private void createCharacteristic() throws SQLException{
        Characteristics entity = new Characteristics();
         System.out.print("Input characteristic name: ");
         entity.setName(input.nextLine());
         CharacteristicController characteristicController = new CharacteristicController();
         int count = characteristicController.create(entity);
         System.out.printf("There ere created %d rows\n", count);
    }
    
    private void updateCharacteristic() throws SQLException {
        Characteristics entity = new Characteristics();
        System.out.print("Input characteristic id: ");
        entity.setCharId(Integer.parseInt(input.nextLine()));
        System.out.print("Input characteristic name: ");
        entity.setName(input.nextLine());
        CharacteristicController characteristicController = new CharacteristicController();
        int count = characteristicController.update(entity);
        System.out.printf("There ere updated %d rows\n", count);
    }
    
    private void deleteCharacteristic() throws SQLException {
        String id;
        System.out.print("Input characteristic ID to delete: ");
        id = input.nextLine();
        Characteristics characteristics;
        characteristics = CharacteristicController.findByID(id);
        CharacteristicController characteristicController = new CharacteristicController();
        int count = characteristicController.delete(characteristics);
        System.out.printf("There ere deleted %d rows\n", count);
    }
    //--------------------------------------------------------------------------------------------------------
    private void showCountries() throws SQLException {
        CountryController countryController = new CountryController();
        List<Country> items = countryController.findAll();
        for(Country entity: items){
            System.out.println(entity);
        }
    }
    
    private void findCountryById() throws SQLException { 
        String id;
        System.out.print("Input country ID to show: ");
        id = input.nextLine();
        CountryController countryController = new CountryController();
        Country item = new Country();
        item = countryController.findByID(id);
        if (item.getCountry() == null){
            System.out.print("There is no such item\n");
        }else{
            System.out.println(item);
        }
    }
    
    private void createCountry() throws SQLException{ 
        Country entity = new Country();
        System.out.print("Input country name: ");
        entity.setCountry(input.nextLine());
        CountryController countryController = new CountryController();
        int count = countryController.create(entity);
        System.out.printf("There ere created %d rows\n", count);
    }
    
    private void updateCountry() throws SQLException {
        Country entity = new Country();
        System.out.print("Input country id: ");
        entity.setId(Integer.parseInt(input.nextLine()));
        System.out.print("Input country name: ");
        entity.setCountry(input.nextLine());
        CountryController countryController = new CountryController();
        int count = countryController.update(entity);
        System.out.printf("There ere updated %d rows\n", count);
    }

    private void deleteCountry() throws SQLException {
        String id;
        System.out.print("Input country ID to delete: ");
        id = input.nextLine();
        Country country;
        country = CountryController.findByID(id);
        CountryController countryController = new CountryController();
        int count = countryController.delete(country);
        System.out.printf("There ere deleted %d rows\n", count);
    }
//--------------------------------------------------------------------------------------------------------
    private void showProducers() throws SQLException {
        ProducerController producerController = new ProducerController();
        List<Producer> items = producerController.findAll();
        for(Producer entity: items){
            System.out.println(entity);
        }
    }

    private void findProducerById() throws SQLException {
        String id;
        System.out.print("Input producer ID to show: ");
        id = input.nextLine();
        ProducerController producerController = new ProducerController();
        Producer item = new Producer();
        item = producerController.findByID(id);
        if (item.getName() == null){
            System.out.print("There is no such item\n");
        }else{
            System.out.println(item);
        }
    }

    private void createProducer() throws SQLException{
        Producer entity = new Producer();
        System.out.print("Input producer name: ");
        entity.setName(input.nextLine());
        System.out.print("Input producer country id: ");
        Country country = new Country();
        country = CountryController.findByID(input.nextLine());
        entity.setCountryByCountryId(country);
        ProducerController producerController = new ProducerController();
        int count = producerController.create(entity);
        System.out.printf("There ere created %d rows\n", count);
    }

    private void updateProducer() throws SQLException {
        Producer entity = new Producer();
        System.out.print("Input producer id: ");
        entity.setId(Integer.parseInt(input.nextLine()));
        System.out.print("Input producer name: ");
        entity.setName(input.nextLine());
        System.out.print("Input producer category id: ");
        Country country = new Country();
        country = CountryController.findByID(input.nextLine());
        entity.setCountryByCountryId(country);
        ProducerController producerController = new ProducerController();
        int count = producerController.update(entity);
        System.out.printf("There ere updated %d rows\n", count);
    }
    
    private void deleteProducer() throws SQLException{
        String id;
        System.out.print("Input producer ID to delete: ");
        id = input.nextLine();

        Producer producer;
        producer = ProducerController.findByID(id);
        ProducerController producerController = new ProducerController();
        int count = producerController.delete(producer);
        System.out.printf("There ere deleted %d rows\n", count);
    }
//--------------------------------------------------------------------------------------------------------
    private void showGoods() throws SQLException {
        GoodsController goodController = new GoodsController();
        List<Goods> items = goodController.findAll();
        for(Goods entity: items){
            System.out.println(entity);
        }
    }

    private void findGoodById() throws SQLException {
        String id;
        System.out.print("Input good ID to show: ");
        id = input.nextLine();
        GoodsController goodController = new GoodsController();
        Goods item = new Goods();
        item = goodController.findByID(id);
        if (item.getName() == null){
            System.out.print("There is no such item\n");
        }else{
            System.out.println(item);
        }
    }

    private void createGood() throws SQLException{
        Goods entity = new Goods();
        System.out.print("Input good name: ");
        entity.setName(input.nextLine());
        System.out.print("Input good category id: ");
        Categories category;
        category = CategoriesController.findByID(input.nextLine());
        entity.setCategoriesByCategoryId(category);
        System.out.print("Input good producer id: ");
        Producer producer;
        producer = ProducerController.findByID(input.nextLine());
        entity.setProducerByProducerId(producer);
        System.out.print("Input good warehouse id: ");
        Warehouse warehouse;
        warehouse = WarehouseController.findByID(input.nextLine());
        entity.setWarehouseByWarehouseId(warehouse);
        GoodsController goodController = new GoodsController();
        int count = goodController.create(entity);
        System.out.printf("There ere created %d rows\n", count);
    }

    private void updateGood() throws SQLException {
        Goods entity = new Goods();
        System.out.print("Input good id: ");
        entity.setId(Integer.parseInt(input.nextLine()));
        System.out.print("Input good name: ");
        entity.setName(input.nextLine());
        System.out.print("Input good category id: ");
        Categories category;
        category = CategoriesController.findByID(input.nextLine());
        entity.setCategoriesByCategoryId(category);
        System.out.print("Input good producer id: ");
        Producer producer;
        producer = ProducerController.findByID(input.nextLine());
        entity.setProducerByProducerId(producer);
        System.out.print("Input good warehouse id: ");
        Warehouse warehouse;
        warehouse = WarehouseController.findByID(input.nextLine());
        entity.setWarehouseByWarehouseId(warehouse);
        GoodsController GoodController = new GoodsController();
        int count = GoodController.update(entity);
        System.out.printf("There ere updated %d rows\n", count);
    }

    private void deleteGood() throws SQLException{
        String id;
        System.out.print("Input good ID to delete: ");
        id = input.nextLine();
        Goods goods;
        goods = GoodsController.findByID(id);
        GoodsController goodController = new GoodsController();
        int count = goodController.delete(goods);
        System.out.printf("There ere deleted %d rows\n", count);
    }
//--------------------------------------------------------------------------------------------------------
    private void showWarehouses() throws SQLException {
        WarehouseController warehouseController = new WarehouseController();
        List<Warehouse> items = warehouseController.findAll();
        for(Warehouse entity: items){
            System.out.println(entity);
        }
    }

    private void findWarehouseById() throws SQLException {
        String id;
        System.out.print("Input Warehouse ID to show: ");
        id = input.nextLine();
        WarehouseController WarehouseController = new WarehouseController();
        Warehouse item = new Warehouse();
        item = WarehouseController.findByID(id);
        if (item.getWarehouse() == null){
            System.out.print("There is no such item\n");
        }else{
            System.out.println(item);
        }
    }

    private void createWarehouse() throws SQLException{
        Warehouse entity = new Warehouse();
        System.out.print("Input Warehouse name: ");
        entity.setWarehouse(input.nextLine());
        System.out.print("Input Warehouse employees amount: ");
        entity.setEmployees(Integer.parseInt(input.nextLine()));
        WarehouseController warehouseController = new WarehouseController();
        int count = warehouseController.create(entity);
        System.out.printf("There ere created %d rows\n", count);
    }
    private void updateWarehouse() throws SQLException {
        Warehouse entity = new Warehouse();
        System.out.print("Input warehouse id: ");
        entity.setId(Integer.parseInt(input.nextLine()));
        System.out.print("Input warehouse name: ");
        entity.setWarehouse(input.nextLine());
        System.out.print("Input warehouse employees amount: ");
        entity.setEmployees(Integer.parseInt(input.nextLine()));
        WarehouseController warehouseController = new WarehouseController();
        int count = warehouseController.update(entity);
        System.out.printf("There ere updated %d rows\n", count);
    }

    private void deleteWarehouse() throws SQLException{
        String id;
        System.out.print("Input warehouse ID to delete: ");
        id = input.nextLine();
        Warehouse warehouse;
        warehouse = WarehouseController.findByID(id);
        WarehouseController warehouseController = new WarehouseController();
        int count = warehouseController.delete(warehouse);
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
                System.out.println("       Exception : " + e.getMessage());
            }
        } while (!keyMenu.equals("Q"));
    }
}
