package tempoApp.restCall.models;

import javax.persistence.*;


@Entity
@Table(name = "Songs")
public class Song {
	
	@Id
	@Column(name= "songID")
	private long songID;
	
	@Column(name= "SingerName")
	private String singerName;
	
	//@Column(name= "Tempo")
	//private Tempo tempo;
	
	@Column(name= "songName")
	private String songName;
	
	/*
	 * @ManyToOne
	 * @JoinColumn (name="playlist_ID")
	 * @JsonBackReference
	 * private Playlist whichPlaylist;
	*/
	
	//manytomany playlist
	
	//end of attributes
	
	//////////////////////////////////////////
	
	//getters and setters
	
	public long getSongID() {
		return songID;
	}
	
	public void setSongID(long songID) {
		this.songID= songID;
	}
	
	
	public String getSingerName() {
		return singerName;
	}
	
	public void setSingerName(String singerName) {
		this.singerName= singerName;
	}
	
	
	public String getSongName() {
		return songName;
	}
	
	public void setSongName(String songName) {
		this.songName= songName;
	}
	
	
	//end of getters and setters
	
	//////////////////////////
	
	//other methods
	
	@Override
	public String toString() {
		//new toString method for using possible fail checks (validation) later
		return String.format("SongID: "+ songID + "\nsingerName: "+ singerName + "\nsongName: "+ songName);
	}
	
	
	
	
	
	

}
