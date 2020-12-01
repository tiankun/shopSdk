#!/bin/bash

SCRIPT_NAME=$0;
BIN_DIR=`cd $(dirname ${SCRIPT_NAME});pwd;`;
BASE_DIR="${BIN_DIR}/..";
BASE_BIN=${BASE_DIR}/bin;
BASE_LIB=${BASE_DIR}/lib;
BASE_CONF=${BASE_DIR}/conf;
BASE_LOG=${BASE_DIR}/logs;

${BIN_DIR}/shutdown.sh
${BIN_DIR}/startup.sh
