package ie.atu.ai;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class AskAQuestion {
    public static void main(String[] args) throws Exception {
        String API_TOKEN = "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";
        String modelId = "microsoft/DialoGPT-large";
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("Type in a question... : \n");
        String question = userInput.nextLine();
        String input = "{\"inputs\":\"" + question + "\"}";
        userInput.close();
        
        String url = "https://api-inference.huggingface.co/models/" + modelId;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Authorization", "Bearer " + API_TOKEN);
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
        con.getOutputStream().write(input.getBytes(StandardCharsets.UTF_8));
        con.getOutputStream().flush();
        con.getOutputStream().close();
        
        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String myResponse = response.toString();
            // Print full response
            //System.out.println("\n\n" + myResponse + "\n\n");
            
            // Manually parsing the JSON response
            int answerStartIndex = myResponse.indexOf(":\"") + 2; // Find the index of the end of the question
            int answerEndIndex = myResponse.indexOf("\","); // Find the index of the end of the anwer in the JSON object
            String answer = myResponse.substring(answerStartIndex, answerEndIndex); // Extract the text between the second pair of quotes
            //answer = answer.replaceAll("\\\\n", System.lineSeparator()); // Replace all occurrences of \n with line separator
            //answer = answer.replaceAll("\\\\\"", "\""); // Replace all occurrences of \" with "
            // answer = answer.trim(); // Remove leading and trailing whitespace

            // Print the answer in red
            System.out.println("\n\u001B[31m" + answer + "\u001B[0m");


        } else {
            System.out.println("API request failed with response code: " + responseCode);
        }
    }
}