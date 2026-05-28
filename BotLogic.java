import java.io.*;
import java.util.*;

public class BotLogic {

    HashMap<String, String> faq = new HashMap<>();

    public BotLogic() {
        loadFAQ();
    }

    private void loadFAQ() {

        try {
            BufferedReader br = new BufferedReader(new FileReader("faq.txt"));

            String line;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split("=");

                if (parts.length == 2) {
                    faq.put(parts[0].toLowerCase(), parts[1]);
                }
            }

            br.close();

        } catch (Exception e) {
            System.out.println("FAQ file not found.");
        }
    }

    public String getResponse(String input) {

        input = input.toLowerCase();

        // Greeting NLP
        if (input.contains("hello") || input.contains("hi")) {
            return "Hello! How can I help you?";
        }

        // Asking name
        else if (input.contains("your name")) {
            return "I am a Java AI ChatBot.";
        }

        // Time query
        else if (input.contains("time")) {
            return java.time.LocalTime.now().toString();
        }

        // FAQ Matching
        for (String question : faq.keySet()) {

            if (input.contains(question)) {
                return faq.get(question);
            }
        }

        // Default response
        return "Sorry, I don't understand that.";
    }
}
