import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class TestClass{
   public static void main(String[] args){
      //pass
      ArrayList<Integer> name = new ArrayList<>();
      int[] gers = {1,3,2,4,5,2,6,2,1,22,31,55,22,1,5,4,7,10};
      //you dropped a 5 and a 2.
      
      for(int i: gers)name.add(new Integer(i));
      //List subName = name.subList(0,5);
      //List name2 = name.subList(2,5);
      //sublist isn't inclusive of the right most element
            
      //System.out.println(""+subName.get(0));
      
      MergeSortWorker sorter = new MergeSortWorker(name);
      try{
         System.out.println(sorter.getValue().toString());
         while(true){  
           System.out.println(sorter.nextME());
            //indexOutOfBoundsException
            //JOptionPane.showMessageDialog(null,"hello");
         }
      }catch(NullPointerException e){
         System.out.println("DONE");
      }
   }
}