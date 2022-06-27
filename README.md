# RicksCrate

>This is data in every dimension with a man named Rick Sanchez letting us know by his adventure with his grandson.

Rick's Crate is an application that demonstrates data on Rick and Morty animated series such as Characters from different species, character's life status, number of episodes and airing date, and locations in different dimensions. The app is based on Android Architecture Components, Paging library, and Hilt.

![Kotlin 1.7.0](https://img.shields.io/badge/Kotlin-1.7.0-7F52FF?style=for-the-badge&logo=kotlin) ![Gradle 7.3.3](https://img.shields.io/badge/Gradle-7.3.3-02303A?style=for-the-badge&logo=gradle) ![AGP 7.2.1](https://img.shields.io/badge/AGP-7.2.1-3DDC84?style=for-the-badge&logo=android)


<p align="center">
<br>
<img src="misc/RicksCrate-demo.gif" width="50%">
</p>

## Tech-stack

- Minimum Sdk level 24
- Tech-stack
  - Kotlin - based language
  - Coroutines - handle background operations
  - Jetpack
    - Lifecycle - act when lifecycle state changes
    - ViewModel - store and manage data for UI-related with lifecycle aware
    - Navigation - in-app navigation
    - Paging - load and display pages of data from local storage or over network
    - Hilt - dependency injection
  - Coil - image loading
  - Lottie - animation image
  - Retrofit - construct type-safe HTTP for networking
  - Moshi - modern JSON library for Android
  - Timber - application debugging
- UI
  - Material components - material design for UI
- Architecture
  - MVVM Architecture

## Open API
This project uses an [API](https://rickandmortyapi.com/documentation/#introduction) that provides information for the Rick and Morty animated series.

## Acknowledge & Guideline
The relevant knowledge resources inspired and guided me in this project.

### Codelab
- [Using Kotlin Coroutines in your Android App](https://developer.android.com/codelabs/kotlin-coroutines?authuser=2#0) - how to use Kotlin Coroutines in an Android app.
- [Advance Kotlin Coroutines with Flow and LiveData](https://developer.android.com/codelabs/advanced-kotlin-coroutines#0) - how to use the LiveData builder to combine Kotlin coroutines with LiveData, and using Flow a type of collection whose values are lazily produced.
- [Android Paging Basics](https://developer.android.com/codelabs/android-paging-basics#1) - how to use basics of Paging 3 library and components.

### Course
- [Developing Android Apps with Kotlin](https://classroom.udacity.com/courses/ud9012) - fundamentals of Android Development with Kotlin, essentials of Android Architecture Components, and Jetpack.

## License
```
MIT License

Copyright (c) 2022 Supol Phupuang

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```