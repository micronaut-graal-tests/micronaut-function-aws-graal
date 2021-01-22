#!/bin/bash

./gradlew -Pmicronaut.runtime=lambda buildNativeLambda && \
cp build/libs/mn-aws-function-graal-0.1-lambda.zip build/function.zip
