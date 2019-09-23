package ocp.sta4;

import java.io.IOException;
import java.util.Map;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.bson.BasicBSONObject;
import org.bson.types.ObjectId;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.hadoop.io.BSONWritable;

public  class TMapper extends Mapper<Object,BasicDBObject,BSONWritable,BSONWritable>{
	
	
	@Override
    public void map(final Object key,final BasicDBObject value,final Context context) 
    		throws IOException, InterruptedException {
    	
    	
    	String id = value.get("_id").toString();
    	String type = value.get("type").toString();
    	String anneeAjoute = value.get("dataAjoute").toString();
    	String materiel = value.get("materiel").toString();
    	String agent= value.get("agent").toString();
    	String idAgent=nomService(agent);
    	String nomService=agent(idAgent);
    	System.out.println("Maper--->"+nomService);
    	BasicBSONObject var = new BasicBSONObject();
        var.put("var", "3");
        BasicBSONObject cle = new BasicBSONObject();
        cle.put("type", type);
        cle.put("dataAjoute", anneeAjoute);
        cle.put("nomservice", nomService);
        context.write(new BSONWritable(cle),new BSONWritable(var));
    }
	
public String agent(String id) throws JsonParseException, JsonMappingException, IOException {
	
		String resultat=null;
		
		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("ocp");
		
		DBCollection col = db.getCollection("user");
		
		//read example
		DBObject query = BasicDBObjectBuilder.start().add("_id", new ObjectId(id)).get();
		DBCursor cursor = col.find(query);
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> map;
		while(cursor.hasNext()){
		DBObject a=cursor.next();
		map = mapper.readValue(a.toString(), Map.class);
			System.out.println("zzzz="+map.get("service"));
			resultat=map.get("service").toString();
		}
		
		
		
		//close resources
		mongo.close();
		
		return resultat;
	}

private String nomService(String total) throws JsonParseException, JsonMappingException, IOException {
	
	ObjectMapper mapper = new ObjectMapper();
	Map<String,Object> map;
	map=mapper.readValue(total, Map.class);
	return map.get("$id").toString();
	
}
  }
