package roomiesApp.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import roomiesApp.dao.RoomieRepository;
import roomiesApp.model.EazzyRoomie;
import roomiesApp.model.Roomie;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TestRoomiesAppPersistence {
	
	@Autowired
	private RoomieRepository roomieRepository;
//@Autowired
//	private ExpenseRepository expenseRepository;
//@Autowired
//	private EazzyRoomieRepository eazzyRoomieRepository;
//	
	private EazzyRoomie ezRoomie;
	
	
	@BeforeEach 
	public void setUp() {
	//	ezRoomie = new EazzyRoomie("2131 house");
		assertNotNull(ezRoomie);
	}
	
	@AfterEach
	public void clearDatabase() {
		roomieRepository.deleteAll();
//		expenseRepository.deleteAll();
//		eazzyRoomieRepository.deleteAll();
		
	}
	
	@Test
	public void testPersistAndLoadRoomie() {
		
		assertNotNull(ezRoomie);
		String name = "TestPerson";
		// First example for object save/load
		Roomie roomie = new Roomie(name, ezRoomie);
		// First example for attribute save/load
		
	//	roomieRepository = context.getBean(RoomieRepository.class);
		assertNotNull(roomieRepository);
		roomieRepository.save(roomie);
		long no = roomieRepository.count();

		assertTrue(no==0);
		roomie = null;

		roomie = roomieRepository.findRoomieByName(name);
		assertNotNull(roomie);
		assertEquals(name, roomie.getUsername());
	}


}
