package hu.codecool.textFormatter;

public class TextFormatter {

	public String[] format(String raw, int charNum) {
		String[] words = raw.split(" ");
		String lines = "";
		int charsLeft = charNum;
		
		for (int i = 0; i < words.length; i++) {
			if (words[i].length() + 1 >= charsLeft){
				lines += "/n" + words[i] + " ";
				charsLeft = charNum - words[i].length() + 1;
			} else {
				lines += words[i] + " ";
				charsLeft -= words[i].length() + 1;
			}
		}
		
		return lines.split("/n");
	}

	public static void main(String[] args) {
		String str = "12345 123 1234567 123456789 123 12 1 123 1234";
		TextFormatter tf = new TextFormatter();
		String[] result = tf.format(str, 4);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
