package it.zebraquagga.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BandinfoGenreController {
	
	@Value("${genres}")
	private String genres;
	
	@RequestMapping("/s1/{bandName}")
	public String getGenre(@PathVariable String bandName) {
		String[] genreArray = genres.split(",");
		int i = (int)(Math.random() * genreArray.length);
		return genreArray[i];
	}
	
}
