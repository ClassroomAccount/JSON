import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonWriteExample {

	private static final String filePath = "C:\\CS280\\jsonWriteTest.json";

	 public static void main(String[] args) {

		 //create data elements for needed content
		 //top level element is an object
			JSONObject obj = new JSONObject();
			obj.put("name", "Joe DePloy");
			obj.put("age", 39);

			JSONArray list = new JSONArray();
			list.add("msg 1");
			list.add("msg 2");
			list.add("msg 3");

			obj.put("messages", list);

			JSONObject address = new JSONObject();
			address.put("number", 175);
			address.put("street", "Forest St.");
			address.put("city", "Waltham");
			address.put("state", "MA");
			address.put("zip", "02452");

			obj.put("mail", address);

			obj.put("email", "harry@bentley.edu");

			try {
				//open stream and write JSON object
				FileWriter file = new FileWriter(filePath);
				file.write(obj.toJSONString());

				file.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.print(obj);

		     }


}
