package be.helb.PierrePlay.models;

import javax.persistence.*;

@Entity
@Table(name="Franchises")
public class Franchise
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "franchise_id")
    private Long franchiseId;
    private String name;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Long getFranchiseId() {
        return franchiseId;
    }

    public void setFranchiseId(Long franchiseId) {
        this.franchiseId = franchiseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
