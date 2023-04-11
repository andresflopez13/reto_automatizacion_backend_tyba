# language: es
# Test Automation backend for Tyba
# Summary: This feature contains test cases for restful-booker rest api
# EP Authentication is deployed in https://restful-booker.herokuapp.com/apidoc/index.html#api-Auth

Característica: Autenticación en el sitio restful-booker por restapi

  Escenario: Autenticacion correcta
    Dado que "Andres" desea loguearse en restful-booker
    Cuando ingresa el email y contrasenia correcta
    Entonces verifica que el usuario se autentica correctamente

  Escenario: Autenticacion incorrecta
    Dado que "Andres" desea loguearse en restful-booker
    Cuando ingresa el email y contrasenia incorrecta
    Entonces verifica que el usuario no se autentica correctamente