# TEST CASES

## Test Case 1: Successful GET Request (Get User's List) (PASS)

**Given** A GET request is sent to the server: `https://reqres.in/api/users?page=2`  
**When** The server responds with status code 200 OK  
**Then** The server responds back with body result printed like this:

```json
{
    "page": 2,
    "per_page": 6,
    "total": 12,
    "total_pages": 2,
    "data": [
        {
            "id": 7,
            "email": "michael.lawson@reqres.in",
            "first_name": "Michael",
            "last_name": "Lawson",
            "avatar": "https://reqres.in/img/faces/7-image.jpg"
        },
        {
            "id": 8,
            "email": "lindsay.ferguson@reqres.in",
            "first_name": "Lindsay",
            "last_name": "Ferguson",
            "avatar": "https://reqres.in/img/faces/8-image.jpg"
        },
        {
            "id": 9,
            "email": "tobias.funke@reqres.in",
            "first_name": "Tobias",
            "last_name": "Funke",
            "avatar": "https://reqres.in/img/faces/9-image.jpg"
        },
        ...
    ]
}
```
## Test Case 2: Successful GET Request (Single User) (PASS)

**Given** A GET request is sent to the endpoint: `https://reqres.in/api/users`  
**And** A GET request is made for the user with an ID "2": `https://reqres.in/api/users/2`  
**And** Values for the user with an ID "2" are:

```json
{
    "data": {
        "id": 2,
        "email": "janet.weaver@reqres.in",
        "first_name": "Janet",
        "last_name": "Weaver",
        "avatar": "https://reqres.in/img/faces/2-image.jpg"
    },
    "support": {
        "url": "https://reqres.in/#support-heading",
        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
    }
}
```
**WHEN** the server response is status code: 200 OK     
**THEN** server respond back with body result printed like this:       
```json
{
    "data": {
        "id": 2,
        "email": "janet.weaver@reqres.in",
        "first_name": "Janet",
        "last_name": "Weaver",
        "avatar": "https://reqres.in/img/faces/2-image.jpg"
    },
    "support": {
        "url": "https://reqres.in/#support-heading",
        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
    }
}
```
## Test Case 3: Unsuccessful GET Request (Single User "User Not Found") (PASS)

**Given** A GET request is sent to the server: `https://reqres.in/api/users`  
**And** A GET request is made for the user with an ID "28": `https://reqres.in/api/users/28`  
**When** The server responds with status code 404 Not Found  
**Then** The server responds back with an empty body  
**And** the result printed like this:

```json
{}
```
## Test Case 4: Successful GET Request (Get Resource's List) (PASS)

**Given** A GET request is sent to the server: `https://reqres.in/api/unknown`  
**When** The server responds with status code 200 OK  
**Then** The server responds back with body result printed like this:    

```json
{
    "page": 1,
    "per_page": 6,
    "total": 12,
    "total_pages": 2,
    "data": [
        {
            "id": 1,
            "name": "cerulean",
            "year": 2000,
            "color": "#98B2D1",
            "pantone_value": "15-4020"
        },
        {
            "id": 2,
            "name": "fuchsia rose",
            "year": 2001,
            "color": "#C74375",
            "pantone_value": "17-2031"
        },
        {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "pantone_value": "19-1664"
        },
        ...
    ]
}
```
## Test Case 5: Successful GET Request (Single Resource) (PASS)

**Given** A GET request is sent to the server: `https://reqres.in/api/unknown`  
**And** A GET request is made for the resource with an ID "5": `https://reqres.in/api/unknown/5`  
**And** The values for the resource with an ID "5" are:  

```json
{
    "data": {
        "id": 5,
        "name": "tigerlily",
        "year": 2004,
        "color": "#E2583E",
        "pantone_value": "17-1456"
    },
    "support": {
        "url": "https://reqres.in/#support-heading",
        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
    }
}
```

**WHEN** the server responds with status code 200 OK      
**THEN** server responds back with body result printed like this      
```json
{
    "data": {
        "id": 5,
        "name": "tigerlily",
        "year": 2004,
        "color": "#E2583E",
        "pantone_value": "17-1456"
    },
    "support": {
        "url": "https://reqres.in/#support-heading",
        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
    }
}
```
## Test Case 6: Unsuccessful GET Request (Single Resource "User Not Found") (PASS)   

**Given** A GET request is sent to the server: `https://reqres.in/api/unknown/23`  
**When** The server responds with status code `404 Not Found`  
**Then** The server responds back with an empty body  
**And** the result printed like this: 

```json
{}
```
## Test Case 7: Successful POST Request (Create User) (PASS)

**Given** A POST request is sent to the endpoint: `https://reqres.in/api/users`  
**And** A body request is sent like this:
```json
{
    "name": "Gorjan",
    "job": "Quality Assurance"
}
```
**WHEN** the server response is status code: 201 Created     
**THEN** server respond back with body result printed like this:       
```json
{
    "name": "Gorjan",
    "job": "Quality Assurance",
    "id": "27",
    "createdAt": "2024-09-23T16:10:22.878Z"
}
```
## Test Case 8: Successful PUT Request (Update User) (PASS)

**Given** A PUT request is sent to the server: `https://reqres.in/api/users`  
**And** A PUT request is made for the user with an ID "5": `https://reqres.in/api/users/5`  
**And** The body values for the user "5" are:
```json
{
    "data": {
        "id": 5,
        "email": "charles.morris@reqres.in",
        "first_name": "Charles",
        "last_name": "Morris",
        "avatar": "https://reqres.in/img/faces/5-image.jpg"
    },
    "support": {
        "url": "https://reqres.in/#support-heading",
        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
    }
}
```
**AND** "name" value is set to "Gorjan"    
**AND** "job" value is set to "Quality Assurance"    
**AND** a body request is sent like this:    
```json
{
    "name": "Gorjan",
    "job": "Quality Assurance"
}
```
**WHEN** the server response is status code: 200 OK    
**THEN** server respond back with body result printed like this:    
```json
{
    "name": "Gorjan",
    "job": "Quality Assurance",
    "updatedAt": "2024-09-23T20:38:21.631Z"
}
```
## Test Case 9: Successful PATCH Request (Update User) (PASS)   

**Given** A PATCH request is sent to the server: `https://reqres.in/api/users`  
**And** A PATCH request is made for the user with an ID "5": `https://reqres.in/api/users/5`  
**And** The body values for the user "5" are:
```json
{
    "data": {
        "id": 5,
        "email": "charles.morris@reqres.in",
        "first_name": "Charles",
        "last_name": "Morris",
        "avatar": "https://reqres.in/img/faces/5-image.jpg"
    },
    "support": {
        "url": "https://reqres.in/#support-heading",
        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
    }
}
```
**AND** "name" value is set to "Gorjan"     
**AND** "job" value is set to "Quality Assurance"    
**AND** a sent body request is like this:     
```json
{
    "name": "Gorjan",
    "job": "Quality Assurance"
}
```
**WHEN** the server response is status code: 200 OK     
**THEN** server respond back with body result printed like this:     
```json
{
    "name": "Gorjan",
    "job": "Quality Assurance",
    "updatedAt": "2024-09-23T20:38:21.631Z"
}
```
## Test Case 10: Successful DELETE Request (Delete User) (PASS)

**Given** A DELETE request is sent to the server: `https://reqres.in/api/users`  
**When** A DELETE request is made for the user with an ID "5": `https://reqres.in/api/users/5`  
**Then** The server responds with status code `204 No Content`  
**And** The server does not respond back with a response body.

## Test Case 11: Successful POST Request (Register User) (PASS)

**Given** A POST request is sent to the server: `https://reqres.in/api/register`  
**And** A body request is sent like this:

```json
{
    "email": "eve.holt@reqres.in",
    "password": "pistol"
}
```
**WHEN** the server response is status code: 200 OK     
**THEN** server respond back with body result printed like this:     
```json
{
    "id": 4,
    "token": "{token value}"
}
```
## Test Case 12: Unsuccessful POST Request (Unsuccessful Register) (PASS)

**Given** A POST request is sent to the server: `https://reqres.in/api/register`  
**And** A body request is sent like this:   
```json
{
    "email": "eve.holt@reqres.in"
}
```
**WHEN** the server response is status code: 400 Bad Request    
**THEN** server respond back with body result printed like this:    
```json
{
    "error": "Missing password"
}
```
## Test Case 13: Successful POST Request (Successful Login) (PASS)

**Given** A POST request is sent to the server: `https://reqres.in/api/login`  
**And** A body request is sent like this:   

```json
{
    "email": "eve.holt@reqres.in",
    "password": "cityslicka"
}
```
**WHEN** the server response is status code: 400 Bad Request     
**THEN** server respond back with body result printed like this:    
```json
{
    "token": "QpwL5tke4Pnpja7X4"
}
```
# TEST CASE

## Test Case 14: Unsuccessful POST Request (Unsuccessful Login) (PASS)

**Given** A POST request is sent to the server: `https://reqres.in/api/login`    
**And** A body request is sent like this:  

```json
{
    "email": "peter@klaven"
}
```
WHEN the server response is status code: 400 Bad Request      
THEN server respond back with body result printed like this:   
```json
{
    "error": "Missing password"
}
```
