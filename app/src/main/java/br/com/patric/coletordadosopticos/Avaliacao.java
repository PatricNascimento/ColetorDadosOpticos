package br.com.patric.coletordadosopticos;
public class Avaliacao {
    private String id, nomePaciente, nomeEmpresa, cpfPaciente;
    private Double leituraPertoOdEsferico, leituraPertoOdCilindrico, leituraPertoOdEixo;
    private Double leituraPertoOeEsferico, leituraPertoOeCilindrico, leituraPertoOeEixo;
    private Double leituraLongeOdEsferico, leituraLongeOdCilindrico, leituraLongeOdEixo;
    private Double leituraLongeOeEsferico, leituraLongeOeCilindrico, leituraLongeOeEixo;

    public Avaliacao(){

    }

    public Avaliacao(String id, String nomePaciente, String nomeEmpresa, String cpfPaciente, Double leituraPertoOdEsferico,
                     Double leituraPertoOdCilindrico, Double leituraPertoOdEixo, Double leituraPertoOeEsferico,
                     Double leituraPertoOeCilindrico, Double leituraPertoOeEixo, Double leituraLongeOdEsferico,
                     Double leituraLongeOdCilindrico, Double leituraLongeOdEixo, Double leituraLongeOeEsferico,
                     Double leituraLongeOeCilindrico, Double leituraLongeOeEixo) {
        this.id = id;
        this.nomePaciente = nomePaciente;
        this.nomeEmpresa = nomeEmpresa;
        this.cpfPaciente = cpfPaciente;
        this.leituraPertoOdEsferico = leituraPertoOdEsferico;
        this.leituraPertoOdCilindrico = leituraPertoOdCilindrico;
        this.leituraPertoOdEixo = leituraPertoOdEixo;
        this.leituraPertoOeEsferico = leituraPertoOeEsferico;
        this.leituraPertoOeCilindrico = leituraPertoOeCilindrico;
        this.leituraPertoOeEixo = leituraPertoOeEixo;
        this.leituraLongeOdEsferico = leituraLongeOdEsferico;
        this.leituraLongeOdCilindrico = leituraLongeOdCilindrico;
        this.leituraLongeOdEixo = leituraLongeOdEixo;
        this.leituraLongeOeEsferico = leituraLongeOeEsferico;
        this.leituraLongeOeCilindrico = leituraLongeOeCilindrico;
        this.leituraLongeOeEixo = leituraLongeOeEixo;
    }
    @Override
    public String toString() {
        return  "Nome Paciente: " + nomePaciente + " | " +
                "Nome Empresa: " + nomeEmpresa ;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
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

    public Double getLeituraPertoOdEsferico() {
        return leituraPertoOdEsferico;
    }

    public void setLeituraPertoOdEsferico(Double leituraPertoOdEsferico) {
        this.leituraPertoOdEsferico = leituraPertoOdEsferico;
    }

    public Double getLeituraPertoOdCilindrico() {
        return leituraPertoOdCilindrico;
    }

    public void setLeituraPertoOdCilindrico(Double leituraPertoOdCilindrico) {
        this.leituraPertoOdCilindrico = leituraPertoOdCilindrico;
    }

    public Double getLeituraPertoOdEixo() {
        return leituraPertoOdEixo;
    }

    public void setLeituraPertoOdEixo(Double leituraPertoOdEixo) {
        this.leituraPertoOdEixo = leituraPertoOdEixo;
    }

    public Double getLeituraPertoOeEsferico() {
        return leituraPertoOeEsferico;
    }

    public void setLeituraPertoOeEsferico(Double leituraPertoOeEsferico) {
        this.leituraPertoOeEsferico = leituraPertoOeEsferico;
    }

    public Double getLeituraPertoOeCilindrico() {
        return leituraPertoOeCilindrico;
    }

    public void setLeituraPertoOeCilindrico(Double leituraPertoOeCilindrico) {
        this.leituraPertoOeCilindrico = leituraPertoOeCilindrico;
    }

    public Double getLeituraPertoOeEixo() {
        return leituraPertoOeEixo;
    }

    public void setLeituraPertoOeEixo(Double leituraPertoOeEixo) {
        this.leituraPertoOeEixo = leituraPertoOeEixo;
    }

    public Double getLeituraLongeOdEsferico() {
        return leituraLongeOdEsferico;
    }

    public void setLeituraLongeOdEsferico(Double leituraLongeOdEsferico) {
        this.leituraLongeOdEsferico = leituraLongeOdEsferico;
    }

    public Double getLeituraLongeOdCilindrico() {
        return leituraLongeOdCilindrico;
    }

    public void setLeituraLongeOdCilindrico(Double leituraLongeOdCilindrico) {
        this.leituraLongeOdCilindrico = leituraLongeOdCilindrico;
    }

    public Double getLeituraLongeOdEixo() {
        return leituraLongeOdEixo;
    }

    public void setLeituraLongeOdEixo(Double leituraLongeOdEixo) {
        this.leituraLongeOdEixo = leituraLongeOdEixo;
    }

    public Double getLeituraLongeOeEsferico() {
        return leituraLongeOeEsferico;
    }

    public void setLeituraLongeOeEsferico(Double leituraLongeOeEsferico) {
        this.leituraLongeOeEsferico = leituraLongeOeEsferico;
    }

    public Double getLeituraLongeOeCilindrico() {
        return leituraLongeOeCilindrico;
    }

    public void setLeituraLongeOeCilindrico(Double leituraLongeOeCilindrico) {
        this.leituraLongeOeCilindrico = leituraLongeOeCilindrico;
    }

    public Double getLeituraLongeOeEixo() {
        return leituraLongeOeEixo;
    }

    public void setLeituraLongeOeEixo(Double leituraLongeOeEixo) {
        this.leituraLongeOeEixo = leituraLongeOeEixo;
    }
}