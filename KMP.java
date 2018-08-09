import java.util.*;
class KMP{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Pattern : ");
        char pat[] = input.next().toCharArray();
        System.out.print("Enter Text : ");
        char txt[] = input.next().toCharArray();

        int lps[] = prepareLPS(pat);
        int patternCount = checkIfPatternExists(txt, pat, lps);

        System.out.println("Pattern encountered in the text " + patternCount + " times.");
    }

    public static int checkIfPatternExists(char txt[], char pat[], int lps[]){
        int i = 0, j = 0, patternCount = 0;
        while(i < txt.length && j < pat.length){
            if(txt[i] == pat[j]){
                i++;
                j++;
            }else{
                if(j != 0)
                    j = lps[j];
                else 
                    i++;
            }
            if(j == pat.length){
                patternCount++;
                j = 0;
            } 
        }
        return patternCount;
    }

    public static int[] prepareLPS(char pat[]){
        int lps[] = new int[pat.length];
        int i=1, j=0;
        lps[0] = 0;
        while(i < pat.length){
            if(pat[j] == pat[i]){
                lps[i] = j+1;
                j++;
                i++;
            }
            else if(j != 0){
                j = lps[j-1];
            }
            else{
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }
}