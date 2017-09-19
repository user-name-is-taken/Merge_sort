public final class NullSortClass implements MergeSort{
   //used to save memory space
   
   @Override
   public Integer nextME(){
      throw new NullPointerException();
   }
   @Override
   public Integer getValue(){
      return Integer.MAX_VALUE;
   }
         /*the null pointer exception means you're compeltely done because it means both
      sides at every level are the NullSortClass killer*/
}