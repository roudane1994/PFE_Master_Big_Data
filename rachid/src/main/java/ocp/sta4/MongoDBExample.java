package ocp.sta4;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Map;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;


public class MongoDBExample {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
	
		
		
		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("ocp");
		
		DBCollection col = db.getCollection("service");
		
		//read example
		DBObject query = BasicDBObjectBuilder.start().add("_id", new ObjectId("5ce3d50bf4136510de64b8d8")).get();
		DBCursor cursor = col.find(query);
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> map;
		while(cursor.hasNext()){
		DBObject a=cursor.next();
		map = mapper.readValue(a.toString(), Map.class);
			System.out.println("zzzz="+map.get("nom"));
		}
		
		
		
		//close resources
		mongo.close();
	}

	

}