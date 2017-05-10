package it.zebraquagga.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BandinfoAlbumController {
	@Value("${albums}")
	private String albums;
	
	@RequestMapping("/s2/{bandName}")
	public String getMostFamousAlbum(@PathVariable String bandName) {
		String[] albumArray = albums.split(",");
		int i = (int)(Math.random() * albumArray.length);
		return albumArray[i];
	}
	
	@RequestMapping("/s2/{bandName}/{albumName}")
	public int getYearOfRealase(@PathVariable String bandName, @PathVariable String albumName){
		return (int)(Math.random() * 58) + 1960;
	}
}
