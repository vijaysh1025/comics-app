## Build tools & versions used
Build tools = 34.0.0
Gradle = 8.3-rc2

## Steps to run the app
* Opened, built and ran app using Android Studio Iguana | 2023.2.1 Canary 6.

## What areas of the app did you focus on?
* I mainly focused on architecture and testing. Tried to adhere to MVVM and Repo architecture using interfaces between data an ui layers to make testing easier.
* Also focused on making sure there were no unnecessary network calls for fetching data or images
* On a separate note, I do enjoy building challenging UI with animations.

## What was the reason for your focus? What problems were you trying to solve?
* By building the data layer properly, I was able to write clear unit tests for the repo and make sure I was able to handle the following requirements
  ** load from remote on launch and user triggered refresh
  ** load from cache in all other cases (ie. configuration change)
  ** load from cache if one exists when remote fetch fails
  ** send failure when fetch fails and no cache available
* Similarly the setup of the viewmodel allowed me to test that the correct data was sent to the UI and requirements were met.
  ** Successful list from repo -> generate Success UI State -> Show list in UI
  ** Empty list from repo -> generate Empty UI State -> Show empty state message
  ** Failure message from repo -> generate Failure UI State -> Show failure message
* Tested above scenarios using the various urls (normal, malformed, and empty) given.
* Using coil, I setup the image loader so images were cached on disk after first load. Tested by attaching a logger to the image loader.

## How long did you spend on this project?
5 hours

## Did you make any trade-offs for this project? What would you have done differently with more time?
With more time, I definitely would have spent time refining the UI to make it look better.

## What do you think is the weakest part of your project?
The UI could definitely be better. My code commenting could also be improved.

## Did you copy any code or dependencies? Please make sure to attribute them here!
* CallAdapter logic was taken from another personal project I have been working on.
* Definitly used a bunch of libraries to make life easier
  ** Retrofit, Turbine -> Square
  ** Coil -> Instacart

## Is there any other information you’d like us to know?
* I enjoy learning from others and sharing what my knowledge with others.