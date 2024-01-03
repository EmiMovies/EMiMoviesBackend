package com.example.filmback.service;

import com.example.filmback.entity.Film;
import com.example.filmback.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {
    @Autowired
    FilmRepository filmRepository;


    public void saveFilm(Film film){
        this.filmRepository.save(film);
    }
    public List<Film> getFilms(String mail){
        return this.filmRepository.findFilmsByUserMail(mail);
    }

    public void removeFilm(Film film){
        this.filmRepository.delete(film);
    }
    public Film getFilmByMailAndId(String mail, Long id){
        return this.filmRepository.findFilmByUserMailAndFilmId(mail, id);
    }

}
