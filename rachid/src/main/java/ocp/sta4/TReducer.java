package ocp.sta4;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;
import org.bson.BSONObject;
import org.bson.BasicBSONObject;

import com.mongodb.hadoop.io.BSONWritable;

public  class TReducer extends Reducer<BSONWritable,BSONWritable,Text,BSONWritable> {
	
 @Override
  public void reduce(BSONWritable key, Iterable<BSONWritable> values,Context context) throws IOException, InterruptedException {
  	int count=0;
  	BasicBSONObject result = new BasicBSONObject();
  	
  	
  	for(final BSONWritable var:values) {
  	
  	
  		count+=1;
  	}
  	BSONObject r;
  	r=key.getDoc();
  	String type=(String) r.get("type");
  	String anneeAjoute=(String) r.get("dataAjoute");
  	String materiel=(String) r.get("materiel");
  	String nomservice=(String) r.get("nomservice");
  	result.put("type",type);
  	result.put("dataAjoute",Integer.parseInt(anneeAjoute));
  	result.put("nb", count);
  	result.put("nomservice",nomservice);
  	System.out.println("Reduse--->"+key.toString());
  	context.write(null, new BSONWritable(result));
    
  }
}
