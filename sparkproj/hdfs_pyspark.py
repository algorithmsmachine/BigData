from pyspark import SparkContext, SparkConf
conf = SparkConf().setAppName("hdfs_pyspark.py").setMaster(master)
sc = SparkContext(conf=conf)

data = [1, 2, 3, 4, 5]
distData = sc.parallelize(data)

rdd = sc.parallelize(range(1, 4)).map(lambda x: (x, "a" * x))
rdd.saveAsSequenceFile("textout.txt")
sorted(sc.sequenceFile("textout.txt").collect())