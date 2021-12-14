package br.com.patric.coletordadosopticos;

public class Avaliacao {
    private String id;
    private String nomePacimente, nomeEmpresa, cpfPaciente;
    private LeituraAvalicao leituraPerto, leituraLonge;

    public Avaliacao(){

    }

    public Avaliacao(String id, String nomePacimente, String nomeEmpresa, String cpfPaciente) {
        this.id = id;
        this.nomePacimente = nomePacimente;
        this.nomeEmpresa = nomeEmpresa;
        this.cpfPaciente = cpfPaciente;
    }

    @Override
    public String toString() {
        return  "Nome Paciente: " + nomePacimente + " | " +
                "Nome Empresa: " + nomeEmpresa ;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomePacimente() {
        return nomePacimente;
    }

    public void setNomePacimente(String nomePacimente) {
        this.nomePacimente = nomePacimente;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public void setCpfPaciente(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
    }

    public LeituraAvalicao getLeituraPerto() {
        return leituraPerto;
    }

    public void setLeituraPerto(LeituraAvalicao leituraPerto) {
        this.leituraPerto = leituraPerto;
    }

    public LeituraAvalicao getLeituraLonge() {
        return leituraLonge;
    }

    public void setLeituraLonge(LeituraAvalicao leituraLonge) {
        this.leituraLonge = leituraLonge;
    }
}

