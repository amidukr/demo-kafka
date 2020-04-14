set -e

KD_SCRIPT_VARS_FILE=$(dirname $0)/../../script-vars.sh
source $KD_SCRIPT_VARS_FILE

cd $KD_APPLICATION_SCRIPTS_DIRECTORY/build

$KD_APPLICATION_SCRIPTS_DIRECTORY/templates/application-yaml.sh >application.yaml

kubectl apply -f application.yaml
