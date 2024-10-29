import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This is a simple server class for exchanging character (text)
 * information with a client. The exchanges are line-based: client
 * input is expected to be a newline-terminated string of text.
 * This server processes that line and sends back a single-line
 * response. The connection terminates when the client sends an
 * empty string.
 */
public class Server
{
    // Strings sent to client.
    private static final String GREETING =
            "The Magic 8 Ball says: Please enter a yes/no question.";
    private static final String GOOD_BYE =
            "“The Magic 8 Ball says: Good bye ... Live long, and prosper.";

    // Instance variables.
    private final int port;

    /**
     * Creates a server for character-based exchanges.
     *
     * @param port the port to listen on.
     * @throws IllegalArgumentException if port not in range [1024, 49151].
     */
    public Server(int port)
            throws IllegalArgumentException
    {
        if (port < 1024 || port > 49151) {
            throw new IllegalArgumentException(
                    "Port " + port + " not in range 1024-49151.");
        }
        this.port = port;
    }

    /**
     * Starts this server, listening on the port it was
     * constructed with.
     *
     * @throws IOException if ServerSocket creation, connection
     *                     acceptance, wrapping, or IO fails.
     */
    public void start() throws IOException
    {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server starting on port " + port + "."
                    + " Ctrl+C to exit.");
            try (
                    // Wait for connection.
                    Socket clientSocket = serverSocket.accept();
                    // Build buffered reader on client socket.
                    BufferedReader fromClient =
                            new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    // Build PrintWriter on client socket.
                    PrintWriter toClient =
                            new PrintWriter(clientSocket.getOutputStream(), true)
            )
            {
                // Connection made. Greet client.
                toClient.println(GREETING);
                // Converse with client.
                String inString = fromClient.readLine();
                Magic8Ball magic8Ball = new Magic8Ball();
                while (inString != null && !inString.isEmpty()) {
//                    System.out.println(inString); //print client input in server
//                    toClient.println(inString); //send client input to client
                    System.out.println(magic8Ball.getAnswer()); //get answer from Magic8Ball & print to server
                    toClient.println(magic8Ball.getAnswer()); //print answer from Magic8Ball to client
                    inString = fromClient.readLine();
                }
                toClient.println(GOOD_BYE);
                System.out.println("Client terminated connection.");
            }   // Streams, client socket closed by try-with-resources.
        } // ServerSocket closed by try-with-resources.
    }
}
