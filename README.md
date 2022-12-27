# Spring Data JPA
Для HEROKU:
Потрібно в корені проекту створити файл system.properties
І прописати рядок
java.runtime.version=11
Якщо у вас 11 версія jdk



Your task is:
- add required dependencies
- use H2 DB
- enable H2 console
- enable generated SQL statement logging
- create model `Product` with fields
    - id
    - title
    - price
    - manufacturer (one phone can have one manufacturer)
- create model `Category` with fields
    - id
    - name
- create `ProductRepository` and `CategoryRepository`
- create `ProductService` and `CategoryService`
- create `ProductController`. Via the controller you must be able to:
    - create a new Product
    - get Product by ID
    - delete Product by ID
    - update Product
    - get all products where price is between two values received as a `RequestParam` inputs
    - get all products in categories 
        (you should think how you will receive a list of categories as a `RequestParam` input)
- create `CategoryController`. Via the controller you must be able to:
    - create a new Category
    - get Category by ID
    - delete Category by ID
    - update Category
- create required DTOs and mappers
