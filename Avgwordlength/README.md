# Average Length in shakespeare 

Create a folder on HDFS for organizing and copy files


Viewing and Manipulating Files copied into HDFS
    
    hadoop fs -ls /exercise/shakespeare

remove a file 

    hadoop fs –rm /exercise/shakespeare/glossary

download a file to work with on the local filesystem

    hadoop fs -get /exercise/shakespeare/poems shakepoems.txt
    cat shakepoems.txt

## Run with file system on windows 

Arguments for Run configuration in IDE
    
    C:\Users\abisht\Downloads\shakespeare C:\Users\abisht\BigData\Avgwordlength\output

## Same with weblog 


    hadoop fs -mkdir /exercise/weblog

    hadoop jar exercise2.jar /exercise/shakespeare /wordlengths


    2022-04-16 05:35:50,824 INFO mapreduce.Job: Counters: 30
    File System Counters
    FILE: Number of bytes read=12445449
    FILE: Number of bytes written=13062765
    FILE: Number of read operations=0
    FILE: Number of large read operations=0
    FILE: Number of write operations=0
    HDFS: Number of bytes read=0
    HDFS: Number of bytes written=0
    HDFS: Number of read operations=8
    HDFS: Number of large read operations=0
    HDFS: Number of write operations=3
    HDFS: Number of bytes read erasure-coded=0
    Map-Reduce Framework
    Combine input records=0
    Combine output records=0
    Reduce input groups=0
    Reduce shuffle bytes=0
    Reduce input records=0
    Reduce output records=0
    Spilled Records=0
    Shuffled Maps =0
    Failed Shuffles=0
    Merged Map outputs=0
    GC time elapsed (ms)=0
    Total committed heap usage (bytes)=276299776
    Shuffle Errors
    BAD_ID=0
    CONNECTION=0
    IO_ERROR=0
    WRONG_LENGTH=0
    WRONG_MAP=0
    WRONG_REDUCE=0
    File Output Format Counters
    Bytes Written=0

## Debugging and help 

**Issue1** java.lang.IllegalArgumentException: Wrong FS: s3:// expected hdfs://

    Exception in thread "main" java.lang.IllegalArgumentException: Wrong FS: s3://bigdataaltanai/output, expected: hdfs://ip-172-31-13-136.ec2.internal:8020
    at org.apache.hadoop.fs.FileSystem.checkPath(FileSystem.java:737)

**solution** 

    s3-dist-cp --src=s3://s3distcp-source/input-data --dest=hdfs:///output-folder1.