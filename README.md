Na implementação do projeto foram utilizadas as tecnologias abaixo:

 IDE:
 IntelliJ IDEA
 https://www.jetbrains.com/idea/download/
 
 MAVEN, JSON
 
 Spring Boot :: (v1.5.2.RELEASE)
 https://start.spring.io/
 
 Dependências utilizadas no projeto são: Web, JPA, H2, Hateoas e Lombok.
 
 Para realizar os testes na API Rest foi utilizada a ferramenta: 
 https://www.getpostman.com/
 
 Para executar o projeto, basta realizar clone ou download e abrir no IntelliJ IDEA, será necessário estar conectado na internet para baixar as dependências através do MAVEN, após basta compilar e executar a classe principal: SpringBootSampleApplication.java
 
 Na raiz do projeto existe o arquivo testes-trabalho-java.exe, se trata de um vídeo demonstrando o funcionamento dos 12 ítens propostos e também como realizar os testes utilizando a API. 
 
 1. Ler o arquivo CSV das cidades para a base de dados;
	A partir do arquivo CSV enviado foram criados os dois arquivos de importação:
         -> data.sql: Criação da tabela com as colunas necessárias
         -> import.sql: Comandos insert criados a partir do CSV para importar os dados  para base de dados.	

2. Retornar somente as cidades que são capitais ordenadas por nome;

	Exemplo de execução: 
	http://localhost:8080/v1/cities/capitals

3. Retornar o nome do estado com a maior e menor quantidade de cidades e a
quantidade de cidades;

	Exemplo de execução: 
	http://localhost:8080/v1/cities/count-smaller-biggest-state


4. Retornar a quantidade de cidades por estado;
	
	Exemplo de execução: 
	http://localhost:8080/v1/cities/count-cities-by-state

5. Obter os dados da cidade informando o id do IBGE;
	Exemplo de execução: http://localhost:8080/v1/cities/city-by-id/1100155

6. Retornar o nome das cidades baseado em um estado selecionado;
	
	Exemplo de execução: 
	http://localhost:8080/v1/cities//cities-by-state/SC

7. Permitir adicionar uma nova Cidade;

Exemplo de execução:  
http://localhost:8080/v1/cities/insert

JSON:
{
    "uf": "SC",
    "name": "Cidade TESTE",
    "capital": "TRUE",
    "lon": -65.65656,
    "lat": -64.32323,
    "no_accents": "Teste",
    "alternaive_names": "Cidade TESTE2",
    "microregion": "Microregiao TESTE",
    "mesoregion": "Mesoregiao TESTE"
}

8. Permitir deletar uma cidade;
	
	Exemplo de execução: 
	http://localhost:8080/v1/cities/delete/1100502	

9. Permitir selecionar uma coluna (do CSV) e através dela entrar com uma string para
filtrar. retornar assim todos os objetos que contenham tal string;
	
	Exemplo de execução:
	http://localhost:8080/v1/cities/cities-by-column-filter/UF/DF/


10. Retornar a quantidade de registro baseado em uma coluna. Não deve contar itens
iguais;
	
	Exemplo de execução: 
	http://localhost:8080/v1/cities/count-cities-by-column/UF

11. Retornar a quantidade de registros total;
	
	Exemplo de execução: 
	http://localhost:8080/v1/cities/count-all
	
12. Dentre todas as cidades, obter as duas cidades mais distantes uma da outra com base
na localização (distância em KM em linha reta);
	
	Exemplo de execução: 	
	http://localhost:8080/v1/cities//most-distant-cities
