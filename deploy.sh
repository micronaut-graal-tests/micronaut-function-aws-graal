#!/bin/bash
docker build . -t function
mkdir -p build
docker run --rm --entrypoint cat function  /home/application/function.zip > build/function.zip
