package roomiesApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@SpringBootApplication
public class RoomiesAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomiesAppApplication.class, args);
	}
	
	
	 @RequestMapping("/")
	  public String greeting(){
	    return "Jambo Ulimwengu!";
	  }
	
	

}
