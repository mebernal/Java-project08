package sorters;

import cs1c.FHbinHeap;
import java.io.*;
import java.util.*;

/**
 * class which uses the  minHeap technique to sort various chunks with respect to each other
 * @author Foothill College, Michael Bernal
 */
public class heapArrayMerger
{
    /**
     * this method sorts various chunks with respect to each other and write the output to a file
     * called result_using_min_heap.txt
     * @param inputChunks an arraylist of chunks
     * @param minHeap a heaptuple array used to hold current minimums
     * @param outfile the file to output to
     * @param ENABLE_DEBUG enables debug
     */
    static void mergeSortedArrays( ArrayList<Integer []> inputChunks,
                                   HeapTuple[] minHeap, String outfile, final boolean ENABLE_DEBUG) {

        int chunks = inputChunks.size(), size, totalGroups = 0, firstIdx = 0;
        ArrayList<ArrayList<Integer[]>> subGroups = new ArrayList<ArrayList<Integer[]>>();
        ArrayList<Integer[]> finalChunks = new ArrayList<>();

        while(chunks > 0)
        {
            if(chunks <= minHeap.length)
            {
                size = chunks;
                chunks = 0;
            }
            else
            {
                size = minHeap.length;
                chunks = (chunks - minHeap.length);
            }

            ArrayList<Integer[]> chunk = new ArrayList<>();
            int lastIdx = (firstIdx + size);

            for(int i = firstIdx; i < lastIdx; i++)
                chunk.add(inputChunks.get(i));

            subGroups.add(chunk);
            firstIdx += size;
            totalGroups++;
        }

        for(int i = 0; i < subGroups.size(); i++)
        {
            Integer[] sortedArr = heapSortAndMerge(subGroups.get(i));
            finalChunks.add(sortedArr);
        }

        Integer[] finalArr = heapSortAndMerge(finalChunks);
        BufferedWriter fileWriter;

        try
        {
            fileWriter = new BufferedWriter(new FileWriter(outfile));

            for(int i = 0; i < finalArr.length; i++)
                fileWriter.write(finalArr[i] + ", ");

            fileWriter.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param chunk Integer chunk that will be sorted with minHeap
     * @return sorted array of ints
     */
    public static Integer[] heapSortAndMerge(ArrayList<Integer[]> chunk)
    {
        int firstIdx = 0;
        ArrayList<Integer> sortedChunks = new ArrayList<>();
        FHbinHeap<HeapTuple> heap = new FHbinHeap<>();

        for(int i = 0; i < chunk.size(); i++)
            heap.insert(new HeapTuple(chunk.get(i)[firstIdx], i, firstIdx));

        while(!heap.empty())
        {
            HeapTuple min = heap.remove();
            sortedChunks.add(min.getData());

            int arrIdx = min.getArrayIndex();
            Integer[] curChunk = chunk.get(arrIdx);
            int curIdx = min.getIndexInArray() + 1;

            if(curIdx < curChunk.length)
            {
                int num = curChunk[curIdx];
                heap.insert(new HeapTuple(num, arrIdx, curIdx));
            }
            else
                continue;
        }
        Integer[] sortedArr = sortedChunks.toArray(new Integer[sortedChunks.size()]);
        return sortedArr;
    }
}