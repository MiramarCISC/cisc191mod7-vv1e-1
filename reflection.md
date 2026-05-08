# Module 7 Lab Reflection 

### What is the purpose of FXML in this project?
> The purpose of FXML is to decouple the view of the JavaFX client from the code making up the client application.

### What is the controller responsible for?
> The controller is responsible for implementing the functionality of the JavaFX window.

### What is the model responsible for?
> The model serves as the primary way of managing data and business logic in the program.

### What is the gRPC server responsible for?
> The gRPC server is responsible for providing data about current matches (if any) to the game client.

### Why should JavaFX network calls run inside a Task instead of directly in the button handler?
> It is best practice that the UI and logic / I/O inhabit separate threads.
> Having the JavaFX network calls run inside a Task allows the UI to continue to operate and respond to user input while the client awaits a response. 
> If the network call was made in the button handler, the application would feel highly unresponsive.

### What changed in the `.proto` file?
> The JoinMatchResponse inside the `.proto` file now provides a match summary.

### Why do both the client and server need matching .proto files?
> The client and server sharing .proto files ensures that they both communicate in the same "language"—i.e. this guarantees that the client can talk to and understand the server and vice versa.

### What does Maven regenerate after a `.proto` change?
> After a `.proto` change, Maven regenerates `.class` files for the protobufs in order to allow the Java code to use them.

### How did you complete the FXML TODO?
> I completed the FXML TODO by adding the required Summary `Label` to the FXML file.

### How did you complete the MVC/model TODO?
> I completed the MVC/model TODO by implementing the `buildMatchSummary()` method responsible for creating short summaries of matches and making the incrementing of the completed match counter thread-safe.

### How did you complete the controller TODO?
> I completed the controller TODO by decoupling the logging of joined matches from the `joinMatch()` method and implementing the `runOnFxThread()` helper method to be able to directly manipulate JavaFX state later.

### How did you complete the gRPC client TODO?
> I completed the gRPC client TODO by decoupling the join match request from the `joinMatchTask()` method and adding the `summary` parameter in its corresponding `.proto` file. 

### How did you complete the gRPC server TODO?
> I completed the gRPC server to do by adding the `summary` parameter in its corresponding `.proto` file, decoupling the summary from `joinMatch()`, and making match statistic incrementing thread-safe.

### How did you make the model completed-match counter thread-safe?
> The completed match counter uses the `AtomicInteger` class in order to guarantee that every method call increments it only once without overriding any concurrent attempts.

### How did you make JavaFX UI updates safe from background threads?
> I made JavaFX UI updates safe from background threads by scheduling updates using the `Platform.runLater()` and `runOnFxThread()` helper methods, in order to ensure that UI update calls from background threads do not happen simultaneously.

### How did you make server statistics safe for concurrent gRPC requests?
> The server statistics use the `AtomicInteger` class in order to ensure that incrementable statistics are incremented once per method call. 

### Which unit test helped you the most, and why?
> The `java.edu.cisc191.controller.GameControllerTest.buildJoinLogMessageTrimsAndDefaultsInput` unit test helped me the most, as it helped remind me to properly implement both the formatting and default values for `buildJoinLogMessage()`.
