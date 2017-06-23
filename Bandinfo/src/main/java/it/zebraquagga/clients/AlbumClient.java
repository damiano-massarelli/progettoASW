package it.zebraquagga.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("album")
public interface AlbumClient {

	@RequestMapping(value="/s2/{bandName}", method=RequestMethod.GET)
	public String getMostFamousAlbum(@RequestParam("bandName") String bandName);
	
	@RequestMapping(value="/s2/{bandName}/{albumName}", method=RequestMethod.GET)
	public int getYearOfRealase(@RequestParam("bandName") String bandName, @RequestParam("albumName") String albumName);
	
	
}
