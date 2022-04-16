package stubs;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class LetterMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    @Override
    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {

        /*
         * TODO implement
         */
        String line = value.toString();
//        for (String word : line.split("\\W+")) {
//            if (word.length() > 0) {
//                context.write(new Text(word), new IntWritable(1));
//            }
//        }

        for (String word: line.split("\\W+")) {
            if (word.length() > 0) {
                /*
                 * Obtain the first letter of the word
                 */
                String letter = word.substring(0, 1);

                /*
                 * call the write method on the Context object to emit a key and a
                 * value from the map method. The key is the letter that the word starts
                 * with; the value is the word's length.
                 */
                context.write(new Text(letter), new IntWritable(word.length()));
            }
        }
    }

}
