package com.polyglot.training.controller;

import com.polyglot.training.dto.Alert;
import com.polyglot.training.dto.UsersDTO;
import org.apache.logging.log4j.message.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {

    @GetMapping("/users")
    public ResponseEntity<UsersDTO> getUsers(){
        UsersDTO data = new UsersDTO();
        data.setId(1);
        data.setName("Risa");
        data.setPassword("Risa29");
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    @PostMapping("/users")
    public ResponseEntity<Alert> addUsers(){
        Alert data = new Alert();
        data.setMessage("Berhasil ditambahkan");
        data.setStatus(true);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }
    @PutMapping("/users")
    public ResponseEntity<Alert> editUsers(){
        Alert data = new Alert();
        data.setMessage("Berhasil diedit");
        data.setStatus(true);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }
    @DeleteMapping("/users")
    public ResponseEntity<Alert> deleteUsers(){
        Alert data = new Alert();
        data.setMessage("Berhasil dihapus");
        data.setStatus(true);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

}
