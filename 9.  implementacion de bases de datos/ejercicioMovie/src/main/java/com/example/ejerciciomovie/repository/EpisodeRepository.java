package com.example.ejerciciomovie.repository;

import com.example.ejerciciomovie.entity.Episode;
import com.example.ejerciciomovie.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EpisodeRepository  extends JpaRepository<Episode,Long> {

}
