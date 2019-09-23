package com.test;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;
import org.bson.BasicBSONObject;

import com.mongodb.hadoop.io.BSONWritable;

public  class TReducer extends Reducer<Text,BSONWritable,Text,BSONWritable> {
	
 @Override
  public void reduce(Text key, Iterable<BSONWritable> values,Context context) throws IOException, InterruptedException {
  	int count=0;
  	BasicBSONObject result = new BasicBSONObject();
  	
  	for(final BSONWritable var:values) {
  		count+=1;
  	}
  	result.put("annee",Integer.parseInt(key.toString()));
  	result.put("nb", count);
  	
  	System.out.println("Reduse--->"+key.toString());
  	context.write(null, new BSONWritable(result));
    
  }
}
