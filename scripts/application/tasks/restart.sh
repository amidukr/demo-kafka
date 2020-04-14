set -e

KD_SCRIPT_VARS_FILE=$(dirname $0)/../../script-vars.sh
source $KD_SCRIPT_VARS_FILE

kubectl scale deployment --replicas=0 $KD_TARGET_APPLICATION_NAME-deployment
kubectl scale deployment --replicas=$KD_TARGET_APPLICATION_REPLICAS $KD_TARGET_APPLICATION_NAME-deployment

