package ProblemaBarbeiroDorminhoco;

/**
 *
 * @author CReis
 */
public class Barbeiro extends Thread {

    private final SalaEspera listaCliente;
    private final RegistroPagamento registroPagamento;
    private Cliente cliente;

    public Barbeiro(String nome, SalaEspera listaCliente, RegistroPagamento registroPagamento) {
        super(nome);
        this.listaCliente = listaCliente;
        this.registroPagamento = registroPagamento;
        start();
    }

    private void chamandoClienteParaCortar() throws InterruptedException {
        synchronized (this.listaCliente) {
            if (this.listaCliente.getLista().isEmpty()) {
                System.out.println(this.getName() + " está dormindo esperando por clientes...");
                listaCliente.wait();
            } else {
                this.cliente = this.chamandoClientesEspacosLivres();
            }
        }

        if (this.cliente != null) {

            this.cliente.cortandoCabelo(this);
            synchronized (registroPagamento) {
                this.registroPagamento.aceitandoPagamento(this, cliente);
            }

            System.out.println(this.cliente.getName() + " saiu da barbearia e o " + this.getName() + " está livre para atender outro cliente");
        }
    }

    private Cliente chamandoClientesEspacosLivres() {

        this.cliente = this.listaCliente.pegarPrimeiro();
        this.listaCliente.getLista().remove(0);

        //Sofá
        for (int i = 0; i < 4; i++) {
            try {
                Cliente encontrarCliente = listaCliente.getLista().get(i);

                if (encontrarCliente.getStatus().equals(ClienteStatus.ESPERANDO)) {
                    encontrarCliente.setStatus(ClienteStatus.SENTADO);

                    System.out.println(this.getName() + " chamou o " + this.cliente.getName() + " para cortar e o " + encontrarCliente.getName() + " sentou no seu lugar no sofá");
                }
            } catch (Exception e) {
            }

        }

        return this.cliente;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.chamandoClienteParaCortar();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
