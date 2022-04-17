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

## Dataset : Amazon Customer Reviews Dataset from Amazon Customer Reviews Library

Amazon Customer Reviews a rich source of information for academic researchers in the fields of Natural Language Processing (NLP), 
Information Retrieval (IR), and 
Machine Learning (ML)

    marketplace	customer_id	review_id	product_id	product_parent	product_title	product_category	star_rating	helpful_votes	total_votes	vine	verified_purchase	review_headline	review_body	review_date
    US	18778586	RDIJS7QYB6XNR	B00EDBY7X8	122952789	Monopoly Junior Board Game	Toys	5	0	0	N	Y	Five Stars	Excellent!!!	2015-08-31
    US	24769659	R36ED1U38IELG8	B00D7JFOPC	952062646	56 Pieces of Wooden Train Track Compatible with All Major Train Brands	Toys	5	0	0	N	Y	Good quality track at excellent price	Great quality wooden track
