import java.util.List;

public class MergeSortBaseCase implements MergeSort{
   private List thisList;
   private static Integer tempInt;//need to be careful with statics in recursion

   
   public MergeSortBaseCase(List ogList){
      //super();
      thisList = ogList;
      if(thisList.size()==2 && (int)thisList.get(0)>(int)thisList.get(1)){
         Object tempInt = thisList.get(1);
         thisList.set(1,thisList.get(0));
         thisList.set(0,tempInt);
      }  
   }

   @Override
   public Integer nextME(){
      Integer temp = (Integer)thisList.remove(0);//will automatically throw an error
      assert !thisList.isEmpty();// checks if there are more. If not, throws an error
      return temp;
   }
   
   @Override
   public Integer getValue(){
      return (Integer) thisList.get(0);
   }
}
