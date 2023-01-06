package be.helb.PierrePlay.models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="Games")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "gameId")
public class Game implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Long gameId;
    private String title;
    private String description;
    private Integer pegi;
    private String boxart;
    private Double price;
    @Column(name = "publishdate")
    private LocalDate publishDate;
    @Column(name = "inapppurchases")
    private Boolean inAppPurchases;
    private Boolean adverts;
    @ManyToMany
    @JoinTable(
        name = "game_tags",
        joinColumns = @JoinColumn(name = "game_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags;

    @OneToMany(mappedBy = "game")
    @JsonManagedReference(value="own-game")
    @JsonIgnore
    private Set<OwnsGame> ownedGames;

    @ManyToOne
    @JoinColumn(name = "franchise_id")
    @JsonBackReference(value="game-franchise")
    private Franchise franchise;

    @ManyToMany
    @JoinTable(
            name = "game_platforms",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "platform_id"))
    private Set<Platform> platforms;

    @OneToMany(mappedBy = "game")
    @JsonManagedReference(value="game-achievement")
    private Set<Achievement> achievements;

    @OneToMany(mappedBy = "subject")
    @JsonManagedReference(value="game-review")
    private Set<Review> reviews;

    public Game() {}

    public Game(String title) { this.title = title; }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPegi() {
        return pegi;
    }

    public void setPegi(Integer pegi) {
        this.pegi = pegi;
    }

    public String getBoxart() {
        return boxart;
    }

    public void setBoxart(String boxart) {
        this.boxart = boxart;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public Boolean getInAppPurchases() {
        return inAppPurchases;
    }

    public void setInAppPurchases(Boolean inAppPurchases) {
        this.inAppPurchases = inAppPurchases;
    }

    public Boolean getAdverts() {
        return adverts;
    }

    public void setAdverts(Boolean adverts) {
        this.adverts = adverts;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
    public Set<OwnsGame> getOwnedGames() {
        return ownedGames;
    }

    public void setOwnedGames(Set<OwnsGame> ownedGames) {
        this.ownedGames = ownedGames;
    }

    public Franchise getFranchise() {
        return franchise;
    }

    public void setFranchise(Franchise franchise) {
        this.franchise = franchise;
    }

    public Set<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(Set<Platform> platforms) {
        this.platforms = platforms;
    }

    public Set<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(Set<Achievement> achievements) {
        this.achievements = achievements;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }
}
