#!/bin/sh
echo "Running check verification..."

JAVA_HOME=$(/usr/libexec/java_home -v 1.8)
export JAVA_HOME

OUTPUT="/tmp/check-verification-result"
./gradlew check --daemon > ${OUTPUT}
EXIT_CODE=$?
if [ ${EXIT_CODE} -ne 0 ]; then
    cat ${OUTPUT}
    rm ${OUTPUT}
    echo "*********************************************"
    echo "         Check Verification Failed           "
    echo "Please fix the above issues before committing"
    echo "*********************************************"
    exit ${EXIT_CODE}
else
    rm ${OUTPUT}
    echo "*********************************************"
    echo "     Check Verification no problems found    "
    echo "*********************************************"
fi
