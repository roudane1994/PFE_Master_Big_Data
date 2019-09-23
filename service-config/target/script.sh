#!/bin/sh
SERVICE_NAME=SecurityService
PATH_TO_JAR=service-config
PID_PATH_NAME=/tmp/MyService-pid

case $1 in 
     start)
    echo "strating $SERVICE_NAME ..."
    if[! -f $PID_PATH_NAME];then
         nohup java -jar $PATH_TO_JAR /tmp 2>> /dev/null >> /dev/null &
         echo $! > $PID_PATH_NAME
         echo "$SERVICE_NAME starting ..."
    else
        echo "$SERVICE_NAME is already running ..."
    fi

   ;;
   stop)

   if [-f $PID_PATH_NAME];then
      PID=$(cat $PID_PATH_NAME);
      echo "$SERVICE_NAME stoping..."
      kill $PID;
      echo "$SERVICE_NAME stopped ..."
      rm $PID_PATH_NAME
   else
       echo "$SERVICE_NAME is not running..."
    fi
    ;;
 restart)
    if [-f $PID_PATH_NAME];then
    PID=$(cat $PID_PATH_NAME);
    echo "$SERVICE_NAME stopping ...";
    kill $PID;
    echo "$SERVICE_NAME stopped...";
    rm $PID_PATH_NAME
    echo "$SERVICE_NAME Starting..."
    nohup java -jar $PAth_TO_JAR /tmp 2>> /dev/null >> /dev/null &
     echo $! > $PID_PATH_NAME
     echo "$SERVICE_NAME started..."
     else
     echo "$SERVICE_NAME is not running ..."
     fi
     ;;
esac

