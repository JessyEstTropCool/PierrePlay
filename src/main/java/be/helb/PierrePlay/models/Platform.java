package be.helb.PierrePlay.models;

import javax.persistence.*;

@Entity
@Table(name="Platforms")
public class Platform
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long platform_id;
    private String name;
    private Integer generation;
}
