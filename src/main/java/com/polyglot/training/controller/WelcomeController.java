package com.polyglot.training.controller;

import com.polyglot.training.dto.AlertDTO;
import com.polyglot.training.dto.WelcomeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping
    public ResponseEntity<AlertDTO> getNilai(@RequestParam Integer nilai){
        AlertDTO data = new AlertDTO();
        data.setStatus(true);
        HttpStatus status = HttpStatus.OK;
        if (nilai >= 81 && nilai <=100){
            data.setMessage("A");
        } else if (nilai >= 51 && nilai <= 80){
            data.setMessage("B");
        } else if (nilai >= 0 && nilai <= 50) {
            data.setMessage("C");
        } else {
            data.setMessage("Masukkan nilai di antara 0 sampai 100");
            data.setStatus(false);
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(data, status);
    }

    @GetMapping("/biodata")
    public ResponseEntity<AlertDTO> getBiodata(@RequestParam String nama, @RequestParam Integer tahunLahir){
        AlertDTO data = new AlertDTO();
        int umur = 2024 - tahunLahir;
        data.setMessage("Umur " + nama + " adalah " + umur + " tahun");
        data.setStatus(true);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
