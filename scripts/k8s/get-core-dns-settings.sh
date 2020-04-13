KD_SCRIPT_VARS_FILE=$(dirname $0)/../script-vars.sh
source $KD_SCRIPT_VARS_FILE
 
echo 'cat /etc/resolv.conf' | kubectl run -i get-core-dns-settings --image=busybox sh 2>/dev/null
kubectl delete pod get-core-dns-settings >/dev/null

