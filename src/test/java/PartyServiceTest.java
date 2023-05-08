import com.party.*;
import com.party.controller.PartyService;
import com.party.model.PartyEquipment;
import com.party.repository.PartyEquipmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({SpringExtension.class})
@SpringBootTest(
        classes = {Application.class},
        webEnvironment = SpringBootTest.WebEnvironment.NONE
)
@ActiveProfiles(
        profiles = {"testing"}
)
public class PartyServiceTest {

    @Autowired
    private PartyService partyService;

    @Autowired
    private PartyEquipmentRepository partyEquipmentRepository;

    @Test
    public void testAusleihen() {
        this.partyEquipmentRepository.deleteAll();
        PartyEquipment item = new PartyEquipment();
        item.setName("Bierbank");
        item.setStatus(EquipmentStatus.VERFUEGBAR);
        this.partyEquipmentRepository.save(item);
        this.partyService.ausleihen(item.getId());
        assertEquals(EquipmentStatus.AUSGELIEHEN, item.getStatus());
    }

    // weitere Testfälle

}
