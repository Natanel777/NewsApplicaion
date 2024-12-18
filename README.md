# News Application

![Build Status](https://img.shields.io/badge/Build-Passing-green) ![Kotlin](https://img.shields.io/badge/Language-Kotlin-blue)

News Application is a modern Android application that delivers top headlines from various countries using the [News API](https://newsapi.org/).
The application is written in Kotlin and follows Clean Architecture principles, showcasing a range of best practices and modern Android development tools.

## Table of Contents
- [Features](#features)
- [Screenshots](#screenshots)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)

## Features
- Fetch and display the top headlines from various countries.
- Smooth and responsive UI with Jetpack Compose.
- Navigation using Navigation Compose.
- Dependency Injection with Dagger Hilt.
- Network requests with Retrofit and OkHttp.
- Image loading with Coil.
- Coroutines for asynchronous operations.
- State management with StateHolder.
- Flow for reactive programming.

## Screenshots

| ![Screen1](screenShots/news1.jpg) | ![Screen2](screenShots/news2.jpg) | ![Screen3](screenShots/news3.jpg) | ![Screen4](screenShots/news4.jpg) |
|:---------------------------------:|:---------------------------------:|:---------------------------------:|:---------------------------------:|




## Technologies Used
- [Kotlin](https://kotlinlang.org/)
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Navigation Compose](https://developer.android.com/jetpack/compose/navigation)
- [Dagger Hilt](https://dagger.dev/hilt/)
- [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
- [Retrofit](https://square.github.io/retrofit/)
- [OkHttp](https://square.github.io/okhttp/)
- [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)
- [Coil](https://coil-kt.github.io/coil/)
- [Kotlin Flow](https://kotlinlang.org/docs/flow.html)

## Getting Started
1. Clone the repository:
   ```sh
   git clone https://github.com/Natanel777/NewsApplicaion.git
   ```
2. Obtain your API key from News API:
    - Go to [News API](https://newsapi.org/register) and register for an account if you don't have one.
    - Once registered and logged in, navigate to your account dashboard or visit [this link](https://newsapi.org/account).
    - Under the `API Keys` section, you can find your API key or generate a new one if needed.

3. Open the project in Android Studio.

4. Locate the `ApiService` class and replace the placeholder API_KEY in the endpoint URL with your actual API key. Ensure that you are passing the appropriate country code as a parameter in the API request.

5. Run the project on an emulator or a physical device.
