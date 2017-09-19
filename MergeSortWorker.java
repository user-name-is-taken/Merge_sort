import java.util.List;

public class MergeSortWorker implements MergeSort{
   private MergeSort smallerSort;
   private MergeSort largerSort;
   private static final NullSortClass killer = new NullSortClass();

   public MergeSortWorker(List origionalList){
      /*
      start the recursive constructor using the ArrayList's split method
      */
      int split = origionalList.size()/2;//this is probably an error

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
   
   private Integer assignSorts(Integer smallestNext){//used in 
      Integer largestNext = largerSort.getValue();
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
      try{
         return assignSorts(smallerSort.nextME());
      }catch(IndexOutOfBoundsException e){//happens on the next
         //switch and null
         smallerSort = largerSort;
         largerSort = killer;
         return largestNext;//fix me!
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