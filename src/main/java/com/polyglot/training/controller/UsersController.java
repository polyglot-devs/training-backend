package com.polyglot.training.controller;

import com.polyglot.training.dto.AlertDTO;
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
    public ResponseEntity<AlertDTO> addUsers(){
        AlertDTO data = new AlertDTO();
        data.setMessage("Data pengguna berhasil ditambahkan");
        data.setStatus(true);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

    @PutMapping("/users")
    public ResponseEntity<AlertDTO> editUsers(){
        AlertDTO data = new AlertDTO();
        data.setMessage("Data pengguna berhasil diedit");
        data.setStatus(true);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @DeleteMapping("/users")
    public ResponseEntity<AlertDTO> deleteUsers(){
        AlertDTO data = new AlertDTO();
        data.setMessage("Data yang ingin dihapus tidak ditemukan");
        data.setStatus(false);
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
}
