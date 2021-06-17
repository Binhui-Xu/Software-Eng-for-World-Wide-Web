/**
 * 
 */
package com.swe642.studentSurvey;

/**
 * @author xubinhui
 * the business logic implement class
 */
public class DataProcessor {
	Double mean = 0.0;
	Double standDev = 0.0;
	
	public void computation(int[] numArray) {
		double sum=0.0,deviation=0.0;
		int len=numArray.length;
		for(int num:numArray) {
			sum+=num;
		}
		mean=sum/len;
		for(int num:numArray) {
			deviation+=Math.pow(num-mean,2);
		}
		standDev=Math.sqrt(deviation/len);
	}
}
