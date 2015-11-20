package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class HtmlTextConverter extends TextConverter
{
    private String filePath;

    public HtmlTextConverter(String filePath) throws FileNotFoundException
    {
    	super(new BufferedReader(new FileReader(filePath)));
        this.filePath = filePath;
    }

    public HtmlTextConverter(BufferedReader reader)
    {
    	super(reader);
    }
    
    public String convertLine(String line) {
    	return StringEscapeUtils.escapeHtml(line)
    			.concat("<br />");
    }
    
	public String getFilename() {
		return this.filePath;
	}
}
