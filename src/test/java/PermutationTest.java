import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.testng.Assert.*;

public class PermutationTest {

    @Test
    public void testWorkingEnglishWords() {
        ArrayList<String> testWords = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/test/resources/WorkingTestWords.json"))
        {
            Object obj = jsonParser.parse(reader);
            JSONArray wordList = (JSONArray) obj;
            for (int i=0;i<wordList.size();i++){
                testWords.add(wordList.get(i).toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ArrayList<String> englishWords = Permutation.allEnglishWords("working");
        Assert.assertNotNull(englishWords);
        Assert.assertEquals(testWords.size(),englishWords.size());
        for (int i=0;i<englishWords.size();i++){
            Assert.assertTrue(testWords.contains(englishWords.get(i)));
        }
    }

    @Test
    public void testRainbowEnglishWords() {
        ArrayList<String> testWords = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/test/resources/RainbowWordsTest.json"))
        {
            Object obj = jsonParser.parse(reader);
            JSONArray wordList = (JSONArray) obj;
            for (int i=0;i<wordList.size();i++){
                testWords.add(wordList.get(i).toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ArrayList<String> englishWords = Permutation.allEnglishWords("rainbow");
        Assert.assertNotNull(englishWords);
        Assert.assertEquals(testWords.size(),englishWords.size());
        for (int i=0;i<englishWords.size();i++){
            Assert.assertTrue(testWords.contains(englishWords.get(i)));
        }
    }@Test
    public void testEmptyEnglishWords() {
        ArrayList<String> englishWords = Permutation.allEnglishWords("1234");
        Assert.assertTrue(englishWords.isEmpty());
    }
}