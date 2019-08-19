#!/bin/bash
exec 2>&1 >> /var/log/selenium.txt
#exec &> /dev/null 2>&1
/opt/jdk1.8.0_71/bin/java -cp "/opt/SILENIUM:/opt/SILENIUM/client-combined-3.7.1.jar:/opt/SILENIUM/libs/*:/opt/SILENIUM/phantomjsdriver-1.0.1.jar:/opt/SILENIUM/aws-lib/*:/opt/SILENIUM/aws-java-sdk-1.11.243.jar:" IframeTest