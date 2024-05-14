# BarbeariaHilzer
**Projeto realizado na disciplina de Processamento Paralelo, dentro do curso de Ciência da Computação, no ano de 2023.**

William Stallings (Stallings, 2012) apresenta uma versão mais complicada do problema da barbearia, que ele atribui a Ralph Hilzer da Universidade da Califórnia. O problema consiste em uma barbearia com três barbeiros e três cadeiras próprias de barbeiros, também existe uma série de lugares para que os clientes possam esperar. Tanto os barbeiros quanto os clientes devem ser implementados como Threads.

Requisitos:
1. Três cadeiras;
2. Três barbeiros;
3. Uma sala de espera com um sofá de quatro lugares;
4. O número total de clientes permitidos na barbearia é 20;
5. Nenhum cliente entrará se a capacidade do local estiver satisfeita;
6. Se o cliente entrou e tiver lugar no sofá ele se senta, caso contrário ele espera em pé;
quando um barbeiro está livre para atender, o cliente que está a mais tempo no sofá é
atendido e o que está a mais tempo em pé se senta;
7. Qualquer barbeiro pode aceitar pagamento, mas somente um cliente pode pagar por vez,
porque só há uma maquina de cartão (POS / TEF);
8. Os barbeiros dividem o seu tempo entre cortar cabelo, receber pagamento e dormir enquanto
esperam por um cliente.
