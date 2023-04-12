# SCM
Entire shipment data

#scm_lite_demo_code
scm_lite_demo_code in this project contains both front end and backend related data like login,create shipment,datastream and logout options is there

Running steps:
==============
1. First we run scm_lite_demo_code and to see browser with respect host and port number

2. Second step you run Scm_server.py file
3. Third step you run Scm_Prodcuer code
4. Fourth step you run Scm_Consumer code

These are the steps to run the code in local

Docker steps
============
1. To build the docker images
    docker build -t imagename .

2. Then to see the images
   docker iamges
3. Then to run the docker using docker-compose or command
   docker run -p exposeport:applicationport imagename
   
4. Using docker compose type this command
    docker-compose up
Instance Details
================
1. Actually we are free tier instance 30gb rom and 1gb ram i.e 1 gb ram is not supporting to start the kafka so we are swapping the rom to ram

step1:sudo dd if=/dev/root of=/swap_file bs=2G count=1

step2:sudo fallocate -l 2G /swap_file

step3:sudo chmod 600 /swap_file

step4:sudo mkswap /swap_file

step5:sudo swapon /swap_file

step6: CHECK   free -m
