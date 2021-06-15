package roomiesApp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;



@RunWith(Suite.class)
@SuiteClasses({ TestRoomiePersistence.class })
@SpringBootTest
class RoomiesAppApplicationTests {

	@Test
	void contextLoads() {
		
		
	}

}
