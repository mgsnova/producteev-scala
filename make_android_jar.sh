#!/bin/sh
cd .
PROGUARD=/usr/local/Cellar/proguard/4.6/libexec/proguard.jar
java -Xmx1g -jar $PROGUARD @proguard.txt
