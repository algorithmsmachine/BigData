# RDD from collections
# myData = [“Alice”, “Carlos”, “Frank”, “Barbara”]
# myRdd = sc.parallelize(myData)
# myRdd. take(2)

from pyspark import SparkContext, SparkConf

# rdd1 = sc.parallelize([1.2, 2.6, 3.9, 4.6])
# rdd2 = rdd1.map(lambda num: num * 2)
# rdd2.mean()


counter = 0
rdd = sc.parallelize(data)

# Wrong: Don't do this!!
def increment_counter(x):
    global counter
    counter += x
rdd.foreach(increment_counter)

print("Counter value: ", counter)