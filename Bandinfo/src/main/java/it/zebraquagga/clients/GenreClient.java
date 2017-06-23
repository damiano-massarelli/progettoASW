package it.zebraquagga.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("genre")
public interface GenreClient {

	@RequestMapping(value="/s1/{bandName}", method=RequestMethod.GET)
	public String getBandGenre(@RequestParam("bandName") String bandName);
	
	
}
