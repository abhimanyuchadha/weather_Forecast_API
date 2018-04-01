FROM ubuntu-16.04

MAINTAINER abhimanyuchadha <chadhaau@mail.uc.edu>

RUN apt-get -y update && apt-get -y install apache2
	
RUN mkdir  java

#COPY /home/ubuntu/java_project/CloudComputing_HW_02/weather_reporting/target/weather_reporting-0.0.1-SNAPSHOT /java
COPY weather_reporting-0.0.1-SNAPSHOT /java
#COPY /etc/apache2/sites-available /etc/apache2/sites-available

RUN cd java && java -jar weather_reporting-0.0.1-SNAPSHOT