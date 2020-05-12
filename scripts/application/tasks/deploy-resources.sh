set -e

KD_SCRIPT_VARS_FILE=$(dirname $0)/../../script-vars.sh
source $KD_SCRIPT_VARS_FILE

helm upgrade -i --set-string global.env=${KD_TARGET_ENV} ${KD_TARGET_ENV}-demokafka-resources $KD_HELM_DIRECTORY/resources
