package com.party;

import com.party.model.PartyEquipment;
import com.party.repository.PartyEquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Component
    class PopulateTestDataRunner implements CommandLineRunner {
        private final PartyEquipmentRepository partyEquipmentRepository;

        @Autowired
        public PopulateTestDataRunner(PartyEquipmentRepository partyEquipmentRepository) {
            this.partyEquipmentRepository = partyEquipmentRepository;
        }


        public void run(String... args) throws Exception {
            this.partyEquipmentRepository.deleteAll();
            PartyEquipment partyEquipment1 = new PartyEquipment();
            partyEquipment1.setName("Stuhl");
            partyEquipment1.setStatus(EquipmentStatus.VERFUEGBAR);
            partyEquipment1.setBeschreibung("Stuhl mit Rückenlehne in Pink");
            this.partyEquipmentRepository.save(partyEquipment1);
            PartyEquipment partyEquipment2 = new PartyEquipment();
            partyEquipment2.setName("Tisch");
            partyEquipment2.setStatus(EquipmentStatus.AUSGELIEHEN);
            partyEquipment2.setBeschreibung("Tisch aus Holz klappbar 200x110 cm");
            this.partyEquipmentRepository.save(partyEquipment2);
            PartyEquipment partyEquipment3 = new PartyEquipment();
            partyEquipment3.setName("Lampe");
            partyEquipment3.setStatus(EquipmentStatus.DEFEKT);
            partyEquipment3.setBeschreibung("Lampe mit Leistungsregler 1,8 Meter hoch");
            this.partyEquipmentRepository.save(partyEquipment3);
            PartyEquipment partyEquipment4 = new PartyEquipment();
            partyEquipment4.setName("DJ Controller Pult");
            partyEquipment4.setStatus(EquipmentStatus.AUSGEMUSTERT);
            partyEquipment4.setBeschreibung("Numark Party Mix II – DJ Controller Pult mit 2 Decks");
            this.partyEquipmentRepository.save(partyEquipment4);
        }
    }

}
