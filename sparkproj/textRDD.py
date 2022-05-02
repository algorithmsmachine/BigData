# -*- coding: utf-8 -*-
# Text file RDDs can be created using SparkContext.textFile 
# sc.textFile(“myfile.txt”)
# sc.textFile(“mydata/*.log”)
# sc.textFile(“myfile1.txt, myfile2.txt”)
# sc.texFile(“mydata/*.gz”)
# sc.textFile (“file:/hadoop-data/myfile.txt”)    (on the local file system)
# sc.textFile(“/exercise/shakespeare/poems”) (on HDFS)
# REf : https://spark.apache.org/docs/latest/api/python/index.html 


from pyspark import SparkContext 
sc = SparkContext.getOrCreate()

users = sc.textFile("file1.txt") \
.map(lambda  line:  line.split('\t'))  \
.map(lambda  fields:  (fields[0], fields[1]))