# Junkie
### a healthy junkie keeping track of what he/she injected in his blood stream

| Request Type | API LINK | Descreption|
| ---- | -------- | ------- |
| GET |http://localhost:8080/junkies | gets all users on the db|
|GET | http://localhost:8080/junkie/{id} | get junkie by id|
| POST | http://localhost:8080/junkie | {"name":"newJunkie}|
| GET | http://localhost:8080/Meds | Gets al the meds in the db|
|GET| http://localhost:8080/meds/{id} | get med by id|
| POST | http://localhost:8080/addMeds | {"name":"Lethal"}|
|GET| http://localhost:8080/injectionLogs/{skip} | gets logs of all injections|
|GET| http://localhost:8080/injectionLogOf/{id}?skip={skip}| get logs of user|
|POST| http://localhost:8080/inject| {injectorID: {id}, injectedID:{id},medsID:{id}}|