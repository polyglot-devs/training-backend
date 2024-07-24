package com.polyglot.training.controller;

import com.polyglot.training.dto.WelcomeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {

    @GetMapping("/english")
    public ResponseEntity<WelcomeDTO> getEnglish(){
        WelcomeDTO data = new WelcomeDTO();
        data.setMessage("Hello, Welcome!");
        data.setLanguage("English");
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/indonesia")
    public ResponseEntity<WelcomeDTO> getIndonesia(){
        WelcomeDTO data = new WelcomeDTO();
        data.setMessage("Halo, Selamat Datang!");
        data.setLanguage("Indonesia");
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/spanish")
    public ResponseEntity<WelcomeDTO> getSpanish(){
        WelcomeDTO data = new WelcomeDTO();
        data.setMessage("Hola, Bienvenido");
        data.setLanguage("Spanish");
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/arab")
    public ResponseEntity<WelcomeDTO> getArab(){
        WelcomeDTO data = new WelcomeDTO();
        data.setMessage("Assalamu'alaikum, 'Ahlan Wasahlan");
        data.setLanguage("Arab");
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
