package ie.atu.ai;

/**
 * HuggingFaceQuestionAnswering
 */
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HuggingFaceQuestionAnswering {

    public static void main(String[] args) throws IOException {
        // Load the tokenizer and model
        InputStream tokenizerStream = HuggingFaceQuestionAnswering.class.getResourceAsStream("/bert-base-uncased-tokenizer.json");
        InputStream modelStream = HuggingFaceQuestionAnswering.class.getResourceAsStream("/bert-base-uncased-model.h5");
        Tokenizer tokenizer = new Tokenizer(tokenizerStream);
        QuestionAnsweringModel model = new QuestionAnsweringModel(modelStream);

        // Ask a question
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the capital of France?");
        String question = scanner.nextLine();

        // Get the answer
        List<Answer> answers = model.answerQuestion(question, tokenizer);

        // Print the answer
        for (Answer answer : answers) {
            System.out.println(answer.getText());
        }

        // Close all scanners and files
        scanner.close();
        tokenizerStream.close();
        modelStream.close();
    }
}

class Tokenizer {

    private final String[] tokens;

    public Tokenizer(InputStream stream) throws IOException {
        Scanner scanner = new Scanner(stream);
        tokens = Arrays.stream(scanner.nextLine().split(" ")).map(String::trim).toArray(String[]::new);
        scanner.close();
    }

    public List<String> tokenize(String text) {
        List<String> tokens = new ArrayList<>();
        for (String token : this.tokens) {
            if (text.contains(token)) {
                tokens.add(token);
            }
        }
        return tokens;
    }
}

class QuestionAnsweringModel {

    private final int maxAnswerLength;
    private final int maxQuestionLength;
    private final int maxContextLength;

    public QuestionAnsweringModel(InputStream stream) throws IOException {
        Scanner scanner = new Scanner(stream);
        maxAnswerLength = Integer.parseInt(scanner.nextLine());
        maxQuestionLength = Integer.parseInt(scanner.nextLine());
        maxContextLength = Integer.parseInt(scanner.nextLine());
        scanner.close();
    }

    public List<Answer> answerQuestion(String question, Tokenizer tokenizer) {
        List<String> questionTokens = tokenizer.tokenize(question);
        List<String> contextTokens = tokenizer.tokenize("This is the context for the question.");

        // Find the start and end of the answer in the context.
        int start = -1;
        int end = -1;
        for (int i = 0; i < contextTokens.size(); i++) {
            if (questionTokens.get(0).equals(contextTokens.get(i))) {
                start = i;
                break;
            }
        }
        if (start == -1) {
            return Arrays.asList(new Answer(null, null));
        }
        for (int i = start + questionTokens.size(); i < contextTokens.size(); i++) {
            if (!Character.isWhitespace(contextTokens.get(i).charAt(0))) {
                end = i;
                break;
            }
        }
        if (end == -1) {
            end = contextTokens.size() - 1;
        }

        // Extract the answer from the context.
        String answer = contextTokens.subList(start, end + 1).stream().collect(Collectors.joining(" "));

        // Return the answer.
        return Arrays.asList(new Answer(answer, start));
    }
}

class Answer {

    private final String text;
    private final Integer start;

    public Answer(String text, Integer start) {
        this.text = text;
        this.start = start;
    }

    public String getText() {
        return text;
    }
}