package gradecreate;
import java.io.*;
import java.util.*;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


import abstractinterfaces.Reader;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.DeserializationConfig;


public class JSONReader implements Reader{

	public GradeMain read()
	{

		ObjectMapper mapper = new ObjectMapper();
		//mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                mapper.enable(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		try {
                        GradeMain gradeMain = mapper.readValue(new File("jsonGradesGoodData.json"), GradeMain.class);
			return gradeMain;
	 		} catch (Exception e) {
                        e.printStackTrace();
			return null;
		}
	}

}
