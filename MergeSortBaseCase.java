import java.util.LinkedList;

public class MergeSortBaseCase implements MergeSort{
   private LinkedList<Integer> baseList;
   

   
   public MergeSortBaseCase(int inSize){
      //super();
      //thisList = ogList;//make this into a new list
      
      //this will allow the constructor to delete the passed in list
      //so the memory size is the same if the passed in list is deleted.
      //List<Integer> subList = new ArrayList<Integer>(list.subList(0,2));
      
      baseList.add(MergeSortWorker.workList.removeFirst());//null pointer
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
      baseList.removeFirst();
      return getValue();
   }
   
   @Override
   public Integer getValue(){
      return baseList.getFirst();
   }
}
