FROM ubuntu:14.04
FROM openjdk

MAINTAINER abhimanyuchadha <chadhaau@mail.uc.edu>

RUN apt-get -y update && apt-get -y install apache2

#RUN sudo apt-get install openjdk-8-jre
	
RUN mkdir project && mkdir /var/www/CloudComputing_HW_03

COPY revProxy.conf /etc/apache2/sites-available/revProxy.conf

#COPY /hw_03/CloudComputing_HW_03/ /var/www/html/

COPY startup.sh /home/ubuntu/project/startup.sh

#COPY /home/abhimanyu/java/hw_03/CloudComputing_HW_03 /var/www/CloudComputing_HW_03 
COPY /hw_03 /var/www/hw_03 

RUN a2ensite revProxy.conf && a2enmod proxy && a2enmod proxy_http  && a2dissite 000-default.conf
# && echo "ServerName 127.0.0.3" >> /etc/apache2/apache2.conf 


#COPY /home/ubuntu/java_project/CloudComputing_HW_02/weather_reporting/target/weather_reporting-0.0.1-SNAPSHOT /java
COPY weather_reporting-0.0.1-SNAPSHOT.jar /home/ubuntu/project/weather_reporting-0.0.1-SNAPSHOT.jar
#COPY /etc/apache2/sites-available /etc/apache2/sites-available

#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/home/ubuntu/project/weather_reporting-0.0.1-SNAPSHOT.jar"]

#RUN cd project && sudo java -jar weather_reporting-0.0.1-SNAPSHOT


#RUN ["chmod","+x","/home/ubuntu/project/startup.sh"]

#CMD ["/bin/bash","/home/ubuntu/project/startup.sh"]

ENTRYPOINT service apache2 start && java -jar /home/ubuntu/project/weather_reporting-0.0.1-SNAPSHOT.jar && /bin/bash




#CMD /etc/init.d/service apache2 start && \
#	/etc/init.d/ java -jar weather_reporting-0.0.1-SNAPSHOT.jar && \
#	/bin/bash
