# LittleLemon Restaurant Menu App

LittleLemon is a restaurant menu app built using Kotlin and Jetpack Compose. It follows the MVVM architecture pattern and incorporates Material Design principles for a modern and intuitive user experience. The app retrieves dish information from Firebase Firestore and displays it in a user-friendly manner.

## Features

- Browse a list of dishes available at LittleLemon restaurant.
- View detailed information about each dish, including name, description, price, and an image.
- Navigate between the Menu Screen and the Dish Details Screen.
- Data is fetched from Firebase Firestore using the FirebaseDishRepository implementation.
- Dependency injection is handled using Hilt.

## Screenshots

[Add relevant screenshots of your app here]

## Tech Stack

- Kotlin as the programming language
- Jetpack Compose for building the user interface
- MVVM architecture for separation of concerns
- Firebase Firestore as the backend database
- Hilt for dependency injection
- Coil for image loading and caching

## Project Structure

The project follows a modular structure, separating concerns into different packages. Here's an overview of the key components:


- **app**: Contains the main entry point and configuration of the app. 
- **data**: Holds the data-related classes, including the repository implementations and data models.
- **di**: Holds the dependency injection-related classes.
- **domain**: Contains the interfaces.
- **ui**: Contains the user interface components, screens, and view models used to display data to the user.

## Setup Instructions

To run the LittleLemon app locally, follow these steps:

1. Clone the repository to your local machine.

```
git clone https://github.com/TheAntiFlash/LittleLemon_MVVM-Hilt-Firebase
```

2. Open the project in Android Studio.

3. Build and run the app on an emulator or physical device.


## Building and Testing

To build the app, simply use the build command in Android Studio or run the following command in your project's root directory:

```
./gradlew build
```

To run unit tests, execute the following command:

```
./gradlew test
```
## Contributors

- [Yahya Bin Naveed](https://github.com/TheAntiFlash) (Me)
- [Hamza Afzal](https://github.com/introvertNerd00)

## Acknowledgments

- [Jetpack Compose Documentation](https://developer.android.com/jetpack/compose)
- [Firebase Documentation](https://firebase.google.com/docs)
- [Hilt Documentation](https://dagger.dev/hilt/)
- [Material Design Guidelines](https://material.io/design)

---
