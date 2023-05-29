package ie.atu.ai;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String API_TOKEN = "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";
        String[] modelIds = {
                             "gpt2",
                             "gpt2-large",
                            };
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("Enter the first line of a story below : \n");
        String question = userInput.nextLine();
        String input = "{\"inputs\":\"" + question + "\"}";
        userInput.close();
        for (String modelId : modelIds) {
            String url = "https://api-inference.huggingface.co/models/" + modelId;
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Authorization", "Bearer " + API_TOKEN);
            //System.out.println("Sending 'POST' request to URL : " + url);
            //System.out.println("Question: The goal of life is ...");
            //String input = "{\"inputs\":\"The goal of life is [MASK].\"}";
            System.out.println("Modle ID: " + modelId);
            //System.out.println("\tQuestion: The capital of France is ...");
            //String input = "{\"inputs\":\"The capital of France is [MASK].\"}";
            

          
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
            // Print full response
            //System.out.println("\n\n" + myResponse + "\n\n");
            
            // Manually parsing the JSON response
            int answerStartIndex = myResponse.indexOf(question) + question.length(); // Find the index of the end of the question
            int answerEndIndex = myResponse.indexOf("\"}]"); // Find the index of the end of the anwer in the JSON object
            String answer = myResponse.substring(answerStartIndex, answerEndIndex); // Extract the text between the second pair of quotes
            answer = answer.replaceAll("\\\\n", System.lineSeparator()); // Replace all occurrences of \n with line separator
            answer = answer.replaceAll("\\\\\"", "\""); // Replace all occurrences of \" with "
            answer = answer.trim(); // Remove leading and trailing whitespace

            System.out.println(answer);
            
          }
    }
}