# Project
* This is a Java 8, SpringBoot, Maven project and can be run as usual.
* The user id is user, and password is password which translates to the Authorization header 
Basic dXNlcjpwYXNzd29yZA==
* sample calls with curl :  
curl http://localhost:8080/counter-api/top/5 -H"Authorization: Basic dXNlcjpwYXNzd29yZA==" -H"Accept: text/csv"  
and  
curl http://localhost:8080/counter-api/search -H"Authorization: Basic dXNlcjpwYXNzd29yZA==" -H"Content-Type: application/json" -d'{"searchText":["eget", "amet", "Duis", "Vuis"]}' -X POST  
