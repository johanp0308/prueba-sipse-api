
# Document Management test project

In this project, the approach combines both backend and frontend development to address the complex document management needs that companies face today. Document management is a fundamental aspect in the operation of any organization.

## Installation

To use our Project you must use git to download the repository:

```bash
  git clone https://github.com/johanp0308/prueba-sipse-api.git
```

To execute it, remember that you must have java on your computer to compile and interpret:

- To install java on windows [here](https://www.java.com/es/download/ie_manual.jsp)
- To install java on Linux maybe [here](https://www.java.com/es/download/help/linux_x64_install.html) remember that it may depend on the distro.


## Tech Stack

**Server:** Spring, Spring Boot

**Libreries:** Spring Security, JWT, Hibernate, MysqlConector, Jquery, Boostrap

## Documentation

- [Api Reference](./backend/api-x/apiDocumentation/API-doc.md)
- [Database Documentation](./backend/database_scripts/database_documetation.md)


For the API documentation, start the project and run the following in a browser
- Api Documentation: http://localhost:8080/doc/swagger-ui/index.html#/

## Config

To correctly configure the project you must create a database in your mysql service.

Recuerda el nombre de esa base de datos, porque es que usaremos en ela configuraciones de ellos:

Nos vamos a src/resources/application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/<database_name>
spring.datasource.username=<user>
spring.datasource.password=<password>
```

