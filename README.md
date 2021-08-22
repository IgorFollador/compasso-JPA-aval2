# compasso-JPA-aval2
Projeto avaliativo da segunda sprint da trilha Java e SpringBoot

### Instruções:

- Para execução do primeiro exercício (CRUD de produtos) é necessário executar a classe `ExecutaCrud.java`;

- Para execução do segundo exercício (Filmes e páginas) é necessário executar a classe `ExecutaFilmesEPaginas.java`, onde na primeira vez que for iniciado é necessário utilizar a opção `2 - Cadastrar Filmes`, para que assim possamos persistir os dados da tabela `filmes`;

- Para execução do terceiro exercício ([OBI 2020] Emoticons) é necessário executar a classe `ExecutaSentimentosEmMensagem.java` e inserir as entradas;

  

#### Configurações:

As configurações do Hibernate para o MySQL estão localizadas em `~/JPA_avaliacao/src/main/resources/META-INF/persistence.xml`.

##### Possuindo as configurações de porta, usuário e senha abaixo:

```xml
            <property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver"/>
            <property name="javax.persistence.jdbc.url" 
                      value="jdbc:mysql://localhost:3306/banco_igorf?createDatabaseIfNotExist=true"/>
            <property name="javax.persistence.jdbc.user" value="root"/>
            <property name="javax.persistence.jdbc.password" value="root"/>

```



##### OBS:

Este é um projeto Maven, no qual foi utilizada apenas linguagem Java e o SGBD MySQL.
O banco de dados é gerado automaticamente ao executar as classes.

- Nome do banco `banco_igorf`;
- Usuário padrão `root`;
- Senha padrão `root`;
