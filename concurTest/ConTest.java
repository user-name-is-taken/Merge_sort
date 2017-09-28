import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.ListIterator;

//https://stackoverflow.com/questions/16878460/how-to-modify-sublist-without-concurrentmodificationexception

public class ConTest{
   public static void main(String[] args){
      //pass
      ArrayList<Integer> name = new ArrayList<>();
      int[] gers = {1,3,2,4,5,2,6,2};
      for(int i: gers)name.add(new Integer(i));
      List L2 = name.subList(0,5);
      List Lc = L2.subList(2,L2.size());
      L2=null;
      //iter2.remove();//need to run next before remove()
      //List<Integer> subList = new ArrayList<Integer>(Lc);
      System.out.println(Lc.get(0));

   }
}
//this works if it's not sublists
//even if you remove from L2 this doesn't work
//this works if you only remove from one subList, then get from the main list
//this works if you get from both

/*
      ListIterator<Integer> iter2 = (ListIterator<Integer>) L2.iterator();
      ListIterator<Integer> iterC = (ListIterator<Integer>)Lc.iterator();
      //iter2.remove();//need to run next before remove()
      System.out.println(iter2.next()+"");
      System.out.println(iter2.next()+"");
      iter2.remove();
      */