import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ConTest{
   public static void main(String[] args){
      //pass
      ArrayList<Integer> name = new ArrayList<>();
      int[] gers = {1,3,2,4,5,2,6,2};
      for(int i: gers)name.add(new Integer(i));
      //List subName = name.subList(0,5);
      //List name2 = name.subList(2,5);
      ConClass cc = new ConClass(name.subList(0,5));
      for(int i=0; i<3; i++){
         cc.remove();
      }
   }
}
