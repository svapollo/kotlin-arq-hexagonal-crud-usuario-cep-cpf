#!/bin/bash

awslocal dynamodb create-table \
    --table-name tb_customer \
    --attribute-definitions AttributeName=id,AttributeType=S \
    --key-schema AttributeName=id,KeyType=HASH \
    --provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5 \
    --region sa-east-1