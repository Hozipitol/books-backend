# books-backend

Download the zip file of the repository and extract in your computer.
Open the extracted file in IntellijIdea so it will automatically start to install all the dependencies that are needed to run the file.
Once the dependencies are installed, Kindly start your mysql workbench and login with your username and password. Then a create a database named fullstack.

In application.properties file which is in src->main->resources->application properties. Open it and changed the required information that is stated below ->

spring.datasource.url=jdbc:mysql://localhost:3306/fullstack
(If you use any other database name, please write that database name innstead of fullstack in the above line)
spring.datasource.username=root
OR
spring.datasource.username=//Your Username//
If you are not logging in with your root id username, please mention your username by which you are connecting.
spring.datasource.password=//Your password//
Provide your password here.
*Keep the rest of the lines as it is.*
I have used port number 8081 as my prefernce, if anyone wants to change it they can. I would still not prefer it as in all th link I have used port number 8081, so changiong the port number might cause problem.

That's all. Run the server now once connected successfully with the database.

