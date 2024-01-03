package com.example.filmback.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "favMovies")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long filmId;

    @Column(name = "movieName" , nullable = false, unique = true)
    String name;

    String userMail;
    public Long getId(){
        return this.filmId;
    }

}
