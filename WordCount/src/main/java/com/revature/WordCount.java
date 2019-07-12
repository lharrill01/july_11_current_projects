package com.revature;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import org.apache.hadoop.mapreduce.Job;

import com.revature.map.WordMapper;
import com.revature.reduce.SumReducer;

public class WordCount {
	
	public static void main(String[] args) throws Exception{
		
		if(args.length < 2) {
			System.out.println("WordCount usage: <input dir><output dir>");
			System.exit(-1);
		}
		
		Job job = new Job();
		
		job.setJarByClass(WordCount.class);
		
		job.setJobName("Word Count");
		
		//Input and Output Paths
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));		
		
		//Specify the Mapper and Reducer class
		job.setMapperClass(WordMapper.class);
		job.setReducerClass(SumReducer.class);
		
		/*
		 * Set the Combiner class to be used before Reudce phase
		 * 
		 */
	
		job.setCombinerClass(SumReducer.class);
		
		//Specify the types of the final ouput
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		//check if job is complete
		boolean success = job.waitForCompletion(true);
		System.exit(success ? 0: 1);
	}

}
