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

import tempoApp.restCall.models.Song;
import tempoApp.restCall.repository.SongRepository;


@RestController
@RequestMapping("/tempoApp/songs")
public class SongElementController {
	//for more about CRUD (create = POST, read = GET, update = PUT, delete = DELETE
	
	@Autowired
	private SongRepository songRepo;
	
	//methods///////////////////
	
	
	//get method for finding all users:
	@RequestMapping(method= RequestMethod.GET)
	public ResponseEntity< Collection<Song> > getAllSongs(){
		return new ResponseEntity<>(songRepo.findAll(), HttpStatus.OK );
	}
	
	//get method for finding user with userID
	@RequestMapping( value = "/{songID}", method = RequestMethod.GET)
	public ResponseEntity<Song> getSongwithID(@PathVariable("songID") long songID){
		Song tmpSong = songRepo.findOne(songID);
		if(tmpSong!= null) {
			return new ResponseEntity<Song>(tmpSong, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	

	//POST method
	@RequestMapping(method= RequestMethod.POST)
	public ResponseEntity<?> addSong(@RequestBody Song tmpSong){
		//@RequestBody handles value= at runtime
		return new ResponseEntity<>(songRepo.save(tmpSong), HttpStatus.CREATED);
	}
	
	
	//PUT method
	@RequestMapping(value= "/{songID}", method= RequestMethod.PUT)
	public ResponseEntity<?> updateSong(@PathVariable("songID") long songID, @RequestBody Song tmpSong ){
		Song currentSong= songRepo.findOne(songID);
		
		currentSong.setSingerName(tmpSong.getSingerName());
		currentSong.setSongName(tmpSong.getSongName());
		
		return new ResponseEntity<>(songRepo.save(currentSong), HttpStatus.OK);
	}
	
	//delete a song
	@RequestMapping(value= "/{songID}", method= RequestMethod.DELETE)
	public ResponseEntity<Void> deleteOneSong(@PathVariable("songID") long songID){
		songRepo.delete(songID);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
		
	//delete all users
	//it will be changed later
	@RequestMapping(value= "/deleteAll",method= RequestMethod.DELETE)
	public ResponseEntity<Void> deleteAllSong(){
		songRepo.deleteAll();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
