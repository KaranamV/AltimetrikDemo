package com.altimetrik.covid.tracking.CovidStatistics.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import java.util.Map;



import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.altimetrik.covid.tracking.CovidStatistics.Model.CovidMetrics;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CovidService {

	public CovidMetrics findCovidDetailsForState(String stateCode) {
		
		 RestTemplate restTemplate = new RestTemplate();
		
		  ObjectMapper mapper = new ObjectMapper();
		  mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		 

	        ResponseEntity<Object> rateResponse =
	                restTemplate.exchange("https://covidtracking.com/api/v1/states/" + stateCode + "/current.json",
	                        HttpMethod.GET, null, new ParameterizedTypeReference<Object>() {
	                        });
	     
	        
	        LinkedHashMap<String,Object> metrics = (LinkedHashMap<String,Object>) rateResponse.getBody();
	              
	          
	          CovidMetrics covidMetric = new CovidMetrics();
	          
	          for (Map.Entry<String,Object> entry : metrics.entrySet())  
	              
	          {
	        	  if(entry.getKey().equals("positive"))
	        	  {
	        	  covidMetric.setPositive((int)entry.getValue());
	        	  }
	        	  
	        	  if(entry.getKey().equals("negative"))
	        	  {
	        	  covidMetric.setNegative((int)entry.getValue());
	        	  }
	        	  
	        	  if(entry.getKey().equals("totalTestResults"))
	        	  {
	        	  covidMetric.setTotalTestResults((int)entry.getValue());
	        	  }
	        	  
	        	  if(entry.getKey().equals("death"))
	        	  {
	        	  covidMetric.setDeaths((int)entry.getValue());
	        	  }
	        	  
	        	
	          }
	          
	      
	       
	       return covidMetric;

	}

	public CovidMetrics findCovidDetailsForCountry(String countryCode) {
		
		
		 RestTemplate restTemplate = new RestTemplate();
			
		  ObjectMapper mapper = new ObjectMapper();
		  mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		 

	        ResponseEntity<Object> rateResponse =
	                restTemplate.exchange("https://covidtracking.com/api/v1/" + countryCode + "/current.json",
	                        HttpMethod.GET, null, new ParameterizedTypeReference<Object>() {
	                        });
	     
		
		 ArrayList<Object> metrics = (ArrayList<Object>) rateResponse.getBody();
		 
		 LinkedHashMap<String,Object> hMap = (LinkedHashMap<String, Object>) metrics.get(0);
		 
		 CovidMetrics covidMetric = new CovidMetrics();
         
         for (Map.Entry<String,Object> entry : hMap.entrySet())  
             
         {
       	  if(entry.getKey().equals("positive"))
       	  {
       	  covidMetric.setPositive((int)entry.getValue());
       	  }
       	  
       	  if(entry.getKey().equals("negative"))
       	  {
       	  covidMetric.setNegative((int)entry.getValue());
       	  }
       	  
       	  if(entry.getKey().equals("totalTestResults"))
       	  {
       	  covidMetric.setTotalTestResults((int)entry.getValue());
       	  }
       	  
       	  if(entry.getKey().equals("death"))
       	  {
       	  covidMetric.setDeaths((int)entry.getValue());
       	  }
         }
           
      return covidMetric;
		 		
		
		}
	
	
	

}
