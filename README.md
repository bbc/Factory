# Factory

This almost certainly won't compile as is.

It's a Processing project done using NetBeans rather than the PDE so there are a bunch of changes that needed to be made for that
(mostly having to pass the PApplet into lower classes).

It's also missing a build script. I've been using NetBeans, "New Project" > "Java" > "Java Project With Existing Sources"

I will try and make this better, using maven or whatever, but some of the libraries aren't available that way.

Anyway, the project allows you to create diagrams of systems and have messages passing through them. I'll add a screenshot.

Libraries
=========

I use the following libraries. Add them to your netbeans project (I copy all mine into a single directory for ease):

* core.jar - from Processing distribution
* gluegen-rt-natives-macosx-universal.jar - from Processing distribution
* gluegen-rt.jar - from Processing distribution
* jogl-all-natives-macosx-universal.jar - from Processing distribution
* jogl-all.jar - from Processing distribution
* peasy-math.jar - from Processing PeasyCam libray
* peasycam.jar - from Processing PeasyCam libray
* slf4j-api-1.7.21.jar - standard slf4j library
* slf4j-simple-1.7.21.jar - standard slf4j library

