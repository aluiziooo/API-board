# API-board
API que responde qual movimento resulta na melhor jogada para o jogador 'o'
API recebe uma string via URL contendo 9 caracteres, cada caractere representa a posição do tabuleiro 3x3

Dado uma posição x do tabuleiro a API retorna o melhor movimento possivel para a jogada.

Exemplo

Dada o tabuleiro: "xxo o   " 

represetação 2d: 
    x    x    o 
    -    o    - 
    -    -    - 


a API deve retornar como resposta: "xxo o o  "

representação 2d:
    x    x    o 
    -    o    - 
    o    -    - 
