package com.mongodb.hadoop.examples.enron;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public  class IntSumReducer extends Reducer<Text,IntWritable,Text,IntWritable> {
	
 @Override
  public void reduce(Text key, Iterable<IntWritable> values,Context context) throws IOException, InterruptedException {
  	int count=0;
  	
  	for(final IntWritable var:values) {
  		count+=var.get();
  	}
  	System.out.println("Reduse--->"+key.toString());
  	context.write(key, new IntWritable(count));
    
  }
}