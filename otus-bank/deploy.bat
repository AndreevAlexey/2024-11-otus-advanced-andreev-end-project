call kubectl apply -f .\deployment\postgres-deployment.yml

call kubectl apply -f .\deployment\app-clients-deployment.yml

call kubectl apply -f .\deployment\app-accounts-deployment.yml

call kubectl apply -f .\deployment\app-moves-deployment.yml

call kubectl apply -f .\deployment\app-manuals-deployment.yml

call kubectl apply -f .\deployment\app-gateway-deployment.yml

call kubectl apply -f .\deployment\app-bank-deployment.yml

call kubectl apply -f .\deployment\prometheus-deployment.yml

call kubectl apply -f .\deployment\grafana-deployment.yml
