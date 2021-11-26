#!/bin/bash

EXIT_STATUS=0

./gradlew nativeCompile || EXIT_STATUS=$?
if [[ $EXIT_STATUS -eq 0 ]]; then
  zip -j build/function.zip bootstrap build/native/nativeCompile/mn-aws-function-graal
else
  exit 1
fi
