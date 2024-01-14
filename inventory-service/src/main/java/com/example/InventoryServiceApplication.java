package com.example;

import com.example.model.Inventory;
import com.example.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class InventoryServiceApplication implements CommandLineRunner {

    private final InventoryRepository inventoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        inventoryRepository.save(Inventory.builder().skuCode("iphone 13 128GB").quantity(3).build());
        inventoryRepository.save(Inventory.builder().skuCode("iphone 13 256GB").quantity(0).build());
    }
}
