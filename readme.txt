To run this application:

Run the main class: FirstSpringApplication

Steps to create docker image and run container from command prompt:
1. cd into the root folder which has Docker file and run: docker build -t mukhou/firstspring .
2. run: docker run -p 8080:8080 mukhou/firstspring
3. Verify: http://localhost:8080/employees

Or, from command prompt, cd into the root folder which has Docker file and
directly run this command: docker-compose up

Steps to run this application on kubernetes:
1. cd into the root folder which has deployment and service file and run:
2. kubectl create -f deployment-definition.yml
3. kubectl create -f service-definition.yml
4. verify pods, replicas, services and deployment created: kubeclt get all
5. forward port to access application from cluster: kubectl port-forward svc/firstspring 8080:8080
6. Verify: http://localhost:8080/employees



