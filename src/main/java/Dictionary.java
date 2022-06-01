import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Dictionary {

    public static boolean isEnglishWord(String str) {
        JSONParser jsonParser = new JSONParser();
        /* ***API Connection***
        URL url = new URL("url of the english words endpoint");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        if(conn.getResponseCode() == 200) {
            Scanner scan = new Scanner(url.openStream());
            while(scan.hasNext()) {
                String temp = scan.nextLine();
                //here should be the parse json
            }
        }*/
        // ***API Mock***
        try (FileReader reader = new FileReader("src/main/resources/WordsServiceMock.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            Object strObject = str;
            JSONArray wordList = (JSONArray) obj;
            if(wordList.contains(strObject)) return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
}


