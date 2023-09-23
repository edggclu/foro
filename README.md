# Challenge ONE | Back End | Foro Alura 

<p align="center" >
     <img width="200" heigth="200" src="https://user-images.githubusercontent.com/91544872/209678377-70b50b21-33de-424c-bed8-6a71ef3406ff.png">
</p>




- ### Tecnologías utilizadas:

  - [Intellij IDEA](https://www.jetbrains.com/idea/)
  - [MySql](https://www.mysql.com/)
  - [Java](https://www.java.com/en/)

  - [Spring Security](https://start.spring.io/)
  - [Token JWT](https://jwt.io/)

Este challenge numero 7, trato sobre el desarollo
de un Foro en Java junto con Spring Framework,
en la cual debimos hacernos cargo del mapeo de
entidades en entorno JPA y patron CRUD

### Dependencias
- Flyway
- Lombok
- Mysql-connector-j
- Spring starter web
- auth0
- Spring security
- Springdoc OpenApi 
 
### La aplicacion cuenta con
- Autenticacion de Usuarios mendiante JWToken
- Posteo de Nuevos Topicos
- Posteo de Respuestas a los topicos
- Metodo CRUD
- Validacion de Usurios Unicos
- Validacion de Topicos con titulo no repetible
- Ingreso en http://localhost:8090/swagger-ui/index.html#/

### [POST] . . /login
```json
{
  "nombre": "admin",
  "password": "admin"
}
```
![loginIMG.png](src%2Fmain%2Fresources%2Fimagenes%2FloginIMG.png)
 
- Agregar el token en el boton Authorize que se encuentra arriba a
derecha

![btnTokenIMG.png](src%2Fmain%2Fresources%2Fimagenes%2FbtnTokenIMG.png)


- Pegar el token

![tknPegarIMG.png](src%2Fmain%2Fresources%2Fimagenes%2FtknPegarIMG.png)


### Repositorio Base
- Basado en Foro - Alura - Challenge
- [Repositorio](https://github.com/alura-challenges/challenge-one-foro-alura)

### Socials ☄️
[![img](https://camo.githubusercontent.com/c00f87aeebbec37f3ee0857cc4c20b21fefde8a96caf4744383ebfe44a47fe3f/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f2d4c696e6b6564496e2d2532333030373742353f7374796c653d666f722d7468652d6261646765266c6f676f3d6c696e6b6564696e266c6f676f436f6c6f723d7768697465)](https://www.linkedin.com/in/edgar-garcia-luna/)


