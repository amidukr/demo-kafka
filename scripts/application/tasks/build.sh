set -e

KD_SCRIPT_VARS_FILE=$(dirname $0)/../../script-vars.sh
source $KD_SCRIPT_VARS_FILE



cd $KD_TARGET_APPLICATION_DIRECTORY

./gradlew clean build || KT_GRADLE_BUILD_ERROR=true

if [ $KT_GRADLE_BUILD_ERROR = true ]; then
  ./gradlew --info clean build
fi

