import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReadExample {
	
	private static final String filePath = "C:\\CS280\\agetest.json";

	 public static void main(String[] args) {

		 //open stream and read the json file
		 try (FileReader reader = new FileReader(filePath);){
				
				JSONParser jsonParser = new JSONParser();
				JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

				String name = (String) jsonObject.get("name");
				System.out.println(name);

				long age = (Long) jsonObject.get("age");
				System.out.println(age);

				// loop array
				JSONArray msg = (JSONArray) jsonObject.get("messages");
				Iterator<String> iterator = msg.iterator();
				while (iterator.hasNext()) {
					System.out.println(iterator.next());
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
