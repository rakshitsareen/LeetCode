package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

class MetaData {
	@SerializedName("page")
	private int page;
	private int per_page;
	private int total;
	private int total_pages;
	private Movie[] data;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPer_page() {
		return per_page;
	}

	public void setPer_page(int per_page) {
		this.per_page = per_page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}

	public Movie[] getData() {
		return data;
	}

	public void setData(Movie[] data) {
		this.data = data;
	}
}

class Movie {
	@SerializedName("Poster")
	private String Poster;
	private String Title;
	private String Type;
	private int Year;
	private String imdbID;

	public String getPoster() {
		return Poster;
	}

	public void setPoster(String poster) {
		Poster = poster;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
}

public class CoxAutomotive {

	final static String URL = "https://jsonmock.hackerrank.com/api/movies/search/?Title=";

	public static String getURL(String urlToRead) throws Exception {
		StringBuilder result = new StringBuilder();
		URL url = new URL(urlToRead);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		rd.close();
		return result.toString();
	}

	public static String getPageResult(String substr, String pageNumber) throws Exception {
		String final_url = URL + substr + "&page=" + pageNumber;
		String return_value = CoxAutomotive.getURL(final_url);
		return return_value;
	}

	public static String[] getAllPages(String substr, int total_pages, int total) throws Exception {
		String[] title = new String[total];
		int i = 0;
		while (total_pages > 0) {
			String result = getPageResult(substr, Integer.toString(total_pages));
			Gson gson = new Gson();
			MetaData val = gson.fromJson(result, MetaData.class);
			Movie[] movies = val.getData();
			for (Movie movie : movies) {
				String _title = movie.getTitle();
				if (_title != null)
					title[i++] = _title;
			}
			total_pages--;
		}
		Collections.sort(Arrays.asList(title));
		return title;
	}

	public static void main(String[] args) throws Exception {
		String substr = "maze";
		String final_url = URL + substr;
		String return_value = CoxAutomotive.getURL(final_url);
		Gson gson = new Gson();
		MetaData val = gson.fromJson(return_value, MetaData.class);
		int total = val.getTotal();
		int total_pages = val.getTotal_pages();

		String[] titles = getAllPages(substr, total_pages, total);

		for (String title : titles)
			System.out.println(title);
	}
}
