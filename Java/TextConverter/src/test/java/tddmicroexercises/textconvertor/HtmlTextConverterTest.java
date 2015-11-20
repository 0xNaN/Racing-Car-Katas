package tddmicroexercises.textconvertor;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

public class HtmlTextConverterTest {
    @Test
    public void 
    doesnt_convert_an_empty_line() throws IOException {
        HtmlTextConverter converter = new HtmlTextConverter(string2reader(""));
        assertEquals("", converter.convertToHtml());
    }
    
    private BufferedReader string2reader(String string) {
    	InputStream is = new ByteArrayInputStream(string.getBytes());
    	return new BufferedReader(new InputStreamReader(is));
    }
}
