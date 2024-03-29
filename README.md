# Deviation Tracker

A REST API that tracks the deviations of the public transport in the Bergen Region.
The API wraps a web scaper for [skyss.no/avvik](https://www.skyss.no/avvik/)

## Tech stack

Written in Kotlin using [SpringBoot](https://spring.io/projects/spring-boot) for API and [Jsoup](https://github.com/jhy/jsoup) for web scarping


## Building the application

### Requirments

For running in docker, the app only requires docker as building is handledin a container.

If running nativly:
- A distrution of JDK17
- [Maven](https://maven.apache.org/)

### Build and run

#### Docker
Navigate to the root directory and run `docker run` or `docker compose up` in a terminal 



#### Native
Navigate to the root folder, run `mvn build` in a terminal to build the application.
To run the application run `mvn run` in a terminal.


## Limitations


### Volatile to changes made by Skyss
The service is built on top of a web scraper, this introduces some volatility, the service might stop working correctly if the structure of [skyss.no/avvik](https://www.skyss.no/avvik/) changes.

### Web scraping
In the case that a lot of lines are grouped togheter as one deviation, it might happen that not all the lines are picked up as part of the devaiton due to not all of them being included in the heading. In theses cases Skyss puts the relevant lines in the message text rather then the heading and thus might not be picked up by the scraper.

Example:

![Screenshot showcasing a list of deviations as of 19.05.2023](pics/deviationExample.png)


The lines: 3, 3E, 4, 4E, 10, 12, 16E, 18, 19 39, are expirincing a deviation in their regualar service, but the scraper is only able to detect deviations in lines: 
3, 3E, 4, 4E, 10, 12,  
missing the lines: 
16E, 18, 19, 39.

This could possbily be addressed in the future by creating a set of known routes, and then searching the message of all deviations of routes.


## API documentation
Documentation is auto-generated using [springdoc-openapi](https://github.com/springdoc/springdoc-openapi). 

When Running the application it will be aviable as swagger-ui located at `http://server:port/context-path/swagger-ui.html`

Which if using the deafult configuration will be: `http://localhost:8080/swagger-ui.html` when running localy.

It is also avaible as be availbe as json: `http://server:port/context-path/v3/api-docs`

## License
See: [LICENSE.md](LICENSE.md)
