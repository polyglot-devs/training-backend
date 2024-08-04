package com.polyglot.training.controller;

import com.polyglot.training.dto.AlertDTO;
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

    @GetMapping
    public ResponseEntity<List<ItemsDTO>> getItems() {
        return new ResponseEntity<>(Database.dataItems, HttpStatus.OK);
    }

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

    @DeleteMapping("/{id}")
    public ResponseEntity<AlertDTO> deleteDetailItem(@PathVariable Integer id){
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
}
