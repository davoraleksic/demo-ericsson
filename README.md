# Car Service Application
Technologies: Spring Boot, PostgreSql database, REST architectural style

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

## User Story 14: Implement error handling
Example: https://github.com/davoraleksic/error-handling-demo

## User Story 15: Validations
Client save:

	- first Name must not be blank
	- last name must not be blank
	- oib must not be blank
	- check oib format
	- check oib lenght (must contain 11 characters)
	- check if oib is not number

For these validations you must throw GenericValidationException with error message and date
	
Client getById:

	- throw EntityNotFoundException if client is not found
	
Client deleteById:

	- throw EntityNotFoundException if client is not found
	
Client updateById:

	- throw EntityNotFoundException if client is not found
	
Car save:

	- check if client exists, if not throw EntityNotFoundException
	- car type must not be null
	- manufacture year must not be null
	- registration mark must not be blank
	- registration mark must be in format AA 000 AA (2 character string -> 1 space -> 3 to 5 digit number -> 1 space -> 2 character string)
	- color must not be blank

Car deleteById:

	- check if client exists, if not throw EntityNotFoundException
	- check if car exists, if not throw EntityNotFoundException
	
Car updateById
	
	- check if client exists, if not throw EntityNotFoundException
	- check if car exists, if not throw EntityNotFoundException

## User Story 16: New Entity -> CarService
Car can have more than one CarServices and one CarService can be in one Car

- Create new entity
- Update Car entity with list of CarServices
- CarServices has attributes:
	- id
	- carId
	- dateOfService (Date)
	- workerFirstName
	- workerLastName
	- workDescription
	- price
	- isPaid


NOTE: BIDIRECTIONAL relation

## User Story 17: Create new CarService
Save CarService in DB

- Endpoint: /api/customers/{clientId}/cars/{carId}/car-services
- Method: POST
- Request Body:

 ```json
 {
	"dateOfService": 2023-02-23T18:25:43.511Z
	"workerFirstName": "Ivo",
	"workerLastName":"Ivic",
	"workDescription": "Zamjena ulja",
	"price": 99.99
	"isPaid": false
}
```

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
	       "color": "red",
	       "carServices": [
		    {
		        "dateOfService": 2023-02-23T18:25:43.511Z
			"workerFirstName": "Ivo",
			"workerLastName":"Ivic",
			"workDescription": "Zamjena ulja",
			"price": 99.99
			"isPaid": false
		    }	
		]
	    }	
	]
}
```

## User Story 18: Delete CarService by ID

- Endpoint: /api/customers/{clientId}/cars/{carId}/car-services/{carServiceId}
- Method: DELETE
- Request Body: none
- Response Body: 200 OK (Use ResponseEntity in your controller to return OK status)
- Validations: return EntityNotFoundException if car service is not found

## User Story 19: Update CarService by ID

- Endpoint: /api/customers/{clientId}/cars/{carId}/car-services/{carServiceId}
- Method: PUT
- Request Body:

```json
 {
	"dateOfService": 2023-02-23T18:25:43.511Z
	"workerFirstName": "Ivo",
	"workerLastName":"Ivic",
	"workDescription": "Zamjena ulja i promjena guma",
	"price": 110.00
	"isPaid": false
}
```
- Response Body
```json
{
	"dateOfService": 2023-02-23T18:25:43.511Z
	"workerFirstName": "Ivo",
	"workerLastName":"Ivic",
	"workDescription": "Zamjena ulja i promjena guma",
	"price": 110.00
	"isPaid": false
}
```

## User Story 20: Update isPaid
Update just isPaid attribute in CarService

- Endpoint: /api/customers/{clientId}/cars/{carId}/car-services/{carServiceId}/is-paid
- Method: PUT
- Request Body:

```json
{
	"isPaid": true
}
```

- Response Body:
```json
{
	"message": "Success"
}
```

## User Story 21: Mail Sending
Send mail to client when car service is saved or updated. Modify client entity with new attribute: email (don't forget validations)

## User Story 22: Unit Testing
TODO: description

## User Story 23: Mapstruct
TODO: description
