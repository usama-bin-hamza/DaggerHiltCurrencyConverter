# DaggerHiltCurrencyConverter
Hilt Clean Architecture | Kotlin | MVVM | Coroutines | Retrofit | Binding | Flow

This project was made with the objective of creating a base structure for new apps, using tools and components supported by Google and by most of the Android development community.

Clean Architecture

Clean architecture promotes separation of concerns, making the code loosely coupled. This results in a more testable and flexible code. 

MVVM

The Model View ViewModel pattern helps with the separation of concerns, dividing the user interface with the logic behind. The decision to use this pattern is mainly based on the support Google has been giving to it. Not only they have created a ViewModel class to use as a parent to the viewmodels, there is also a huge use of the pattern in official Android presentations and samples. Moreover, MVVM is vastly used in today’s Android development, and combines very well with Android Architecture Components like LiveData and DataBindings.

Model
As we are implementing MVVM alongside with Clean Architecture, we decided not to have a model class per se. The ViewModel interacts directly with the domain, utilizing the use cases.

View Model
The orchestrator of the relationship between the data and the user interface of the application. The ViewModel has the logic to convert what the use cases provide into information that the view can understand and present. Furthermore, it has the logic to react to the user’s input, and call the pertinent use cases.

The most useful part of the Android’s ViewModel class is its lifecycle consciousness. It only communicates to the View with LiveData components, so it’s totally agnostic of contexts and activities: it can keep the information alive even against configuration changes like screen rotations or calls to background.

View
The view in our implementation of MVVM is actually a Fragment or an Activity. The views enclose everything needed to handle the user interface. They observe the ViewModel, using LiveData components, and react to its changes as they need to.

Coroutines

Coroutines are a new way of managing background threads that can simplify code by reducing the need for callbacks. They convert async callbacks for long-running tasks, such as database or network access, into sequential code. We use coroutines to do tasks in a background thread. This goes very well with the idea of use cases, single actions that the ViewModel calls depending of its needs. The guideline should be that every task executed by a use case should be done in a background thread, so, in the main thread, we could show a loading screen or any alternative, and the UI doesn’t get blocked.

Job: a job is a cancellable task with a life-cycle that culminates in its completion. By default, a failure of any of the job’s children leads to an immediate failure of its parent and cancellation of the rest of its children. This behavior can be customized using SupervisorJob.

Dispatchers:

Dispatchers.Default – is used by all standard builders by default. It uses a common pool of shared background threads. This is an appropriate choice for compute-intensive coroutines that consume CPU resources.
Dispatchers.IO – uses a shared pool of on-demand created threads and is designed for offloading of IO-intensive blocking operations (like file I/O and blocking socket I/O).

Other concepts

