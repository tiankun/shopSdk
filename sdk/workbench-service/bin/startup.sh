#!/bin/bash

SCRIPT_NAME=$0;
BIN_DIR=`cd $(dirname ${SCRIPT_NAME});pwd;`;
BASE_DIR="${BIN_DIR}/..";
BASE_BIN=${BASE_DIR}/bin;
BASE_LIB=${BASE_DIR}/lib;
BASE_CONF=${BASE_DIR}/conf;
BASE_LOG=${BASE_DIR}/logs;
ENV_CONF=${BASE_BIN}/env.conf;

PID_FILE=${BASE_BIN}/app.pid;

if [ -f $PID_FILE ];
then
        old_pid=`cat $PID_FILE`;
        pids=`ps aux | grep java | awk '{print $2;}'`;
        for pid in $pids
        do
                if [ $pid -eq $old_pid ];
                then
                        echo "process is running as $pid,please stop it first.";
                        exit 0;
                fi
        done
fi

if [ ! -d $BASE_LOG ];
then
	mkdir "$BASE_LOG"
fi

export LANG=en_US.UTF-8
ulimit -c unlimited

if [ -f ${ENV_CONF} ];
then
    source ${ENV_CONF}
fi

script="java ${JAVA_OPTS} -classpath ${BASE_CONF}:${BASE_LIB}/*: UnifyWorkbenchService";

echo $script
cd $BASE_DIR
nohup $script > ${BASE_LOG}/nohup.out 2>&1 &
pid=$!
cd -
echo $pid > $PID_FILE;
