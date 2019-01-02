package tempoApp.restCall.repository;


import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tempoApp.restCall.models.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long>	{
	//this class will be a repository that holds all collection of 
	//it will be user for storage, encapsulating and search behavior for User instances
	
	
	//findAll() is defined in CrudRepository that finds all entities
	Collection<User> findAll();
	
}
