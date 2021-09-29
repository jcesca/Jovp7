# Applications
- ```gio-game``` is the server
- ```gio-game-client``` is the client

# Versions
- Java 8

# Technologies Used and why
- Server Side:
  - Spring Boot: a quick way to implement a web server. Works well for this kind of challenge as it provides a ready solution that integrates JUnit tests, Maven, Tomcat etc. 
  - Maven: easy to track/resolve any dependency and to build the JAR files.
  - JUnit: standard approach for Unit Tests.
- Client Side:
  - java.net.HttpURLConnection: being used as a simple way to client perform HTTP requests to server as can be seen at the GameServerAPI.java on gio-game-client class.
  
# Each application must be installed with Maven
- Navigate to each application directory using terminal. There is a pom.xml for the server side and one for the client side.
- Run the command: ```mvn clean install```. This command runs the unit tests and generate the jar files.
- A "target" directory will be created where you can find the jar files.

# How to run (on terminal)
1. Open CMD terminal and navigate to the target directory.
2. Enter the following command: ```java -jar gio-game-1.0.jar``` - to start the server
3. Enter the command: ```java -jar gio-game-client-1.0.jar``` (this will have to be executed twice - on the same computer)
4. Follow the steps on the terminal and start to play!
5. Note: webserver is running on port 8080, which can not be used by other applications while playing the gane.

# Additional Implementations
- Code is handling well the board validations, player turns, winning and tie results.
- Server cleansup after both clients disconnect, there is no need to restart the server to run again and play.
- Checks if someone wins on each play, by analysing the disc being played and not all the board each time.
- While a game is ongoing, a new client can not connect.
- When adding a disc, application is checking for out of bounds and overflow (too many discs on the same position).
- Unit tests made by class (Board and Game), focusing on the class purpouse (and not simply validating method by method).
- On Client side, created a class that serves as an API to the game server. Instead of writing an HTTP request at each call, main code calls the methods that translate the commands to HTTP requests. This isolates the communication from the rest of the code.

# Future Work
- Do more unit tests on client side. This will require mocking some classes. For now, Client side needs to be tested manually.
- Client and server must be running on the same computer because Client is pointing to ```http://localhost:8080/```. In the future, this can be modified to get the server address from user input.
- Game is not ending if a client disconnects. Couldn't figure out a good solution with HTTP requests. Needs more research.
- Game.addDisc method code is repetitive and should be refactored if had more time. Although, works well and fits its purpouse.
- Client/Server communication could use JSON, as this is a standard practice on Web Servers.



