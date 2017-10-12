import java.util.ArrayList;

import javax.swing.JOptionPane;
import java.lang.Math;
import java.util.Collections;

import java.util.Arrays;
import java.util.List;
import java.lang.instrument.Instrumentation;
import java.util.Iterator;


public class TestClass{

   /*Tests confirm that subsequent nextME() runs are fast
   The first sort is still slow, but should get faster.*/
   public static void main(String[] args){
         //System.out.println(Arrays.toString(randomArr(30).toArray()));
   
      MergeSortWorker work = new MergeSortWorker(randomArr(Integer.MAX_VALUE/300));//doesn't work with /250
      //sortNprint(work);
      
      JOptionPane.showMessageDialog(null,"hello");
      for(int i=0;i<10;i++){
         System.out.println(work.nextME());
      }
      //SOtest();
      
   }
   
   /*prints the memory currently being used by the JVM
   https://stackoverflow.com/questions/239202/during-execution-how-can-a-java-program-tell-how-much-memory-it-is-using
   https://stackoverflow.com/questions/9368764/calculate-size-of-object-in-java
   
   public static void prtMem(Object o){
      //Instrumentation inst = new Instrumentation();
      Instrumentation inst;
      System.out.println(inst.getObjectSize(o));
   }
   */
      /*a test for stack overflow. Trying to find the right data structure*/
   public static void SOtest(){
      int[] gers = {1,3,2,4};
      ArrayList<Integer> name = new ArrayList<>();
      for(int i:gers)name.add(i);
      
      
      Iterator<Integer> firstI = name.subList(0,2).iterator();
      Iterator<Integer> secondI = name.subList(2,name.size()).iterator();
      
      firstI.next();
      firstI.next();
      firstI.next();//java.util.NoSuchElementException
      //secondI.remove();
      
      /* The behavior of an iterator is unspecified
if the underlying collection is modified while the
iteration is in progress in any way other than by calling this method (remove()).
      */
  // could use an iterator instead of the current approach, while this doesn't
  //delete members in the backing list it doesn't require making new arrays
      /*

weakly consistent (fail-safe) iterators might do the trick?
https://stackoverflow.com/questions/17377407/what-are-fail-safe-fail-fast-iterators-in-java#17377698
*/ 
      System.out.println(Arrays.toString(name.toArray()));
      //.out.println(Arrays.toString(secondSL.toArray()));

   }
   
   
   
   public static void sortNprint(MergeSortWorker sorter){
      try{
         System.out.println(sorter.getValue().toString());
         while(true){  
           System.out.println(sorter.nextME());
            //indexOutOfBoundsException
            //JOptionPane.showMessageDialog(null,"hello");
         }
      }catch(NullPointerException e){
         System.out.println("DONE");
      }
   }
   
   /*the java library sort function*/
   public static void classicSort(ArrayList<Integer> name){
      Collections.sort(name);
   }
   
   /*makes an array with random elements of the specified size*/
   public static ArrayList<Integer> randomArr(int size){
      ArrayList<Integer> name = new ArrayList<>();
      for(int i = size; i>0; i--)name.add((int)(Math.random()*(Integer.MAX_VALUE-1)));
      return name;
   }
   
   /*makes a large random array*/
   public static ArrayList<Integer> randomArr(){
      return randomArr(Integer.MAX_VALUE/500);
   }
   

}

/* notes:
     //sublist isn't inclusive of the right most element
     https://stackoverflow.com/questions/44744092/concurrent-modification-exception-on-using-addall-and-removeall-on-same-arraylis
     https://stackoverflow.com/questions/46591087/is-there-a-java-collection-where-multiple-non-overlapping-sublists-can-modify-th
     https://docs.oracle.com/javase/8/docs/api/java/util/List.html#subList-int-int-
     
     https://stackoverflow.com/questions/239202/during-execution-how-can-a-java-program-tell-how-much-memory-it-is-using
     https://stackoverflow.com/questions/9368764/calculate-size-of-object-in-java 
      memory usage analysis
     
     https://stackoverflow.com/questions/1444242/how-much-memory-does-a-java-object-use-when-all-its-members-are-null
      null members use memory?
      
      can't ever have values that are as big as the max integer

*/