#!/bin/sh
mvn clean install
rm -f /media/nixdata/Projects/paperdebug/plugins/*.jar
rm -rf /media/nixdata/Projects/paperdebug/world
rm -rf /media/nixdata/Projects/paperdebug/world_nether
rm -rf /media/nixdata/Projects/paperdebug/world_the_end
cp ./target/CreativeFlatWorld*.jar /media/nixdata/Projects/paperdebug/plugins
cd /media/nixdata/Projects/paperdebug
java -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005 -Xms512M -Xmx1024M -jar /media/nixdata/Projects/paperdebug/paper-1.19.2.jar