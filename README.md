XMindAPI
========
This small project contains a few samples using the
[XMind](http://www.xmind.net) APIs to generate XMind files.  As I
integrated XMind support into other tools, I kept needing to make a
simple sample to figure out how some feature worked.  I decided to start
collecting them for others to use.

Please see the
[API documentation on the Xmind wiki](https://github.com/xmindltd/xmind/wiki/UsingXmindAPI)
for information about how to use the API.  I don't work on the team
creating this wonderful project, I'm just a user.

Note that this requires the actual XMind jars to work.  I have included
two jars in the lib directory, since the XMind team does not seem to publish
their jars to a public repository.
* org.xmind.core_3.6.1.jar
* org.xmind.ui.mindmap_3.6.1.jar

Most features only need the core jar.  The ui jar is only needed if you
are manipulating styles.

License
-------

These samples are licensed under the
[Eclipse Public License (EPL) v1.0](http://www.eclipse.org/legal/epl-v10.html).

How To Build
------------
These samples include a gradle build file and wrapper.  Use the provided
gradlew file to create a project for your IDE or a command line runner
for the samples.  You will need to have a Java 8 SDK installed and your
JAVA_HOME environment variable set.

Run "gradlew idea" to generate a project for [IntelliJ Idea](https://www.jetbrains.com/idea/)
Run "gradlew eclipse" to generate a project for [Eclipse](https://eclipse.org/ide/).

Run "gradlew installDist" to build a runnable sample in the build/install/xmindapi
directory.  From that directory you may run the examples using **bin/xmindapi**.

Running
-------
The launcher takes a parameter specifying the sample to run.  If you
provide no parameters, it displays the samples available.
```
>bin\xmindapi
Missing argument.  Please specify a sample to run.
simpletree - Creates a simple map two levels deep and sets the structure
custommarker - Adds a custom marker to the root topic
markthrough - Demonstrates the markthrough style
importfails - Tries (unsuccesfully) to use IMakerSheet.importFrom to import markers
```