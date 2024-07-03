public class String_matching {
        public static void search(String str, String pattern) 
        { 
            int n = str.length(); 
            int m = pattern.length(); 

            for (int s = 0; s <= n - m; s++) { 
                int j; 
                for (j = 0; j < m; j++) 
                    if (str.charAt(s + j) != pattern.charAt(j)) 
                        break; 
                if (j == m) 
                    System.out.println("Pattern occurs at index " + s); 
            } 
        } 
      
        public static void main(String[] args) 
        { 
            String txt = "AABAACAADAABAAABAA"; 
            String pat = "AABA"; 
            search(txt, pat); 
        } 
    
}
