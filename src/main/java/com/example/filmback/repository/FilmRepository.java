package com.example.filmback.repository;

import com.example.filmback.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {
    public List<Film> findFilmsByUserMail(String mail);
    public void deleteFilmByUserMailAndFilmId(String mail,Long filmId);

    public Film findFilmByUserMailAndFilmId(String mail,Long filmId);
}
