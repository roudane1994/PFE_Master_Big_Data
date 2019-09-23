package ocp.sta3;

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
	
	

	
	 public static void main(String[] args) throws Exception {
	        Configuration conf = new Configuration();
	        conf.set( "mongo.input.uri" , "mongodb://localhost/gestionIncidentOcp.incident" );
	        conf.set( "mongo.output.uri" , "mongodb://localhost/gestionIncidentOcp.case3" );
	        @SuppressWarnings("deprecation")
	        Job job = new Job(conf, "word count");
	        job.setNumReduceTasks(12);
	       // job.setJarByClass(WordCount.class);
	        job.setMapperClass(TMapper.class);
	        //job.setCombinerClass(IntSumReducer.class);
	        job.setReducerClass(TReducer.class);
	        job.setMapOutputKeyClass(BSONWritable.class);
	        job.setMapOutputValueClass(BSONWritable.class);
	        job.setOutputKeyClass(Text.class);
	        job.setOutputValueClass(BSONWritable.class);
	        job.setInputFormatClass( MongoInputFormat.class );
	        job.setOutputFormatClass( MongoOutputFormat.class );
	        System.exit(job.waitForCompletion(true) ? 0 : 1);
	    }
	}
