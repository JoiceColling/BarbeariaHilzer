package ProblemaBarbeiroDorminhoco;

import java.util.concurrent.atomic.AtomicInteger;

public class ProblemaBarbeiroDorminhoco {

    public static final int QTD_CLIENTES = 20;
    public static final int QTD_BARBEIROS = 3;

    public static void main(String a[]) throws InterruptedException {
        AtomicInteger idCliente = new AtomicInteger(0);
        SalaEspera listaCliente = new SalaEspera(QTD_CLIENTES);

        RegistroPagamento registroPagamento = new RegistroPagamento();

        for (int i = 1; i <= QTD_BARBEIROS; i++) {
            new Barbeiro("Barbeiro #" + i, listaCliente, registroPagamento);
        }

        while (true) {
            if (!listaCliente.estaCheia()) {
                Cliente cliente = new Cliente("Cliente #" + (idCliente.getAndIncrement() + 1), listaCliente);
                cliente.start();
                Thread.sleep(100);
            } else {
                System.out.println("A barbearia está cheia, não há espaço para mais clientes!");
                Thread.sleep(10000);
            }
        }
    }
}
