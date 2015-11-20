package tddmicroexercises.textconvertor;

import java.io.IOException;

abstract class TextConverter {
	private File file;

	public TextConverter(File file) {
		this.file = file;
	}
	
	public String convertToHtml() throws IOException{
	    String line = file.nextLine();
	    String html = "";
	    while (line != null)
	    {
	    	html += convertLine(line);
	    	line = file.nextLine();
	    }
	    return html;
	}
	
	abstract String convertLine(String line);
}
