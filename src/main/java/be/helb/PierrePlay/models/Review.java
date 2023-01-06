package be.helb.PierrePlay.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="Reviews")
public class Review
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long reviewId;
    private Integer stars;
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference(value="user-review")
    private User author;

    @ManyToOne
    @JoinColumn(name = "game_id")
    @JsonBackReference(value="game-review")
    private Game subject;

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Game getSubject() {
        return subject;
    }

    public void setSubject(Game subject) {
        this.subject = subject;
    }
}
