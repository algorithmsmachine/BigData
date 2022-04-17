## HDFS and HADOOP

First check how many nodes are running 

    > hadoop dfsadmin -report
    
    WARNING: Use of this script to execute dfsadmin is deprecated.
    WARNING: Attempting to execute replacement "hdfs dfsadmin" instead.
    
    Configured Capacity: 0 (0 B)
    Present Capacity: 0 (0 B)
    DFS Remaining: 0 (0 B)
    DFS Used: 0 (0 B)
    DFS Used%: 0.00%
    Replicated Blocks:
    Under replicated blocks: 0
    Blocks with corrupt replicas: 0
    Missing blocks: 0
    Missing blocks (with replication factor 1): 0
    Low redundancy blocks with highest priority to recover: 0
    Pending deletion blocks: 0
    Erasure Coded Block Groups:
    Low redundancy block groups: 0
    Block groups with corrupt internal blocks: 0
    Missing block groups: 0
    Low redundancy blocks with highest priority to recover: 0
    Pending deletion blocks: 0
    
    ------------------------------------------------- 

Check ports 

    >netstat -ntlp

    Active Internet connections (only servers)
    Proto Recv-Q Send-Q Local Address           Foreign Address         State       PID/Program name
    tcp        0      0 127.0.0.1:9000          0.0.0.0:*               LISTEN      274/java
    tcp        0      0 127.0.0.1:3306          0.0.0.0:*               LISTEN      -
    tcp        0      0 0.0.0.0:9868            0.0.0.0:*               LISTEN      600/java
    tcp        0      0 0.0.0.0:9870            0.0.0.0:*               LISTEN      274/java
    tcp        0      0 0.0.0.0:22              0.0.0.0:*               LISTEN      15/sshd
    tcp6       0      0 :::22                   :::*                    LISTEN      15/sshd


##  HttpFS server, the HDFS HTTP Gateway 

	> hdfs httpfs


## Clean the name 

	sudo rm -R /tmp/*

format the namenode

	hdfs namenode -format


##Debugging

**Issue1** space issues 

**solution** check free space available

 	> free -m
        total        used        free      shared  buff/cache   available
	Mem:           6265        1407        2788         366        2069        4213
	Swap:          2048           0        2048



	> hdfs dfs -df
	Filesystem             Size  Used  Available  Use%
	hdfs://localhost:9000     0     0          0  NaN%

**Issue2** safe mode probnlems 

	# hadoop fs -mkdir /exercise/reviews
	mkdir: Cannot create directory /exercise/reviews. Name node is in safe mode.

**Solution** CHECK THE name node status

	> hdfs dfsadmin -safemode get
	Safe mode is ON

Leave the safe mode 

	> hdfs dfsadmin -safemode leave
	Safe mode is OFF

Enter in SAFE MODE:

	> hdfs dfsadmin -safemode enter