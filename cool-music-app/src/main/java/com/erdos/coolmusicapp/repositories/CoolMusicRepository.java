package com.erdos.coolmusicapp.repositories;

import com.erdos.coolmusicapp.models.CoolMusic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoolMusicRepository extends JpaRepository<CoolMusic, Long> {}
