package roomiesApp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import roomiesApp.model.Roomie;

@Repository
public interface RoomieRepository extends CrudRepository<Roomie, String> {
	Roomie findRoomieByUsername(String username);
}
