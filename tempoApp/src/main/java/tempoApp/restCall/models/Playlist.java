package tempoApp.restCall.models;

import javax.persistence.*;


@Entity
@Table(name= "playlists")
public class Playlist {
	
	
	@Id
	@Column(name= "playlistID")
	private long playlistID;
	
	
	@Column(name= "playlistName")
	private String playlistName;
	
	/*
	 * @ManyToOne
	 * @JoinColumn (name="user_ID")
	 * @JsonBackReference
	 * private User ownedBy;
	*/
	
	/*
	 * @ManyToMany
	 * @JoinColumn (name="song_ID")
	 * @JsonBackReference
	 * private List<Song> songsIncluded;
	*/
	
	
	//user many to one
	
	
	//songs many to many
	
	//end of attributes
	
	//////////////////////////////
	
	//getters and setters
	
	public long getPlaylistID() {
		return playlistID;
	}
	
	public void setPlaylistID(long playlistID) {
		this.playlistID= playlistID;
	}
	
	
	public String getPlaylistName() {
		return playlistName;
	}
	
	public void setPlaylistName(String playlistName) {
		this.playlistName= playlistName;
	}
	
	
	//end of getters and setters
	
	/////////////////////
	
	//other functions
	
	@Override
	public String toString() {
		//new toString method for using possible fail checks (validation) later
		return String.format("playlistID: "+playlistID + "\nplaylistName: "+ playlistName);
	}
	
	
	
	
	

}
