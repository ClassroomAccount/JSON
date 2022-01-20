//Be sure to place JSON files in CS280 directory

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParseMenu {
	
	private static final String filePath = "C:\\CS280\\menu.json";

	public static void main(String[] args) {

			//open stream and read the json file
			try (FileReader reader = new FileReader(filePath);){
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

			// get the menu object from the JSON object
			JSONObject menu =  (JSONObject) jsonObject.get("menu");
			String header = (String)menu.get("header");
			System.out.println(header);
			
			// items array from menu object
			JSONArray items = (JSONArray) menu.get("items");
			
			// get the elements of the json array
			for(int i=0; i<items.size(); i++){
				
				JSONObject element = (JSONObject)items.get(i);
				String id = (String)element.get("id");
				String label = (String)element.get("label");
				
				//if label is null, use id as both id and label
				if (label == null) label = id;
				
				System.out.printf("%5d.     %-15s %-25s%n", i + 1, id, label);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
