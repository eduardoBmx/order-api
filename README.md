# Order Api

sudo docker-compose up

CRUD Product

curl -X POST -H 'Content-Type: application/json' -d '{"name": "Brigadeiro de Ninho", "price": "1.50", "weightType": "UN"}' http://localhost:8080/product

curl -X GET -H 'Content-Type: application/json' http://localhost:8080/product
