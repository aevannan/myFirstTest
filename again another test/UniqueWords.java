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
         //Creates a map in which to store the characters and words
         //Creates corresponding keyset
         Set <String> words = new TreeSet<>();
         
         //takes the words, cleans them of non-characters, and adds to map
         while (in.hasNext())
         {
            String word = clean(in.next());
            //System.out.println(word);
            words.add(word);
         }
         
      }
      catch (FileNotFoundException e)
      {
         System.out.println("Cannot open: " + filename);
      }
    }

    public static String clean(String s)
   {
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
       oldWay("UniqueWordsFile.txt");
   }
 }
