# producteev-scala

producteev-scala is an API wrapper for the online task management [Producteev](http://www.producteev.com/), written in
[Scala](http://www.scala-lang.org/).
At the moment most of the API is supported by producteev-scala.

## Building with sbt (simple build tool)

For now I only got the whole thing working with sbt 0.10.1

To compile the source and perform the tests run

        sbt compile
        sbt test

To create a jar file run

        sbt package

## Building with ant

Just run

        ant build 

to compile the source and run the tests

## Use producteev-scala

The main entry point for the API is src/main/scala/org/producteev/Producteev.scala.
For example usage just have a look at the tests in src/test/scala/org/producteev/ProducteevSpec.scala
and src/test/scala/org/producteev/SmokeSpec.scala.

You will need an API key, which you can request [here](http://www.producteev.com/developers/)
