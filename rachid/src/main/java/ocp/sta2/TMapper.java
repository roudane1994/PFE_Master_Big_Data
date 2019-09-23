package ocp.sta2;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.bson.BasicBSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.hadoop.io.BSONWritable;

public  class TMapper extends Mapper<Object,BasicDBObject,BSONWritable,BSONWritable>{
	
	
	@Override
    public void map(final Object key,final BasicDBObject value,final Context context) 
    		throws IOException, InterruptedException {
    	
    	
    	String id = value.get("_id").toString();
    	String type = value.get("type").toString();
    	String anneeAjoute = value.get("dataAjoute").toString();
    	System.out.println("Maper--->"+key.toString());
    	BasicBSONObject var = new BasicBSONObject();
        var.put("var", "3");
        BasicBSONObject cle = new BasicBSONObject();
        cle.put("type", type);
        cle.put("dataAjoute", anneeAjoute);
        context.write(new BSONWritable(cle),new BSONWritable(var));
    }
  }
