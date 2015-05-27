# lb-healthcheck-java
Load balancer health check library and examples for Java. Optimized for use with HOSTING Cloud Load Balancer but should work with just about any deployment.

## Installation

## Usage

This library is intended to be used most often with custom health check logic that you write and tests the critical components of your application. Examples of things to test would be:

* Connectivity to your database or other storage repository
* Availabilty of critical services (e.g., payment gateway, service bus)
* Functionality of core business logic (e.g., call some controller functions)

## Load Balancer Configuration
Here is what that Cloud Load Balancer configuration would look like in the [HOSTING Customer Portal].

![HOSTING Cloud Load Balancer Example Config](https://raw.github.com/HOSTINGLabs/lb-healthcheck/master/examples/config/config-screencap.png)

[Composer]: https://getcomposer.org
[HOSTING Customer Portal]: https://portal.hosting.com
