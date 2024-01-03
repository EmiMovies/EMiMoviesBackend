package com.example.filmback.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Entity
@Table(name = "comments")
public class Comment {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    Long id;

    @Column(name = "email" , nullable = false )
    public String email;
    @Column(name = "text" ,nullable = false)
    public String text;
    @Column(name = "movieId" ,nullable = false)
    public Long movieId;




    /*  @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
*/

}
