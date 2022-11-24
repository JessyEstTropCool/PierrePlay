package be.helb.PierrePlay.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="Games")
public class Game implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Integer pegi;
    private String esrb;
    private String cero;
    private String boxart;
    private Double price;
    @Column(name = "publishdate")
    private LocalDate publishDate;
    @Column(name = "inapppurchases")
    private Boolean inAppPurchases;
    private Boolean adverts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEsrb() {
        return esrb;
    }

    public void setEsrb(String esrb) {
        this.esrb = esrb;
    }

    public String getCero() {
        return cero;
    }

    public void setCero(String cero) {
        this.cero = cero;
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
}
