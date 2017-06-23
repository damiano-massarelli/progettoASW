package it.zebraquagga.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("track")
public interface TrackClient {
	
	@RequestMapping(value="/s3/{bandName}/{albumName}/{songTitle}", method=RequestMethod.GET)
	public int getTrackNumer(@RequestParam("bandName") String bandName, 
			@RequestParam("albumName") String albumName, 
			@RequestParam("songTitle") String songTitle);
	
	
}
