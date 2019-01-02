package tempoApp.restCall.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tempoApp.restCall.models.Playlist;


@Repository
public interface PlaylistRepository extends CrudRepository<Playlist, Long>{
	//this class will be a repository that holds all collection of Users
	//it will be user for storage, encapsulating and search behavior for User instances
		
		
	//findAll() is defined in CrudRepository that finds all entities
	Collection<Playlist> findAll();

}
