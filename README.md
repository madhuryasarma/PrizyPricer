# PrizyPricer
The company ‘Prizy’ wants to start conducting surveys of prices for different products, and then based on the collected information, calculate an ‘Ideal Price’ for a product. 

##Steps to run tests and generate build:
1. Run following command from Project root directory
```
    mvn clean package
```
2. Copy `prizy-pricer.war` file from `target` folder to Tomcat-Installation's `webapps` Directory.
3. Run `bin/startup.bat` from Tomcat Directory and wait for Server to start.
4. Navigate to http://localhost:8080/prizy-pricer/index.jsp from your Browser.
