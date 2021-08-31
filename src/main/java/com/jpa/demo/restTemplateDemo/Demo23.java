package com.jpa.demo.restTemplateDemo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpa.demo.Person;

@RestController
public class Demo23 {
	@GetMapping("/test/") 
	public List<Person> getAll()
	{
		RestTemplate obj=new RestTemplate();
		Person[] forObject = obj.getForEntity("http://localhost:9090/getall", Person[].class).getBody();
		List<Person> lp=new ArrayList<>(); 
		for(Person p:forObject)
		{
			lp.add(p);
		}
		return lp;
	} 
	@GetMapping("/test/get")
	public String getAll23()
	{
		RestTemplate obj=new RestTemplate();
		String s=obj.getForObject("http://localhost:9090/getall", String.class);
		return s;
	}
	@GetMapping("/test/addperson23")
	public String AddPerson()
	{
		RestTemplate obj=new RestTemplate();
		String s=obj.postForObject("http://localhost:9090/addperson", new Person(5,"dhillep"),String.class);
		return s;
	}
}
