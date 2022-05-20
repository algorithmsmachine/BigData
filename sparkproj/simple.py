from pyspark import SparkContext
sc = SparkContext()

users = sc.textFile('file1.txt') \
.map(lambda  line:  line.split('\t'))  \
.map(lambda  fields:  (fields[0], fields[1])).distinct()