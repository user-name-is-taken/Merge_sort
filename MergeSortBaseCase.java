import java.util.List;

public class MergeSortBaseCase implements MergeSort{
   private List thisList;
   private static Integer tempInt;//need to be careful with statics in recursion
   
   public MergeSortBaseCase(List ogList){
      //super();
      thisList = ogList;
   }

   @Override
   public Integer next(){
      if(thisList.size()<2 || (int)thisList.get(0)<=(int)thisList.get(1)){
         //tempInt = (int)thisList.get(0);
         //thisList.set(0,Integer.MAX_VALUE);//could also delete here with a better data structure
         //return tempInt;
         return (Integer)thisList.remove(0);
      }else{
         //tempInt = (int)thisList.get(1);
         //thisList.set(1,Integer.MAX_VALUE);//could also delete here
         //return tempInt;
         return (Integer)thisList.remove(1);
         //concurrent modification?
         
      }
   }
}
