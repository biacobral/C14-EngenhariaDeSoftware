Este é um resumo do material, com foco nos pontos importantes para a prova, e uma lista de exercícios com questões fechadas, conforme solicitado.

---

## Resumo e Pontos Importantes para a Prova

### 1. Fundamentos e Definição de Engenharia de Software (ES)

A Engenharia de Software (C14) é a área da Computação que se preocupa em propor e aplicar **princípios de engenharia na construção de software**. A ES trata da aplicação de abordagens sistemáticas, disciplinadas e quantificáveis para desenvolver, operar, manter e evoluir software. Seu objetivo é investigar desafios e propor soluções que permitam desenvolver sistemas de software complexos e de grande tamanho de forma produtiva e com qualidade.

**Pontos-chave:**

*   **Dificuldades Essenciais:** Construir software é desafiador devido a quatro dificuldades essenciais:
    *   **Complexidade:** Software é uma das construções mais desafiadoras e complexas existentes.
    *   **Conformidade:** O software deve se adaptar ao seu ambiente, que muda constantemente (ex: leis de impostos).
    *   **Facilidade de Mudanças:** Sistemas bem-sucedidos recebem mais demanda por mudanças e novas funcionalidades.
    *   **Invisibilidade:** É difícil visualizar o tamanho do software e estimar o esforço de construção.
*   O termo Engenharia de Software foi usado pela primeira vez na Conferência da OTAN na Alemanha, em 1968.
*   **Conceitos de Erro:**
    *   **Defeito (ou Bug, termo informal):** Um erro no código (ex: fórmula incorreta).
    *   **Falha:** Ocorre quando um código com defeito é executado e leva o programa a apresentar um resultado incorreto (ex: Falha do Ariane 5, causada por conversão de tipos).
*   **Estrutura da Avaliação (C14):**
    *   A nota final (NFA) é calculada como $NPA$, onde $NPA = (NPT \times 0.6) + (NPL \times 0.4)$.
    *   $NPT$ (Nota da Parte Teórica) é a média de $NP1$ e $NP2$, e deve ser $\ge 60$.
    *   $NP1$: Prova (0.5) + Listas de Exercícios (0.5).
    *   $NP2$: Prova (0.3) + Projeto laboratório (0.7).
    *   $NPL$ (Nota do Projeto Laboratório) deve ser $\ge 60$.
    *   Reprovação direta ocorre se $NPA < 30$. Se $30 \le NPA \le 60$, o aluno faz $NP3$.

### 2. Gerência de Dependências e Controle de Versão (Maven e Git)

#### Maven
O Maven é usado para **Gerência de Dependências** e **Automatização da Build**.

*   **Build:** Processo de geração do software como produto, geralmente envolvendo teste automatizado, compilação e empacotamento (ex: gerar um `.jar`).
*   **Gerência de Dependências:** O Maven resolve a dificuldade de baixar bibliotecas e gerenciar suas atualizações.
*   **Componentes:**
    *   **POM (`pom.xml`):** Arquivo central de configuração (`Project Object Model`) onde se define dependências, nome do `.jar`, tipo de empacotamento, e instruções de build.
    *   **Repositório Central:** Local onde artefatos de software (bibliotecas, frameworks) estão armazenados e acessíveis (ex: `https://mvnrepository.com`).
    *   **Repositório Local:** O Maven baixa dependências para um repositório local antes de buscar no repositório central.
*   **Convenção:** O Maven usa *convention over configuration* e espera uma estrutura de diretórios específica (ex: `src/main/java` para código principal e `src/test/java` para código de teste).
*   **Comando de Build:** `mvn package` compila o projeto, executa os testes de unidade e gera o arquivo empacotado (jar).

#### Git (Controle de Versão)
O Git é um **Sistema de Controle de Versões Distribuído (DVCS)**.

*   **DVCS:** Cada cliente possui um repositório local completo, permitindo trabalhar *offline*.
*   **Estrutura (Três Áreas):** O Git manipula três áreas:
    *   **Diretório de Trabalho (Working Directory):** Onde se encontram os arquivos.
    *   **Stage (Área Intermediária):** Armazena temporariamente os arquivos que pretendemos versionar (arquivos adicionados com `git add`).
    *   **Repositório (`.git`):** Armazena o histórico de *commits* (fotografias instantâneas do arquivo).
*   **Comandos Essenciais:**
    *   `git init`: Cria um repositório vazio local.
    *   `git clone <URL>`: Copia commits de um repositório remoto para um local.
    *   `git add <arquivo>`: Adiciona o arquivo à área de *Stage*.
    *   `git commit -m "Mensagem"`: Tira a "foto" dos arquivos no *Stage* e armazena no repositório local.
    *   `git push`: Envia os *commits* locais para o repositório central.
    *   `git pull`: Traz os *commits* do repositório central para o repositório local.
    *   **Branch:** Permite que desenvolvedores trabalhem de forma isolada do repositório principal.
    *   **Merge:** Serve para intercalar *commits* de diferentes *branches*.

### 3. Teste de Software, Teste de Unidade e Mock

Testar o software é crucial para evitar desconforto, prejuízos e catástrofes. Testes modernos são principalmente **automatizados** e implementados durante o desenvolvimento.

*   **Tipos de Testes por Granularidade/Escopo:**
    *   **Teste de Unidade (Foco):** Testes automatizados de **pequenas unidades de código de forma isolada** (normalmente uma classe e seus métodos).
    *   **Teste de Integração:** Interessa-se em testar várias classes para verificar uma funcionalidade completa (não se usa Mocks).
    *   **Teste de Sistema:** Testa o sistema como um todo.
    *   **Teste Funcional:** Verifica se a funcionalidade opera, generalizando testes a nível de código.
*   **Teste de Unidade em Prática (JUnit):**
    *   Métodos de teste são anotados com `@Test` e geralmente são *públicos*, *sem parâmetros* e *retorno void*.
    *   O método de teste tem **três partes**:
        1.  **Fixture (Contexto):** Inicialização e instanciação dos objetos.
        2.  **Execução:** Chama o método a ser testado e armazena o resultado.
        3.  **Assertiva:** Verifica se o teste passou/falhou, usando métodos como `assertTrue()`, `assertEquals(expectativa, realidade)` ou `assertSame()`.
    *   **Princípios FIRST (para Testes Unitários de Qualidade):**
        *   **F**ast (Rápido): Devem ser executados com frequência, logo devem ser rápidos.
        *   **I**ndependent (Independente): A ordem de execução não deve alterar o resultado (não podem alterar o estado global).
        *   **R**epeatable (Repetível): Devem ter o mesmo resultado sempre. Se o resultado é intermitente, são chamados de testes *Flaky*.
        *   **S**elf-Checking (Auto-Verificáveis): O resultado deve ser imediato (Passou/Falhou).
        *   **T**imely (Oportuno): Devem ser escritos o quanto antes.

*   **Teste Mock:**
    *   Necessário quando a classe testada depende de outras classes não implementadas ou de **acesso a recursos externos** (BD, Web Service), que são complexos ou lentos de configurar.
    *   **Objetos Mock** são objetos simulados que "imitam" o comportamento de objetos reais de forma controlada.
    *   A classe testada precisa ser preparada para receber objetos mock, geralmente por meio de **Injeção de Dependências** (via construtor ou *setter*).
    *   Frameworks como **Mockito** facilitam a criação de mocks (usando `@Mock`) e a configuração de seus comportamentos (usando `when().thenReturn()`), eliminando a necessidade de criar classes mock manuais.

### 4. TDD (Desenvolvimento Dirigido por Testes)

TDD é uma **metodologia** de desenvolvimento proposta pelo eXtreme Programming (XP).

*   **Ciclo do TDD:**
    1.  **Vermelho (Red):** Escrever um teste que falha (ou não compila, pois o código de produção ainda não existe).
    2.  **Verde (Green):** Escrever o código de produção **suficiente e mais simples possível** para que o teste passe.
    3.  **Azul/Refatorar (Refactor):** Melhorar o código, focando em limpeza e legibilidade, garantindo que todos os testes continuem passando.
*   **Vantagens:** Força a escrita de testes de unidade e favorece classes com alta testabilidade. Melhora o design do código, pois o desenvolvedor age como usuário da classe.
*   **Padrões TDD (Step Patterns):**
    1.  **API Definition:** O primeiro teste define a interface da classe (Método/Classe).
    2.  **Differential Test:** Mudar o cenário para forçar um incremento pequeno no código de produção (ex: testar *para cima* após testar *parado*).
    3.  **Exceptional Limit:** Criar testes para cenários inválidos ou limites, forçando a classe a tratar exceções (ex: `pop` em pilha vazia).
    4.  **Everything Working Together:** Adicionar cenários para verificar a integração entre duas ou mais funcionalidades.

### 5. Integração e Entrega Contínua (CI/CD e DevOps)

DevOps é um movimento que visa unificar as culturas de Desenvolvimento (Dev) e Operações (Ops), permitindo a implantação mais **ágil** de um sistema através da **automatização**.

*   **Integração Contínua (CI):** Prática que exige que os desenvolvedores integrem o código de forma **frequente** (recomendação de ao menos uma vez ao dia) no *branch* principal (ex: *master* ou *main*).
    *   **Objetivo:** Evitar conflitos de integração e o *Merge Hell* que surgem quando os *branches* têm longa duração.
    *   **Servidor de CI:** Após um novo *commit*, o servidor clona o repositório, executa a *build* e roda **todos os testes**. Se a *build* falhar, ela "quebrou".
    *   **TBD (Trunk Based Development):** É comum em CI/CD não haver *branches* longos, adotando o desenvolvimento baseado no tronco principal.

*   **Deployment Contínuo (CD - Continuous Deployment):** Proposta do DevOps onde **todo novo commit** que passa pelo CI pode entrar em produção **imediatamente**.
    *   **Vantagem:** Reduz o tempo de entrega, e a equipe recebe *feedback* rápido do cliente.
*   **Entrega Contínua (Continuous Delivery):** Similar ao Deployment Contínuo, mas existe uma figura manual que irá **autorizar ou não** a entrada em produção.
*   **Feature Flags:** Uma solução para que o software incompleto possa entrar em produção (evitando *branches* longos). A parte incompleta é desabilitada por uma variável booleana, controlando o que o usuário vê.
    *   **Uso:** Podem ser usadas para **Release Canário** (liberar funcionalidade para um pequeno grupo) ou **Testes A/B** (liberar duas versões para testar valor).

---

## Lista de Exercícios (Questões Fechadas)

### Questão 1 (Engenharia de Software - Fundamentos)
Qual dos conceitos abaixo **NÃO** é listado como uma das dificuldades essenciais encontradas para construir um software, segundo as fontes?

a) Complexidade
b) Invisibilidade
c) Facilidade de Mudanças
d) Modularidade

**Resposta correta:** d) Modularidade

### Questão 2 (Git - Controle de Versão)
O Git, um Sistema de Controle de Versões Distribuído (DVCS), manipula o código em três áreas principais. Qual área é responsável por armazenar temporariamente os arquivos que o desenvolvedor pretende versionar antes de realizar o *commit*?

a) Working Directory (Diretório de Trabalho)
b) Repository (Repositório)
c) Stage (Área Intermediária)
d) Main Branch

**Resposta correta:** c) Stage (Área Intermediária)

### Questão 3 (Maven - Build e Dependências)
Qual dos seguintes itens é um propósito central do Maven em um projeto de software, além da Gerência de Dependências?

a) Ser o Repositório Central para todos os artefatos de software.
b) Ser o Servidor de Integração Contínua (CI).
c) Automatizar o processo de *Build*, que inclui etapas como teste automatizado, compilação e empacotamento.
d) Implementar o ciclo Red, Green, Refactor do TDD.

**Resposta correta:** c) Automatizar o processo de *Build*, que inclui etapas como teste automatizado, compilação e empacotamento.

### Questão 4 (Teste de Unidade - Princípios)
O princípio **FIRST** para a escrita de testes de unidade de qualidade inclui a característica de que os testes devem ser **Repeatable (Repetível)**. O que significa essa característica?

a) Os testes devem ter o mesmo resultado se executados N vezes.
b) A ordem de execução dos testes não deve alterar o resultado.
c) O resultado deve ser imediato (Passou/Falhou) para o desenvolvedor.
d) Os testes devem ser executados apenas no final do projeto, para garantir a repetibilidade.

**Resposta correta:** a) Os testes devem ter o mesmo resultado se executados N vezes.

### Questão 5 (TDD - Ciclo)
Qual é a ordem correta das etapas no ciclo de desenvolvimento Test Driven Development (TDD)?

a) Verde (escrever código) -> Vermelho (escrever teste) -> Refatorar.
b) Vermelho (escrever teste que falha) -> Verde (escrever código mínimo) -> Azul (Refatorar).
c) Refatorar -> Verde (escrever código) -> Vermelho (escrever teste).
d) Escrever teste -> Refatorar -> Escrever código.

**Resposta correta:** b) Vermelho (escrever teste que falha) -> Verde (escrever código mínimo) -> Azul (Refatorar).

### Questão 6 (Teste Mock)
Ao realizar Teste de Unidade, é uma boa prática substituir uma dependência complexa (como acesso a um Web Service ou Banco de Dados) por um **Objeto Mock**. A técnica de design de código que permite que o objeto mock seja inserido na classe testada de forma controlada é conhecida como:

a) Injeção de Dependências.
b) Teste Baseado em Estado.
c) Gerência de Configuração.
d) TDD.

**Resposta correta:** a) Injeção de Dependências.

### Questão 7 (CI/CD - Conceitos)
Qual é a principal diferença entre **Continuous Deployment (Deployment Contínuo)** e **Continuous Delivery (Entrega Contínua)**, de acordo com as fontes?

a) Deployment Contínuo permite *branches* de longa duração, enquanto Entrega Contínua não.
b) Deployment Contínuo exige que *todo commit* possa entrar em produção imediatamente, enquanto na Entrega Contínua, a entrada em produção é autorizada manualmente.
c) Deployment Contínuo depende de *feature flags*, enquanto Entrega Contínua não.
d) Deployment Contínuo é usado apenas em aplicações móveis e desktop, e Entrega Contínua em aplicações web.

**Resposta correta:** b) Deployment Contínuo exige que *todo commit* possa entrar em produção imediatamente, enquanto na Entrega Contínua, a entrada em produção é autorizada manualmente.
