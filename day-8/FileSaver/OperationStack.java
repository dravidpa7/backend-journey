package FileSaver;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

public class OperationStack {
    private static Stack<List<String>> undoStack = new Stack<>();
    private static Stack<List<String>> redoStack = new Stack<>();
    private static Stack<Integer> cursorStack = new Stack<>();
    private static Stack<Integer> redoCursorStack = new Stack<>();

    // initialize with the current document (call this after loading file)
    public static void init(String currentText) {
        undoStack.clear();
        redoStack.clear();
        cursorStack.clear();
        redoCursorStack.clear();
        
        // Split initial text into words and push
        List<String> words = splitIntoWords(currentText);
        undoStack.push(words);
        cursorStack.push(0); // Initial cursor position
    }

    private static List<String> splitIntoWords(String text) {
        List<String> words = new ArrayList<>();
        StringBuilder currentWord = new StringBuilder();
        
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            
            if (Character.isWhitespace(c)) {
                if (currentWord.length() > 0) {
                    words.add(currentWord.toString());
                    currentWord = new StringBuilder();
                }
                words.add(String.valueOf(c)); // Preserve whitespace as separate tokens
            } else if (isPunctuation(c)) {
                if (currentWord.length() > 0) {
                    words.add(currentWord.toString());
                    currentWord = new StringBuilder();
                }
                words.add(String.valueOf(c)); // Preserve punctuation as separate tokens
            } else {
                currentWord.append(c);
            }
        }
        
        if (currentWord.length() > 0) {
            words.add(currentWord.toString());
        }
        
        return words;
    }

    private static boolean isPunctuation(char c) {
        return !Character.isLetterOrDigit(c) && !Character.isWhitespace(c);
    }

    // Call this BEFORE you apply a new change to the JTextArea
    public static void recordBeforeChange(String currentText) {
        List<String> words = splitIntoWords(currentText);
        undoStack.push(words);
        cursorStack.push(currentText.length()); // Store cursor position
        redoStack.clear();
        redoCursorStack.clear();
    }

    public static String undo(String currentText) {
        if (undoStack.size() <= 1) {
            return currentText;
        }

        List<String> currentWords = splitIntoWords(currentText);
        redoStack.push(currentWords);
        redoCursorStack.push(currentText.length());
        
        undoStack.pop(); // Remove current state
        List<String> previousWords = undoStack.peek();
        
        return String.join("", previousWords);
    }

    public static String redo(String currentText) {
        if (redoStack.isEmpty()) {
            return currentText;
        }

        List<String> currentWords = splitIntoWords(currentText);
        undoStack.push(currentWords);
        cursorStack.push(currentText.length());
        
        List<String> nextWords = redoStack.pop();
        redoCursorStack.pop(); // Remove the cursor position
        
        return String.join("", nextWords);
    }

    // Helper method to get current text as words
    public static List<String> getCurrentWords() {
        return undoStack.isEmpty() ? new ArrayList<>() : undoStack.peek();
    }
}
