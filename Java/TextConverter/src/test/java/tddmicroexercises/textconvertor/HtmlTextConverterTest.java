package tddmicroexercises.textconvertor;

import static org.junit.Assert.*;

import java.io.IOException;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class HtmlTextConverterTest {
	@Rule public JUnitRuleMockery context = new JUnitRuleMockery();
	private final File file = context.mock(File.class);
	
    @Test
    public void 
    doesnt_convert_an_empty_line() throws IOException {
    	context.checking(new Expectations(){{
			oneOf(file).nextLine(); will(returnValue(null));
		}});
        HtmlTextConverter converter = new HtmlTextConverter(file);
        assertEquals("", converter.convertToHtml());
    }
    
    @Test
    public void 
    convert_a_simple_line() throws IOException {
    	context.checking(new Expectations(){{
    		exactly(2).of(file).nextLine();
    		will(onConsecutiveCalls(
    				returnValue("line"),
    				returnValue(null)));
		}});
        HtmlTextConverter converter = new HtmlTextConverter(file);
        assertEquals("line<br />", converter.convertToHtml());
    }
    
    @Test
    public void 
    convert_two_lines() throws IOException {
    	context.checking(new Expectations(){{
    		exactly(3).of(file).nextLine();
    		will(onConsecutiveCalls(
    				returnValue("line1"),
    				returnValue("line2"),
    				returnValue(null)));
		}});
        HtmlTextConverter converter = new HtmlTextConverter(file);
        assertEquals("line1<br />line2<br />", converter.convertToHtml());
    }
    
}
