package com.rajmevada.test;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.rajmevada.model.User;

public class SpringRestTestClient {

	
	public static final String REST_SERVICE_URL = "http://localhost:8080/SpringRestCurdOperation";
	
	public static final void findAllUsers(){
		
		RestTemplate template=new RestTemplate();
		List<LinkedHashMap<String, Object>> users=template.getForObject(REST_SERVICE_URL+"/user/",List.class);
		if(users!=null){
			for(LinkedHashMap<String, Object> map:users){
				System.out.println(map.get("name")+"   city : "+map.get("city"));
			}
		}
	}
	public static void main(String[] args) {
		
		findAllUsers();
	}
}
