set -e

KD_SCRIPT_VARS_FILE=$(dirname $0)/../../script-vars.sh
source $KD_SCRIPT_VARS_FILE


helm dependency update $KD_HELM_DIRECTORY/applications/charts/consumer
helm dependency update $KD_HELM_DIRECTORY/applications/charts/producer

helm uninstall ${KD_TARGET_ENV}-demokafka-applications || echo
helm install --set-string global.env=${KD_TARGET_ENV} ${KD_TARGET_ENV}-demokafka-applications $KD_HELM_DIRECTORY/applications
