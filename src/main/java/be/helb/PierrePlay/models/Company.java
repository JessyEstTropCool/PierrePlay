package be.helb.PierrePlay.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Companies")
public class Company
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long companyId;
    private String name;
    private String email;
    private String address;
    @OneToMany(mappedBy ="company")
    @JsonManagedReference(value="company-franchise")
    private Set<Franchise> franchises;
    @OneToMany(mappedBy ="company")
    @JsonManagedReference(value="company-platform")
    private Set<Platform> platforms;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference(value="user-company")
    private User owner;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Franchise> getFranchises() {
        return franchises;
    }

    public void setFranchises(Set<Franchise> franchises) {
        this.franchises = franchises;
    }

    public Set<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(Set<Platform> platforms) {
        this.platforms = platforms;
    }
}
