import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ConClass{
   List testList;
   public ConClass(List testAL){
      testList = testAL;
   }
   public void remove(){
      testList.remove(0);
   }
}