# Micronaut AWS Function GraalVM

Test application for Micronaut Function deployed to AWS as a GraalVM native image.

To build the application and test it locally:

```
./build-native-image.sh
./sam-local.sh
```

To send a request:

```
curl -X POST -H 'Content-Type:application/json' -d '{"category":"foo"}' localhost:3000/jokes
```

To deploy to AWS:

```
zip -j build/function.zip bootstrap aws-function


S3_BUCKET=USE-YOUR-OWN-BUCKET
STACK_NAME=USE-YOUR-OWN-STACK-NAME

aws cloudformation package --template-file sam-native.yaml --output-template-file build/output-sam.yaml --s3-bucket $S3_BUCKET
aws cloudformation deploy --template-file build/output-sam.yaml --stack-name $STACK_NAME --capabilities CAPABILITY_IAM

API_ENDPOINT=`aws cloudformation describe-stacks --stack-name $STACK_NAME | jq -r '.Stacks[0] .Outputs[0] .OutputValue'`

curl -X POST -H 'Content-Type:application/json' -d '{"category":"foo"}' $API_ENDPOINT

# To delete everything
aws cloudformation delete-stack --stack-name $STACK_NAME
```
