# Sonarqube instruction manual

To run `Sonarqube` on this gradle project, you need to have a running `Sonarqube` server on your local machine. Instructions can be found here:
<https://docs.sonarqube.org/latest/setup/get-started-2-minutes/>

Once you are completed with the installation, start up the server, login and go to the following path: 

**Administration > Configuration > General Settings > Security** 

and disable the **Force user authentication** property. This is to simplify the process.

Now you just need to run the sonarqube Gradle task to run a scan, with `./gradlew sonarqube`