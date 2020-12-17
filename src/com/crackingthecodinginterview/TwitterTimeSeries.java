package com.crackingthecodinginterview;

import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

class TwitterPair {
	private String engangementData;
	private Integer engagementCount;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((engagementCount == null) ? 0 : engagementCount.hashCode());
		result = prime * result + ((engangementData == null) ? 0 : engangementData.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "TwitterPair [engangementData=" + engangementData + ", engagementCount=" + engagementCount + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TwitterPair other = (TwitterPair) obj;
//		if (engagementCount == null) {
//			if (other.engagementCount != null)
//				return false;
//		} else if (!engagementCount.equals(other.engagementCount))
//			return false;
		if (engangementData == null) {
			return other.engangementData == null;
		} else return engangementData.equals(other.engangementData);
	}

	public TwitterPair(String engangementData, Integer engagementCount) {
		this.engangementData = engangementData;
		this.engagementCount = engagementCount;
	}

	public String getEngangementData() {
		return engangementData;
	}

	public void setEngangementData(String engangementData) {
		this.engangementData = engangementData;
	}

	public Integer getnOfData() {
		return engagementCount;
	}

	public void setnOfData(Integer nOfData) {
		this.engagementCount = nOfData;
	}

}

public class TwitterTimeSeries {

	private TreeMap<String, List<TwitterPair>> DATA;

	private static String[] INTERVALS;
	private static final int NO_OF_INTERVALS = 2;
	private static final Scanner in = new Scanner(System.in);

	public static void inputIntervals() {

		INTERVALS = new String[NO_OF_INTERVALS];

		in.useDelimiter("\n");
		String interval = in.next();
		interval.trim();

		StringTokenizer tokens = new StringTokenizer(interval, ",");
		int i = 0;
		while (tokens.hasMoreTokens() && i < NO_OF_INTERVALS) {
			String str_date = tokens.nextToken();

			StringBuffer s = new StringBuffer();
			StringTokenizer tokens_of_Date = new StringTokenizer(str_date, "-");
			INTERVALS[i] = (s.append(tokens_of_Date.nextToken()).append("-").append(tokens_of_Date.nextToken())
					.append("-").append("01")).toString();
			i++;
			System.out.println(s);
		}
		in.next();
	}

	public static void processAndAddIntoRegistry(String engagement) {
		StringTokenizer st = new StringTokenizer(engagement, ",");
		String engagementType = null;
		String engagementCount = null;
		while (st.hasMoreTokens()) {
			String date = st.nextToken().trim();
			if (st.hasMoreTokens())
				engagementType = st.nextToken().trim();
			if (st.hasMoreTokens())
				engagementCount = st.nextToken().trim();
			TwitterPair pair = new TwitterPair(engagementType, Integer.parseInt(engagementCount));
			addToRegistry(date, pair);
		}
	}

	public static void addToRegistry(String date, TwitterPair pair) {

	}

	public static String inputSingleEngagement() {
		String singleEngagement = in.next();
		return singleEngagement;
	}

	public static void inputEngagements() {
		String singleEngagement = null;
		do {
			singleEngagement = inputSingleEngagement();
			System.out.println(singleEngagement.length());
			processAndAddIntoRegistry(singleEngagement);
		} while (singleEngagement != null && singleEngagement.length() > 0 && !singleEngagement.equals("\n"));
		return;
	}

	public static void main(String[] args) {
		TwitterTimeSeries.inputIntervals();
		TwitterTimeSeries.inputEngagements();
	}
}
