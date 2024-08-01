package com.polyglot.training.controller;

import com.polyglot.training.dto.BooksDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    public List<BooksDTO> dataBuku = List.of(
            BooksDTO.builder().build(),
            BooksDTO.builder().id(1).title("Howl Moving Castle").author("Ghibli").build(),
            BooksDTO.builder().id(2).title("Bulan").author("Tere Liye").build(),
            BooksDTO.builder().id(3).title("Matahari").author("Tere Liye").build()
    );

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
