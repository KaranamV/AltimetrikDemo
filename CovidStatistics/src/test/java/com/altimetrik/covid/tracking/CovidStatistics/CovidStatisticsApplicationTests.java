package com.altimetrik.covid.tracking.CovidStatistics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.altimetrik.covid.tracking.CovidStatistics.Controller.CovidController;
import com.altimetrik.covid.tracking.CovidStatistics.Model.CovidMetrics;

@SpringBootTest
class CovidStatisticsApplicationTests {


	
	@Autowired
	CovidController covidController;
	
	
	@Test
	void testGetByState() throws JSONException {
		
		CovidMetrics expected = new CovidMetrics();
		
		expected.setDeaths(1557);
		expected.setPositive(36681);
		expected.setNegative(265193);
		expected.setTotalTestResults(301874);
		
		CovidMetrics actual = covidController.findCovidDetailsByState("GA");
		
		assertEquals(expected.getDeaths(), actual.getDeaths());
		assertEquals(expected.getPositive(), actual.getPositive());
		assertEquals(expected.getNegative(), actual.getNegative());
		assertEquals(expected.getTotalTestResults(), actual.getTotalTestResults());
	
}
	
	@Test
	void testGetByCountry() throws JSONException {
		
		CovidMetrics expected = new CovidMetrics();
		
		expected.setDeaths(81729);
		expected.setPositive(1433696);
		expected.setNegative(9286489);
		expected.setTotalTestResults(10720185);
		
		CovidMetrics actual = covidController.findCovidDetailsByCountry("us");
		
		assertEquals(expected.getDeaths(), actual.getDeaths());
		assertEquals(expected.getPositive(), actual.getPositive());
		assertEquals(expected.getNegative(), actual.getNegative());
		assertEquals(expected.getTotalTestResults(), actual.getTotalTestResults());
	
   }

}