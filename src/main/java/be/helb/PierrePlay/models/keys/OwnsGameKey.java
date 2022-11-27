package be.helb.PierrePlay.models.keys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OwnsGameKey implements Serializable
{
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "game_id")
    private Long gameId;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OwnsGameKey that = (OwnsGameKey) o;
        return userId.equals(that.userId) && gameId.equals(that.gameId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, gameId);
    }
}
