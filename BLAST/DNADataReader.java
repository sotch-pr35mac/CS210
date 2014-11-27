// Class: DNADataReader
//
// Author: Pamela Cutter & Alyce Brady
//
// Created on May 23, 2006
// Modified November 15, 2006
// Modified November 19, 2006 to extend DNASeqReader

import java.io.IOException;
import java.util.*;

/**
 * This class contains code to read DNA sequence data in from
 * a file.  It must be put into a data structure as it is read.
 * The data structure should be chosen by the modifier of this
 * class.
 *
 * @author Pamela Cutter
 * @author Alyce Brady
 * @version Nov 19, 2006
 * @updated Preston Stosur-Bassett
 * @updated Nov, 20, 2014
 */
public class DNADataReader extends DNASeqReader
{
    private String filename;
    private int numLinesNucleoInfo;
    private ArrayList<DNASequence> returnToDatabase;

    /** Constructs an object that reads DNA sequence information
     *  from the given file.  The data is assumed to be in the
     *  following format:
     *      GenInfoIdentifier  A string describing the sequence
     *      a group of nucleotide blocks, spanning 1 or more lines
     *  where the number of lines of nucleotide blocks per sequence,
     *  is provided as a parameter. For example, if the parameter were
     *  1, the following would be a valid single sequence.
     *      94717691 Campo. sono. ichnovirus segment W, complete sequence
     *      ctccaccaaa ctttgagagt cactacaaaa acattcacga tcgcttcact
     */
    public DNADataReader(String filename, int numLinesNucleoInfo)
    {
        super(filename);
        this.filename = filename;
        this.numLinesNucleoInfo = numLinesNucleoInfo;
    }

    /** Reads DNA sequence information from the given file, which must be
     *  in the format specified in the documentation for the DNADataReader
     *  constructor.
     *  Precondition: the file must have been successfully opened for
     *                reading.
     */
    public ArrayList<DNASequence> readData()
    {
        returnToDatabase = new ArrayList<DNASequence>();
        try
        {
            // Read complete lines at a time, until end of file.
            String next;
            while ( (next = this.readLine()) != null)
            {
                //Debug.println(next);

                if ( ! next.equals("") )
                    readInfoForOneSequence(next);
            }
        }
        catch (IOException e)
        {
            System.err.println("Could not read line " +
                               (this.getLineNumber() + 1) +
                               " of file " + filename);
            return null;
        }

        // Debugging: Print out the elements in your data structure.
        Debug.println("No data structure created to print out (yet).");

        return returnToDatabase;
    }

    /** Reads in the sequence information for a single DNA sequence in the file.
     *      @param firstLine    the first line of info for this sequence
     *      @throws IOException
     */
    private void readInfoForOneSequence(String firstLine) throws IOException
    {
        // Put the space-separated items from the line into an array.
        String[] items = firstLine.split(" ");

        // The first line should contain the GenInfo identifier (GI)
        // and sequence description.
        String gi = items[0];     // GenInfo identifier
        String desc = "";         // Description
        for (int i = 1; i < items.length; i++)
            desc += items[i] + " ";

        Debug.println("Line " + this.getLineNumber() + ": " +
                      gi + ", " + desc);

        //System.out.println(numLinesNucleoInfo);
        // Then read in the lines with the sequence information.
        String seq = readSequenceString(numLinesNucleoInfo);

        Debug.println("Just read " + seq);

        DNASequence currentSequence = new DNASequence(gi, desc, seq);

        returnToDatabase.add(currentSequence);
        Debug.println("Should be adding an element to the data structure");
    }
}
