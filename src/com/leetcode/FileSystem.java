package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileSystem {

	class File {
		Map<String, File> dir;
		String content;
		boolean isFile;
	}

	File root;

	public FileSystem() {
		this.root = new File();
	}

	public List<String> ls(String path) {
		List<String> output = new ArrayList<>();
		String[] arr = path.split("/");
		File temp = root; // starting File
		int i = 0;
		for (i = 0; i < arr.length; i++) {
			if (arr[i].length() == 0)
				continue;
			if (temp.dir.containsKey(arr[i]))
				temp = temp.dir.get(arr[i]);
		}
		if (temp.dir != null) {
			output.addAll(temp.dir.keySet());
			if (temp.isFile) {
				System.out.println("arr[i] is :: " + arr[i]);
				output.add(arr[i]);
			}
			Collections.sort(output);
		}
		if(temp.dir == null && arr.length > 0 && temp.isFile) output.add(arr[arr.length-1]);
		return output;
	}

	public void mkdir(String path) {
		String[] splitPath = path.split("/");
		File temp = root;
		int i = 0;
		for (i = 0; i < splitPath.length; i++) {
			if (splitPath[i].length() == 0)
				continue;
			if (temp.dir == null)
				temp.dir = new HashMap<>();
			if (temp.dir.containsKey(splitPath[i]))
				temp = temp.dir.get(splitPath[i]);
			else {
				temp.dir.put(splitPath[i], new File());
				temp = temp.dir.get(splitPath[i]);
			}
		}
		return;
	}

	public void addContentToFile(String filePath, String content) {
		String[] splitPath = filePath.split("/");
		File temp = root;
		int i;
		for (i = 0; i < splitPath.length; i++) {
			if (splitPath[i].length() == 0)
				continue;
			if (temp.dir != null && temp.dir.containsKey(splitPath[i]))
				temp = temp.dir.get(splitPath[i]);
			else {
				if (temp.dir == null)
					temp.dir = new HashMap<>();
				if (!temp.dir.containsKey(splitPath[i])) {
					File file = new File();
					temp.dir.put(splitPath[i], file);
					temp = temp.dir.get(splitPath[i]);
				}
			}
		}
		temp.isFile = true;
		if (temp.content == null || temp.content.isEmpty())
			temp.content = "";
		temp.content += content;
		return;
	}

	public String readContentFromFile(String filePath) {
		File temp = root;
		String[] splitPath = filePath.split("/");
		int i;
		for (i = 0; i < splitPath.length; i++)
			if (temp.dir.containsKey(splitPath[i]))
				temp = temp.dir.get(splitPath[i]);
		if (temp != null && i == splitPath.length) {
			if (temp.isFile)
				return temp.content;
		}
		return null;
	}

	public static void main(String[] args) {
		FileSystem f = new FileSystem();
		f.mkdir("/a");
		System.out.println(f.ls("/a"));
		System.out.println(f.ls("/"));
		f.mkdir("/z");
		System.out.println(f.ls("/"));
		System.out.println(f.ls("/"));
		f.addContentToFile("/a/c", "hello");
		System.out.println(f.ls("/z"));
		System.out.println(f.ls("/a/c"));
		System.out.println(f.ls("/a"));
		// System.out.println(f.readContentFromFile("/a/b"));
	}

}
