from pyspark.shell import spark
print(spark)

textFile = spark.read.text("README.md")
print(textFile.count())
print(textFile.first())


# transform this DataFrame to a new one. We call filter to return a new DataFrame with a subset of the lines in the file.