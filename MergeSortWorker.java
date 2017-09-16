import java.util.List;

public class MergeSortWorker implements MergeSort{
   private MergeSort rightSort;
   private MergeSort leftSort;
   private Integer rightVal;
   private Integer leftVal;
   
   private Integer tempInt;

   public MergeSortWorker(List origionalList){
      /*
      start the recursive constructor using the ArrayList's split method
      */
      int split = origionalList.size()/2;//this is probably an error

      if(origionalList.size() <= 4){
         rightSort = new MergeSortBaseCase(origionalList.subList(split, origionalList.size()));
         leftSort = new MergeSortBaseCase(origionalList.subList(0, split));
      }else{
         rightSort = new MergeSortWorker(origionalList.subList(split, origionalList.size()));
         leftSort = new MergeSortWorker(origionalList.subList(0, split));
      }
      rightVal = rightSort.next();
      leftVal = leftSort.next();
   }//end constructor
   
   @Override
   public Integer next(){
      /*
      return the next integer or raise an error 
      or throw the correct index out of bounds exception
      */

      if(rightVal > leftVal){//if both are null, this will be a null pointer exception
         tempInt = leftVal;
         leftVal = leftSort.next();
         if(rightVal == Integer.MAX_VALUE){
            rightSort = null;
            //deleting the object to save space can also delete rightSort
            //can also delete the other value
            //need to remove last constructor recursion
         }
         return tempInt;
       }else if (leftVal > rightVal){
         tempInt = rightVal;
         rightVal = rightSort.next();
         if(leftVal == Integer.MAX_VALUE){
            leftSort = null;
         }
         return tempInt;
      }else{
         return Integer.MAX_VALUE;
      }
   }//end next
}//end classs