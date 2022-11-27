package be.helb.PierrePlay.models;

import be.helb.PierrePlay.models.keys.OwnsGameKey;

import javax.persistence.*;

@Entity
@Table(name="OwnedGames")
public class OwnsGame
{
    @EmbeddedId
    OwnsGameKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("gameId")
    @JoinColumn(name = "game_id")
    private Game game;

    private Integer stars;
    private String review;
    private Integer hours;
    private Boolean downloaded;

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

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
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
