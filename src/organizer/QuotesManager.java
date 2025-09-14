package organizer;

import java.io.FileReader;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;

public class QuotesManager {
    private List<String> quotes;

    public QuotesManager(String filePath) {
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader(filePath);
            quotes = gson.fromJson(reader, new TypeToken<List<String>>(){}.getType());
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getRandomQuote() {
        if (quotes == null || quotes.isEmpty()) {
            return "No quotes available!";
        }
        int index = (int) (Math.random() * quotes.size());
        return quotes.get(index);
    }
}

