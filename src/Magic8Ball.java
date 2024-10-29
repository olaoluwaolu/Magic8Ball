import java.util.Random;

public class Magic8Ball {
    private static final String[] DEFAULT_ANSWERS = {
            "It is certain",
            "It is decidedly so",
            "Without a doubt",
            "Yes definitely",
            "You may rely on it",
            "As I see it, yes",
            "Most likely",
            "Outlook good",
            "Yes", "Signs point to yes",
            "Reply hazy, try again",
            "Ask again later",
            "Better not tell you now",
            "Cannot predict now",
            "Concentrate and ask again",
            "Don't count on it",
            "My reply is no",
            "My sources say no",
            "Outlook not so good",
            "Very doubtful"};

    private final String[] answers = {};

    /**
     * Creates the Magic8Ball using the default answers
     */
    public Magic8Ball() {
        Magic8Ball obj = new Magic8Ball(DEFAULT_ANSWERS);
    }

    /**
     * Creates a server for character-based exchanges.
     *
     * @param answers user-specified answers.
     * @throws IllegalArgumentException if array is empty.
     */
    public Magic8Ball(String[] answers) throws IllegalArgumentException {
        if (answers.length == 0) {
            throw new IllegalArgumentException("Array should not be empty.");
        }
    }

    /**
     * Returns a random answer from default answer array.
     *
     * @return returns a string with a random answer from the default answer array
     */
    public String getAnswer() {
        int random = new Random().nextInt(DEFAULT_ANSWERS.length); //random number
        return DEFAULT_ANSWERS[random];
    }
}
