import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {
    public static void main(String[] args) {
        String str = "working";
        int n = str.length();
        //permutation.permute(str, 0, n - 1, allWords);
        System.out.println(Arrays.toString(allEnglishWords(str).toArray()));
    }

    public static ArrayList<String> allEnglishWords(String str){
        ArrayList<String> allWords = new ArrayList<>();
        ArrayList<String> englishWords = new ArrayList<>();
        Permutation.permute(str, 0, str.length()-1, allWords);
        for (String word : allWords) {
            if(Dictionary.isEnglishWord(word)) englishWords.add(word);
        }
        return englishWords;
    }
    public static void permute(String str, int l, int r, ArrayList<String> allWords) {
        if (l == r) {
            for (int length = 0; length <= str.length(); length++) {
                if (!allWords.contains(str.substring(0, length))) {
                    allWords.add(str.substring(0,length));
                }
            }
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str,l+1,r,allWords);
                str = swap(str, l, i);
            }
        }
    }

    public static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
