import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

//	Find the average product rating reviews for each product
public class ProductAverageRatingMain {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException
    {
        try {
            long startTime = System.currentTimeMillis();
            Job job = Job.getInstance();
            job.setJarByClass(ProductAverageRatingMain.class);

            FileInputFormat.addInputPath(job, new Path(args[0]));
            FileOutputFormat.setOutputPath(job, new Path(args[1]));

            job.setMapperClass(ProductAverageRatingMapper.class);
            job.setReducerClass(ProductAverageRatingReducer.class);
            job.setCombinerClass(ProductAverageRatingReducer.class);

            job.setMapOutputKeyClass(Text.class);
            job.setMapOutputValueClass(CountAverageTuple.class);

            job.setNumReduceTasks(1);

            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(CountAverageTuple.class);

            job.waitForCompletion(true);
            long endTime = System.currentTimeMillis();
            System.out.println("Time taken in milliseconds : " + (endTime - startTime));
            System.out.println("Time taken in seconds : " + (endTime - startTime)/1000);

        } catch (Exception e) {
            System.out.println("Something went wrong in main class: ");
            e.printStackTrace();
        }
    }
}