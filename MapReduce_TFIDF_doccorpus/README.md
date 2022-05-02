# TFIDF

## Job 1: Word Frequency in Doc
1. Reduces the map phase by using the lower-case values, because they will be aggregated before the reduce phase;
2. Don’t use simple words by verifying in the stopwords dictionary (Google search stopwords);
3. Use RegEx to select only words, removing punctuation and other data anomalies;

## supply arguments for example 

For a local file system run on windows

    C:\Users\abisht\Downloads\ebooks
    C:\Users\abisht\BigData\MapReduce_TFIDF_doccorpus\output
    C:\Users\abisht\BigData\MapReduce_TFIDF_doccorpus\output_freq
    C:\Users\abisht\BigData\MapReduce_TFIDF_doccorpus\output_word_count

For running on cloud

    s3://bigdataaltanai/ebooks/ 
    s3://bigdataaltanai/output_tfidf 
    s3://bigdataaltanai/output_freq 
    s3://bigdataaltanai/output_wordcount

For **Spark** projects the hadoop home is inside of spark folder 

- HADOOP_HOME=C:\Users\abisht\Downloads\spark-3.2.1-bin-hadoop3.2\spark-3.2.1-bin-hadoop3.2

For **hadoop HDFS** only projects Set in system 

- JAVA_HOME=C:\Users\abisht\.jdks\openjdk-18.0.1
- hadoop HADOOP_HOME=C:\Users\abisht\Downloads\hadoop-3.2.1.tar\hadoop-3.2.1
- HADOOP_PATH_BIN= C:\Users\abisht\Downloads\hadoop-3.2.1.tar\hadoop-3.2.1\bin

## Hadoop fs for ebooks

In an older system this may or may not work 

    hadoop fs -mkdir C:\Users\abisht\BigData\MapReduce_TFIDF_doccorpus\input
    hadoop fs -put C:\Users\abisht\Downloads\ebooks\ C:\Users\abisht\BigData\MapReduce_TFIDF_doccorpus\input
    hadoop fs -ls C:\Users\abisht\BigData\MapReduce_TFIDF_doccorpus\input
    

For windows 10, these work ( self used)

    cd cd C:\Users\abisht\BigData\MapReduce_TFIDF_doccorpus
    hdfs dfs -mkdir input
    hdfs dfs -put C:\Users\abisht\Downloads\ebooks\ input
    hdfs dfs -ls input

hadoop fs -cat C:\Users\abisht\BigData\MapReduce_TFIDF_doccorpus\input\ | tail -n 50

## Run 

Run using Hadoop cmd 
    
    cd C:\Users\abisht\BigData\MapReduce_TFIDF_doccorpus
    hadoop jar C:\Users\abisht\BigData\MapReduce_TFIDF_doccorpus\out\artifacts\MapReduce_TFIDF_doccorpus_jar\MapReduce_TFIDF_doccorpus.jar\
        C:\Users\abisht\Downloads\ebooks\
        C:\Users\abisht\BigData\MapReduce_TFIDF_doccorpus\output\
        C:\Users\abisht\BigData\MapReduce_TFIDF_doccorpus\output_freq\
        C:\Users\abisht\BigData\MapReduce_TFIDF_doccorpus\output_word_count

## References 


