import java.util.List;
import java.util.ArrayList;

public class MergeSortBaseCase implements MergeSort{
   private List<Integer> thisList;
   private static Integer tempInt;//need to be careful with statics in recursion

   
   public MergeSortBaseCase(List ogList){
      //super();
      //thisList = ogList;//make this into a new list
      thisList = new ArrayList<Integer>(ogList);
      //this will allow the constructor to delete the passed in list
      //so the memory size is the same if the passed in list is deleted.
      //List<Integer> subList = new ArrayList<Integer>(list.subList(0,2));
      
      
      if(thisList.size()==2 && thisList.get(0)>thisList.get(1)){
         Integer tempInt = thisList.get(1);
         thisList.set(1,thisList.get(0));
         thisList.set(0,tempInt);
      }  
   }

   @Override
   public Integer nextME(){
      Integer temp = thisList.remove(0);//will automatically throw an error
      assert !thisList.isEmpty();// checks if there are more. If not, throws an error
      //return temp;
      return getValue();
   }
   
   @Override
   public Integer getValue(){
      return (Integer) thisList.get(0);//index out of bounds
   }
}
