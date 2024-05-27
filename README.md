# location-update-task

## Project files overview
Project Overview
Please Read [https://github.com/La-Volpe/location-update-task/issues/1](this) for the overview of the task
Architecture and Layers

## Architecture Overview
The project follows a layered architecture approach with a clear separation of concerns, ensuring that each layer is responsible for a specific part of the application's functionality. The main layers in this project include:

- Presentation Layer: Handles the UI and user interaction.
- Domain Layer: Contains business logic and interacts with the data layer. 
- Data Layer: Manages data operations and interacts with remote and local data sources.
### Layers Mechanism
Presentation Layer: Composed of Activities and ViewModels. The HomeViewModel class, for instance, is responsible for preparing data for the UI.
Domain Layer: Not exactly implemented but would include use cases that encapsulate specific business logic. These use cases are called by the ViewModels. Idealy, It would have a use case and implementation classes covering the part of the app that handles the data fetching operations, etc.
Data Layer: Contains repositories that manage data operations. The repositories interact with data sources, such as remote APIs via Retrofit and other raw datas.

## Technologies Used
The project utilizes a range of modern Android development technologies, including but not limited to:
Kotlin: The primary programming language used in the project.
Hilt: For dependency injection, providing a consistent way to manage dependencies throughout the app.
Retrofit: For making network requests to fetch weather data from a remote API.
Jetpack Compose: For building the UI using a declarative approach and intuitive animation.
Coroutines: For asynchronous programming, making it easier to handle background tasks.

## Further improvements:
Ideally I would love to have the following features implemented in the app if there was more time (maybe I do it, the idea was fun):
- Background handling with WorkManager. The app would fetch the weather info in the background using WorkManager, write them into a database so that whenever the app is opened, it reads from there first. This would make the opening of the app rather smooth.
- Furthur loose-coupling the app. Implementing a repository pattern would make the app more robust and changing data sources would be easier.
- After doing the above, writing tests for both the api using a mocked approach as well as writing test for the logic of progress bar and repetition of looping through the cities
- Completing the Setting section for user's customization.
- Ask for user's location permission and if they consent, Adding and 11th location to the list which would be user's own real location.
- Adding a detail screen for the cities so that user can see a more detailed forecast (7 day forecast, sunrise, sunset, etc)

