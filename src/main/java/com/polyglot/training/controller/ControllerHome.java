package com.polyglot.training.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerHome {
    @GetMapping("/books")
    public String welcome(){
        return "Welcome";
    }
    @PostMapping("/books")
    public String addBooks(){
        return "Buku berhasil ditambahkan";
    }
    @PutMapping("/books")
    public String editBooks(){
        return "Buku berhasil diedit";
    }
    @DeleteMapping("/books")
    public String deleteBooks(){
        return "Buku berhasil dihapus";
    }


}
