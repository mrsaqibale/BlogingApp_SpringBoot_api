**Blogging App API**
=====================

**Overview**
-----------

This is a RESTful API for a blogging app, built using Spring Boot and Java. The API provides endpoints for managing blog posts, comments, categories, and users.

**API Endpoints**
---------------

### Posts

* **GET /posts**: Retrieve a list of all blog posts
* **GET /posts/:id**: Retrieve a single blog post by ID
* **POST /posts**: Create a new blog post
* **PUT /posts/:id**: Update an existing blog post
* **DELETE /posts/:id**: Delete a blog post

### Comments

* **GET /comments**: Retrieve a list of all comments
* **GET /comments/:id**: Retrieve a single comment by ID
* **POST /comments**: Create a new comment
* **PUT /comments/:id**: Update an existing comment
* **DELETE /comments/:id**: Delete a comment

### Categories

* **GET /categories**: Retrieve a list of all categories
* **GET /categories/:id**: Retrieve a single category by ID
* **POST /categories**: Create a new category
* **PUT /categories/:id**: Update an existing category
* **DELETE /categories/:id**: Delete a category

### Users

* **GET /users**: Retrieve a list of all users
* **GET /users/:id**: Retrieve a single user by ID
* **POST /users**: Create a new user
* **PUT /users/:id**: Update an existing user
* **DELETE /users/:id**: Delete a user

**Authentication**
---------------

The API uses JSON Web Tokens (JWT) for authentication. To authenticate, send a `POST` request to `/login` with a JSON payload containing the user's email and password.

