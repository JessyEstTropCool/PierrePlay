package be.helb.PierrePlay.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Achievements")
public class Achievement
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "achivement_id")
    private Long achivementId;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "game_id")
    @JsonManagedReference
    private Game game;
    @ManyToMany(mappedBy = "achievements")
    @JsonBackReference
    Set<User> users;

    public Long getAchivementId() {
        return achivementId;
    }

    public void setAchivementId(Long achivementId) {
        this.achivementId = achivementId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
