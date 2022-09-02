package com.example.ejerciciomovie.repository;

import com.example.ejerciciomovie.entity.Episode;
import com.example.ejerciciomovie.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository  extends JpaRepository<Episode,Long> {
}
