// Class: DNADataReader
//
// Author: Pamela Cutter & Alyce Brady
//
// Created on May 23, 2006
// Modified November 15, 2006
// Modified November 19, 2006 to extend DNASeqReader
// Modified March 30, 2010 by Nathan Sprague
//    refactored and simplified.
// Modified April 4, 2013 by Alyce Brady
//    modified method names and comments for readability

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * This class contains code to read DNA sequence data in from
 * a file.  It must be put into an ArrayList as it is read.
 * 
 * @author Pamela Cutter
 * @author Alyce Brady
 * @author Nathan Sprague
 * @version April 4, 2013
 */
public class DNADataReader 
{
    private String filename;
    private BufferedReader reader = null;

    /** Constructs an object that can read DNA sequence information
     *  from a file.  The data is assumed to be in the
     *  following format:
     *
     *      GenInfoIdentifier  A string describing the sequence
     *      a group of nucleotide blocks, spanning 1 or more lines
     *
     *   For example   the following would be a valid single sequence:
     *   <pre>
     *      94717691 Campo. sono. ichnovirus segment W, complete sequence
     *      ctccaccaaa ctttgagagt cactacaaaa acattcacga tcgcttcact
     *      ctccaccaaa ctttgagagt cactacaaaa acattcacga tcgcttcact
     *   </pre>
     *      @param filename  the name of the file to open for reading
     */
    public DNADataReader(String filename) 
    {
        // Create an object that can read from the file.
        try
        {
            this.reader = new BufferedReader(new FileReader(filename));
        } 
        catch (IOException e)
        {
            System.err.println("Cannot open file "+ filename+" for reading");
        }

        this.filename = filename;
    }

    /** Reads DNA sequence information from the given file, which must be
     *  in the format specified in the documentation for the DNADataReader
     *  constructor.
     *  Precondition: the file must have been successfully opened for
     *                reading.
     *      @return void (for now -- should return the information read in)
     */
    public ArrayList<DNASequence> readData() 
    {
     
        ArrayList<DNASequence> seqData = new ArrayList<DNASequence>(10);

        try 
        {
            // Read lines until hitting a null or blank line.
            String nextLine;
            while ( ! ((nextLine = this.reader.readLine()) == null) && 
                    ! nextLine.trim().equals(""))
            {
                // The line read in contains the first line of
                // information for a DNA sequence.  Build a sequence
                // object from that information and the nucleotide
                // information on subsequent lines.
                //Debug.println(nextLine);
                seqData.add(buildDNASequence(nextLine));
            }
        } 
        catch (IOException e) 
        {
            System.err.println("Could not read file " + filename);
            return null;
        }

        return seqData ;
    }

    /** Builds a DNA sequence object using initial information already
     *  read in (identifier and description) and nucleotide sequence
     *  information that must be read in from the file.
     *      @param firstLine    the first line of info for this sequence
     *      @return void (for now -- should return a DNA Sequence object)
     *      @throws IOException
     */
    private DNASequence buildDNASequence(String firstLine) throws IOException
    {
        // The first line should contain the GenInfo identifier (GI)
        // and sequence description, separated by a space.
        int indexOfSpace = firstLine.indexOf(' ');
        String gi = firstLine.substring(0, indexOfSpace);
        String desc = firstLine.substring(indexOfSpace + 1);

        Debug.println("GI: " + gi);
        Debug.println("Description: " + desc);

        // Next read in the lines with the nucleotide sequence information.
        String seq = readNucleotideSequence();

        Debug.println("Sequence: " + seq);
        Debug.println("");

        DNASequence sequenceObject = new DNASequence(gi, desc, seq);
        return sequenceObject;
        
    }



    /** Reads in the nucleotide sequence for a single DNA sequence.
     *  The nucleotide sequence is assumed to be presented as
     *  groups of space-separated nucleotide blocks, spanning 1 or
     *  more lines.  For example, the following would be a valid
     *  single-line nucleotide sequence:
     *      ctccaccaaa ctttgagagt cactacaaaa acattcacga tcgcttcact
     *  The method reads until it reaches an empty line, representing
     *  then end of this particular sequence.  It returns a string
     *  containing the nucleotide sequence without the intermediate
     *  spaces.  For the example above, the method would return:
     *      ctccaccaaactttgagagtcactacaaaaacattcacgatcgcttcact
     *
     *      @return String containing nucleotide sequence without spaces
     *      @throws IOException
     */
    public String readNucleotideSequence() throws IOException
    {
        String seq = "";      // Will contain complete nucleotide sequence
        String nextLine;
        
        // Read lines until hitting a null or blank line.
        while ( ! ((nextLine = this.reader.readLine()) == null) && 
                ! nextLine.trim().equals(""))
        {
            // Create a new string that contains all the nucleotide
            // blocks without the separating spaces.  

            // Create separate strings of all the blocks (without spaces).
            String[] blocks = nextLine.split(" ");

            // Then concatenate all those strings together.
            for ( String eachBlock : blocks )
                seq += eachBlock;
           
        }

        return seq;
    }


}


