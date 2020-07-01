./gradlew assemble
native-image --no-server --no-fallback --class-path build/libs/mn-aws-function-graal-*-all.jar
zip -j build/function.zip bootstrap mn-aws-function-graal
