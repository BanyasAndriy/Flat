package ua.kiev.prog.flat.flat.model;


import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Flat {
    @Id
    @GeneratedValue
    private Long id;

    private String address;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "flat")
     @Nullable
    private List<Citizen> citizens = new ArrayList<>();

    public Flat() {}

    public Flat(String address ,List<Citizen> citizens) {
        this.address=address;
        this.citizens=citizens;

    }

    public Flat(String address ) {
        this.address=address;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Citizen> getCitizens() {
        return citizens;
    }

    public void setCitizens(List<Citizen> citizens) {
        this.citizens = citizens;
    }
}
