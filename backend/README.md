
# BACKEND README
---
## Docker instructions
- ***First time start containers***
  `docker compose up -d`
- ***Delete containers and volumes after starting***
  `docker compose down -v`
- ***Starting containers after first time***
  `docker compose start`
- ***Stopping containers without deleting volumes***
  `docker compose stop`

## URLS
- ***PgAdmin:*** http://localhost:5050

## DEFAULT .ENV CONFIGURATION

***POSTGRES_PASSWORD =*** PoopAppPassword 

***POSTGRES_USER =*** PoopAppUser

***POSTGRES_HOST =*** PoopAppDB

***POSTGRES_DB =*** PoopAppDB