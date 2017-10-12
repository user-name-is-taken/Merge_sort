import java.util.List;
import java.util.LinkedList;


/*
One problem is you were returning the previous smallest
Instead of the current value that replaced the previous smallest.

See the base class's nextME() changes
*/




public class MergeSortWorker implements MergeSort{
   private MergeSort smallerSort;
   private MergeSort largerSort;
   private static final NullSortClass killer = new NullSortClass();
   public static LinkedList<Integer> workList;

   public MergeSortWorker(LinkedList<Integer> origionalList){
      /*
      This constructor should run in O(2 + 4 + 8...+n/2) which is close to O(n) it also requires this many objectst.
         after that, the nextME method should require only one stop per level (k in the previous sum) at each step
         ultimately this isn't as efficient as other sorting algorithms O(setup + finding each element) to sort an entire list,
         but the set-up is faster, so you can start reading the list immediately
      start the recursive constructor using the ArrayList's split method
      
      hopefully, origionalList will be deleted after this function
      */
      workList = origionalList;
      int inSize = workList.size();// -1 doesn't stop the NullPointerException
      //above this only in top constructor
      
      int nextInSize = inSize/2;
      if(inSize <= 4){
         smallerSort = new MergeSortBaseCase(nextInSize);
         if(inSize>2){ 
            largerSort = new MergeSortBaseCase(inSize-nextInSize);
         }else{
            largerSort = killer;
         } 

      }else{
         smallerSort = new MergeSortWorker(nextInSize);//null pointer
         largerSort = new MergeSortWorker(inSize-nextInSize);
         
      }
      assignSorts(smallerSort.getValue(), largerSort.getValue());
      
      //below this only in top constructor
      System.out.println("wtf error");
      workList = null;//not causing the null pointer exception
      System.out.println("wtf error");
   }
      
   private MergeSortWorker(int inSize){
      int nextInSize = inSize/2;
      if(inSize <= 4){// null pointer
         smallerSort = new MergeSortBaseCase(nextInSize);
         if(inSize>2){ 
            largerSort = new MergeSortBaseCase(inSize-nextInSize);
         }else{
            largerSort = killer;
         } 
      }else{
         smallerSort = new MergeSortWorker(nextInSize);// multiple null pointers?
         largerSort = new MergeSortWorker(inSize-nextInSize);
      }
      assignSorts(smallerSort.getValue(), largerSort.getValue());
   }//end constructor
     
   private Integer assignSorts(Integer smallestNext,Integer largestNext){
      if(smallestNext > largestNext){
         MergeSort temp = smallerSort;
         smallerSort = largerSort;
         largerSort = temp;
         return largestNext;
      }
      return smallestNext;
   }
   
   /*
   finds the nextME value of the old smallest one,
   checks if the old smallest's replacement is still smallest   
   */
   @Override
   public Integer nextME(){    
      Integer largeNext = largerSort.getValue();//IndexOutOfBoundsException
      try{
         return assignSorts(smallerSort.nextME(), largeNext);//IndexOutOfBoundsException
      }catch(java.util.NoSuchElementException e){//see the BaseCase
         //switch and null
         smallerSort = largerSort;
         largerSort = killer;
         return largeNext;
      }   
   }//end nextME
   
   @Override
   public Integer getValue(){
      return smallerSort.getValue();
   }
}//end classs