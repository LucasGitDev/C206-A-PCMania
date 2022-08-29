public class Computador {
    String marca;
    float preco;
    SistemaOperacional sistemaOperacional;
    HardwareBasico[] hardwareBasico;
    MemoriaUSB memoriaUSB;

    public Computador(String nome, float preco, String nomeSO, int tipoSO, HardwareBasico[] hardwaresBasicos) {
        this.marca = nome;
        this.preco = preco;
        this.sistemaOperacional = new SistemaOperacional(nomeSO, tipoSO);
        this.hardwareBasico = hardwaresBasicos;
    }

    public void mostraPCConfigs() {
        System.out.println("Marca: " + marca);
        System.out.println("Preço: " + preco);
        System.out.println("Sistema Operacional: " + sistemaOperacional.nome + " - " + sistemaOperacional.tipo);
        for (HardwareBasico hardwareBasico : hardwareBasico) {
            System.out.println("Hardware Básico: " + hardwareBasico.nome + " - " + hardwareBasico.capacidade);
        }
        System.out.println("Memória USB: " + memoriaUSB.nome + " - " + memoriaUSB.capacidade);
    }

    public void adicionaMemoriaUSB(MemoriaUSB memoriaUSB) {
        this.memoriaUSB = memoriaUSB;
    }
}
