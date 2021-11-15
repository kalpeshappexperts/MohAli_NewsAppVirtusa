
# Breaking News App
The application displays articles and breaking news headlines from news sources and blogs across the web
API used from public list: https://newsapi.org/ 

#Features:
1 On application launch displays the latest news articles
2 On click of any news item, display details view of the particular news 
3 User can enter specific keyword to search for news
example when user enters keyword Bitcoin in search textview; the app will make an API call to get all news relating to the search keyword 
4 User can add news to favorite to view news later and in offline mode 

## API key 🔑
Have add my own key but if required; you'll need to provide API key to fetch the news from the [NewsAPI](https://newsapi.org/)

# Software Development Approach
This software was developed using an Agile and TDD methodology

# Screenshots
![Alt text](app/docs/images/HomeScreen.png?raw=true “Breaking News”) 
![Alt text](app/docs/images/NewsDetails.png?raw=true “Detail News”) 
![Alt text](app/docs/images/SearchNews.png?raw=true “Search News”) 
![Alt text](app/docs/images/Favourtite.png?raw=true “Favourtitle News”)


# Libraries Used
- Hilt dependency injection to standardizes the component hierarchy. This means that libraries that integrate with Hilt can easily add or consume bindings from these known components. Hilt provides a standard way to do DI injection in your application by providing containers to every Android component in your project and managing the container's lifecycle automatically for you
- Retrofit, okhttp  to provide access to the backend API endpoints
- Coroutines to run API network requests on background threads. Coroutines stick to a thread, and as soon as suspension point is reached, it leaves the Thread and frees it up letting it to pick up another coroutine if it is waiting. This way with less threads and less memory usage, that much concurrent work can be done
- AndroidX to provide Lifecycle and LiveData functionality to the app
- Room to store the news responses from Retrofit and coroutines.
- Data binding to bind the inflated layout files to instances running in the application code.
- Espresso to perform instrumentation tests on the user interface
- Mockito to mock the ViewModel and Repository classes

# Architecture Design
The Project follows a MVVM with Repository pattern architecture. This architecture was chosen for:
- Seperation of Concerns that provides a way to testing the architecture components in isolation and allows for the View classes to be updated without modifying the ViewModel classes.
- Resilience to configuration changes allows the ViewModel classes to store UI data that would otherwise be lost on screen rotation or activity lifecycle changes.
- Communication between fragments using a ViewModel class removes the need for fragments to communicate via an Activity using callbacks.
Livedata: Unlike a regular observable, LiveData is lifecycle-aware, meaning it respects the lifecycle of other app components, such as activities, fragments, or services. This awareness ensures LiveData only updates app component observers that are in an active lifecycle state. This awareness ensures LiveData only updates app component observers that are in an active lifecycle state.

Viewmodel:  ViewModel objects are also lifecycle-aware. They are automatically cleared when the Lifecycle they are observing gets permanently destroyed.
The purpose of the ViewModel is to acquire and keep the information that is necessary for an Activity or a Fragment. The Activity or the Fragment should be able to observe changes in the ViewModel. ViewModels usually expose this information via LiveData or Android Data Binding.
The View classes use data binding to communicate updates to their respective ViewModel classes. The ViewModel classes communicate with a Repository class using coroutines and receives responses using LiveData. This is then passed back to the View classes observing this LiveData. The Repository class communicates with a RESTful API using Retrofit and caches the response to a local Room database.

# Repository pattern: 
A repository module handles data operations and allows you to use multiple backends. 
In a typical real-world app, the repository implements the logic for deciding whether to fetch data from a network or use results that are cached in a local database. 
This helps make your code modular and testable. 
You can easily mock up the repository and test the rest of the code.
Your Room database doesn't have logic for managing the offline cache, it only has methods to insert and retrieve the data. 
The repository will have the logic to fetch the network results and to keep the database up-to-date.


![](https://developer.android.com/topic/libraries/architecture/images/final-architecture.png)

