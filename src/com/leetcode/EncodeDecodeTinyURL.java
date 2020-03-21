package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class EncodeDecodeTinyURL {

	Map<String, String> idx = new HashMap<>();
	Map<String, String> ridx = new HashMap<>();
	String base = "www.tinyurl.com/";
	String charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ01923456789";

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		if (ridx.containsKey(longUrl))
			return base + ridx.get(longUrl);
		StringBuilder sb = new StringBuilder();
		String key = null;
		do {
			for (int i = 0; i < 6; ++i) {
				int r = (int) (Math.random() * charset.length());
				sb.append(charset.charAt(r));
			}
			key = sb.toString();
		} while (idx.containsKey(key));
		idx.put(key, longUrl);
		ridx.put(longUrl, key);
		return base + key;
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		return idx.get(shortUrl.replace(base, ""));
	}
}
