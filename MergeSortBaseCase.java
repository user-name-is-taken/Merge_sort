import java.util.LinkedList;

public class MergeSortBaseCase implements MergeSort{
   private LinkedList<Integer> baseList;
  
   public MergeSortBaseCase(int inSize){
      //super();
      //thisList = ogList;//make this into a new list
      
      /*each of these will chop off the workList. 
      By the end, the workList should be empty, and the baseLists should all be full.
      
      This comment also explains the use of inSize in the Worker
      */
      //this will allow the constructor to delete the passed in list
      //so the memory size is the same if the passed in list is deleted.
      //List<Integer> subList = new ArrayList<Integer>(list.subList(0,2));
      
      
      
      baseList = new LinkedList<Integer>();
      
      Integer val = MergeSortWorker.workList.removeFirst(); 
      
      this.baseList.add(val);//null pointer
      if(inSize==2){
         if(baseList.getFirst()>MergeSortWorker.workList.getFirst()){
            baseList.addFirst(MergeSortWorker.workList.removeFirst());
         }else{
            baseList.addLast(MergeSortWorker.workList.removeFirst());
         }
      }
   }

   @Override
   public Integer nextME(){
      //can switch to returning removeFirst, then saving the result in the worker? 
      //--no because it might be larger.
      baseList.removeFirst();
      return getValue();
   }
   
   @Override
   public Integer getValue(){
      return baseList.getFirst();
   }
}
