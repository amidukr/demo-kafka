set -e

if [ $# -eq 0 ]; then
    echo "install.sh <env>"
    exit 1
fi

KD_SCRIPT_VARS_FILE=$(dirname $0)/../script-vars.sh
source $KD_SCRIPT_VARS_FILE

export KD_TARGET_APPLICATION_VERSION=latest
export KD_TARGET_ENV=$1

$KD_APPLICATION_SCRIPTS_DIRECTORY/tasks/deploy-resources.sh

#---------
 export KD_TARGET_APPLICATION_NAME=demokafka-producer
 $KD_APPLICATION_SCRIPTS_DIRECTORY/build-service.sh

#---------
 export KD_TARGET_APPLICATION_NAME=demokafka-consumer
 $KD_APPLICATION_SCRIPTS_DIRECTORY/build-service.sh


$KD_APPLICATION_SCRIPTS_DIRECTORY/tasks/deploy-applications.sh

