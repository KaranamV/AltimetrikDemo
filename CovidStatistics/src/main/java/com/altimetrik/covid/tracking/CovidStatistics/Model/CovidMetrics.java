package com.altimetrik.covid.tracking.CovidStatistics.Model;

import org.springframework.stereotype.Component;

@Component
public class CovidMetrics {
	
	int positive;
	int negative;
	int totalTestResults;
	int deaths;
	
	public CovidMetrics(int positive, int negative, int totalTestResults, int deaths) {
		this.positive = positive;
		this.negative = negative;
		this.totalTestResults = totalTestResults;
		this.deaths = deaths;
	}
	
	public CovidMetrics(){		
	}
	
	public int getPositive() {
		return positive;
	}
	public void setPositive(int positive) {
		this.positive = positive;
	}
	public int getNegative() {
		return negative;
	}
	public void setNegative(int negative) {
		this.negative = negative;
	}
	public int getTotalTestResults() {
		return totalTestResults;
	}
	public void setTotalTestResults(int totalTestResults) {
		this.totalTestResults = totalTestResults;
	}
	public int getDeaths() {
		return deaths;
	}
	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}


	@Override
	public String toString() {
		return "CovidMetrics [positive=" + positive + ", negative=" + negative + ", totalTestResults="
				+ totalTestResults + ", deaths=" + deaths + "]";
	}

	

}
