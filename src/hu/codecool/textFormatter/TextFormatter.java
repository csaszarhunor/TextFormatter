package hu.codecool.textFormatter;

import java.util.ArrayList;
import java.util.List;

public class TextFormatter {

	public String[] format(String raw, int charNum) {
		String[] words = raw.split(" ");
		List<String> lines = new ArrayList<>();

		String line = "";
		for (int i = 0; i < words.length; i++) {
			if (line.length() + words[i].length() + 1 <= charNum) {
				line += words[i] + " ";
			} else if (words[i].length() >= charNum) {
				if (line.length() != 0)
					lines.add(line);
				lines.add(words[i]);
				line = "";
			} else {
				lines.add(line);
				line = words[i] + " ";
			}
		}
		Object[] objs = lines.toArray();
		String[] result = new String[objs.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = (String) objs[i];
		}
		return result;
	}

	public static void main(String[] args) {
		String str = "12345 123 1234567 123456789 123 12 1 123 1234";
		TextFormatter tf = new TextFormatter();
		String[] result = tf.format(str, 7);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
