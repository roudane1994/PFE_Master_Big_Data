package ocp.sta1;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import com.mongodb.BasicDBObject;
import com.mongodb.hadoop.MongoInputFormat;
import com.mongodb.hadoop.MongoOutputFormat;
import com.mongodb.hadoop.io.BSONWritable;
import com.mongodb.hadoop.util.MongoConfigUtil;

public class Main {
	
	
/**
	public static void main(String[] args) throws Exception {
	    Configuration conf = new Configuration();
	    Job job = Job.getInstance(conf, "word count");
	    MongoConfigUtil.setInputURI(job.getConfiguration(), "mongodb://localhost/ocp.incident");
	    job.setJarByClass(Mongo_MR.class);
	    job.setNumReduceTasks(0);
	    job.setMapperClass(TMapper.class);
	    job.setCombinerClass(TReducer.class);
	    job.setReducerClass(TReducer.class);
	    job.setMapOutputKeyClass(Text.class);
	    job.setMapOutputValueClass(Text.class);
	    job.setInputFormatClass(com.mongodb.hadoop.MongoInputFormat.class);
	    job.setOutputKeyClass(Text.class);
	    job.setOutputValueClass(Text.class);
	    FileOutputFormat.setOutputPath(job, new Path(args[0]));
	    System.exit(job.waitForCompletion(true) ? 0 : 1);
	  }**/
	
	 public static void main(String[] args) throws Exception {
	        Configuration conf = new Configuration();
	        conf.set( "mongo.input.uri" , "mongodb://localhost/gestionIncidentOcp.incident" );
	        conf.set( "mongo.output.uri" , "mongodb://localhost/gestionIncidentOcp.case1" );
	        @SuppressWarnings("deprecation")
	        Job job = new Job(conf, "word count");
	        job.setNumReduceTasks(12);
	       // job.setJarByClass(WordCount.class);
	        job.setMapperClass(TMapper.class);
	        //job.setCombinerClass(IntSumReducer.class);
	        job.setReducerClass(TReducer.class);
	        job.setMapOutputKeyClass(Text.class);
	        job.setMapOutputValueClass(BSONWritable.class);
	        job.setOutputKeyClass(Text.class);
	        job.setOutputValueClass(BSONWritable.class);
	        job.setInputFormatClass( MongoInputFormat.class );
	        job.setOutputFormatClass( MongoOutputFormat.class );
	        System.exit(job.waitForCompletion(true) ? 0 : 1);
	    }
	}
