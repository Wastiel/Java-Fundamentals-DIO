package Sistema;

public class Pessoa {
    private String nome;
    private String email;
    private String senha;
    protected boolean administrador;
    protected boolean logado;

    public Pessoa(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.logado = false;
    }

    public boolean login(String email, String senha) {
        if (this.email.equals(email) && this.senha.equals(senha)) {
            this.logado = true;
            return true;
        }
        return false;
    }

    public void logoff() {
        this.logado = false;
    }

    public void alterarSenha(String novaSenha) {
        this.senha = novaSenha;
    }

    public void alterarDados(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public boolean isLogado() {
        return logado;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public String getSenha() {
        return senha;
    }
}
