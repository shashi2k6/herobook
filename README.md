# `Herobook`

GC publishing wants to develop a new application for fans to browse all the heroes 
and villains from the comics.

### **Acceptance Criteria**
**Visitors**

As a visitor, I can view all the heroes.
````
When I view all the heros
Then I can see names of all heros
````
As a visitor, I can see information about any individual hero so that I can see their stats.

````
Rule: Heroes have an image, real name, hero name, height, weight, special power, intelligence, strength, power, speed, agility, description, and story.

Given I have the name of a hero
When I retreive the hero
Then I can view all the details for that hero

Given I have an incorrect hero name
When I retreive details for that hero
Then I receive a message that it doesn't exist
````

### **Technical Specification**

| URI                             | Method | Description                                          |
|---------------------------------|--------|------------------------------------------------------|
|/api/hero                        |GET     | Get a list of all the Heroes                         |
|/api/heroByName/{hero_name}      |GET     | Get the details of the single hero                   |
|/api/hero                        |POST    | Add a new hero                                       |

### **Sample Request and Response**

GET /api/hero
````
[
    {
       "heroName" : "Spiderman"
    },
    {
       "heroName": "Batman"
    }
]
````

GET /api/heroByName/Spiderman
````
{
    "id" : "1",
    "heroName" : "Spiderman",
	"imagePath" : "imageUrl",
	"height"  : "6 feet",
	"weight"  : "50 kg",
	"specialPower" : "can fly",
	"intelligence" : "web",
	"strength"       : "Web & Fly",
	"speed" : "100km/h",
	"agility":"Very fast",
	"description":"saves world from villains",
	"story":"Spider man"
}
````

POST /api/hero
````
Request:
{
    "heroName" : "Spiderman",
	"imagePath" : "imageUrl",
	"height"  : "6 feet",
	"weight"  : "50 kg",
	"specialPower" : "can fly",
	"intelligence" : "web",
	"strength"       : "Web & Fly",
	"speed" : "100km/h",
	"agility":"Very fast",
	"description":"saves world from villains",
	"story":"Spider man"
}
````

````
Response:
{
    "id" : "1",
   "heroName" : "Spiderman",
	"imagePath" : "imageUrl",
	"height"  : "6 feet",
	"weight"  : "50 kg",
	"specialPower" : "can fly",
	"intelligence" : "web",
	"strength"       : "Web & Fly",
	"speed" : "100km/h",
	"agility":"Very fast",
	"description":"saves world from villains",
	"story":"Spider man"
}
````


#### **Stories and Acceptance Criteria**
As a visitor, I can view all the villains.
````
When I view all the villains
Then I can see names of all villains
````

As a visitor, I can see information about any individual hero so that I can see their stats.

````
Rule: Villains have an arch rival, image, real name, hero name, height, weight, special power, intelligence, strength, power, speed, agility, description, and story.

Given I have the name of a villain
When I retreive the villain
Then I can view all the details for that villain

Given I have an incorrect villain name
When I retreive details for that villain
Then I receive a message that it doesn't exist
````


### **Technical Specification**

| URI                             | Method | Description                                          |
|---------------------------------|--------|------------------------------------------------------|
|/api/villain                     |GET     | Get a list of all the Villain                        |
|/api/villainByName/{villain_name}|GET     | Get the details of the single villain                |
|/api/villain                     |POST    | Add a new villain                                    |

### **Sample Request and Response**

GET /api/villain
````
[
    {
       "villainName" : "Joker"
    },
    {
       "villainName":  "catWomen"
    }
]
````

GET /api/villainByName/{villain_name}
````
{
    "id" : "1",
    "villainName" : "Jokerman",
	"imagePath" : "imageUrl",
	"height"  : "6 feet",
	"weight"  : "50 kg",
	"specialPower" : "can manipulate others",
	"intelligence" : "convincing power",
	"strength"       : "can fight",
	"speed" : "100km/h",
	"agility":"Very fast",
	"description":"trouble the world",
	"story":"Joker"
}
````

POST /api/villain
````
Request:
{
    "villainName" : "Jokerman",
	"imagePath" : "imageUrl",
	"height"  : "6 feet",
	"weight"  : "50 kg",
	"specialPower" : "can manipulate others",
	"intelligence" : "convincing power",
	"strength"       : "can fight",
	"speed" : "100km/h",
	"agility":"Very fast",
	"description":"trouble the world",
	"story":"Joker"
}
````

````
Response:
{
    "id" : "1",
    "villainName" : "Jokerman",
	"imagePath" : "imageUrl",
	"height"  : "6 feet",
	"weight"  : "50 kg",
	"specialPower" : "can manipulate others",
	"intelligence" : "convincing power",
	"strength"       : "can fight",
	"speed" : "100km/h",
	"agility":"Very fast",
	"description":"trouble the world",
	"story":"Joker"
}
````