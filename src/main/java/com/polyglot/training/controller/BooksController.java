package com.polyglot.training.controller;

import com.polyglot.training.dto.BooksDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BooksController {

    @GetMapping("/books")
    public ResponseEntity<BooksDTO> welcome(){
        BooksDTO data = new BooksDTO();
        data.setId(1);
        data.setAuthor("Tere Liye");
        data.setTitle("Bulan");
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<String> addBooks(){
        return new ResponseEntity<>("Buku berhasil ditambahkan", HttpStatus.CREATED);
    }

    @PutMapping("/books")
    public ResponseEntity<String> editBooks(){
        return new ResponseEntity<>("Title harus diisi", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/books")
    public ResponseEntity<String> deleteBooks(){
        return new ResponseEntity<>("Buku tidak ditemukan", HttpStatus.NOT_FOUND);
    }
}
