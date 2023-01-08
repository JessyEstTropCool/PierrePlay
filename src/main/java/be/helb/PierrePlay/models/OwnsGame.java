package be.helb.PierrePlay.models;

import be.helb.PierrePlay.models.keys.OwnsGameKey;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name="OwnedGames")
public class OwnsGame
{
    @EmbeddedId
    private OwnsGameKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    @JsonBackReference(value="user-own")
    private User user;

    @ManyToOne
    @MapsId("gameId")
    @JoinColumn(name = "game_id")
    @JsonBackReference(value="own-game")
    private Game game;
    private Integer hours;
    private Boolean downloaded;

    public OwnsGame() {}

    public OwnsGame(User user, Game game) {
        this.user = user;
        this.game = game;
        this.id = new OwnsGameKey(user.getUserId(), game.getGameId());
    }

    public OwnsGameKey getId() {
        return id;
    }

    public void setId(OwnsGameKey id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Boolean getDownloaded() {
        return downloaded;
    }

    public void setDownloaded(Boolean downloaded) {
        this.downloaded = downloaded;
    }
}
