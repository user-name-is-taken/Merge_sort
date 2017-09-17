import java.util.List;

public class MergeSortWorker implements MergeSort{
   private MergeSort rightSort;
   private MergeSort leftSort;
   private Boolean leftVal;

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
      leftVal = leftSort.getVal()<=rightSort.getVal();
   }//end constructor
   
   /*
   finds the next value of the smallest one,
   then re-finds the smallest
   */
   @Override
   public void next(){
      Integer tempInt;
      if(leftVal){
         leftSort.next();
      else{
         rightSort.next();
      }
      leftVal = leftSort.getVal() <= rightSort.getVal();
   }//end next
   
   @Override
   public Integer getValue(){
      if(leftVal){
         return leftSort.getVal();
      }else{
         return rightSort.getVal();
      }
   }
   
   public Integer topLevelNext(){
      Integer tempInt = getValue();
      next();
      return tempInt;
   }
}//end classs