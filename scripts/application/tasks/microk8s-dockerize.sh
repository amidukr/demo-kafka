set -e

KD_SCRIPT_VARS_FILE=$(dirname $0)/../../script-vars.sh
source $KD_SCRIPT_VARS_FILE

cd $KD_APPLICATION_SCRIPTS_DIRECTORY/build

docker save $KD_TARGET_DOCKER_IMAGE > application-image.tar

microk8s ctr image import application-image.tar

