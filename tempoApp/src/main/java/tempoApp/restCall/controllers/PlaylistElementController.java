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

import tempoApp.restCall.models.Playlist;
import tempoApp.restCall.repository.PlaylistRepository;



@RestController
@RequestMapping("/tempoApp/playlist")
public class PlaylistElementController {
	
	
		//for more about CRUD (create = POST, read = GET, update = PUT, delete = DELETE
	
	
		@Autowired
		private PlaylistRepository playlistRepo;
		
		
		
		//get method for finding all playlist:
		@RequestMapping(method= RequestMethod.GET)
		public ResponseEntity< Collection<Playlist> > getAllPlaylist(){
			return new ResponseEntity<>(playlistRepo.findAll(), HttpStatus.OK );
		}
		
		
		
		
		//get method for finding user with playlistID
		@RequestMapping( value = "/{playlistID}", method = RequestMethod.GET)
		public ResponseEntity<Playlist> getPlaylistwithID(@PathVariable("playlistID") long playlistID){
			Playlist tmpPlaylist = playlistRepo.findOne(playlistID);
			if(tmpPlaylist!= null) {
				return new ResponseEntity<Playlist>(tmpPlaylist, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
			}
		}
		
		
		//POST method
		@RequestMapping(method= RequestMethod.POST)
		public ResponseEntity<?> addPlaylist(@RequestBody Playlist tmpPlaylist){
			//@RequestBody handles value= at runtime
			return new ResponseEntity<>(playlistRepo.save(tmpPlaylist), HttpStatus.CREATED);
		}
		
		
		
		//PUT method
		@RequestMapping(value= "/{playlistID}", method= RequestMethod.PUT)
		public ResponseEntity<?> updatePlaylist(@PathVariable("playlistID") long playlistID, 
				@RequestBody Playlist tmpPlaylist ){
			Playlist currentPlaylist= playlistRepo.findOne(playlistID);
			
			currentPlaylist.setPlaylistName(tmpPlaylist.getPlaylistName());
			return new ResponseEntity<>(playlistRepo.save(tmpPlaylist), HttpStatus.OK);
		}
		
		
		

		//delete an playlist (delete specific playlist)
		
		@RequestMapping(value= "/{playlistID}", method= RequestMethod.DELETE)
		public ResponseEntity<Void> deleteOnePlaylist(@PathVariable("playlistID") long playlistID){
			playlistRepo.delete(playlistID);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		
		//delete all playlist
		@RequestMapping(value= "/deleteAll",method= RequestMethod.DELETE)
		public ResponseEntity<Void> deleteAllPlaylist(){
			playlistRepo.deleteAll();
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		
		

}









