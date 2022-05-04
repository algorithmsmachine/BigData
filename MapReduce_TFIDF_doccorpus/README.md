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

    s3://bigdataaltanai/ebooks.zip
    s3://bigdataaltanai/output_tfidf 
    s3://bigdataaltanai/output_freq 
    s3://bigdataaltanai/output_wordcount


or 

    hdfs://ip-172-31-81-248.ec2.internal:8020

For **Spark** projects the hadoop home is inside of spark folder 

- HADOOP_HOME=C:\Users\abisht\Downloads\spark-3.2.1-bin-hadoop3.2\spark-3.2.1-bin-hadoop3.2

For **hadoop HDFS** only projects Set in system 

- JAVA_HOME=C:\Users\abisht\.jdks\openjdk-18.0.1
- hadoop HADOOP_HOME=C:\Users\abisht\Downloads\hadoop-3.2.1.tar\hadoop-3.2.1
- HADOOP_PATH_BIN=C:\Users\abisht\Downloads\hadoop-3.2.1.tar\hadoop-3.2.1\bin

## Hadoop fs for ebooks

In an older system this may or may not work 

    hadoop fs -mkdir C:\Users\abisht\BigData\MapReduce_TFIDF_doccorpus\input
    hadoop fs -put C:\Users\abisht\Downloads\ebooks\ C:\Users\abisht\BigData\MapReduce_TFIDF_doccorpus\input
    hadoop fs -ls C:\Users\abisht\BigData\MapReduce_TFIDF_doccorpus\input
    

For windows 10, these work ( self used)

    cd C:\Users\abisht\BigData\MapReduce_TFIDF_doccorpus
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


    hadoop jar out\artifacts\MapReduce_TFIDF_doccorpus_jar\MapReduce_TFIDF_doccorpus.jar ebooks C:\Users\abisht\BigData\MapReduce_TFIDF_doccorpus\output C:\Users\abisht\BigData\MapReduce_TFIDF_doccorpus\output_freq C:\Users\abisht\BigData\MapReduce_TFIDF_doccorpus\output_word_count

## References 

## Help and Debug 


**Issue 1**  nameNode cannot be started

    Exception in thread "main" java.lang.IllegalArgumentException: Invalid URI for NameNode address (check fs.defaultFS): 
    file:///has no authority.

**solution** Edit the core-site.xml

    PS C:\Users\abisht\Downloads\hadoop-3.2.1.tar\hadoop-3.2.1\sbin> notepad ..\etc\hadoop\core-site.xml

and add property 

    <?xml version="1.0" encoding="UTF-8"?>
    <?xml-stylesheet type="text/xsl" href="configuration.xsl"?>
    <configuration>
    <property>
        <name>fs.default.name</name>
        <value>hdfs://localhost:9000</value>
     </property>
    </configuration>

**Issue2** ResourceManager error 

    2022-05-03 06:40:49,958 FATAL resourcemanager.ResourceManager: Error starting ResourceManager
    java.lang.ExceptionInInitializerError

**Solution** Edit the file hdfs-site.xml

    PS C:\Users\abisht\Downloads\hadoop-3.2.1.tar\hadoop-3.2.1\sbin> notepad ..\etc\hadoop\hdfs-site.xml

and add property inside configuration like

    <?xml version="1.0" encoding="UTF-8"?>
    <?xml-stylesheet type="text/xsl" href="configuration.xsl"?>
    
    <configuration>
        <property>
            <name>dfs.replication</name>
            <value>1</value>
        </property>
    </configuration>


**Issue3** 

    2022-05-03 06:53:23,759 WARN checker.StorageLocationChecker: Exception checking StorageLocation [DISK]file:/C:/tmp/hadoop-abisht/dfs/data
    java.lang.UnsatisfiedLinkError: 'org.apache.hadoop.io.nativeio.NativeIO$POSIX$Stat org.apache.hadoop.io.nativeio.NativeIO$POSIX.stat(java.lang.String)'

**solution** check the env variables 

    > $env:path.Split(";")
    C:\Program Files (x86)\VMware\VMware Player\bin\
    C:\Program Files (x86)\Common Files\Oracle\Java\javapath
    C:\WINDOWS\system32
    C:\WINDOWS
    C:\WINDOWS\System32\Wbem
    C:\WINDOWS\System32\WindowsPowerShell\v1.0\
    C:\WINDOWS\System32\OpenSSH\
    C:\Program Files (x86)\Sennheiser\SoftphoneSDK\
    C:\Program Files\Docker\Docker\resources\bin
    C:\ProgramData\DockerDesktop\version-bin
    C:\Users\abisht\Downloads\hadoop-3.2.1.tar\hadoop-3.2.1\bin
    C:\Users\abisht\Downloads\hadoop-3.2.1.tar\hadoop-3.2.1\sbin
    C:\Users\abisht\Anaconda3\
    C:\Users\abisht\Anaconda3\python.exe
    C:\Users\abisht\Downloads\spark-3.2.1-bin-hadoop3.2\spark-3.2.1-bin-hadoop3.2\python\pyspark
    C:\Users\abisht\Downloads\spark-3.2.1-bin-hadoop3.2\spark-3.2.1-bin-hadoop3.2\python\pyspark\bin
    C:\Users\abisht\AppData\Local\Microsoft\WindowsApps
    C:\Users\abisht\AppData\Local\GitHubDesktop\bin
    C:\Users\abisht\AppData\Local\Programs\Git\cmd


Ensure you have the winutils in bin folder https://github.com/cdarlint/winutils/tree/master/hadoop-3.2.1/bin


****

    Exception in thread "main" java.lang.IllegalArgumentException: Wrong FS: s3://bigdataaltanai/output_tfidf, expected: hdfs://ip-172-31-29-119.ec2.internal:8020