import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class MergeSortBaseCase implements MergeSort{
   private Iterator<Integer> thisIter;
   private static Integer tempInt;//need to be careful with statics in recursion
   private Integer previous;

   
   public MergeSortBaseCase(List ogList){
      //super();
      //thisList = ogList;//make this into a new list
      
      //this will allow the constructor to delete the passed in list
      //so the memory size is the same if the passed in list is deleted.
      //List<Integer> subList = new ArrayList<Integer>(list.subList(0,2));
      
      
      if(ogList.size()==2 && (int)ogList.get(0)>(int)ogList.get(1)){
         Integer tempInt = (Integer) ogList.get(1);
         ogList.set(1,ogList.get(0));
         ogList.set(0,tempInt);
      }  
      thisIter = ogList.iterator();
   }

   @Override
   public Integer nextME(){
      previous = thisIter.next();
      return previous;
   }
   
   @Override
   public Integer getValue(){
      return previous;//index out of bounds
   }
}
