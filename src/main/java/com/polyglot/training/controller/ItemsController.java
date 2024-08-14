package com.polyglot.training.controller;

import com.polyglot.training.Repositiory.ItemsRepository;
import com.polyglot.training.dto.AlertDTO;
import com.polyglot.training.dto.ItemsDTO;
import com.polyglot.training.dto.request.ItemsRequest;
import com.polyglot.training.model.Items;
import com.polyglot.training.util.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    private ItemsRepository itemsRepository;

    @GetMapping
    public ResponseEntity<List<Items>> getItems2() {
        return new ResponseEntity<>(itemsRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Items> getDetailItem(@PathVariable Integer id) {
        Optional<Items> find = itemsRepository.findById(id);
        if (find.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(find.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AlertDTO> deleteItem(@PathVariable Integer id) {
        List<ItemsDTO> dataItems = Database.dataItems;
        AlertDTO data = new AlertDTO();
        data.setMessage("Data berhasil dihapus");
        data.setStatus(true);
        for (int i = 0; i < dataItems.size(); i++) {
            if (dataItems.get(i).getId().equals(id)) {
                dataItems.remove(i);
                return new ResponseEntity<>(data, HttpStatus.OK);
            }
        }
        data.setMessage("Data tidak ditemukan");
        data.setStatus(false);
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<AlertDTO> addItem(@RequestBody ItemsRequest request) {
        AlertDTO response = new AlertDTO();
        if (request.getName() == null || request.getDescription() == null || request.getStock() == null || request.getPrice() == null) {
            response.setMessage("Data gagal ditambahkan");
            response.setStatus(false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        ItemsDTO data = new ItemsDTO();
        data.setId((int) (Math.random() * 1000));
        data.setName(request.getName());
        data.setDescription(request.getDescription());
        data.setStock(request.getStock());
        data.setPrice(request.getPrice());
        Database.dataItems.add(data);
        response.setMessage("Data berhasil ditambahkan");
        response.setStatus(true);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
