// language: java
package com.op_solutions.menu_service.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.op_solutions.menu_service.model.MenuItem;
import com.op_solutions.menu_service.model.Restaurant;


import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationRunner {

    private final RestaurantService restaurantService;
    private final MenuService menuItemService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // names of restaurants to create
        List<String> restaurantNames = List.of("Central Diner", "Ocean Grill", "Mountain Cafe");

        for (String name : restaurantNames) {
            // Avoid duplicate inserts - adapt to your service API
            Restaurant restaurant = new Restaurant();
            restaurant.setName(name);
            // set other fields if required (address, phone, etc.)

            Restaurant saved = restaurantService.addRestaurant(restaurant); // adapt method name if different

            List<MenuItem> items = new ArrayList<>(150);
            for (int i = 1; i <= 150; i++) {
                MenuItem item = new MenuItem();
                item.setRestaurant(saved);
                item.setName("Item " + i + " - " + name);
                item.setDescription("Auto-generated menu item " + i + " for " + name);
                item.setPrice(BigDecimal.valueOf(5.00 + (i % 20))); // example pricing
                items.add(item);
            }

            menuItemService.saveAll(items); // adapt method name if different
        }
    }
}
