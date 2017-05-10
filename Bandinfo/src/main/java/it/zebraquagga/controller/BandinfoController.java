package it.zebraquagga.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BandinfoController {

	private static final String GENERIC_INFOS = "Il genere dei %1$s è \"%2$s\" e il loro album più famoso è \"%3$s\"";
	private static final String GENRE_AND_YEAR_OF_RELEASE = "Il genere dei %1$s è \"%2$s\" e l'album \"%3$s\" è stato pubblicato nel %4$d";
	private static final String GENRE_YEAR_OF_RELEASE_TRACK_NUMBER = GENRE_AND_YEAR_OF_RELEASE + ". \"%5$s\" è la traccia numero %6$d";
	
	private RestTemplate restTemplate;
	
	@PostConstruct
	public void init() {
		restTemplate = new RestTemplate();
	}
	
	@Value("${s1.uri}")
	private String s1Uri;
	
	@Value("${s2.mostFamousUri}")
	private String s2MostFamousUri;
	
	@Value("${s2.yearOfReleaseUri}")
	private String s2YearOfReleaseUri;

	@Value("${s3.uri}")
	private String s3Uri;
	
	private String getBandGenreFromS1(String bandName) {
		return restTemplate.getForObject(s1Uri, String.class, bandName);
	}
	
	private String getMostFamousAlbumFromS2(String bandName) {
		return restTemplate.getForObject(s2MostFamousUri, String.class, bandName);
	}
	
	private int getAlbumYearOfReleaseFromS2(String bandName, String albumName) {
		return restTemplate.getForObject(s2YearOfReleaseUri, Integer.class, bandName, albumName);
	}
	
	private int getSongTrackNumberFromS3(String bandName, String albumName, String songTitle  ) {
		return restTemplate.getForObject(s3Uri, Integer.class, bandName, albumName, songTitle);
	}
	
	@RequestMapping("/s/{bandName}")
	public String getBandGenreAndMostFamousAlbum(@PathVariable String bandName) {
		String genre = getBandGenreFromS1(bandName);
		String mostFamousAlbum = getMostFamousAlbumFromS2(bandName);
		return String.format(GENERIC_INFOS, bandName, genre, mostFamousAlbum);
	}
	
	@RequestMapping("/s/{bandName}/{albumName}")
	public String getBandGenreAndAlbumYearOfRelease(@PathVariable String bandName, @PathVariable String albumName) {
		String genre = getBandGenreFromS1(bandName);
		int yearOfRelease = getAlbumYearOfReleaseFromS2(bandName, albumName);
		return String.format(GENRE_AND_YEAR_OF_RELEASE, bandName, genre, albumName, yearOfRelease);
	}
	
	@RequestMapping("/s/{bandName}/{albumName}/{songTitle}")
	public String getSongTrackNumber(@PathVariable String bandName, @PathVariable String albumName, @PathVariable String songTitle) {
		String genre = getBandGenreFromS1(bandName);
		int trackNumber = getSongTrackNumberFromS3(bandName, albumName, songTitle);
		int yearOfRelease = getAlbumYearOfReleaseFromS2(bandName, albumName);
		return String.format(GENRE_YEAR_OF_RELEASE_TRACK_NUMBER, bandName, genre, albumName, yearOfRelease, songTitle, trackNumber);
	}
	
}
