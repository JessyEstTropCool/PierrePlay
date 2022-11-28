package be.helb.PierrePlay.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Platforms")
public class Platform
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "platform_id")
    private Long platformId;
    private String name;
    private Integer generation;
    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonManagedReference
    private Company company;
    @ManyToMany(mappedBy = "platforms")
    @JsonBackReference
    Set<Game> compatibleGames;

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGeneration() {
        return generation;
    }

    public void setGeneration(Integer generation) {
        this.generation = generation;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<Game> getCompatibleGames() {
        return compatibleGames;
    }

    public void setCompatibleGames(Set<Game> compatibleGames) {
        this.compatibleGames = compatibleGames;
    }
}
