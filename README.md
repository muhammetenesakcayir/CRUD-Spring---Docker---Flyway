<h1 align="center"> Case </h1> <br>
<p align="center">
This project providers fundamental product operations. 

---
</p>


## Table of Contents

- [Run](https://github.com/muhammetenesakcayir/case#run)
- [Database Tables](https://github.com/muhammetenesakcayir/case#database-tables)
- [Endpoints](https://github.com/muhammetenesakcayir/case#endpoints)
- [Postman](https://github.com/muhammetenesakcayir/case#postman)
- [Flyway](https://github.com/muhammetenesakcayir/case#flyway)

### Run
Running the application in dev mode

You can run Postgres in your local using our docker-compose.yml file in the root folder. See env/local-database.env file for an additional config.

```shell script
docker-compose up
```

Then, you can run command as following;

```shell script
./gradlew bootRun
```


### Database Tables

![db](https://user-images.githubusercontent.com/30078377/129443453-8d9aad13-6bc4-4f7b-9730-f1dcca03f228.jpg)


### Endpoints

- [Product](https://github.com/muhammetenesakcayir/case#product)
    + [create](https://github.com/muhammetenesakcayir/case#create)
    + [update](https://github.com/muhammetenesakcayir/case#update)
    + [delete](https://github.com/muhammetenesakcayir/case#delete)
    + [list](https://github.com/muhammetenesakcayir/case#list)
    

#### Product
- ##### Create
    ```
   url: ../product | POST 
   ```
    - ###### request
  ```json
   {
    "title": "Tablet",
    "price": "300.00",
    "memberId": "1"
   }

   ```
    - ###### response
   ```
   {
    "productId": 2
  }
   ```

- ##### Update
    ```
   url: ../product | PUT 
   ```
    - ###### request
   ```
   {
    "title": "Tablet",
    "price": "550.00",
    "memberId": "1"
   }
   ```
    - ###### response
   ```
   200 (Http Ok)
   ```
- ##### Delete
    ```
   url: ../product | DELETE 
   ```
    - ###### request
  ```
  {
    "productId": "1"
  }
   ```
    - ###### response
   ```
   200 (Http Ok)
   ```
- ##### List
    ```
   url: ../products | GET
   ```
    - ###### response
   ```
   {
    "products": [
        {
            "id": 1,
            "title": "Tablet",
            "price": 300.00,
            "member": {
                "id": 1,
                "nickname": "John"
            }
        },
        {
            "id": 2,
            "title": "Phone",
            "price": 500.00,
            "member": {
                "id": 1,
                "nickname": "John"
            }
        }
    ]
}

#### Postman

You can use this postman collection to simulate http requests and responses

[enoca.postman_collection.zip](https://github.com/muhammetenesakcayir/case/files/6986324/enoca.postman_collection.zip)


#### Flyway

Flyway is a database migration tool also easy to use build database schema 

[Flyway with Spring](https://flywaydb.org/documentation/usage/plugins/springboot.html)
