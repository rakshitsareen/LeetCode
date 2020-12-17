package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

interface HtmlParser {
	List<String> getUrls(String url);
}

public class WebCrawler {

	public List<String> crawl(String startUrl, HtmlParser htmlParser) {
		String hostname = getHost(startUrl);
		Queue<String> q = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		q.offer(startUrl);
		visited.add(startUrl);
		while (!q.isEmpty()) {
			String url = q.poll();
			List<String> urls = htmlParser.getUrls(url);
			for (String u : urls) {
				if (u.contains(hostname) && !visited.contains(u)) {
					q.offer(u);
					visited.add(u);
				}
			}
		}
		return new ArrayList<String>(visited);
	}

	private String getHost(String url) {
		String[] U = url.split("/");
		return U[2];
	}

}
