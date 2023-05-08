package com.party;

import com.party.model.PartyEquipment;

import java.util.List;
import java.util.Optional;

public interface PartyEquipmentInt {

    List<PartyEquipment> getAllEquipment();

    Optional<PartyEquipment> getEquipmentById(Long equipmentId);

    void addEquipment(PartyEquipment equipment);

    void deleteEquipment(Long equipmentId);

    void updateEquipment(PartyEquipment equipment);

    void ausleihen(Long equipmentId);

    void zurueckgeben(Long equipmentId);

    void defektMelden(Long equipmentId);

    void repariertMarkieren(Long equipmentId);

}
