# language: es

Característica: Autenticación en el sitio restful-booker por restapi

  Escenario: Autenticacion correcta
    Dado que "Andres" desea loguearse en restful-booker
    Cuando ingresa el email y contrasenia correcta
    Entonces verifica que el usuario se autentica correctamente

  Escenario: Autenticacion incorrecta
    Dado que "Andres" desea loguearse en restful-booker
    Cuando ingresa el email y contrasenia incorrecta
    Entonces verifica que el usuario no se autentica correctamente