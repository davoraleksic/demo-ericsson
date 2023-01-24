# Car Service Application
Technologies: Spring Boot, PostgreSql baza, REST architectural style

## User Story 1: Init project

-	Init project with Spring Initializr
-	Add dependencies:
      -	spring-boot-starter-web
      -	spring-boot-starter-data-jpa
      -	postgresql
-	Create postgresql database with PgAdmin or with git bash/cmd terminal (terminal is recommended)
-	Connect database with application
-	You can use application.properties or application.yml file (whatever you want)

## User Story 2: Create client
Create ClientController and add POST method which is used to save client in database.
-	Create Entity Client in DB
-	Create ClientController
-	Create ClientService
-	Create ClientRepository
-	Create Client entitet


- Endpoint: /api/customers
- Method: POST
- Request Body example:

 ```json
 {
	"firstName": "Ivan",
	"lastName": "Peric",
	"oib":"65547479545",
	"city": "Osijek",
	"street": "Vukovarska",
	"zipCode": "31000",
	"country": "Hrvatska",
}
```
 
- Response Body example:

``` json 
{
	"firstName": "Ivan",
	"lastName": "Peric",
	"oib":"65547479545",
	"city": "Osijek",
	"street": "Vukovarska",
	"zipCode": "31000",
	"country": "Hrvatska",
}
```

## User Story 3: Fetch all clients 
With API getAll fetch all clients stored in DB.

- Endpoint: /api/customers
- Method: GET
- Request Body example: none
- Response Body example: 

``` json 
[
	{
		"firstName": "Ivan",
		"lastName": "Peric",
		"oib":"65547479545",
		"city": "Osijek",
		"street": "Vukovarska",
		"number": "8"
		"zipCode": "31000",
		"country": "Hrvatska",
	},
	{
		"firstName": "Hrvoje",
		"lastName": "Maric",
		"oib":"91540145073",
		"city": "Zagreb",
		"street": "Vladimira Nazora",
		"number": "55a"
		"zipCode": "10000",
		"country": "Hrvatska",
	}
]
```

## User Story 4: Fetch Client by ID
With API-a getById fetch client stored in DB. In controller you need to use PathVariable annotation to pass ID parameter.

- Endpoint: /api/customers/{id}
- Method: GET
- Request Body example: none
- Response Body example:

``` json 
{
	"firstName": "Ivan",
	"lastName": "Peric",
	"oib":"65547479545",
	"city": "Osijek",
	"street": "Vukovarska",
	"zipCode": "31000",
	"country": "Hrvatska",
}
```