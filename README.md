# Automação Web 2.0

Versão completa e finalizada do projeto da aula de Teste e Qualidade de Software (original: [AutomacaoWeb](https://github.com/guilhermecamardelli-cloud/AutomacaoWeb)), atualizada com a estrutura da versão de referência da turma ([automacaowebfundatec2](https://github.com/franvareira/automacaowebfundatec2)): relatório Allure, screenshots, dados com Faker, arquivos de properties e esperas explícitas.

Automação do fluxo de compra no [SauceDemo (Swag Labs)](https://www.saucedemo.com) com Selenium + JUnit:

login → adicionar produto → carrinho → checkout (dados aleatórios) → overview → finish → validação da compra → logout

## Estrutura

| Pacote | Classes |
|---|---|
| `Framework` | `TestBase` |
| `Framework.Browser` | `DriverManager`, `TypeBrowser`, `Waits` |
| `Framework.Utils` | `FakersGeneration`, `FileOperations`, `TakeScreenshot` |
| `PageObjects` | `LoginPage`, `ProdutoPage`, `GenericPage`, `CartPage`, `CheckoutPage`, `FinishPage` |
| `Tasks` | `LoginTask`, `ProdutoTask`, `CheckoutTask`, `FinishTask` |
| `Validacao` | `GenericValidacao`, `CheckoutValidacao`, `FinishValidacao`, `LoginValidacao` |
| `TestCases` | `RealizarCompraComSucessoTest` |

Arquivos de configuração em `src/main/resources/Properties`: `url.properties` (endereço do site) e `user.properties` (usuário e senha). Os dados gerados para o formulário vão para `target/Properties/form.properties`.

## Como rodar

Requer Java 25, Maven e Google Chrome.

```bash
cd sauceDemo
mvn test                      # abre o Chrome
mvn test -Dbrowser=HEADLESS   # sem abrir janela
mvn allure:serve              # abre o relatório Allure no navegador
```

O relatório mostra um print de cada tela validada e, se algo falhar, um print com o nome `ERRO`.

## Diferenças em relação à versão de referência

- Java 25 (a referência exige Java 27 com `--enable-preview`)
- Aviso de "senha vazada" do Chrome desativado: ele bloqueia o clique em Finish
- Screenshot de erro também quando um `assert` falha (`catch (AssertionError | RuntimeException e)`; `AssertionError` não é `Exception`)
- Sem `Thread.sleep`: todas as pages esperam o elemento com `Waits`, e a validação de título espera a troca de página
- `form.properties` gerado em `target/`, para o teste não alterar arquivos do projeto a cada execução
- `FileOperations` fecha os arquivos e avisa com erro claro quando não acha uma properties
- Nomes corrigidos: `visibilityOfElement` e `getFirstName`
- `Locale.of("pt", "BR")` no Faker; argumentos do modo headless corrigidos
