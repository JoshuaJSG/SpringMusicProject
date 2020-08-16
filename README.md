#What is this project ?
This project allows users to search their favourite musical artists and to be returned a list of some of their great songs, you can add these songs and artists to my database and also delete them through the use of the buttons provided on the user interface.

#How to use this project

###Options

    1. Once project is being ran, either through it being cloned or through launching the application from a .jar file.
        If you decide to run a .jar file, run the command "java -jar <APPLICATION_NAME.jar> in your terminal where the .jar file is located and access localhost:8080/artists to view data. 
        If you decide to clone the project, you can run it as normal in your own integrated development environment.
        go to your browser and search localhost:8080/artists.
     
    2. Once the project has been cloned, start the springboot server (I use Intellij), then locate to the 'myproject' directory.
    
    Working directory path is: 'JSGApplication/src/main/java/com/JSG/JSGApplication/myproject'
    and run 'yarn start' to run the back end sever which is ran on port 3000, this will load the front end application on localhost:3000
    I hope you enjoy my project!
    
    
    3. For those wanting to use Postman or Insomnia. Choose one of the following examples.
       Get artists localhost:8080/artists "This displays all artists"
       Get by id localhost:8080/artists/1 "This gets an artist by their id"
       Post a new artist localhost:8080/artists "This adds a new artist"
       Updates an artist localhost:8080/artists "This updates an artist by name and songs".
       

Note: You must have yarn installed on your terminal in order to run the back end server.
