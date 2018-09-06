# weather_Forecast_API

The repository has both the client and server side code. the client folder has all the front-end code.
The application is used to predict the weather of the next seven days from a given date(inclusive), it compares the weather generated from raw data(daliy.csv) with DarkSky third party API.

Technology stack:  
Java  
Springboot  
SpringMVC  
MongoDB  
AWS  
Apache2  
HTML5  
JavaScript  
CSS  
Bootstrap  
Docker  


The website plots a graph of Max and Min temp of Our as well as the third party's API, used https://www.gstatic.com/charts/loader.js for visualization.

The technology used in developing the client side are:
* Javascript
* HTML
* CSS
* Bootstrap
* AJAX
* Google's Visualization API

To get the thirdparty API results, a server call is made, this function/API accepts the request from the client and calls the third party API and returns the result.
The primary reason of introducing this was to avoid the CORS error, which occurs when we try to access a resource wich can not be accessed from differenct origin, and also , the API shares a private key to be seeded in the request every time we send a request for forecast.

To run the applicaiton
1. Pull the docker image from https://hub.docker.com/r/abhimanyuchadha/weather_api/ 
2. Run the docker image docker run -d -p 8081:80 [image_name or id]
3. Go to the browser and enter localhost:8081 in the URL
