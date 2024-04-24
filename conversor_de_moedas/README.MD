O desafio de criar um conversor de moedas em Java passou por várias etapas:

Ambiente de Desenvolvimento Java: Configuração do ambiente de desenvolvimento Java, incluindo o IntelliJ IDEA.
Compreensão da API de Taxas de Câmbio: Utilização da API de taxas de câmbio (ExchangeRate-API) para obter as taxas de câmbio atualizadas.
Importação da Biblioteca Gson: Importação e utilização da biblioteca Gson para manipulação de JSON em Java.
Classe HttpClient: Utilização da classe HttpClient para fazer requisições HTTP para a API de taxas de câmbio.
Classe HttpRequest: Utilização da classe HttpRequest para construir requisições HTTP para a API.
HttpResponse: Utilização da classe HttpResponse para obter a resposta da API após a requisição.
Análise da Resposta JSON: Utilização da biblioteca Gson para analisar a resposta JSON da API e extrair as taxas de câmbio.
Filtragem das Moedas: Processo de filtrar as moedas desejadas a partir da resposta JSON da API.
Conversões entre as Moedas: Implementação das funções de conversão entre as moedas, utilizando as taxas de câmbio obtidas da API.
Interação com o Usuário: Implementação de uma interface textual no console para permitir que o usuário selecione as opções de conversão de moedas e forneça os valores a serem convertidos.
Ao final, o programa permite ao usuário escolher as conversões desejadas e fornece os valores convertidos com base nas taxas de câmbio obtidas da API.