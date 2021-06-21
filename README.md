# API-Controle-de-Veiculos

Esta aplicaçao cadastra usuarios, veiculos e lista usuario e seus veiculos cadastrados. Faz uma busca a api externa para pesquisar o valor do veiculo, porém no momento os dados do veiculo tem que ser iguais ao que está na API, para retornar o valor. 

Tecnologias utilizadas:

* Spring Boot
* Banco H2
* JPA
* Spring Cloud OpenFeign
* Validation

# Endpoint usuario
localhost:8080/api/usuarios
Documentação postman: https://documenter.getpostman.com/view/14662521/TzeZFmoE

# Endpoint Veiculo
localhost:8080/api/veiculos
Documentação postman: https://documenter.getpostman.com/view/14662521/TzeZFmsW

# Endpoint Listagem
localhost:8080/api/listagem
Documentação postman: https://documenter.getpostman.com/view/14662521/TzeZFmsY

Essa api faz consulta a https://deividfortuna.github.io/fipe/ para buscar o valor do veiculo. 

