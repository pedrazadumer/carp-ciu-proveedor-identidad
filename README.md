# [Fines Académicos] Servicio Operador Entidad Pública

### ¿Cómo probar?

* Subir el mockup del Servicio Operador Cliente (Ciudadano)
```shell script
$ mvn clean package
$ mvn spring-boot:run
```

* Ejecutar el llamado POST con los siguientes parámetros.

Parámetro | Valor
---|---
Metodo HTTP|POST
Endpoint|http://localhost:8085/proveedor-identidad/login
Request Params| username=TheUser </br> password=ThePassword
Request Headers|Content-Type=multipart/form-data