package Sistema;

public class Vendedor extends Pessoa {
    private int vendas;

    public Vendedor(String nome, String email, String senha) {
        super(nome, email, senha);
        this.administrador = false;
        this.vendas = 0;
    }

    public void realizarVenda() {
        if (logado) {
            vendas++;
            System.out.println("Venda realizada com sucesso!");
        } else {
            System.out.println("Você precisa estar logado para vender.");
        }
    }

    public void consultarVendas() {
        System.out.println("Total de vendas realizadas: " + vendas);
    }
}
