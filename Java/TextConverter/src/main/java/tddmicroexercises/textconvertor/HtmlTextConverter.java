package tddmicroexercises.textconvertor;

import java.io.FileNotFoundException;

public class HtmlTextConverter extends TextConverter
{
    private File file;
    
    public HtmlTextConverter(String filePath) throws FileNotFoundException
    {
    	super(new RegularFile(filePath));
    }

    public HtmlTextConverter(File file)
    {
    	super(file);
    }
    
    public String convertLine(String line) {
    	return StringEscapeUtils.escapeHtml(line)
    			.concat("<br />");
    }
    
	public String getFilename() {
		return this.file.getPath();
	}
}
