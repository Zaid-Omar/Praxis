package com.example.praxis.Service;

import com.example.praxis.Entity.Item;
import com.example.praxis.Repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepo itemRepo;

    public List<Item> getAllItems() {
        return itemRepo.findAll();
    }

    public Optional<Item> getItemById(Long id) {
        return itemRepo.findById(id);
    }

    public Item createItem(Item item) {
        return itemRepo.save(item);
    }

    public void deleteItem(Long id) {
        itemRepo.deleteById(id);
    }
}
