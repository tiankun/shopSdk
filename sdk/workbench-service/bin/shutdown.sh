#!/bin/bash

SCRIPT_NAME=$0;
BIN_DIR=`dirname ${SCRIPT_NAME}`;
BASE_DIR="${BIN_DIR}/..";
BASE_BIN=${BASE_DIR}/bin;
BASE_LIB=${BASE_DIR}/lib;
BASE_CONF=${BASE_DIR}/conf;
BASE_LOG=${BASE_DIR}/log;

PID_FILE=${BASE_BIN}/app.pid;
PIDS=`cat $PID_FILE`

if [ -f $PID_FILE ];
then
    old_pid=`cat $PID_FILE`;
	kill -9 $old_pid;
	rm $PID_FILE;
fi

COUNT=0
while [ $COUNT -lt 1 ]; do    
    echo -e ".\c"
    sleep 1
    COUNT=1
    for PID in $PIDS ; do
		PID_EXIST=`ps --no-heading -p $PID`
		if [ -n "$PID_EXIST" ]; then
			COUNT=0
			break
		fi
	done
done

echo "OK!"
echo "PID: $PIDS"
