public class Cliente {
    String nome;
    long cpf;
    Computador[] computadores = new Computador[10];

    public Cliente(String nome, long cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public float calculaTotalCompra() {
        float total = 0;
        for (Computador computador : computadores) {
            if (computador != null) {
                total += computador.preco;
            }
        }
        return total;
    }

    public void adicionarComputadorAoCarrinho(Computador computador) {
        for (int i = 0; i < computadores.length; i++) {
            if (computadores[i] == null) {
                computadores[i] = computador;
                break;
            }
        }
    }

    public String getComputadores() {
        String result = "";
        for (int i = 0; i < computadores.length; i++) {
            if (computadores[i] != null) {
                result += "" + computadores[i].marca + "\n";
            }
        }
        return result;
    }
}
