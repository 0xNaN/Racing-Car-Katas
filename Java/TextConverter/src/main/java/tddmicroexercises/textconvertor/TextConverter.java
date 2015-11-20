package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.IOException;

abstract class TextConverter {
	private BufferedReader reader;

	public TextConverter(BufferedReader reader) {
		this.reader = reader;
	}
	
	public String convertToHtml() throws IOException{
	    String line = reader.readLine();
	    String html = "";
	    while (line != null)
	    {
	    	html += convertLine(line);
	        line = reader.readLine();
	    }
	    return html;
    }
	
	abstract String convertLine(String line);
}
