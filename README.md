## Synopsis

This project is a simple JavaFx application that calculates the area of a rectangle.  Really its more about a first foray into using JavaFx.  Learning points for me were :

* Adding a button node to a root node and having it span multiple columns does not work unless you untether the objects     preferred size by calling setMaxSize() on the object.

* You can set horizontal alignment for a whole row by calling setHalignment(nodeName, HposValue) on your GridPane static object as opposed to the grid instance itself.

## Code Example

![screen shot 2017-10-27 at 18 17 19](https://user-images.githubusercontent.com/17004808/32116738-c758887e-bb43-11e7-9f02-1cea126c19cc.png)

## Motivation

This code forms part of a lab I have submitted for my computer science course.

## Installation

Clone, compile and run.

## API Reference

https://docs.oracle.com/javase/8/javafx/api/toc.htm

## Tests
There are no tests.

## License

This project is licensed under the MIT License
