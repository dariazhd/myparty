package com.party.repository;

import com.party.EquipmentStatus;
import com.party.model.PartyEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PartyEquipmentRepository extends JpaRepository<PartyEquipment, Long> {

    List<PartyEquipment> findByName(String name);

    List<PartyEquipment> findByBeschreibung(String beschreibung);

    List<PartyEquipment> findByStatus(EquipmentStatus status);

    Optional<PartyEquipment> findById(Long id);

    @Query("SELECT pe FROM PartyEquipment pe WHERE pe.status = 'DEFEKT'")
    List<PartyEquipment> findByIsDefektTrue();
}
