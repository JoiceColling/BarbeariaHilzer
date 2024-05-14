package ProblemaBarbeiroDorminhoco;

import java.util.Random;

/**
 *
 * @author CReis
 */
public class Cliente extends Thread {

    private final SalaEspera listaCliente;
    private ClienteStatus status = ClienteStatus.ESPERANDO;

    public Cliente(String nome, SalaEspera listaCliente) {
        super(nome);
        this.listaCliente = listaCliente;
    }

    public ClienteStatus getStatus() {
        return status;
    }

    public void setStatus(ClienteStatus status) {
        this.status = status;
    }

    private void procurandoProximoParaSentar() throws InterruptedException {
        synchronized (this.listaCliente) {
            if (this.listaCliente.getLista().size() < 4) {
                this.setStatus(ClienteStatus.SENTADO);
                System.out.println(this.getName() + " entrou na barbearia e sentou-se no sofá");
                listaCliente.notifyAll();
            } else {
                this.setStatus(ClienteStatus.ESPERANDO);
                System.out.println(this.getName() + " entrou na barbearia e está esperando em pé por um espaço no sofá");
            }

            this.listaCliente.adicionaNaLista(this);
        }
    }

    public void cortandoCabelo(Barbeiro barbeiro) throws InterruptedException {
        System.out.println(barbeiro.getName() + " está cortando o cabelo do " + this.getName());
        this.setStatus(ClienteStatus.CORTANDO);

        Thread.sleep(1000 + new Random().nextInt(2000));

        System.out.println(barbeiro.getName() + " cortou o cabelo do " + this.getName());
        this.setStatus(ClienteStatus.FINALIZADO);
    }

    @Override
    public void run() {
        try {
            this.procurandoProximoParaSentar();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
