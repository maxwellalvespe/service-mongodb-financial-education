# service-mongodb-financial-education

# Objetivo:

 - Criar serviço que consiga receber uma carga de dados referente ao contrato de financiamento de um veiculo e retorne o detalhamento 
 analitico baseado no input do usuário. "esse cenário é um caso de uso real , e os dados são coletados do portalRCI 
 através de um payload de um contrato ativo"
 
 - Criar recurso que gere a previsão de retorno de um investimento baseado no periodo de liquidez do 
 
 ## Qual o valor que esse projeto gerou?
 
 - após a analise do load inicial dos dados , foi verificado que é mais vantajoso no ano de 2023 quitar o financiamento de um automovel do que investir
 o valor a longo prazo com taxa de 1.4% a.m, pois baseado no lucro do valor investido ,o valor do juros era 18% superior ao lucro liquido obtido.
 
 ## Observações:
 - O projeto se encontra funcional porém, com o mapeamento dos dados especifico do portalRCI.
 - No projeto foi utilizado as seguintes ferramentas.
   - mongoDb
   - docker
   - java 19
   - Gradle
   - lombook
 
 - Para resolver a abordagem da previsão para saque de investimento foi utilizado dois recursos do java.time o DateTimeFormatter e o ChronoUnit 
 que para o caso de uso foi o suficiente para calcular os dias e retornar a data no padrão pt-br
 
