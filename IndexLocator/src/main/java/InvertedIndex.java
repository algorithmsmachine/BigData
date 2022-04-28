import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.io.Text;

public class InvertedIndex {

    public static void main(String[] args) throws Exception {

        if (args.length != 2) {
            System.out.printf("Usage: InvertedIndex <input dir> <output dir>\n");
            System.exit(-1);
        }

        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "Inverted Index");
        job.setJarByClass(InvertedIndex.class);

//     Job job = new Job(getConf());
//     job.setJarByClass(InvertedIndex.class);
//     job.setJobName("Inverted Index");

//     Job job = Job.getInstance();
//     job.setJarByClass(InvertedIndex.class);


        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        /*
         * We are using a KeyValueText file as the input file.
         * Therefore, we must call setInputFormatClass.
         * There is no need to call setOutputFormatClass, because the
         * application uses a text file for output.
         */
        job.setInputFormatClass(KeyValueTextInputFormat.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        job.setMapperClass(IndexMapper.class);
        job.setReducerClass(IndexReducer.class);

        boolean success = job.waitForCompletion(true);
        System.exit(success ? 0 : 1);
    }
}
