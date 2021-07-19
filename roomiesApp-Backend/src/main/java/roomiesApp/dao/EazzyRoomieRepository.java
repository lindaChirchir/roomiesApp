package roomiesApp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import roomiesApp.model.EazzyRoomie;

@Repository
public interface EazzyRoomieRepository extends CrudRepository<EazzyRoomie, String> {
	EazzyRoomie findByAddress(String address);

}
