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
      leftVal = leftSort.getValue() <= rightSort.getValue();
   }//end constructor
   
   /*
   finds the nextME value of the smallest one,
   then re-finds the smallest
   */
   @Override
   public void nextME(){
      if(leftVal){
         leftSort.nextME();
      }else{
         rightSort.nextME();
      }
      leftVal = leftSort.getValue() <= rightSort.getValue();
   }//end nextME
   
   @Override
   public Integer getValue(){
      if(leftVal){
         return leftSort.getValue();
      }else{
         return rightSort.getValue();
      }
   }
   /*
   public Integer topLevelNext(){
      Integer tempInt = getValue();
      nextME();
      return tempInt;
   }
   */
}//end classs