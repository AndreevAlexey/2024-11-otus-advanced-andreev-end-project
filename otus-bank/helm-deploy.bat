call helm upgrade --install postgres-service --values .\postgres\values.yml .\deployment\helm

call helm upgrade --install app-clients --values .\app-clients\values.yml .\deployment\helm

call helm upgrade --install app-accounts --values .\app-accounts\values.yml .\deployment\helm

call helm upgrade --install app-moves --values .\app-moves\values.yml .\deployment\helm

call helm upgrade --install app-manuals --values .\app-manuals\values.yml .\deployment\helm

call helm upgrade --install app-gateway --values .\app-gateway\values.yml .\deployment\helm

call helm upgrade --install app-bank --values .\app-bank\values.yml .\deployment\helm

call helm upgrade --install prometheus --values .\prometheus\values.yml .\deployment\helm

call helm upgrade --install grafana --values .\grafana\values.yml .\deployment\helm