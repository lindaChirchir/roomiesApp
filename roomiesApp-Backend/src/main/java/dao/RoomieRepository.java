package dao;

import org.springframework.data.repository.CrudRepository;

import model.Roomie;

public interface RoomieRepository extends CrudRepository<Roomie, String> {
	Roomie findRoomieByName(String name);
}
