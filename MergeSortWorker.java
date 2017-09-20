import java.util.List;

public class MergeSortWorker implements MergeSort{
   private MergeSort smallerSort;
   private MergeSort largerSort;
   private static final NullSortClass killer = new NullSortClass();

   public MergeSortWorker(List origionalList){
      /*
      This constructor should run in O(2 + 4 + 8...+n/2) which is close to O(n) it also requires this many objectst.
         after that, the nextME method should require only one stop per level (k in the previous sum) at each step
         ultimately this isn't as efficient as other sorting algorithms O(setup + finding each element) to sort an entire list,
         but the set-up is faster, so you can start reading the list immediately
      start the recursive constructor using the ArrayList's split method
      */
      int split = origionalList.size()/2;

      if(origionalList.size() <= 4){
         smallerSort = new MergeSortBaseCase(origionalList.subList(split, origionalList.size()));
         largerSort = new MergeSortBaseCase(origionalList.subList(0, split));
      }else{
         smallerSort = new MergeSortWorker(origionalList.subList(split, origionalList.size()));
         largerSort = new MergeSortWorker(origionalList.subList(0, split));
      }
      assignSorts();
   }//end constructor
   
   private void assignSorts(){//used in constructor
      if(smallerSort.getValue() > largerSort.getValue()){
         MergeSort temp = smallerSort;
         smallerSort = largerSort;
         largerSort = temp;
      }
   }
   
   private Integer assignSorts(Integer smallestNext,Integer largestNext){//used in 
       
      if(smallestNext > largestNext){
         MergeSort temp = smallerSort;
         smallerSort = largerSort;
         largerSort = temp;
         return largestNext;
      }
      return smallestNext;
   }
   
   /*
   finds the nextME value of the smallest one,
   then re-finds the smallest
   */
   @Override
   public Integer nextME(){    
      Integer largeNext = largerSort.getValue();
      try{
         return assignSorts(smallerSort.nextME(), largeNext);
      }catch(AssertionError e){//see the BaseCase
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
   /*
   public Integer topLevelNext(){
      Integer tempInt = getValue();
      nextME();
      return tempInt;
   }
   */
}//end classs