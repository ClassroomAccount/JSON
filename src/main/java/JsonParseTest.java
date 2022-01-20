//Be sure to place JSON files in CS280 directory

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParseTest {

	private static final String filePath = "C:\\CS280\\test.json";
	
	public static void main(String[] args) {

		//open stream and read the json file
		try (FileReader reader = new FileReader(filePath);){

			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

			// get a String from the JSON object
			String firstName =  (String) jsonObject.get("firstname");
			System.out.println("The first name is: " + firstName);

			// get a number from the JSON object
			long id =  (long) jsonObject.get("id");
			System.out.println("The id is: " + id);

			// get an array from the JSON object
			JSONArray lang= (JSONArray) jsonObject.get("languages");
			
			// take the elements of the json array
			for(int i=0; i<lang.size(); i++){
				System.out.println("The " + i + " element of the array: "+lang.get(i));
			}
			
			Iterator<JSONObject> i = lang.iterator();

			// iterate over each object in JSONArray
			while (i.hasNext()) {				
				JSONObject innerObj = (JSONObject) i.next();
				System.out.println("language "+ innerObj.get("lang") + 
						" with level " + innerObj.get("knowledge"));
			}
		
			
			// handle JSONObject
			JSONObject structure = (JSONObject) jsonObject.get("job");
			System.out.println("job object name: " + structure.get("name"));
			System.out.println("job object site: " + structure.get("site"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

	}

}
