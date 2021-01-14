# Hero Book :

URL ref:  https://www.restapitutorial.com/lessons/httpmethods.html

### `API Specifications`

`Resource Summary`

1.)

|   URI         |   HTTP method |    HTTP status    |   Description |
| ------------- | ------------- |  ---------------  | ------------- |           
| gc.com/api/hero | GET  |         200 OK          |       Test to get the empty hero - no hero in database       |           

`Request :`

 - HTTP Method = GET
 - Request URI = /api/hero

`Response :`
- Body = []

2.)

|   URI         |   HTTP method |    HTTP status    |   Description |
| ------------- | ------------- |  ---------------  | ------------- |
| gc.com/api/hero | POST  |         200 OK          |       Add the hero to the Database        |  

`Request :`

- HTTP Method = GET
- Request URI = /api/hero

`Response :`
-  Body = {"id":1,"image":"ImageName","heroName":"Andrew Garfield","height":"6 feet 30 inches","weight":"70 kg","specialPower":"Webs & Strings","intelligence":"Fast thinker","strength":"Webs & Flexible","speed":"200 km/hour","agility":"Very fast","description":"Spiderman - Super Hero saves the world","story":"SuperHero saves the city from all the villians"}

3.)

|   URI         |   HTTP method |    HTTP status    |   Description |
| ------------- | ------------- |  ---------------  | ------------- |
| gc.com/api/herobyname | GET |         200 OK          |       Add the hero to the Database        |  

`Request :`

- HTTP Method = GET
- Request URI = /api/herobyname
- Parameters = {heroName=[Andrew Garfield]}

`Response :`
-  Body = {"id":1,"image":"ImageName","heroName":"Andrew Garfield","height":"6 feet 30 inches","weight":"70 kg","specialPower":"Webs & Strings","intelligence":"Fast thinker","strength":"Webs & Flexible","speed":"200 km/hour","agility":"Very fast","description":"Spiderman - Super Hero saves the world","story":"SuperHero saves the city from all the villians"}




