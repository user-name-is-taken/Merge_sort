//https://stackoverflow.com/questions/559839/big-o-summary-for-java-collections-framework-implementations#559862

import java.util.Iterator;
import java.util.ArrayList;

public class MergeController implements MergeSort{
   int[][] cont;//this stores the heirarchy
   ArrayList<MergeSortBaseCase> base = new ArrayList<MergeSortBaseCase>();//this stores the backing list
   
   public MergeController(Iterator<Integer> iter){
      
      makeBase(iter);
      initializeCont();
      populateCont();
      
   }
   
   public void makeBase(Iterator iter){
      //pass
      Integer val;
      while (iter.hasNext()){
         MergeSortBaseCase cur = new MergeSortBaseCase((Integer)iter.next());
         base.add(cur);
         while(iter.hasNext() && cur.addVal((Integer)iter.next())){
            //pass
         }
      }
   }//end makeBase
   
   public void initializeCont(){
      int size = getMostSigBit(base.size());
      cont = new int[size][];
   }
   
   /*populates cont with lists of the smallest index up to that level
   */
   public void populateCont(){
      //populate the first one
      cont[0] = new int[(int)Math.ceil(base.size()/2.0)];//creates the first list
      for(int i = 0; i < base.size()-1; i += 2){// this will have an off by 1 error
         if(base.get(i).getValue()<base.get(1+i).getValue()){
            cont[0][i/2] = i;
         }else{
            cont[0][i/2] = i+1;
         }
      }
      
      /*populate the rest of the lists until you're out 
      remember to handle lists of odd lengths*/
      
      for(int arr = 1; arr<cont.length; arr++){
         int[] lastArr = cont[arr-1];
         cont[arr] = new int[(int)Math.ceil(lastArr.length/2.0)];
         for (int n=0; n < lastArr.length -1 ; n+=2){ // off by 1 error
            if(base.get(lastArr[n]).getValue()<base.get(lastArr[1+n]).getValue()){
               cont[arr][n/2] = lastArr[n];//references to the index in base list.
            }else{
               cont[arr][n/2] = lastArr[n+1];
            }
         }
      }
   }
   
   /*
   http://docs.oracle.com/javase/1.5.0/docs/api/java/lang/Integer.html#numberOfLeadingZeros%28int%29
   returns the highest bit position with 1 added to it if
   all the trailing bits aren't 0
   
   This finds how many levels of cont there are (basically log(numb) base 2)
   */
   public int getMostSigBit(int numb){
      if(numb == 0){
         return 0;//shouldn't be necessary, but I'll add it anyway
      }
      int val = 31 - Integer.numberOfLeadingZeros(numb);
      //31 because Integers are signed
      if(numb > Integer.highestOneBit(numb)) val++;
      return val;
   }   
   
   @Override
   public Integer getValue(){
      return base.get(this.getValIndex()).getValue();
   }
   
   /*getValIndex() gets the index of the baseList element with the smallest
   value from the last array in cont*/
   public int getValIndex(){
      int[] highestList = cont[cont.length - 1];
      int smallestIndex = highestList[0];
      for(int i = 1; i<highestList.length ; i++){
      //this should be only 1 comparison, the highest list should be size 2
         if(base.get(highestList[i]).getValue() < base.get(smallestIndex).getValue())
             smallestIndex = highestList[i];         
      }
      return smallestIndex;
   }
   
   /*nextME does this:
   starts from the bottom and brings that number up to the top
   */
   @Override
   public void nextME(){
      int topSmallestIndex = this.getValIndex();
      int curIndex = topSmallestIndex;
      //start at this value,
      //need to call the baseCase's nextME
      //need to put something in here to compare base to cont[0]
      
      for(int i = 1; i<cont.length; i++){
         int nextIndex = curIndex >> 1;//floor division by 2
         /*this might go left too many times?
         but I don't think so. Once you hit 0 you should be OK
         stop if the old base wasnt used
         */
         cont[i+1][nextIndex] = Math.min((int)base.get(cont[i][curIndex]).getValue(), (int)base.get(cont[i][curIndex+1]).getValue());
         /*pretty sure this is wrong, because it never compares and corrects the first two in cont[0]
         */
         curIndex=nextIndex;
      } 
   }
}