package ProblemaBarbeiroDorminhoco;

import java.util.ArrayList;

/**
 *
 * @author CReis
 */
public class SalaEspera {

    private final Integer tamMaximo;
    public ArrayList<Cliente> listaCliente;

    SalaEspera(int tam) {
        this.tamMaximo = tam;
        this.listaCliente = new ArrayList<Cliente>(tam);
    }

    public ArrayList<Cliente> getLista() {
        return this.listaCliente;
    }

    public boolean estaCheia() {
        return this.listaCliente.size() == this.tamMaximo;
    }

    public Cliente pegarPrimeiro() {
        return this.listaCliente
                .stream()
                .findFirst()
                .orElse(null);
    }

    public void adicionaNaLista(Cliente cliente) {

        if (!estaCheia()) {
            this.listaCliente.add(cliente);
        }
    }
}
