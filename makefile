all:
	javac MainApplication.java

run: all
	java MainApplication 
clean:
	rm -f *.class

