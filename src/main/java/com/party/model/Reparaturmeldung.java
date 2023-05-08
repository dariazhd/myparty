package com.party.model;

import com.party.EquipmentStatus;
import com.party.model.PartyEquipment;

import javax.persistence.*;

@Entity
public class Reparaturmeldung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private EquipmentStatus reparaturStatus;

    @ManyToOne
    private PartyEquipment betreffendesItem;

    public PartyEquipment getBetreffendesItem() {
        return betreffendesItem;
    }

    public void setBetreffendesItem(PartyEquipment betreffendesItem) {
        this.betreffendesItem = betreffendesItem;
    }

    public EquipmentStatus getReparaturStatus() {
        return reparaturStatus;
    }

    public void setReparaturStatus(EquipmentStatus reparaturStatus) {
        this.reparaturStatus = reparaturStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
