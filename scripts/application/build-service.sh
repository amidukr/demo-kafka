set -e

KD_SCRIPT_VARS_FILE=$(dirname $0)/../script-vars.sh
source $KD_SCRIPT_VARS_FILE


cd $KD_APPLICATION_SCRIPTS_DIRECTORY
rm -rf ./build
mkdir ./build

$KD_APPLICATION_SCRIPTS_DIRECTORY/tasks/build.sh
$KD_APPLICATION_SCRIPTS_DIRECTORY/tasks/dockerize.sh
$KD_APPLICATION_SCRIPTS_DIRECTORY/tasks/microk8s-dockerize.sh

