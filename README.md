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
	"number": "22",
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
	"number": "22",
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
		"number": "8",
		"zipCode": "31000",
		"country": "Hrvatska",
	},
	{
		"firstName": "Hrvoje",
		"lastName": "Maric",
		"oib":"91540145073",
		"city": "Zagreb",
		"street": "Vladimira Nazora",
		"number": "55a",
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
	"number": "22"
	"zipCode": "31000",
	"country": "Hrvatska",
}
```

## User Story 5: Delete client by ID
With this API (deleteById) you can delete client by ID.

- Endpoint: /api/customers/delete/{id}
- Method: DELETE
- Request Body: none
- Response Body: 200 OK (Use ResponseEntity in your controller to return OK status)

## User Story 6: Update client by ID

With this API you need to update existing client. Firstly get client by id and that client you need to update with new data from request body. This time in controller you need to pass @PathVariable and @RequestBody

- Endpoint: /api/customers/{id}
- Method: PUT
- Request Body:

 ```json
 {
	"firstName": "Ivan",
	"lastName": "Peric",
	"oib":"65547479545",
	"city": "Osijek",
	"street": "Vukovarska",
	"number": "11",
	"zipCode": "31000",
	"country": "Hrvatska",
}
```
- Response Body:
```json
{
   "firstName": "Ivan",
   "lastName": "Peric",
   "oib":"65547479545",
   "city": "Osijek",
   "street": "Vukovarska",
   "number": "11",
   "zipCode": "31000",
   "country": "Hrvatska",
}
```
## User Story 7: ClientDtoMapper
Implement ClientDtoMapper class. In this class you must have all the mappings from dto to entity and vice versa that you have done so far. Load this class using dependency injection into the service layer and replace all mappings that are in the service layer. 

You can see example in: https://git.devops.cc.lab.etk.extern.eu.ericsson.se/CEZIH/eKarton (check DtoMapper.class)

## User Story 8: Swagger
Add swagger in your application and use Swagger instead Postman.

You can see example in: https://git.devops.cc.lab.etk.extern.eu.ericsson.se/CEZIH/eVacHelp (check pom.xml, SwaggerConfiguration, application.yml)

## User Story 9: Modification of getAll() method in Client
- Now this method need to fetch clients by first name and/or last name. Both params are not required. 
- Method must return all clients ASC sorted by last name
- See example in: https://git.devops.cc.lab.etk.extern.eu.ericsson.se/CEZIH/org-select-cezih-ui-backend/src/branch/develop

## User Story 10: New Entity -> Car
Client can have more than one car and one car can be own by one client. 

- Create new entity, controller, service and repository
- Update Client entity with list of cars, add jpa mapping
- Car has this attributes:
	- id
	- Client id
	- Car type (this must be ENUM, example: OPEL_ASTRA)
	- Year of manufacture
	- Registration mark
	- Color

NOTE: Relation of Client and Car must be BIDIRECTIONAL (Client has list of cars and Car has reference on Client)

## User Story 11: Create new Car
Create save method which is used to save client in database and then response with client and his cars.

- Endpoint: /api/customers/{id}/cars NOTE: id is client.id
- Method: POST
- Request Body example:

 ```json
 {
	"carType", "TOYOTA_AURIS"
	"manufactureYear": 2010,
	"registrationMark":"OS555CC",
	"color": "red"
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
	"number": "22",
	"zipCode": "31000",
	"country": "Hrvatska",
	"cars": [
	    {
	       "carType", "TOYOTA_AURIS"
	       "manufactureYear": 2010,
	       "registrationMark":"OS555CC",
	       "color": "red"
	    }	
	]
}
```
## UserStory 12: Delete Car by ID
Implement deleteById

- Endpoint: /api/customers/{id}/cars/{id} NOTE: first id is client.id, second id is car.id
- Method: DELETE
- Request Body: none
- Response Body: 200 OK (Use ResponseEntity in your controller to return OK status)

## UserStory 13: Update Car by ID
Implement updateById

- Endpoint: /api/customers/{id}/cars/{id} NOTE: first id is client.id, second id is car.id
- Method: PUT
- Request Body: 

 ```json
 {
	"carType", "TOYOTA_AURIS"
	"manufactureYear": 2010,
	"registrationMark":"OS555CC",
	"color": "red"
}
```

- Response Body:
 ```json
 {
	"carType", "TOYOTA_AURIS"
	"manufactureYear": 2010,
	"registrationMark":"OS555CC",
	"color": "red"
}
```
