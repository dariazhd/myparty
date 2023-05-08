package com.party.model;

import javax.persistence.*;

@Entity
public class Ausleihe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String ausleihender;

    //private LocalDate startdatum;

    //private LocalDate enddatum;

    @ManyToOne
    private PartyEquipment ausgeliehenesItem;

}
