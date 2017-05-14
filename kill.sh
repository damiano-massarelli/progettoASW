#!/bin/bash

echo Killing All Services

ps -ef | grep Bandinfo | grep -v grep | awk '{print $2}'
