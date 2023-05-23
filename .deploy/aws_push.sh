#!/bin/sh

#
# This script is executed on the server,
# each time a new version of the application is deployed.
#

sudo systemctl stop spring-boot-app

# Create bin folder if it does not exist.
test -d ~/bin || mkdir ~/bin

# Move backend application to bin folder.
if test -f ~/bin/backend-1.0.0-SNAPSHOT.jar; then
rm -f ~/bin/backend-1.0.0-SNAPSHOT.jar
cp -f ~/ctbs/backend-1.0.0-SNAPSHOT.jar ~/bin
rm -f ~/ctbs/backend-1.0.0-SNAPSHOT.jar
else
printf "%s: %s\n" "No backend-1.0.0-SNAPSHOT.jar file found" "$(date)" >> ~/ctbs/log.txt
fi

# Move frontend files to nginx folder.
if test -d ~/ctbs/integration; then
sudo rm -rf /var/www/html/*
sudo mv -f ~/ctbs/integration/* /var/www/html
rmdir ~/ctbs/integration
else
printf "%s: %s\n" "No integration folder found" "$(date)" >> ~/ctbs/log.txt
fi

sudo systemctl start spring-boot-app
exit 0
