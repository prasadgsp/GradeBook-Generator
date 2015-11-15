package gradecreate;

import abstractinterfaces.Reader;

public class ReaderFactory {
	
	public Reader createReader(String type)
	{
		if(type.equalsIgnoreCase("Grad"))
			return new XMLReader();
		else
			return new JSONReader();
	}
	

}
