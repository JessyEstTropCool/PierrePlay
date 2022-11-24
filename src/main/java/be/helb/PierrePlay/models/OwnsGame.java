package be.helb.PierrePlay.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Games")
public class OwnsGame
{
    @ManyToOne
    @JoinColumn(name = "id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "id")
    private Game game;
    private Integer stars;
    private String review;
    private Integer hours;
    private Boolean downloaded;
}
