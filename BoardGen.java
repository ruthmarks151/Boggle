// The "BoardGen" class.
import java.awt.*;
import hsa.Console;

public class BoardGen
{
    static Console c;           // The output console

    public static void main (String[] args)
    {
	c = new Console ();

	while (c.getChar () != 'x')
	{
	    c.clear();
	    char board[] [] = boardGen ();
	    c.println ("BOGGLE");


	    for (int i = 0 ; i < 4 ; i++)
	    {
		for (int j = 0 ; j < 4 ; j++)
		    c.print (board [i] [j] + " ");

		c.println ();
	    }
	}

    }


    public static char[] [] boardGen ()
    {
	int x, y;
	char board[] [] = {
		{' ', ' ', ' ', ' '},
		{' ', ' ', ' ', ' '},
		{' ', ' ', ' ', ' '},
		{' ', ' ', ' ', ' '}};
	for (int i = 0 ; i < 16 ; i++)
	{
	    do
	    {
		x = (int) (Math.random () * 4);
		y = (int) (Math.random () * 4);

	    }
	    while (board [x] [y] != ' ');
	    board [x] [y] = letterRoll (i);

	}
	return board;
    }


    public static char letterRoll (int dieId)
    {
	char dice[] [] = {
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
} // BoardGen class


