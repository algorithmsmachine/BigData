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
            if (args.length != 2) {
                System.out.printf("Usage: ProductAverageRatingMain <input dir> <output dir>\n");
                System.exit(-1);
            }

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


        } catch (Exception e) {
            System.out.println("Something went wrong in main class: ");
            e.printStackTrace();
        }
    }
}