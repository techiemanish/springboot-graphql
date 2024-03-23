# GraphQL Spring Boot Example

This project is a demonstration of how to integrate GraphQL with a Spring Boot application. It provides endpoints to query and mutate data related to books using GraphQL.

#### Author
This project was created by techiemanish.

## Prerequisites

Before running this project, ensure you have the following installed:

- Java Development Kit (JDK)
- Maven

## Getting Started

Follow these steps to get this project up and running on your local machine:

1. Clone the repository:

   ```bash
   git clone https://github.com/techiemanish/springboot-graphql.git
   ```

2. Navigate to the project directory:

   ```bash
   cd your-repo
   ```

3. Build the project using Maven:

   ```bash
   mvn clean install
   ```

4. Run the application:

   ```bash
   java -jar target/springboot-graphql.jar
   ```

## Usage

Once the application is up and running, you can interact with it using GraphQL queries. You can use tools like Postman or cURL to send GraphQL requests.

#### Endpoint: https://springboot-graphql.onrender.com/graphql

### Sample GraphQL Schema

```graphql
type Mutation {
    createBook(bookInput: BookInput): Book
}

type Query {
    getAllBooks: [Book]
    getBookById(bookId: Int): Book
}

type Book {
    id: ID!
    title: String
    desc: String
    author: String
    price: Float
    pages: Int
}

input BookInput {
    id: ID!
    title: String
    desc: String
    author: String
    price: Float
    pages: Int
}
```

### Example Queries

#### Get All Books

```graphql
{
  getAllBooks {
    id
    title
    desc
    author
    price
    pages
  }
}
```

#### Get Book by ID

```graphql
{
  getBookById(bookId: 123) {
    id
    title
    desc
    author
    price
    pages
  }
}
```

#### Create a Book

```graphql
mutation {
  createBook(bookInput: {
    id: "456"
    title: "Sample Book"
    desc: "This is a sample book."
    author: "John Doe"
    price: 29.99
    pages: 250
  }) {
    id
    title
    desc
    author
    price
    pages
  }
}
```

## Deployment

This application is deployed on cloud. Please use healthCheck url before hitting the graphQL query.

## Public URL

You can access a live version of this application at [https://springboot-graphql.onrender.com](#).
For the first time it will take 60 seconds. Once application is up, you can use it smoothly without any delay.


---
