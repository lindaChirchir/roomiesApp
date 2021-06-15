package roomiesApp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import dao.RoomieRepository;
import model.EazzyRoomie;
import model.Roomie;

public class TestRoomiePersistence {
	
	@Autowired
	private RoomieRepository roomieRepository;
	
	@AfterEach
	public void clearDatabase() {
		roomieRepository.deleteAll();
		
	}
	
	@Test
	public void testPersistAndLoadRoomie() {
		
		EazzyRoomie ezRoomie = new EazzyRoomie();
		String name = "TestPerson";
		// First example for object save/load
		Roomie roomie = new Roomie(name, ezRoomie);
		// First example for attribute save/load
		roomieRepository.save(roomie);

		roomie = null;

		roomie = roomieRepository.findRoomieByName(name);
		assertNotNull(roomie);
		assertEquals(name, roomie.getUsername());
	}


}
