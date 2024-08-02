package com.polyglot.training.controller;

import com.polyglot.training.dto.ItemsDTO;
import com.polyglot.training.dto.UsersDTO;
import com.polyglot.training.util.Database;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemsController {

    @GetMapping("/{id}")
    public ResponseEntity<ItemsDTO> getDetailItem(@PathVariable Integer id) {
        List<ItemsDTO> dataItems = Database.dataItems;
        for (int i = 0; i < dataItems.size(); i++) {
            if (dataItems.get(i).getId().equals(id)) {
                return new ResponseEntity<>(dataItems.get(i), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(new ItemsDTO(), HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<ItemsDTO>> getItems() {
        return new ResponseEntity<>(Database.dataItems, HttpStatus.OK);
    }
}
