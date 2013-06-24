// The "BoardGen" class.
import java.awt.*;

public class BoardGen
{
    static Console c;           // The output console

    public static void main (String[] args)
    {
 c = new Console ();

 while (c.getChar () != 'x')
 {
     c.clear ();
     char board[] [] = boardGen ();
     c.println ("BOGGLE");


     for (int row = 0 ; row < 4 ; row++) //prents every element of every row
     {
  for (int collumn = 0 ; collumn < 4 ; collumn++)   //prints each element of roe i
      c.print (board [row] [collumn] + " ");

  c.println ();
     }
 }

    }


    public static char[] [] boardGen ()
    {
 int row, collumn;
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
  collumn = (int) (Math.random () * 4);

     }
     while (board [row] [collumn] != ' '); //Runs until positrion is empty
     board [row] [collumn] = letterRoll (i); //places the die in that position

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
} // BoardGen class


