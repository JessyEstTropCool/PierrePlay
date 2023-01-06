package be.helb.PierrePlay.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Tags")
public class Tag
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tag_id;
    private String name;
    private String description;
    @ManyToMany(mappedBy = "tags")
    Set<Game> taggedGames;

    public Long getTag_id() {
        return tag_id;
    }

    public void setTag_id(Long tag_id) {
        this.tag_id = tag_id;
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
