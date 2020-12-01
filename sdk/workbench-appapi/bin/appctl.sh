#!/bin/bash
SCRIPT_NAME=$0;
BIN_DIR=`dirname ${SCRIPT_NAME}`;

script=$1;

case "$script" in
        "start")
                ${BIN_DIR}/startup.sh
                ;;
        "stop")
                ${BIN_DIR}/shutdown.sh
                ;;
        "restart"|"publish")
                ${BIN_DIR}/shutdown.sh
                ${BIN_DIR}/startup.sh
                ;;
        *)
                echo "Usage : clientctl [start|stop|restart|publish]"
                ;;
esac
