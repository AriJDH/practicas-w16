package com.example.ejerciciomovie.repository;

import com.example.ejerciciomovie.entity.Actor;
import com.example.ejerciciomovie.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActorRepository  extends JpaRepository<Actor,Long> {}

