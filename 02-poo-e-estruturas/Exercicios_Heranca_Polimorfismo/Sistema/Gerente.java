package Sistema;

public class Gerente extends Pessoa {

    public Gerente(String nome, String email, String senha) {
        super(nome, email, senha);
        this.administrador = true;
    }

    public void gerarRelatorioFinanceiro() {
        System.out.println("Relatório financeiro: [VALORES SIMULADOS]");
    }

    public void consultarVendas() {
        System.out.println("Consultando vendas do sistema (modo gerente)...");
    }
}
