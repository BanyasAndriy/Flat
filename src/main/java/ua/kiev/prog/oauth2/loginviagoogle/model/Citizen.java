package ua.kiev.prog.oauth2.loginviagoogle.model;



import javax.persistence.*;
import java.util.Date;

@Entity
public class Citizen {
    @Id
    @GeneratedValue
    private Long id;

    private String pib;

    @ManyToOne
    @JoinColumn(name = "flat_id")
    private Flat flat;

    public Citizen() {
    }
    public Citizen(String pib,Flat flat) {
        this.pib=pib;
        this.flat=flat;
    }
    public Citizen(String pib) {
        this.pib=pib;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public Flat getFlat() {
        return flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }
}
