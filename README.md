# Nuvalence
Created by: John Franklin Ruiz Neira

This webservice is for evaluate two rectangles in order to determinate if them are intersected, contained or have adjacency. 

Steps to test the functionallity: 

1) JWT Token has been implemented and it is neccesary send a request as follows

curl --location --request POST 'http://nuvalence.herokuapp.com/signup' \ 
--header 'Content-Type: application/json' \
--data-raw '{
    "username":"meli",
    "email":"user@gmail.com",
    "password":"password",</br>
    "roles":[
      "ROLE_CLIENT"
    ]
}'

La respuesta del endpoint anterior retornara el token, supongamos que es
“eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtZWxpIiwiYXV0aCI6W3siYXV0aG9yaXR5IjoiUk9MRV9DTElFTlQifV0sImlhdCI6MTYwMjk5NjYzNCwiZXhwIjoxNjAyOTk2OTM0fQ.Qzs-Wu4ewuSBPI7p_WbHr7RfiwL7ZE2MbVl-paviqYw”

2) Once we have the token it must be send in the second request together with the coordinates of the 2 rectangles:

curl --location --request POST 'http://nuvalence.herokuapp.com/topsecret' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtZWxpIiwiYXV0aCI6W3siYXV0aG9yaXR5IjoiUk9MRV9DTElFTlQifV0sImlhdCI6MTYwMjk5NjYzNCwiZXhwIjoxNjAyOTk2OTM0fQ.Qzs-Wu4ewuSBPI7p_WbHr7RfiwL7ZE2MbVl-paviqYw' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=2EBEB5AEE8900B9D453D6091A6268122' \
--data-raw '{</br>
    "rectangles":[</br>
        {</br>
            "leftBorderPosition":1,</br>
            "rightBorderPosition":10,</br>
            "downBorderPosition":5,</br>
            "upBorderPosition":20</br>
        },</br>
        {</br>
            "leftBorderPosition":2,</br>
            "rightBorderPosition":15,</br>
            "downBorderPosition":6,</br>
            "upBorderPosition":25</br>
        }</br>
    ]</br>
}</br>
  

The service will response with a message indicating the result of the evaluation:</br>
The rectangles are intersected, not contained, not adjacent each other</br>

Additionall, it is possible to see the swagger of the microservice from the next link:

http://nuvalence.herokuapp.com/swagger-ui.html
