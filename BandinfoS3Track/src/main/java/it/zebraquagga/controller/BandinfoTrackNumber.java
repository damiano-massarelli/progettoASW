package it.zebraquagga.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BandinfoTrackNumber {
	
	private static final int MAX_TRACK_NUMBER = 15;

	@RequestMapping("/s3/{bandName}/{albumName}/{songTitle}")
	public int getTrackNumer(@PathVariable String bandName, @PathVariable String albumName, @PathVariable String songTitle) {
		return (int)(Math.random() * MAX_TRACK_NUMBER);
	}
	
	
}
