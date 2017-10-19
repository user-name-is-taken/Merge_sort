//import java.util.HashMap;//<int,MergeSort>;
//https://stackoverflow.com/questions/559839/big-o-summary-for-java-collections-framework-implementations#559862

import java.util.Iterator;
import java.util.ArrayList;

public class MergeController implements MergeSort{
   //HashMap<Integer,MergeSort> cont = new HashMap<Integer,MergeSort>();
   //use an array of arrays instead
   int[][] cont;
   ArrayList<MergeSortBaseCase> base;
   
   public MergeController(Iterator<Integer> iter){
      //pass
      
      makeBase(iter);//the L is for list
      
   }
   
   public void makeBase(Iterator iter){
      //pass
      Integer val = (Integer) iter.next();
      while (iter.hasNext()){
         MergeSortBaseCase cur = new MergeSortBaseCase();
         base.add(cur);
         while(cur.add(val)){
            val = iter.next();  
         }
      }
   }//end makeBase
   
   public void initializeCont(){
      double size = Math.sqrt(base.size());//this is wrong, use bin and indexOf
      int sizeInt = (int)size;
      byte addOn = size > sizeInt?(byte)1:(byte)0;
      cont = new int[sizeInt+addOn][];
   }
   
   public void populateCont(){
      cont[0] = new int[Math.ceil(base.size()/2.0)];creates the first list
      for(int i = 0; i < base.size(); i += 2){
         cont[0][i] = Math.min(base.get(i).getValue(),base.get(++i).getValue();
         
      }
      
   }
   
   
   
   @Override
   public Integer getValue(){
      return base.get(this.getValIndex()).getValue();
   }
   
   public int getValIndex(){
      int[] highestList = cont[cont.length() - 1];
      int smallestIndex = highestList[0];
      for(int i = 1; i<highestList.length ; i++){
      //this should be only 1 comparison, the highest list should be size 2
         if(base[highestList[i]] < smallestIndex) smallestIndex = highestList[i];
      }
      return smallestIndex;
   }
   
   @Override
   public void nextME(){
      int topSmallestIndex = this.getValIndex();
      int curIndex = topSmallestIndex;
      //start at this value,
      //need to put something in here to start cont[0]
      for(int i = 1; i<cont.size(); i++){
         curIndex -= curIndex % 2;//finds the farthest left index in this group
         nextIndex = curIndex >> 2;
         /*this might go left too many times?
         but I don't think so. Once you hit 0 you should be OK
         */
         cont[i+1][nextIndex] = Math.min((int)base.get(cont[i][curIndex], (int)base.get(cont[i][curIndex+1]);
         /*pretty sre this is wrong, because it never compares and corrects the first two in cont[0]
         */
      } 
   }
}