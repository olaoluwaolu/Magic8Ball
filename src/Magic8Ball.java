import java.util.Random;
import java.util.Arrays;

/**
 * This is a Magic8Ball class. It creates
 * a Magic8Ball based on the default 20 answers
 * or by using a user-specified answer array.
 * It throws an error if the user-specified answer
 * array is empty
 */

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

    private final String[] answers;

    /**
     * Creates the Magic8Ball using user-specified answers.
     *
     * @param myAnswers user-specified answers.
     * @throws IllegalArgumentException if array is empty.
     */
    public Magic8Ball(String[] myAnswers) throws IllegalArgumentException {
        if (myAnswers == null || myAnswers.length == 0) {
            throw new IllegalArgumentException("Array should not be empty.");
        }
        this.answers = Arrays.copyOf(myAnswers, myAnswers.length); //create a copy
    }

    /**
     * Creates the Magic8Ball using the default answers
     */
    public Magic8Ball() {
        this(DEFAULT_ANSWERS);
    }

    /**
     * Returns a random answer from the user-specified or default answer array.
     *
     * @return returns a string with a random answer from the answer (default or user-specified) array
     */
    public String getAnswer() {
        int random = new Random().nextInt(answers.length); //random number
        return answers[random];
    }
}
