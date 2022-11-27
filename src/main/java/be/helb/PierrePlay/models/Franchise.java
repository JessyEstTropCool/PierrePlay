package be.helb.PierrePlay.models;

import javax.persistence.*;

@Entity
@Table(name="Franchises")
public class Franchise
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long franchise_id;
    private String name;
}
