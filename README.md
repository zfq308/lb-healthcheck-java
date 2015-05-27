# lb-healthcheck-java
Load balancer health check library and examples for Java. Optimized for use with HOSTING Cloud Load Balancer but should work with just about any deployment.

## Installation

Simply grab the [latest release]((https://github.com/HOSTINGLabs/lb-healthcheck-java/releases/download/latest/lb.healthcheck.core.jar)) of the core libraries and add it to your project's classpath / dependancy list.

## Usage

This library is intended to be used most often with custom health check logic that you write and tests the critical components of your application. Examples of things to test would be:

* Connectivity to your database or other storage repository
* Availabilty of critical services (e.g., payment gateway, service bus)
* Functionality of core business logic (e.g., call some controller functions)

You can find an example of how to implement a health check servlet using your own custom logic in the [web](web) folder.

If you're just wanting to get started quickly or if you're only concerned about the web server responding to requests and executing Java servlets, perhaps the bare minimum implementation is for you. Simply grab the latest [lb.healthcheck.web.war](https://github.com/HOSTINGLabs/lb-healthcheck-java/releases/download/latest/lb.healthcheck.web.war) and launch it within your JEE container. The simple health check will be exposed at `/lb.healthcheck.web/health'.

## Load Balancer Configuration
Here is what that Cloud Load Balancer configuration would look like in the [HOSTING Customer Portal].

![HOSTING Cloud Load Balancer Example Config](https://raw.github.com/HOSTINGLabs/lb-healthcheck/master/examples/config/config-screencap.png)

[HOSTING Customer Portal]: https://portal.hosting.com
