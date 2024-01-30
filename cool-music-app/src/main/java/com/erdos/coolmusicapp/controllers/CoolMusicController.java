package com.erdos.coolmusicapp.controllers;

import com.erdos.coolmusicapp.models.CoolMusicDTO;
import com.erdos.coolmusicapp.services.CoolMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CoolMusicController {
    private final CoolMusicService coolMusicService;

    @Autowired
    public CoolMusicController(CoolMusicService coolMusicService) {
        this.coolMusicService = coolMusicService;
    }

    @GetMapping("/cool-music")
    public ResponseEntity<List<CoolMusicDTO>> showMeGoodMusic(){
        return ResponseEntity.status(200).body(coolMusicService.getAllCoolMusicDTO());
    }

    @PostMapping("/add-music")
    public ResponseEntity<CoolMusicDTO> addMusic(
            @RequestBody(required = false) CoolMusicDTO coolMusicDTO){
        return ResponseEntity.status(200).body(coolMusicService.addCoolMusic(coolMusicDTO));
    }
}
