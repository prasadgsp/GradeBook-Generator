package gradecreate;

import abstractinterfaces.Formatter;

public class FormatterFactory {

	public Formatter createFormat(String type)
	{
		if(type.equalsIgnoreCase("CSV"))
			return new CSVFormatter();
                else if(type.equalsIgnoreCase("XML"))
			return new XMLFormatter();
		else
			return new HTMLFormatter();
	}
	
}
