package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.IOException;

abstract class TextConverter {
	private BufferedReader reader;

	public TextConverter(BufferedReader reader) {
		this.reader = reader;
	}
	
	public String convertToHtml() throws IOException{
	    String line = readLine();
	    String html = "";
	    while (line != null)
	    {
	    	html += convertLine(line);
	    	line = readLine();
	    }
	    return html;
    }

	private String readLine() throws IOException {
		return reader.readLine();
	}
	
	abstract String convertLine(String line);
}
