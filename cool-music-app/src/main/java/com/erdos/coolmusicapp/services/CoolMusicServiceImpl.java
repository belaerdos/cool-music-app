package com.erdos.coolmusicapp.services;

import com.erdos.coolmusicapp.models.CoolMusic;
import com.erdos.coolmusicapp.models.CoolMusicDTO;
import com.erdos.coolmusicapp.repositories.CoolMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoolMusicServiceImpl implements CoolMusicService {

    private final CoolMusicRepository coolMusicRepository;

    @Autowired
    public CoolMusicServiceImpl(CoolMusicRepository coolMusicRepository) {
        this.coolMusicRepository = coolMusicRepository;
    }

    @Override
    public CoolMusicDTO createCoolMusicDTO(CoolMusic coolMusic) {
        return new CoolMusicDTO(coolMusic.getTitle(), coolMusic.getArtist(), coolMusic.getLink());
    }

    @Override
    public List<CoolMusicDTO> getAllCoolMusicDTO() {
        return coolMusicRepository.findAll().stream().map(cm -> createCoolMusicDTO(cm)).collect(Collectors.toList());
    }

    @Override
    public CoolMusicDTO addCoolMusic(CoolMusicDTO coolMusicDTO) {
        CoolMusic newMusic = new CoolMusic();
        newMusic.setTitle(coolMusicDTO.getTitle());
        newMusic.setArtist(coolMusicDTO.getArtist());
        newMusic.setLink(coolMusicDTO.getLink());
        coolMusicRepository.save(newMusic);

        return createCoolMusicDTO(newMusic);
    }
}