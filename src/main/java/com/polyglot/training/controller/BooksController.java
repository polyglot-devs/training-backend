package com.polyglot.training.controller;

import com.polyglot.training.dto.BooksDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    @GetMapping("/{id}")
    public ResponseEntity<BooksDTO> getBook(@PathVariable Integer id){
        BooksDTO data = dataBuku.get(id);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BooksDTO>> getBooks(){
        return new ResponseEntity<>(dataBuku, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addBooks(){
        return new ResponseEntity<>("Buku berhasil ditambahkan", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> editBooks(){
        return new ResponseEntity<>("Title harus diisi", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteBooks(){
        return new ResponseEntity<>("Buku tidak ditemukan", HttpStatus.NOT_FOUND);
    }
}
