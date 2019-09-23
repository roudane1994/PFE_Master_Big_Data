package com.mongodb.hadoop.examples.enron;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

import com.mongodb.BasicDBObject;

public  class TokenizerMapper extends Mapper<Object,BasicDBObject,Text,IntWritable>{
	
	
	@Override
    public void map(final Object key,final BasicDBObject value,final Context context) 
    		throws IOException, InterruptedException {
    	
    	
    	String id = value.get("_id").toString();
    	//String type = value.get("type").toString();
    	System.out.println("Maper--->"+key.toString());
        context.write(new Text(id+"M."),new IntWritable(1));
    }
  }