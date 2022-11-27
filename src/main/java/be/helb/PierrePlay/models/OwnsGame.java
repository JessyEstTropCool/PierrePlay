package be.helb.PierrePlay.models;

import javax.persistence.*;

@Entity
@Table(name="OwnedGames")
public class OwnsGame
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*@OneToMany
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany
    @JoinColumn(name = "game_id")*/
    private Game game;
    private Integer stars;
    private String review;
    private Integer hours;
    private Boolean downloaded;
}
