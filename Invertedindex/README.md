#  Inverted Index  

MapReduce job that produces an inverted index. 

Produce an index of all the words in the  text. 
For each word, the index should have a list of all the locations where the word appears. 

Sample 

    0 HAMLET
    1   
    2    
    3 DRAMATIS  PERSONAE
    4     
    5      
    6 CLAUDIUS    king of Denmark. (KING CLAUDIUS: )
    7     
    8 HAMLET        son to the late, and nephew to the present king.
    9      
    10 POLONIUS     lord chamberlain.  (LORD  POLONIUS: )


Each line contains 

    Line number 
    Separator: a tab character 
    Value: the line of text

## IndexMapper.java (mapper) 

    FileSplit fileSplit    =   (FileSplit) context.getInputSplit();
    Path path  =  fileSplit.getPath();
    String filename  =  path.getName();

## IndexReducer.java (reducer) 

## InvertedIndex.java (driver)  