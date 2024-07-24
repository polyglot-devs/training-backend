package com.polyglot.training.controller;

import com.polyglot.training.dto.WelcomeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/welcome/english")
    public ResponseEntity<WelcomeDTO> getEnglish(){
        WelcomeDTO data = new WelcomeDTO();
        data.setMessage("Hello, Welcome!");
        data.setLanguage("English");
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/welcome/indonesia")
    public ResponseEntity<WelcomeDTO> getIndonesia(){
        WelcomeDTO data = new WelcomeDTO();
        data.setMessage("Halo, Selamat Datang!");
        data.setLanguage("Indonesia");
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/welcome/spanish")
    public ResponseEntity<WelcomeDTO> getSpanish(){
        WelcomeDTO data = new WelcomeDTO();
        data.setMessage("Hola, Bienvenido");
        data.setLanguage("Spanish");
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/welcome/arab")
    public ResponseEntity<WelcomeDTO> getArab(){
        WelcomeDTO data = new WelcomeDTO();
        data.setMessage("Assalamu'alaikum, 'Ahlan Wasahlan");
        data.setLanguage("Arab");
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
