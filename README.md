# JokesApp

This app is created as a part of Android Developer Nanodegree Program. I built this app with multiple flavors that uses
multiple libraries and Google Cloud Endpoints. The app consists of four modules. A Java library that provides jokes, a Google Cloud Endpoints (GCE) project that serves those jokes, an Android Library containing an activity for displaying jokes, and an Android app that fetches jokes from the GCE module and passes them to the Android Library for display.

The diagram of the app is as the following:

<img src="../master/img/diagram.png" alt="alt text" width="800">

## What I Learned

* Add free and paid flavors to an app, and set up the build to share code between them
* Factor reusable functionality into a Java library
* Factor reusable Android functionality into an Android library
* Configure a multi project build to compile the libraries and app
* Use the Gradle App Engine plugin to deploy a backend
* Configure an integration test suite that runs against the local App Engine development server
