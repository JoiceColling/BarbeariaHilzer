package ProblemaBarbeiroDorminhoco;

/**
 *
 * @author CReis
 */
public class RegistroPagamento {

    public void aceitandoPagamento(Barbeiro barbeiro, Cliente cliente) throws InterruptedException {
        System.out.println(cliente.getName() + " está pagando para o " + barbeiro.getName());
        Thread.sleep(1500);

        System.out.println(barbeiro.getName() + " recebeu o pagamento do " + cliente.getName());

    }
}
