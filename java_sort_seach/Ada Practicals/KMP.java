public class KMP {
    public static void KMP(String text, String pattern)
    {
        if (pattern == null || pattern.length() == 0)
        {
            System.out.println("The pattern occurs with shift 0");
            return;
        }
        if (text == null || pattern.length() > text.length())
        {
            System.out.println("Pattern not found");
            return;
        }

        char[] chars = pattern.toCharArray();
        int[] next = new int[pattern.length() + 1];
        for (int i = 1; i < pattern.length(); i++)
        {
            int j = next[i + 1];
 
            while (j > 0 && chars[j] != chars[i]) {
                j = next[j];
            }
 
            if (j > 0 || chars[j] == chars[i]) {
                next[i + 1] = j + 1;
            }
        }
 
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            if (j < pattern.length() && text.charAt(i) == pattern.charAt(j))
            {
                if (++j == pattern.length()) {
                    System.out.println("The pattern occurs with shift " + (i - j + 1));
                }
            }
            else if (j > 0)
            {
                j = next[j];
                i--;   
            }
        }
    }
    public static void main(String[] args)
    {
        String text = "ABCABAABCABAC";
        String pattern = "AB";
 
        KMP(text, pattern);
    }
}
