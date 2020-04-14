set -e

KD_SCRIPT_VARS_FILE=$(dirname $0)/../../script-vars.sh
source $KD_SCRIPT_VARS_FILE

cd $KD_APPLICATION_SCRIPTS_DIRECTORY/build

cp $KD_APPLICATION_SCRIPTS_DIRECTORY/templates/Dockerfile ./
cp $KD_TARGET_APPLICATION_DIRECTORY/build/libs/*.jar ./app.jar

docker build -t $KD_TARGET_DOCKER_IMAGE . 

