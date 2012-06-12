// The "Boggle" class.
import java.awt.*;
import hsa.Console;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Boggle
{
    static Console c;           // The output console

    public static void main (String[] args)
    {
	c = new Console ();
	int wordRow = 16;
	int wordCollumn = 3;
	int score = 0;
	String gottenWord;

	c.clear ();
	char board[] [] = boardGen ();
	drawBoard (board);



	while (true)
	{
	    c.setCursor (wordRow, wordColumn);
	    c.print ("          ");
	    c.setCursor (wordRow, wordColumn);
	    gottenWord = c.readString ();
	    wordRow++;
	    if (spellCheck (gottenWord))
		score+=scoreWord(gottenWord);

	    if (wordRow > 24)
	    {
		c.print ("          ");
		wordRow = 5;
		wordCollumn += 30;
	    }
	    c.setCursor (wordRow + 1, wordColumn);
	    c.print ("SCORE: " + score);
	}


    }


    public static int scoreWord (String word)
    {
	if (word.length() > 7)
	    return 11;

	if (word.length() == 7)
	    return 5;

	if (word.length() == 6)
	    return 3;

	if (word.length() == 5)
	    return 2;

	if (word.length() == 4 || word.length() == 3)
	    return 1;
	
	return 0;//Words with 2 or 1 letters do not count
    }


    public static void drawBoard (char[] [] board)
    {
	c.setFont (new Font ("Arial", Font.PLAIN, 50));
	c.drawString ("  Boggle", 0, 40);

	for (int row = 0 ; row < 4 ; row++) //prents every element of every row
	{
	    for (int column = 0 ; column < 4 ; column++)   //prints each element of roe i
	    {

		c.drawRoundRect (row * 60, column * 60 + 60, 50, 50, 10, 10);
		c.setFont (new Font ("Arial", Font.PLAIN, 50));
		c.drawString ((board [row] [column] + " "), (column * 60 + 5), (row * 60 + 105));
	    }
	}
    }


    public static char[] [] boardGen ()
    {
	int row, column;
	char board[] [] = {  //Creates array of spaces
		{' ', ' ', ' ', ' '},
		{' ', ' ', ' ', ' '},
		{' ', ' ', ' ', ' '},
		{' ', ' ', ' ', ' '}};
	for (int i = 0 ; i < 16 ; i++) //For each dieid
	{
	    do
	    {
		row = (int) (Math.random () * 4); //generates a random position
		column = (int) (Math.random () * 4);

	    }
	    while (board [row] [column] != ' '); //Runs until positrion is empty
	    board [row] [column] = letterRoll (i); //places the die in that position

	}
	return board;
    }


    public static char letterRoll (int dieId)
    {
	char dice[] [] = {  //2D array of 1D arrays of characters representing each letter on a given die
		{'A', 'A', 'C', 'I', 'O', 'T'},
		{'A', 'H', 'M', 'O', 'R', 'S'},
		{'E', 'G', 'K', 'L', 'U', 'Y'},
		{'A', 'B', 'I', 'L', 'T', 'Y'},
		{'A', 'C', 'D', 'E', 'M', 'P'},
		{'E', 'G', 'I', 'N', 'T', 'V'},
		{'G', 'I', 'L', 'R', 'U', 'W'},
		{'E', 'L', 'P', 'S', 'T', 'U'},
		{'D', 'E', 'N', 'O', 'S', 'W'},
		{'A', 'C', 'E', 'L', 'R', 'S'},
		{'A', 'B', 'J', 'M', 'O', 'Q'},
		{'E', 'E', 'F', 'H', 'I', 'Y'},
		{'E', 'H', 'I', 'N', 'P', 'S'},
		{'D', 'K', 'N', 'O', 'T', 'U'},
		{'A', 'D', 'E', 'N', 'V', 'Z'},
		{'B', 'I', 'F', 'O', 'R', 'X'}};

	return dice [dieId] [(int) (Math.random () * 6)];
    }


    public static boolean spellCheck (String word)
    {
	
	//Uses the corncob caps dictionary file
	//http://www.mieliestronk.com/wordlist.html
	String filename = "corncob_caps.txt";
	
	try
	{
	    return readFromFile (filename, word);
	}
	catch (IOException e)
	{

	    return false;
	}


    }


    //This code taken from alexmcchessers on Stack Overflow
    //http://stackoverflow.com/questions/9913/java-file-io-compendium

    public static boolean readFromFile (String filename, String word) throws /*FileNotFoundException,*/IOException
    {
	StringBuffer readBuffer = new StringBuffer ();
	BufferedReader fileReader = new BufferedReader (new FileReader (filename));
	String sRead = null;


	do
	{
	    if (word.equalsIgnoreCase (sRead))//if the word is found
	    {
		return true;
	    }
	    sRead = fileReader.readLine ();//reads the next line in the file input buffer
	}
	while (sRead != null);//null indicates the end of the file
	return false;
    }
}




