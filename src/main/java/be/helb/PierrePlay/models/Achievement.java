package be.helb.PierrePlay.models;

import javax.persistence.*;

@Entity
@Table(name="Achievements")
public class Achievement
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long achivement_id;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
}
