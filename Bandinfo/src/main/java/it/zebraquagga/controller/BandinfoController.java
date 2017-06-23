package it.zebraquagga.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import it.zebraquagga.clients.AlbumClient;
import it.zebraquagga.clients.GenreClient;
import it.zebraquagga.clients.TrackClient;

@RestController
public class BandinfoController {

	private static final String GENERIC_INFOS = "Il genere dei %1$s è \"%2$s\" e il loro album più famoso è \"%3$s\"";
	private static final String GENRE_AND_YEAR_OF_RELEASE = "Il genere dei %1$s è \"%2$s\" e l'album \"%3$s\" è stato pubblicato nel %4$d";
	private static final String GENRE_YEAR_OF_RELEASE_TRACK_NUMBER = GENRE_AND_YEAR_OF_RELEASE + ". \"%5$s\" è la traccia numero %6$d";
	private static final String SERVICE_NOT_AVAILABLE_MSG = "Momentaneamente non sono disponibili informazioni per %1$s";
	
	
	@Autowired
	private GenreClient genreClient;
	
	@Autowired
	private AlbumClient albumClient;

	
	@Autowired
	private TrackClient trackClient;
	
	
	@RequestMapping("/s/{bandName}")
	@HystrixCommand(fallbackMethod="getFallbackBandGenreAndMostFamousAlbum")
	public String getBandGenreAndMostFamousAlbum(@PathVariable String bandName) {
		String genre = this.genreClient.getBandGenre(bandName);
		String mostFamousAlbum = this.albumClient.getMostFamousAlbum(bandName);
		return String.format(GENERIC_INFOS, bandName, genre, mostFamousAlbum);
	}
	
	@RequestMapping("/s/{bandName}/{albumName}")
	@HystrixCommand(fallbackMethod="getFallbackBandGenreAndAlbumYearOfRelease")
	public String getBandGenreAndAlbumYearOfRelease(@PathVariable String bandName, @PathVariable String albumName) {
		String genre = this.genreClient.getBandGenre(bandName);
		int yearOfRelease = this.albumClient.getYearOfRealase(bandName, albumName);
		return String.format(GENRE_AND_YEAR_OF_RELEASE, bandName, genre, albumName, yearOfRelease);
	}
	
	@RequestMapping("/s/{bandName}/{albumName}/{songTitle}")
	@HystrixCommand(fallbackMethod="getFallbackSongTrackNumber")
	public String getSongTrackNumber(@PathVariable String bandName, @PathVariable String albumName, @PathVariable String songTitle) {
		String genre = this.genreClient.getBandGenre(bandName);;
		int trackNumber = this.trackClient.getTrackNumer(bandName, albumName, songTitle);
		int yearOfRelease = this.albumClient.getYearOfRealase(bandName, albumName);
		return String.format(GENRE_YEAR_OF_RELEASE_TRACK_NUMBER, bandName, genre, albumName, yearOfRelease, songTitle, trackNumber);
	}
	
	public String getFallbackBandGenreAndMostFamousAlbum(String bandName) {
		return String.format(SERVICE_NOT_AVAILABLE_MSG, bandName);
	}
	
	public String getFallbackBandGenreAndAlbumYearOfRelease(String bandName, String albumName) {
		return String.format(SERVICE_NOT_AVAILABLE_MSG, bandName);
	}
	
	public String getFallbackSongTrackNumber(String bandName, String albumName, String songTitle) {
		return String.format(SERVICE_NOT_AVAILABLE_MSG, bandName);
	}
	
}
