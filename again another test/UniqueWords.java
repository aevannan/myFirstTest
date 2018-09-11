import java.util.TreeSet;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Set;
/**
 * Write a description of class UniqueWords here.
 * 
 * Aaina Vannan
 * Ex 15.12
 */
public class UniqueWords
{
   public static void oldWay(String filename){
      try (Scanner in = new Scanner(new File(filename)))
      {
         //creates a set that holds all the words from the file 
         Set <String> words = new TreeSet<>();
         
         //takes the words, cleans them of non-characters, and adds to set
         while (in.hasNext())
         {
            String word = clean(in.next());
            words.add(word);//adds it to the treeset
         }
         
         //prints all of the words in the set with a for-each loop
         for (String w: words)
         {
             System.out.println(w);
         }
         System.out.println("There are " + words.size() + " unique words"); //how many unique words in the treeset 
      }
      catch (FileNotFoundException e)
      {
         System.out.println("Cannot open: " + filename); //if file doesnt exist
      }
    }

    public static String clean(String s)
   {
      //gets rid of non-letters characters
      String r = "";
      for (int i = 0; i < s.length(); i++)
      {
         char c = s.charAt(i);
         if (Character.isLetter(c))
         {
            r = r + c;
         }
      }
      return r.toLowerCase();
    }
    
   public static void main (String[] args)
   {
       oldWay("UniqueWordsFile.txt"); //runs oldWay
   }
 }
