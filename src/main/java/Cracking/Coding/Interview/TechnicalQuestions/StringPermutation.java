/**
 * Given a TEXT and PATTERN write a function search that prints all occurrences of PATTERN and its permutations(Anagrams)
 * in TEXT.
 * Ex: Input Text[] = BACDGABCDA     PAT[] = ABCD
 *     Output  Found at Index 0 [BACD]GABCDA
 *             Found at Index 5 BACDG[ABCD]A
 *             Found at Index 6 BACDGA[BCDA]
 * Input Text[] = AAABABAA      PAT[] = AABA
 * Output  Found at Index 0  [AAAB]ABAA
 *         Found at Index 1  A[AABA]BAA
 *         Found at Index 4  AAAB[ABAA]
 */
package Cracking.Coding.Interview.TechnicalQuestions;

public class StringPermutation {
    static boolean checkWindow(int[] patW, int[] textW) {
        for(int i=0;i<256;i++) {
            if(patW[i] != textW[i])
                return false;
        }
        return true;
    }
    public static void search(String text, String pattern) {
        int[] patW = new int[256];
        int[] textW = new int[256];

        int patLen = pattern.length();
        int textLen = text.length();

        //Initialize the first window of text which will be equal to patter length
        for(int i=0;i<patLen;i++) {
            patW[pattern.charAt(i)]++;
            textW[text.charAt(i)]++;
        }

        //Check if the window if text Matches, if not increase the Text Window by adding next Character and removing the first
        for(int i=patLen;i<textLen;i++) {

            //Compare the current window, if matches then we found our Match
            if(checkWindow(textW, patW)) {
                System.out.println("found at Index:"+ (i - patLen));
            }

            //Add current Character to textWindow
            textW[text.charAt(i)]++;

            //remove the first character of textWindow
            textW[text.charAt(i-patLen)]--;
        }

        //Check the last window
        if(checkWindow(textW, patW)) {
            System.out.println("found at Index:"+ (textLen - patLen));
        }

    }

    public static void main(String[] args) {
        String text = "BACDGABCDA";
        String pattern = "ABCD";
        System.out.println("Text:"+text+" pattern:"+pattern);
        search(text, pattern);

        text = "cbabadcbbabbcbabaabccbabc";
        pattern = "abbc";
        System.out.println("Text:"+text+" pattern:"+pattern);
        search(text, pattern);
    }
}
