package com.polyglot.training.controller;

import com.polyglot.training.dto.ItemsDTO;
import com.polyglot.training.dto.UsersDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemsController {

    public List<ItemsDTO> dataItems = List.of(
            ItemsDTO.builder().id(1).name("sunscreen").description("perawatan").stock(100).price(150000L).build(),
            ItemsDTO.builder().id(2).name("laptop").description("elektronik").stock(50).price(20000000L).build(),
            ItemsDTO.builder().id(99).name("hp samsung").description("elektronik").stock(50).price(20000000L).build()
    );

    @GetMapping("/{id}")
    public ResponseEntity<ItemsDTO> getDetailItem(@PathVariable Integer id) {
        for (int i = 0; i < dataItems.size(); i++) {
            if (dataItems.get(i).getId().equals(id)) {
                return new ResponseEntity<>(dataItems.get(i), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(new ItemsDTO(), HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<ItemsDTO>> getItems() {
        List<ItemsDTO> data = dataItems;
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
