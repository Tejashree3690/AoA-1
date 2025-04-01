public class NaiveString
{
   static void naiveFindPatrn(String mainString, String pattern, int[] array) {
      int patLen = pattern.length();
      int strLen = mainString.length();
      int index = 0;  
      for(int i = 0; i <= (strLen - patLen); i++) {
         int j;
         for(j = 0; j < patLen; j++) {      
            if(mainString.charAt(i+j) != pattern.charAt(j))
               break;
         }
         if(j == patLen) {    
            array[index] = i;
            index++;
         }
      }
   }
   public static void main(String[] args) {
      String mainString = "ABAAABCDBBABCDDEBCABC";
      String pattern = "ABC";
      int[] locArray = new int[mainString.length()];
      naiveFindPatrn(mainString, pattern, locArray);
      for(int i = 0; i < locArray.length && locArray[i] != 0; i++) {
         System.out.println("Pattern found at position: " + locArray[i]);
      }
   }
}