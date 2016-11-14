# Vert.x Slides presented in some BBL and other informal gatherings

These slides are a presentation about Vert.x, distributed applications, reactive systems and microservices. 

In this repo you will find the slides and the demos.

## Slides

You can get the slides as PDF here: [slides](vertx-bbl-2016-slides.pdf).


## Prerequisites

You need Maven and an IDE.

## Build the slides and run them

Run:

```
mvn clean package
cd vertx-slides
java -jar target/vertx-bbl-slides-1.0-SNAPSHOT-fat.jar -cluster 
```

Slides are served on `http://localhost:9000`.

## Examples

Examples needs to be imported in your IDE. add the `libs` directory to your classpath. Each example has a `main` 
method you just need to _run_.





