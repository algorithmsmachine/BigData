package main;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MapperJob2 extends Mapper<LongWritable, Text, Text, Text> {

    public MapperJob2() {
    }


    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] wordAndDocCounter = value.toString().split("\t");
        String[] wordAndDoc = wordAndDocCounter[0].split(",");
        context.write(new Text(wordAndDoc[1]), new Text(wordAndDoc[0] + "," + wordAndDocCounter[1]));
        // doc2	:	can,1
    }
}