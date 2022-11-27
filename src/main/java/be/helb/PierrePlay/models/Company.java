package be.helb.PierrePlay.models;

import javax.persistence.*;

@Entity
@Table(name="Companies")
public class Company
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long company_id;
    private String name;
    private String email;
    private String address;
}
