package sorters;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * reads the numbers from file and puts them in an array
 * then splits the array according to the given memory size and adds the chunks to the chunks array
 * @author Foothill College, Michael Bernal
 */
public class SimulateChunks
{
    /**
     * splits the array according to the SIM_MEM_SIZE
     * @param SIM_MEM_SIZE simulated memory size
     * @param inputFile the input file
     * @param fileChunksAsArrays chunks of arrays as integers
     */
    public static void splitFileIntoArrayChunks(final int SIM_MEM_SIZE, String inputFile,
                                                ArrayList<Integer[]> fileChunksAsArrays)
    {
        int chunks;
        String inputLine;

        File inFile = new File(inputFile);

        try
        {
            Scanner input = new Scanner(inFile);
            inputLine = input.nextLine();
            String[] tokens = inputLine.split(",");

            if(tokens.length % SIM_MEM_SIZE == 0)
                chunks = tokens.length / SIM_MEM_SIZE;
            else
                chunks = tokens.length / SIM_MEM_SIZE + 1;

            for(int i = 0; i < chunks - 1; i++)
            {
                Integer[] chunk = new Integer[SIM_MEM_SIZE];
                for(int j = 0; j < SIM_MEM_SIZE; j++)
                    chunk[j] = Integer.parseInt(tokens[i + SIM_MEM_SIZE + j]);

                fileChunksAsArrays.add(chunk);
            }

            int size = tokens.length % SIM_MEM_SIZE;
            Integer[] chunk = new Integer[size];

            for(int i = 0; i < size; i++)
                chunk[i] = Integer.parseInt(tokens[i]);

            fileChunksAsArrays.add(chunk);

            input.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
