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
      return (Integer)thisList.remove(0);
   }
   
   @Override
   public Integer getValue(){
       if (thisList.isEmpty()){
         //delete self to save memory
         return Integer.MAX_VALUE;
       }else{
         return (Integer) thisList.get(0);
       }
   }
}
