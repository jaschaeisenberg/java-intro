package exercise_04;

import java.io.IOException;

import exercise_04.WebServer.RequestHandler;

public class HelloWorldWebserver {

  public static void main(String[] args) throws IOException {
    WebServer webServer = new WebServer("localhost", 8080);
    webServer.registerHandler(new RequestHandler() {

      @Override
      public String handle(String query) {

        // Currently, this web server just returns 'Hello', when you use a browser to surf to the page.
        return "Hello " + query;

        // Make it a little more interesting:

        // Return the current time. Can you find out how to do it? (Hint: There is a 'Date' class.)

        
        
        
        
        
        // Return a random number from 1 to 6 (a dice).

        
        
        
        
        
        // Return a random number from 0 to the number provided as query:
        // http://localhost:8080/38 would generate a number between 0 and 38.

      }

    });

    webServer.startServer();
  }

}