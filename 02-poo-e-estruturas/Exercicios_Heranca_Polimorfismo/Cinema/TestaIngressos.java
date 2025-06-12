package Cinema;

    public class TestaIngressos {

        public static void main(String[] args) {
            // Criando um ingresso normal
            Ingresso ingressoNormal = new Ingresso(30.00, "Duna: Parte 2", "Legendado");
            System.out.println("--- Ingresso Normal ---");
            System.out.println("Filme: " + ingressoNormal.getNomeFilme());
            System.out.println("Tipo: " + ingressoNormal.getTipoExibicao());
            System.out.println("Valor Real: R$ " + String.format("%.2f", ingressoNormal.getValorBase())); // Formatando para 2 casas decimais
            System.out.println("-----------------------");
            System.out.println();

            // Criando um ingresso de Meia Entrada
            MeiaEntrada meiaEntrada = new MeiaEntrada(30.00, "Vingadores: Ultimato", "Dublado");
            System.out.println("--- Ingresso Meia Entrada ---");
            System.out.println("Filme: " + meiaEntrada.getNomeFilme());
            System.out.println("Tipo: " + meiaEntrada.getTipoExibicao());
            System.out.println("Valor Real: R$ " + String.format("%.2f", meiaEntrada.getValorBase()));
            System.out.println("-----------------------------");
            System.out.println();

            // Criando um ingresso Família (3 pessoas, sem desconto)
            Familia ingressoFamilia1 = new Familia(30.00, "Divertida Mente 2", "Dublado", 3);
            System.out.println("--- Ingresso Família (3 pessoas) ---");
            System.out.println("Filme: " + ingressoFamilia1.getNomeFilme());
            System.out.println("Tipo: " + ingressoFamilia1.getTipoExibicao());
            System.out.println("Quantidade de Pessoas: " + ingressoFamilia1.getQuantidade());
            System.out.println("Valor Real: R$ " + String.format("%.2f", ingressoFamilia1.getValorBase())); // 30 * 3 = 90
            System.out.println("------------------------------------");
            System.out.println();

            // Criando outro ingresso Família (4 pessoas, com desconto)
            Familia ingressoFamilia2 = new Familia(30.00, "Planeta dos Macacos: O Reinado", "Legendado", 4);
            System.out.println("--- Ingresso Família (4 pessoas com desconto) ---");
            System.out.println("Filme: " + ingressoFamilia2.getNomeFilme());
            System.out.println("Tipo: " + ingressoFamilia2.getTipoExibicao());
            System.out.println("Quantidade de Pessoas: " + ingressoFamilia2.getQuantidade());
            System.out.println("Valor Base por pessoa: R$ " + ingressoFamilia2.valorBase); // Acesso direto ao protected
            System.out.println("Valor Calculado Sem Desconto: R$ " + String.format("%.2f", (ingressoFamilia2.valorBase * ingressoFamilia2.getQuantidade())));
            System.out.println("Valor Real (com desconto): R$ " + String.format("%.2f", ingressoFamilia2.getValorBase())); // (30 * 4) * 0.95 = 120 * 0.95 = 114
            System.out.println("---------------------------------------------");
        }
    }
