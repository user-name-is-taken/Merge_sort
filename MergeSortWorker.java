import java.util.List;


/*
One problem is you were returning the previous smallest
Instead of the current value that replaced the previous smallest.

See the base class's nextME() changes
*/




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
      
      hopefully, origionalList will be deleted after this function
      */
      int split = origionalList.size()/2;
      
      
      if(origionalList.size() <= 4){
         smallerSort = new MergeSortBaseCase(origionalList.subList(0, split));
         if(origionalList.size()>2){ 
            largerSort = new MergeSortBaseCase(origionalList.subList(split, origionalList.size()));
         }else{
            largerSort = killer;
         } 
      }else{
         smallerSort = new MergeSortWorker(origionalList.subList(0, split));
         largerSort = new MergeSortWorker(origionalList.subList(split, origionalList.size()));
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
      }catch(EmptyList e){//see the BaseCase
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