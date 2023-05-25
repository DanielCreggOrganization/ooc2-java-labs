package ie.atu.ai;

import java.net.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String API_TOKEN = "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";
        String MODEL_ID = "bert-base-uncased";
        String url = "https://api-inference.huggingface.co/models/" + MODEL_ID;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Bearer " + API_TOKEN);
        String input = "{\"inputs\":\"The goal of life is [MASK].\"}";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(input);
        wr.flush();
        wr.close();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        
        String myResponse = response.toString();
        System.out.println("\n\n" + myResponse + "\n\n");
        // Manually parsing the JSON response
        int sequenceStartIndex = myResponse.indexOf("\"sequence\":") + 12;
        int sequenceEndIndex = myResponse.indexOf("\",", sequenceStartIndex);
        String sequence = myResponse.substring(sequenceStartIndex, sequenceEndIndex);
        
        int scoreStartIndex = myResponse.indexOf("\"score\":") + 8;
        int scoreEndIndex = myResponse.indexOf(",", scoreStartIndex);
        double score = Double.parseDouble(myResponse.substring(scoreStartIndex, scoreEndIndex));
        
        System.out.println("Sequence: " + sequence);
        System.out.println("Score: " + score);
    }
}