import java.util.Random;

/**
 * Main program. Based on command-line arguments (see USAGE
 * string), creates and starts either a client or a server.
 * To use, create a single server on a given host and port.
 * Clients (possibly multiple) can then be created, each in
 * their own terminal/command window. The client can accept
 * "localhost" as a server name. If a client cannot connect
 * to a server on a remote host, check firewall settings on
 * the host.
 * <p>
 * The usage message assumes this program has been built as
 * a jar file. IDEs vary in how they do this; check the IDE
 * documentation.
 */
public class Magic8BallDemo
{
    private final static String USAGE =
                "Usage: java SocketDemo client <server name> <server port>\n"
              + "       java SocketDemo server <server port>\n"
              + "    where <server port> is in the range 1024-49151.";

    public static void main(String[] args)
    {
        if (args.length < 2) {
            System.err.println(USAGE);
        } else if (args.length == 2
                && args[0].equalsIgnoreCase("server"))
        {
            try {
                int port = Integer.parseInt(args[1]);
                Server server = new Server(port);
                server.start();
            } catch (NumberFormatException e) {
                System.err.println(args[1] + " cannot be parsed as an int.");
                System.err.println(USAGE);
            } catch (Exception e) {
                System.err.println(e.getMessage());
                System.err.println(USAGE);
            }
        } else if (args.length == 3
                && args[0].equalsIgnoreCase("client"))
        {
            try {
                String serverName = args[1];
                int port = Integer.parseInt(args[2]);
                Client client = new Client(serverName, port);
                client.start();
            } catch (NumberFormatException e) {
                System.err.println(args[2] + " cannot be parsed as an int.");
                System.err.println(USAGE);
            } catch (Exception e) {
                System.err.println(e.getMessage());
                System.err.println(USAGE);
            }
        } else {
            System.err.println(USAGE);
        }
    }
}
