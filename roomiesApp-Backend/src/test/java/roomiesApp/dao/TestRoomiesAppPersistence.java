package roomiesApp.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;

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
import roomiesApp.model.Expense;
import roomiesApp.model.Roomie;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TestRoomiesAppPersistence {

	@Autowired
	private RoomieRepository roomieRepository;
	@Autowired
	private ExpenseRepository expenseRepository;
	@Autowired
	private EazzyRoomieRepository eazzyRoomieRepository;
	
	private EazzyRoomie ezRoomie;
	private Roomie roomie;
	
	
	@BeforeEach 
	public void setUp() {
	ezRoomie = new EazzyRoomie("2131 house");
	eazzyRoomieRepository.save(ezRoomie);
		assertNotNull(ezRoomie);
	}
	
	@AfterEach
	public void clearDatabase() {
		expenseRepository.deleteAll();
		roomieRepository.deleteAll();
		eazzyRoomieRepository.deleteAll();
		
	}
	
	@Test
	public void testPersistAndLoadRoomie() {
		
		assertNotNull(ezRoomie);
		String name = "TestPerson";
		// First example for object save/load
		
		Roomie roomie = new Roomie(name, ezRoomie);
		// First example for attribute save/load
		
		assertNotNull(roomie);
		roomieRepository.save(roomie);
		long no = roomieRepository.count();
		assertTrue(no==1);
		roomie = null;

		roomie = roomieRepository.findRoomieByUsername(name);
		assertNotNull(roomie);
		assertEquals(name, roomie.getUsername());
	}

	@Test
	public void testPersistAndLoadExpense() {
		 Date aDate = new Date(2020,11,11) ;
		    String aDescription = "aDescription";
		    Integer aCost = 12;
		    String aClaimant = "aClaimant";
		    createRoomie();
		    
		    
		   Expense expense = new Expense(aDate, aDescription, aCost, aClaimant, ezRoomie, roomieRepository.findRoomieByUsername("name"));
		   expenseRepository.save(expense);
		   expense = null;
		   
		   Expense exp = expenseRepository.findExpenseById(1);
		   assertTrue(exp.getCost() == aCost);
	}
	
	
	public void createRoomie() {
		roomie = new Roomie("name", ezRoomie);
		roomieRepository.save(roomie);
		
	}

}
