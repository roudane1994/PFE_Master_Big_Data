package ocp.sta1;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.bson.BasicBSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.hadoop.io.BSONWritable;

public  class TMapper extends Mapper<Object,BasicDBObject,Text,BSONWritable>{
	
	
	@Override
    public void map(final Object key,final BasicDBObject value,final Context context) 
    		throws IOException, InterruptedException {
    	
    	
    	String id = value.get("_id").toString();
    	String anneeAjoute = value.get("dataAjoute").toString();
    	System.out.println("Maper--->"+key.toString());
    	BasicBSONObject urlCounts = new BasicBSONObject();
        urlCounts.put(anneeAjoute, 1);
        context.write(new Text(anneeAjoute),new BSONWritable(urlCounts));
    }
  }
