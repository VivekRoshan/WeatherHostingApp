# Weather UI.
##Cloud-Computing Assignment-3

###Note: Please install cors extension for chrome in order not to get the cross-domain(allow control allow origin) error.

The project is developed using J2EE (dynamic web project) in eclipse. All the weather information is stored in daily.csv and is accessed the data in java. <br>
The project is developed using rest api-which is implemented through jersey framework in the back-end.<br>
The project is developed using HTML,CSS,jQuery for the front end.<br>

###back-end: <br>
http://suggalvn.online:8080/WeatherHosting/rest/ReportService/forecast/20170228 -- GET method  <br>
This method is useful to forecast the weather for the next 7 days.<br>
External API used : darksky.api<br>
O/P : weather forecast data for seven days<br>

###front-end<br>
home page: http://suggalvn.online:8080/WeatherHostingAPI/index.html<br>
Give a valid date in the date field present in the home page of the project. <br>
In order to get the forecast from the logic already written from the back-end, click on the first button, "Forecast".<br>
In order to get the forecast from the 3rd party API, click on the second button, "Forecast-Bonus".<br>
You will be able to view different graphs accordingly.<br>


###->Technologies and tools used:<br>
Eclipse neon EE, Java Rest full Web services, HTML, CSS, Javascript(JQuery), Tomcat Server, Postmaster.<br>

###->DEPLOYMENT<br>
Deployed the project in Amazon EC2 Linux instance and executed on tomcat server.<br>
