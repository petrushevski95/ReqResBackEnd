# ACCEPTANCE CRITERIA

## Test Scenario 1: Successful GET Request (Get User's List)

**Given**  A GET request is sent to the server:  `https://reqres.in/api/users?page=[page number]`
**When**  The server responds with status code 200 OK
**Then**  The server responds back with a body result printed like this:
```json
{
    "page": ,
    "per_page": ,
    "total": ,
    "total_pages": ,
    "data": [
        {
            "id": ,
            "email": "",
            "first_name": "",
            "last_name": "",
            "avatar": ""
        },
        {
            "id": ,
            "email": "",
            "first_name": "",
            "last_name": "",
            "avatar": ""
        },
        {
            "id": ,
            "email": "",
            "first_name": "",
            "last_name": "",
            "avatar": ""
        }
        ...
    ]
}
```
## Test Scenario 2: Successful GET Request (Single User)

**Given** A GET request is sent to the server: `https://reqres.in/api/users/[id]`  
**When** The server responds with status code 200 OK  
**Then** The server responds back with a body result printed like this:

```json
{
    "data": {
        "id": ,
        "email": "",
        "first_name": "",
        "last_name": "",
        "avatar": ""
    },
    "support": {
        "url": "",
        "text": ""
    }
}
```
## Test Scenario 3: Unsuccessful GET Request (Single User "User Not Found")

**Given** A GET request is sent to the server: `https://reqres.in/api/users/[id]`  
**When** The server responds with status code 404 Not Found  
**Then** The server responds back with an empty body  
**And** the result printed like this:  

```json
{}
```
## Test Scenario 4: Successful GET Request (Get Resource's List)

**Given** A GET request is sent to the server: `https://reqres.in/api/unknown`  
**When** The server responds with status code 200 OK  
**Then** The server responds back with a body result printed like this:

```json
{
    "page": ,
    "per_page": ,
    "total": ,
    "total_pages": ,
    "data": [
        {
            "id": ,
            "name": "",
            "year": ,
            "color": "#",
            "pantone_value": ""
        },
        {
            "id": ,
            "name": "",
            "year": ,
            "color": "#",
            "pantone_value": ""
        },
        {
            "id": ,
            "name": "",
            "year": ,
            "color": "#",
            "pantone_value": ""
        }
        ...
    ]
}
```
## Test Scenario 5: Successful GET Request (Single Resource)

**Given** A GET request is sent to the server: `https://reqres.in/api/unknown/[id]`  
**When** The server responds with status code 200 OK  
**Then** The server responds back with a body result printed like this:

```json
{
    "data": {
        "id": ,
        "name": "",
        "year": ,
        "color": "",
        "pantone_value": ""
    },
    "support": {
        "url": "",
        "text": ""
    }
}
```
## Test Scenario 6: Unsuccessful GET Request (Single Resource "User Not Found")

**Given** A GET request is sent to the server: `https://reqres.in/api/unknown/[id]`  
**When** The server responds with status code 404 Not Found  
**Then** The server responds back with an empty body  
**And** the result printed like this:  

```json
{}
```
## Test Scenario 7: Successful POST Request (Create User)

**Given** A POST request is sent to the endpoint: `https://reqres.in/api/users`  
**And** a body request is sent like this:
```json
{
    "name": "",
    "job": ""
}
```
**WHEN** the server response is status code: 201 Created
**THEN** server respond back with body result printed like this:
```json
{
    "name": "",
    "job": " ",
    "id": "",
    "createdAt": ""
}
```
## Test Scenario 8: Successful PUT Request (Update User)

**Given** A PUT request is sent to the server: `https://reqres.in/api/users/[id]`  
**And** a body request is sent like this:

```json
{
    "name": "",
    "job": ""
}
```
**When** The server response is status code 200 OK  
**Then** The server responds back with a body result printed like this:
```json
{
    "id": [id],
    "title": "",
    "body": ""
}
```

## Test Scenario 9: Successful PATCH Request (Update User)

**Given** A PATCH request is sent to the server: `https://reqres.in/api/users/[id]`  
**And** a body request is sent like this:

```json
{
    "name": "",
    "job": ""
}
```
**WHEN** the server response is status code: 200 OK
**THEN** server respond back with body result printed like this:
```json
{
    "id": [id],
    "title": "",
    "body": ""
}
```
## Test Scenario 10: Successful DELETE Request (Delete User)

**Given** A DELETE request is sent to the server: `https://reqres.in/api/users/[id]`  
**When** The server responds with status code 204 No Content  
**Then** The server does not respond back with a response body.

## Test Scenario 11: Successful POST Request (Register User)

**Given** A POST request is sent to the server: `https://reqres.in/api/register`  
**And** a body request is sent like this:

```json
{
    "email": "",
    "password": ""
}
```
**When** The server response is status code `200 OK`  
**Then** The server responds back with a body result printed like this:

```json
{
    "id": ,
    "token": ""
}
```
## Test Scenario 12: Unsuccessful POST Request (Unsuccessful Register)

**Given** A POST request is sent to the server: `https://reqres.in/api/register`  
**And** a body request is sent like this:

```json
{
    "email": ""
}
```
**WHEN** the server response is status code: 400 Bad Request
**THEN** server respond back with body result printed like this:
```json
{
    "error": "Missing password"
}
```
## Test Scenario 13: Successful POST Request (Successful Login)

**Given** A POST request is sent to the server: `https://reqres.in/api/login`  
**And** a body request is sent like this:

```json
{
    "email": "",
    "password": ""
}
```
**WHEN** the server response is status code: 201 Created
**THEN** server respond back with body result printed like this:
```json
{
    "token": ""
}
```
## Test Scenario 14: Unsuccessful POST Request (Unsuccessful Login)

**Given** A POST request is sent to the server: `https://reqres.in/api/login`  
**And** a body request is sent like this:

```json
{
    "email": ""
}
```
**WHEN** the server response is status code: 400 Bad Request
**THEN** server respond back with body result printed like this:
```json
{
    "error": "Missing password"
}
```
