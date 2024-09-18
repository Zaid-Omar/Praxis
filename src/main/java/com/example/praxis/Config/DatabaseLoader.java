package com.example.praxis.Config;

import com.example.praxis.Entity.Customer;
import com.example.praxis.Entity.Item;
import com.example.praxis.Entity.Order;
import com.example.praxis.Repos.CustomerRepo;
import com.example.praxis.Repos.ItemRepo;
import com.example.praxis.Repos.OrderRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
public class DatabaseLoader {

    @Bean
    CommandLineRunner initDatabase(CustomerRepo customerRepo, ItemRepo itemRepo, OrderRepo orderRepo) {
        return args -> {
            Random random = new Random();

            // Erstellen von 100 Kunden
            for (int i = 1; i <= 300; i++) {
                Customer customer = new Customer();
                customer.setName("Customer " + i);
                customerRepo.save(customer);

                // Liste der Bestellungen für den Kunden
                List<Order> orders = new ArrayList<>();

                // Erstelle 10 Bestellungen pro Kunde, sodass insgesamt 1000 Bestellungen erstellt werden
                for (int j = 1; j <= 10; j++) {
                    Order order = new Order();
                    order.setPrice(random.nextDouble() * 1000);  // Zufälliger Preis zwischen 0 und 1000
                    order.setCustomer(customer);  // Setze den Kunden
                    orderRepo.save(order);  // Bestellung zuerst speichern

                    // Erstellen eines einzelnen Artikels für die Bestellung
                    Item item = new Item();
                    item.setName("Product " + ((i - 1) * 10 + j));  // Jeder Artikel bekommt einen eindeutigen Namen
                    item.setPrice(random.nextDouble() * 500);  // Zufälliger Preis zwischen 0 und 500
                    itemRepo.save(item);  // Speichern des Artikels

                    // Setze den Artikel in die Bestellung
                    order.setItem(item);
                    orderRepo.save(order);  // Bestellung erneut speichern
                    orders.add(order);  // Bestellung zur Kundenbestellliste hinzufügen
                }

                // Kunde mit Bestellungen aktualisieren und speichern
                customer.setOrders(orders);
                customerRepo.save(customer);  // Kunde erneut speichern
            }
        };
    }
}
