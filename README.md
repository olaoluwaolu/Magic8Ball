<ol>
<li> Download code into IDEA.</li> 
<li> Build the project.</li>
<li> Server
   <ol>
   <li> Open a terminal/command window.</li>
   <li> cd to SocketDemo/out/production/SocketDemo</li>
   <li> Enter 'java SocketDemo' to see the usage message.</li>
   <li> Enter 'java SocketDemo server 4466' to start the server 
        on port 4466 (you can use any port in the User Ports 
        range that is not already in use on your computer).</li>
   <li> You should see a server startup message.</li>
   <li> Leave the window open.</li>
   </ol>
   </li>
<li> Client
   <ol>
   <li> Open another terminal/command window.</li>
   <li> cd to SocketDemo/out/production/SocketDemo</li>
   <li> Enter 'java SocketDemo client localhost 4466' to start 
        the client (if you used a different number for the server, 
        use that number here as well).</li>
   <li> You should see a message from the server.
   <li> Enter text from the keyboard; when you hit Enter you will 
        receive a reply.</li>
   <li> When you hit just Enter, both client and server will stop 
        with a message.</li>
   </ol>
</ol>
