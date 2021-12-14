Project folder:
mebernal-project08/

doc/
    - Javadoc

src/sorters/BasicSorter.java
    - Sorts an individual chunk in place using the static sortChunk() method
      which receives an Integer[] object as argument. The sorting algorithm
      should depend on the number of elements.
src/sorters/heapArrayMerger.java
    - Class which uses the  minHeap technique to sort various chunks with respect to each other.
src/sorters/SimulateChunks.java
    - Reads the numbers from file and puts them in an array then splits the array according
      to the given memory size and adds the chunks to the chunks array.
src/sorters/SortFileData.java
    - Reads multiple plain text files, which contain unsorted numbers.
      Sorts the input files by dividing them into multiple chunks.

resources/RUN.txt
    - Console output of BasicSorter.java, heapArrayMerger.java, HeapTuple.java, SimulateChunks.java,
      and SortFileData.java

README.txt
    - Description of submitted files.