package tempoApp.restCall.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tempoApp.restCall.models.User;
import tempoApp.restCall.repository.UserRepository;


//define class as RestController and map it under http://localHost:{portNo}/tempoApp/users
@RestController
@RequestMapping("/tempoApp/users")
public class UserElementController {
	
	//for more about CRUD (create = POST, read = GET, update = PUT, delete = DELETE
	
	
	@Autowired
	private UserRepository userRepo;
	
	//methods///////////////////
	
	
	//get method for finding all users:
	@RequestMapping(method= RequestMethod.GET)
	public ResponseEntity< Collection<User> > getAllUsers(){
		return new ResponseEntity<>(userRepo.findAll(), HttpStatus.OK );
	}
	
	
	
	//get method for finding user with userID
	@RequestMapping( value = "/{userID}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserwithID(@PathVariable("userID") long userID){
		User tmpUser = userRepo.findOne(userID);
		if(tmpUser!= null) {
			return new ResponseEntity<User>(tmpUser, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	
	//POST method
	@RequestMapping(method= RequestMethod.POST)
	public ResponseEntity<?> addUser(@RequestBody User tmpUser){
		//@RequestBody handles value= at runtime
		return new ResponseEntity<>(userRepo.save(tmpUser), HttpStatus.CREATED);
	}
	
	
	//PUT method
	@RequestMapping(value= "/{userID}", method= RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@PathVariable("userID") long userID, @RequestBody User tmpUser ){
		User currentUser= userRepo.findOne(userID);
		currentUser.setPassword(tmpUser.getPassword());
		currentUser.setUsername(tmpUser.getUsername());
		currentUser.setWeight(tmpUser.getWeight());
		
		return new ResponseEntity<>(userRepo.save(currentUser), HttpStatus.OK);
	}
	
	
	//delete an user (delete specific user)
	
	@RequestMapping(value= "/{userID}", method= RequestMethod.DELETE)
	public ResponseEntity<Void> deleteOneUser(@PathVariable("userID") long userID){
		userRepo.delete(userID);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	//delete all users
	@RequestMapping(value= "/deleteAll",method= RequestMethod.DELETE)
	public ResponseEntity<Void> deleteAllUser(){
		userRepo.deleteAll();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	

}



