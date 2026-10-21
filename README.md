# Automação Web 2.0

Versão completa e finalizada do projeto da aula de Teste e Qualidade de Software (original: [AutomacaoWeb](https://github.com/guilhermecamardelli-cloud/AutomacaoWeb)). Mesmas classes e métodos do projeto da aula, com os erros corrigidos.

Automação do fluxo de compra no [SauceDemo (Swag Labs)](https://www.saucedemo.com) com Selenium + JUnit:

login → adicionar produto → carrinho → checkout → overview → finish → validação da compra → logout

## Estrutura

| Pacote | Classes |
|---|---|
| `Framework` | `TesteBase`, `DriverManager`, `TypeBrowser` |
| `PageObjects` | `LoginPage`, `ProdutoPage`, `GenericPage`, `CartPage`, `CheckoutPage`, `FinishPage` |
| `Task` | `LoginTask`, `ProdutoTask`, `CheckoutTask`, `FinishTask` |
| `Validacao` | `GenericValidacao`, `FinnishValidacao`, `LoginValidacao` |
| `TestCases` | `RealizarCompraComSucesso` |

## Como rodar

Requer Java 25, Maven e Google Chrome.

```bash
cd sauceDemo
mvn test                      # abre o Chrome
mvn test -Dbrowser=HEADLESS   # sem abrir janela
```

## Correções em relação ao código da aula

- Erros de compilação: `}` faltando no `FinishPage`, linha incompleta e `finishValidacao` no `FinishTask`, classe `LoginValidacao` inexistente (criada)
- `NullPointerException`: `cartPage` e `genericValidacao` não eram inicializados
- Ids: `login-button` e `checkout` (minúsculos)
- Validações sem `try/catch`, para o teste falhar de verdade quando algo estiver errado, e com espera pela troca de página
- XPath do título (o site trocou `div` por `header`)
- `Thread.sleep(50000)` removidos
- Aviso de "senha vazada" do Chrome desativado (ele bloqueava o clique em Finish)
- `pom.xml`: `maven.compiler`, engine do JUnit e surefire configurado para a pasta `TestCases`
- Fluxo completo: `FinishTask` finaliza a compra, valida a mensagem de sucesso e faz logout
