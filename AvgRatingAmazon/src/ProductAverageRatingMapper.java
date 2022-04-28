import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


public class ProductAverageRatingMapper extends Mapper<LongWritable, Text, Text, CountAverageTuple> {

    private CountAverageTuple outCountAverage = new CountAverageTuple();
    private Text id = new Text();

    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException  {

        try {
            //     marketplace	customer_id	review_id	product_id	product_parent	product_title
            //     product_category	star_rating	helpful_votes	total_votes	vine
            //     verified_purchase	review_headline	review_body	review_date
            String input[] = value.toString().split("\\t");
            String productId = input[3].trim();

            if (!productId.isEmpty()) {
                id.set((productId));
                outCountAverage.setCount(Long.valueOf(1));
                outCountAverage.setAverage(Float.valueOf(input[7].trim()));
                context.write(id, outCountAverage);
            }

        } catch (Exception e) {
            System.out.println("Exception in Mapper Task: ");
            e.printStackTrace();
        }

    }
}