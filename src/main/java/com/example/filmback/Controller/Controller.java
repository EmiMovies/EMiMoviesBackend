package com.example.filmback.Controller;

import com.example.filmback.DTO.LoginDto;
import com.example.filmback.entity.Comment;
import com.example.filmback.entity.Film;
import com.example.filmback.entity.User;
import com.example.filmback.service.CommentService;
import com.example.filmback.service.FilmService;
import com.example.filmback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {
    @Autowired
    FilmService filmService;
    @Autowired
    UserService userService;
    @Autowired
    CommentService commentService;


    @PostMapping("/favorites")

    public ResponseEntity<HttpStatus> saveFilmToFavourite(@RequestBody Film film) {
        this.filmService.saveFilm(film);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/favFilms/{userMail}")
    public ResponseEntity<List<Long>> getFilms(@PathVariable String userMail) {

        List<Long> filmIds = this.filmService.getFilms(userMail).stream()
                .map(Film::getId)
                .collect(Collectors.toList());


        return new ResponseEntity<>(filmIds, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userMail}/{filmId}")
    public ResponseEntity<?> deleteFavoriteMovieByEmail(@PathVariable String userMail, @PathVariable Long filmId) {
        System.out.println("User Mail: " + userMail + ", Film ID: " + filmId);
        Film film = this.filmService.getFilmByMailAndId(userMail,filmId);
        this.filmService.removeFilm(film);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity<HttpStatus> addUser(@RequestBody User user){
        this.userService.addUser(user);
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PostMapping("/login")
    public ResponseEntity<User> getUser(@RequestBody LoginDto loginDto){
        if(this.userService.login(loginDto) != null)
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/comment")
    public ResponseEntity<HttpStatus> addComment(@RequestBody Comment com){

            this.commentService.addComment(com);
         return  new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/comments/{movieId}")
    public ResponseEntity<List<Comment>> getComments(@PathVariable Long movieId){
        System.out.println("getting them");
        return new ResponseEntity<>(this.commentService.getComments(movieId), HttpStatus.OK);
    }


}
