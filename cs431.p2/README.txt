To execute via command line, compile all .java files and run with the input file as a command line argument. 
To obtain the output in a file rather than on the console, redirect output into [outputfilename].[desired file extension].

For example:
cs431.p2 $ javac src/cs431/p2/*.java // to compile
cs431.p2 $ java -cp src cs431.p2.cpu src/cs431/p2/test_files/test_1.txt > output.csv // to execute and redirect output to output.csv file