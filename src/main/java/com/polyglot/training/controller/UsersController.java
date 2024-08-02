package com.polyglot.training.controller;

import com.polyglot.training.dto.AlertDTO;
import com.polyglot.training.dto.UsersDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @GetMapping("/login")
    public ResponseEntity<AlertDTO> getLogin(@RequestParam String username, @RequestParam String password) {
        HttpStatus status = HttpStatus.OK;
        AlertDTO data = new AlertDTO();
        for (int i = 0; i < dataUser.size(); i++) {
            if (dataUser.get(i).getName().equals(username) && dataUser.get(i).getPassword().equals(password)) {
                data.setMessage("Login Berhasil");
                data.setStatus(true);
                status = HttpStatus.OK;
                break;
            } else {
                data.setMessage("Login Gagal");
                data.setStatus(false);
                status = HttpStatus.BAD_REQUEST;
            }
        }
        return new ResponseEntity<>(data, status);
    }

    @GetMapping
    public ResponseEntity<UsersDTO> getUsers() {
        UsersDTO data = new UsersDTO();
        data.setId(1);
        data.setName("Risa");
        data.setPassword("Risa29");
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AlertDTO> addUsers() {
        AlertDTO data = new AlertDTO();
        data.setMessage("Data pengguna berhasil ditambahkan");
        data.setStatus(true);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AlertDTO> editUsers() {
        AlertDTO data = new AlertDTO();
        data.setMessage("Data pengguna berhasil diedit");
        data.setStatus(true);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<AlertDTO> deleteUsers() {
        AlertDTO data = new AlertDTO();
        data.setMessage("Data yang ingin dihapus tidak ditemukan");
        data.setStatus(false);
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
}
