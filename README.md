To run this application:

Run the main class: FirstSpringApplication

Steps to create docker image and run container from command prompt:

#Approach 1
1. cd into the root folder which has Docker file and run: docker build -t mukhou/firstspring .
2. run: docker run -p 8080:8080 mukhou/firstspring
3. Verify: http://localhost:8080/employees


#Approach 2(use docker-compose)
Or, from command prompt, cd into the root folder which has Docker file and
directly run this command: docker-compose up

Steps to run this application on kubernetes:
1. build the docker image following above section(step #1)
2. publish image to docker hub: docker push mukhou/firstspring
3. cd into the root folder which has deployment and service file and run:
4. kubectl create -f deployment-definition.yml (**Note**: if see error connection actively refused 
   on 127.0.0.1:32768, tcp, check status of minikube container using docker ps -a. It should be UP.
   If it says **exited**, run command minikube start to bring it up).
5. kubectl create -f service-definition.yml
6. verify pods, replicas, services and deployment created: kubeclt get all
7. forward port to access application from cluster: kubectl port-forward svc/firstspring 8080:8080
8. Verify: http://localhost:8080/employees



