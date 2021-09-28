# Applications
- gio-game is the server
- gio-game-client is the client

# Versions
- Java 8

# Technologies Used (and why)
- Server Side:
  - Spring Boot: quick way to bring up a web server. Perfect for this kind of problem. I don't have too much experience with it, but was enough to make the application work.
  - Maven: easy to track/resolve any dependency and to build the JAR files.
  - JUnit: standard approach for Unit Tests.
  - java.net.HttpURLConnection: being used as a simple way to client perform HTTP requests to server (see GameServerAPI.java on gio-game-client).

# Each application must be installed with Maven
- Navigate to each application directory using terminal (there is a pom.xml inside it)
- Run the command: mvn clean install (this command runs the unit tests and generate the jar files)
- A target directory will be created where you can find the jar files

# How to run (on terminal)
- Server (from the target directory described above): java -jar gio-game-1.0.jar
- Client (from the target directory described above): java -jar gio-game-client-1.0.jar (this will have to be executed twice)

# Additional Implementations
- Code is handling well, board validations, player turns, winning/tie results.
- Server cleansup after both clients disconnect, so don't need to restart the server to run again.
- Checks on if there is a winner are happening on each play, and only related to the disc being played. This is much smarter than iterating all positions on the board.
- While a game is ongoing, a new client can't connect.
- When adding a disc, application is checking for out of bounds and overflow (too many discs on the same position).

# Future Work
- Only Server side has unit tests (Board and Game classes), Client side needed to be tested manually, due the nature of the application. Unit tests made by class, trying to focus on the class purpouse (and not simply validating method by method).
- Client and server must be running on the same computer. Client is pointing to localhost. In the future, this can be modified to get the server address from user input.
- Game is not ending if a client disconnects. Couldn't figure out a good solution with HTTP requests. Needs more research.
- I'm not happy with the structure of Game.addDisc method. Code is repetitive and should be refactored if had more time.
- Client/Server communication should use JSON.
- On Client side, created a class that serves as an API to the game server. Instead of writing an HTTP request at each call, main code calls the methods that translate the commands to HTTP requests. This isolate the communication from the rest of the code.


