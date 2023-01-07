package be.helb.PierrePlay.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Tags")
public class Tag
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;
    private String name;
    private String description;
    @ManyToMany(mappedBy = "tags")
    Set<Game> taggedGames;

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
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

    public Set<Game> getTaggedGames() {
        return taggedGames;
    }

    public void setTaggedGames(Set<Game> taggedGames) {
        this.taggedGames = taggedGames;
    }
}
