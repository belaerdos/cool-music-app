package com.erdos.coolmusicapp.services;

import com.erdos.coolmusicapp.models.CoolMusic;
import com.erdos.coolmusicapp.models.CoolMusicDTO;

import java.util.List;

public interface CoolMusicService {
    CoolMusicDTO createCoolMusicDTO(CoolMusic coolMusic);
    List<CoolMusicDTO> getAllCoolMusicDTO();
    CoolMusicDTO addCoolMusic(CoolMusicDTO coolMusicDTO);
}