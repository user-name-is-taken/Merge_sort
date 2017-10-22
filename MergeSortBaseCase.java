import java.util.LinkedList;

/*
This class isn't strictly necessary, and it adds memory and steps to construct
it, but It's useful conceptually.
*/

public class MergeSortBaseCase implements MergeSort{
   private LinkedList<Integer> baseList;
   
   public MergeSortBaseCase(Integer val){
      
      
      baseList = new LinkedList<Integer>();
      baseList.add(val);    
   }
   
   /*add to beginning or end, or delete
   as these values are passed in they're deleted from the MergeController's
   passed in iterator*/
   public boolean addVal(Integer val){
      if(val <= baseList.getFirst()){
         baseList.addFirst(val);
         return true;
      }else if(val >= baseList.getLast()){
         baseList.addLast(val);
         return true;
      }
      return false;
   }

/*nextME will be handled from the top level
*/
   @Override
   public void nextME(){ 
      //just delete
      baseList.removeFirst();
   }
   
   @Override
   public Integer getValue(){
      return baseList.getFirst();
   }
}
