# Vert.x Slides presented at Devconf.cz (2017)

These slides are a presentation about Vert.x, distributed applications, reactive systems and microservices. 

In this repo you will find the slides and the demos.

## Slides

You can get the slides as PDF here: [slides](slides-snowcamp.pdf).


## Prerequisites

You need Maven and an IDE.

## Build the slides and run them

Run:

```
mvn clean package
cd vertx-slides
java -jar target/snowcamp-distributed-applications-slides-1.0-SNAPSHOT-fat.jar -cluster
```

Slides are served on `http://localhost:9000`.

## Examples

Examples needs to be imported in your IDE. Add the `lib` directory to your classpath as well as the `etc` directory. 
Each example has a `main`  method you just need to _run_ from your IDE.





