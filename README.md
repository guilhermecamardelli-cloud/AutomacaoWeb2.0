# Automação Web 2.0

Versão completa do projeto da aula de Teste e Qualidade de Software (original: [AutomacaoWeb](https://github.com/guilhermecamardelli-cloud/AutomacaoWeb)).

Automação do fluxo de compra no [SauceDemo (Swag Labs)](https://www.saucedemo.com) com Selenium + JUnit, no padrão Page Objects + Tasks:

login → adicionar produto → carrinho → checkout → overview → finish → validação da compra → logout

## Como rodar

Requer Java 25, Maven e Google Chrome.

```bash
cd sauceDemo
mvn test                      # abre o Chrome
mvn test -Dbrowser=HEADLESS   # sem abrir janela
```

## O que mudou em relação ao original

- Correções: id `login-button`, remoção dos `Thread.sleep(50000)`, `pom.xml` (`maven.compiler`, engine do JUnit, surefire), XPath do título (o site trocou `div` por `header`), argumentos do modo headless
- Novos: `CarrinhoPage`, `CheckoutInformacoesPage`, `OverviewPage`, `CheckoutCompletePage`, `CarrinhoTask`, `CheckoutTask`
- Validações com `assert` em cada tela e espera explícita na troca de páginas
