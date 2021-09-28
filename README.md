# Applications
- gio-game is the server
- gio-game-client is the client

# Versions
- Java 8

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
- Only Server side has unit tests (Board and Game classes), Client side needed to be tested manually, due the nature of the application.
- Client and server must be running on the same computer. Client is pointing to localhost. In the future, this can be modified to get the server address from user input.
- Game is not ending if a client disconnects. Couldn't figure out a good solution with HTTP requests. Needs more research.
- I'm not happy with the structure of Game.addDisc method. Code is repetitive and should be refactored if had more time.


