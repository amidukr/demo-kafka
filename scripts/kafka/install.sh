KD_SCRIPT_VARS_FILE=$(dirname $0)/../script-vars.sh
source $KD_SCRIPT_VARS_FILE

kubectl apply -f $KD_SCRIPT_DIRECTORY/kafka/k8s-yaml/zookeeper.yaml
kubectl apply -f $KD_SCRIPT_DIRECTORY/kafka/k8s-yaml/kafka-0.yaml

