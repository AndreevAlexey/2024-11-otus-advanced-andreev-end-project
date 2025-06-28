call cd bom

call mvn clean package -DskipTests

call docker run -d -p 5000:5000 --restart=always --name registry registry:2

call cd ..

call docker image build -t 127.0.0.1:5000/postgres:latest --rm=true . -f .\postgres\Dockerfile
call docker push 127.0.0.1:5000/postgres:latest

call docker image build -t 127.0.0.1:5000/app-clients:latest --rm=true .\app-clients
call docker push 127.0.0.1:5000/app-clients:latest

call docker image build -t 127.0.0.1:5000/app-accounts:latest --rm=true .\app-accounts
call docker push 127.0.0.1:5000/app-accounts:latest

call docker image build -t 127.0.0.1:5000/app-moves:latest --rm=true .\app-moves
call docker push 127.0.0.1:5000/app-moves:latest

call docker image build -t 127.0.0.1:5000/app-manuals:latest --rm=true .\app-manuals
call docker push 127.0.0.1:5000/app-manuals:latest

call docker image build -t 127.0.0.1:5000/app-bank:latest --rm=true .\app-bank
call docker push 127.0.0.1:5000/app-bank:latest

call docker image build -t 127.0.0.1:5000/app-gateway:latest --rm=true .\app-gateway
call docker push 127.0.0.1:5000/app-gateway:latest

call docker image build -t 127.0.0.1:5000/prometheus:latest --rm=true .\prometheus
call docker push 127.0.0.1:5000/prometheus:latest

call docker image build -t 127.0.0.1:5000/grafana:latest --rm=true .\grafana
call docker push 127.0.0.1:5000/grafana:latest