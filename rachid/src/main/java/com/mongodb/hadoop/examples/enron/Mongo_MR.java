package com.mongodb.hadoop.examples.enron;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import com.mongodb.BasicDBObject;
import com.mongodb.hadoop.MongoOutputFormat;
import com.mongodb.hadoop.io.BSONWritable;
import com.mongodb.hadoop.util.MongoConfigUtil;

public class Mongo_MR {
	
	

	  public static void main(String[] args) throws Exception {
	    Configuration conf = new Configuration();
	    Job job = Job.getInstance(conf, "word count");
	    MongoConfigUtil.setInputURI(job.getConfiguration(), "mongodb://127.0.0.1:27017/ocp.user");
	    MongoConfigUtil.setOutputURI(job.getConfiguration(), "mongodb://127.0.0.1:27017/ocp.sta2");
	    job.setJarByClass(Mongo_MR.class);
	    job.setNumReduceTasks(0);
	    job.setMapperClass(TokenizerMapper.class);
	    job.setCombinerClass(IntSumReducer.class);
	    job.setReducerClass(IntSumReducer.class);
	    job.setMapOutputKeyClass(Text.class);
	    job.setMapOutputValueClass(Text.class);
	    job.setInputFormatClass(com.mongodb.hadoop.MongoInputFormat.class);
	    job.setOutputKeyClass(Text.class);
	    job.setOutputValueClass(Text.class);
	    
	    job.setOutputFormatClass(MongoOutputFormat.class);
        job.setOutputValueClass(BSONWritable.class);
	   // FileOutputFormat.setOutputPath(job, new Path(args[0]));
	    System.exit(job.waitForCompletion(true) ? 0 : 1);
	  }
	}
