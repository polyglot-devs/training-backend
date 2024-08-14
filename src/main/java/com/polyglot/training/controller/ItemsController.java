package com.polyglot.training.controller;

import com.polyglot.training.Repositiory.ItemsRepository;
import com.polyglot.training.dto.AlertDTO;
import com.polyglot.training.dto.ItemsDTO;
import com.polyglot.training.dto.request.ItemsRequest;
import com.polyglot.training.model.Items;
import com.polyglot.training.util.Database;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
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
    public ResponseEntity<List<Items>> getItems() {
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
        AlertDTO response = new AlertDTO();
        response.setMessage("Data berhasil dihapus");
        response.setStatus(true);
        Optional<Items> find = itemsRepository.findById(id);
        if (find.isPresent()) {
            itemsRepository.deleteById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        response.setMessage("Data tidak ada");
        response.setStatus(false);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<AlertDTO> addItem(@RequestBody ItemsRequest request) {
        AlertDTO response = new AlertDTO();
        if (request.getName() == null || request.getDescription() == null || request.getStock() == null || request.getPrice() == null) {
            response.setMessage("Data gagal ditambahkan");
            response.setStatus(false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        Items data = new Items();
        data.setName(request.getName());
        data.setDescription(request.getDescription());
        data.setStock(request.getStock());
        data.setPrice(request.getPrice());
        itemsRepository.save(data);
        response.setMessage("Data berhasil ditambahkan");
        response.setStatus(true);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlertDTO> updateItem(@PathVariable Integer id, @RequestBody ItemsRequest request){
        AlertDTO response = new AlertDTO();
        response.setMessage("Data berhasil di update");
        response.setStatus(true);
        Optional<Items> find = itemsRepository.findById(id);
        if (find.isPresent()){
            find.get().setName(request.getName());
            find.get().setDescription(request.getDescription());
            find.get().setStock(request.getStock());
            find.get().setPrice(request.getPrice());
            itemsRepository.save(find.get());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        response.setMessage("Data tidak ditemukan");
        response.setStatus(false);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }
}
