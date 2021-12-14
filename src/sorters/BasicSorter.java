package sorters;

import cs1c.FHsort;

/**
 * sorts an individual chunk in place using the static sortChunk() method which receives an Integer[]
 * object as argument. The sorting algorithm should depend on the number of elements
 * @author Foothill College, Michael Bernal
 */
public class BasicSorter
{
    /**
     * use the shell sort #1 to sort individual chunks
     * @param chunk the chunk to sort
     */
    public static void sortChunk(Integer[] chunk)
    {
        FHsort.shellSort1(chunk);
    }
}
