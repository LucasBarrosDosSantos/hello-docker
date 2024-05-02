# 1 - subir localstack:

version: '3.7'
services:
aws:
image: 'localstack/localstack'
container_name: 'localstack'
environment:
- SERVICES=sqs
- DEFAULT_REGION=us-east-1
- AWS_DEFAULT_REGION=us-east-1
- DEBUG=1
- DATA_DIR=/tmp/localstack/data
ports:
- '4566:4566'


# 2 - aws configure &&
aws configure

aws --endpoint-url=http://localhost:4566 sqs create-queue --queue-name sample-queue.fifo --attributes FifoQueue=true

# 3 - adicionar dependencia:

<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-aws-messaging</artifactId>
    <version>2.2.1.RELEASE</version>
</dependency>