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
            "Welcome to the echo server. Press just ENTER to end session.";
    private static final String GOOD_BYE =
            "Ending echo server session.";

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
                    InputStream inStream = clientSocket.getInputStream();
                    InputStreamReader inStreamReader =
                            new InputStreamReader(inStream);
                    BufferedReader fromClient =
                            new BufferedReader(inStreamReader);
                    // Build PrintWriter on client socket.
                    OutputStream outStream = clientSocket.getOutputStream();
                    PrintWriter toClient =
                            new PrintWriter(outStream, true)
            )
            {
                // Connection made. Greet client.
                toClient.println(GREETING);
                // Converse with client.
                String inString = fromClient.readLine();
                while (inString != null && !inString.isEmpty()) {
                    System.out.println(inString);
                    toClient.println(inString);
                    inString = fromClient.readLine();
                }
                toClient.println(GOOD_BYE);
                System.out.println("Client terminated connection.");
            }   // Streams, client socket closed by try-with-resources.
        } // ServerSocket closed by try-with-resources.
    }
}
