/**************************************************************************************************************************
 Using Regular Expression
 ========================
 input = "youwillwinthis";
 output = "ywllwnths"
***************************************************************************************************************************/

package day5;  
class RemoveTheVowels 
{   
    static String remVowel(String input) 
    { 
         return input.replaceAll("[aeiou]", ""); 
    } 
      
    public static void main(String[] args)  
    { 
        String input = "youwillwinthis";    
        System.out.println("The Input String is:- "+input);
        System.out.println("The Input String is:- "+remVowel(input)); 
    } 
} 