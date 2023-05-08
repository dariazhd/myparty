package com.party.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "customer_name")
    private String name;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    //@JoinColumn(name="customerId") // generiert dann keine Jointabelle
    private List<PartyEquipment> ausgeliehene = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addAusleihe(PartyEquipment ausgelieheneEquipment) {
        this.ausgeliehene.add(ausgelieheneEquipment);
    }
}

