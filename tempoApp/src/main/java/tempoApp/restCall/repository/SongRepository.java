package tempoApp.restCall.repository;


import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tempoApp.restCall.models.Song;



@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
	
	//this class will be a repository that holds all collection of Songs
	//it will be user for storage, encapsulating and search behavior for User instances
		
		
	//findAll() is defined in CrudRepository that finds all entities
	Collection<Song> findAll();

}
