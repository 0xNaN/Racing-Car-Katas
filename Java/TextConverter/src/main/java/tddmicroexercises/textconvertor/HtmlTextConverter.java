package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HtmlTextConverter
{
	private BufferedReader reader;
    private String filePath;

    public HtmlTextConverter(String filePath) throws FileNotFoundException
    {
        this.filePath = filePath;
        reader = new BufferedReader(new FileReader(filePath));
    }

    public HtmlTextConverter(BufferedReader reader)
    {
    	this.reader = reader;
    }

    public String convertToHtml() throws IOException{
	    String line = reader.readLine();
	    String html = "";
	    while (line != null)
	    {
	    	html += StringEscapeUtils.escapeHtml(line);
	        html += "<br />";
	        line = reader.readLine();
	    }
	    return html;

    }

	public String getFilename() {
		return this.filePath;
	}
}
