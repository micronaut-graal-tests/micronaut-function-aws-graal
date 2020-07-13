#!/bin/bash

EXIT_STATUS=0

./gradlew assemble
native-image --no-server --no-fallback --class-path build/libs/mn-aws-function-graal-*-all.jar || EXIT_STATUS=$?
if [[ $EXIT_STATUS -eq 0 ]]; then
  zip -j build/function.zip bootstrap mn-aws-function-graal
else
  exit 1
fi
