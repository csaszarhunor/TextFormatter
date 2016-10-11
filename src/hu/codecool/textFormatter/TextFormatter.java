package hu.codecool.textFormatter;

import java.util.ArrayList;
import java.util.List;

public class TextFormatter {

	public static String[] format(String text, int maxLineLength){
		String[] words = text.split(" ");
		List<String> lines = new ArrayList<>();
		String line = "";
		int freeChars = maxLineLength;
		for (String word : words) {
			if(word.length() > freeChars){
				line += word.substring(0, freeChars);
				lines.add(line);
				
				int splitIndex = freeChars;
				while(word.substring(splitIndex).length() > maxLineLength){
					lines.add(word.substring(splitIndex, splitIndex + maxLineLength));
					splitIndex += maxLineLength;
				}
				line = word.substring(splitIndex) + " ";
				freeChars = maxLineLength - line.length();
			} else {
				line += word + " ";
				freeChars = maxLineLength - line.length();
			}
		}
		return (String[]) lines.toArray(new String[lines.size()]);
	}
	
	public static String[] alignWithConcreteLength(String text, int maxLineLength){
		List<String> lines = new ArrayList<>();
		for (int i = 0; i < text.length(); i += maxLineLength) {
			String line = (text.length() < i + maxLineLength) ? text.substring(i) : text.substring(i, i + maxLineLength);
			lines.add(line);
		}
		return (String[]) lines.toArray(new String[lines.size()]);
	}
	
	public static void main(String[] args) {
		String text = "I am a Codecooler dsdfs sdfsdfsf sdfsdffsfsddfsf sdf d d df dfdf sdf";
		String[] lines = TextFormatter.alignWithConcreteLength(text, 5);
		for (String string : lines) {
			System.out.println(string);
		}
		System.out.println();
		lines = TextFormatter.format(text, 5);
		for (String string : lines) {
			System.out.println(string);
		}
	}
}
