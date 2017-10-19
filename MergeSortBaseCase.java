import java.util.LinkedList;

public class MergeSortBaseCase implements MergeSort{
   private LinkedList<Integer> baseList;
  
  
   public MergeSortBaseCase(){
      //super();
      //thisList = ogList;//make this into a new list
      
      /*each of these will chop off the workList. 
      By the end, the workList should be empty, and the baseLists should all be full.
      
      This comment also explains the use of inSize in the Worker
      */
      //this will allow the constructor to delete the passed in list
      //so the memory size is the same if the passed in list is deleted.
      //List<Integer> subList = new ArrayList<Integer>(list.subList(0,2));
      
      LinkedList<Integer> baseList = new LinkedList<Integer>();      
   }
   
   /*add to beginning or end, or delete*/
   public boolean addVal(Integer val){
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
