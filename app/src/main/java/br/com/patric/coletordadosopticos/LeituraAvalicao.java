package br.com.patric.coletordadosopticos;

public class LeituraAvalicao {
    private Double OdEsferico, OdCilindrico, OdEixo;
    private Double OeEsferico, OeCilindrico, OeEixo;

    public LeituraAvalicao(Double odEsferico, Double odCilindrico, Double odEixo, Double oeEsferico, Double oeCilindrico, Double oeEixo) {
        OdEsferico = odEsferico;
        OdCilindrico = odCilindrico;
        OdEixo = odEixo;
        OeEsferico = oeEsferico;
        OeCilindrico = oeCilindrico;
        OeEixo = oeEixo;
    }

    public Double getOdEsferico() {
        return OdEsferico;
    }

    public void setOdEsferico(Double odEsferico) {
        OdEsferico = odEsferico;
    }

    public Double getOdCilindrico() {
        return OdCilindrico;
    }

    public void setOdCilindrico(Double odCilindrico) {
        OdCilindrico = odCilindrico;
    }

    public Double getOdEixo() {
        return OdEixo;
    }

    public void setOdEixo(Double odEixo) {
        OdEixo = odEixo;
    }

    public Double getOeEsferico() {
        return OeEsferico;
    }

    public void setOeEsferico(Double oeEsferico) {
        OeEsferico = oeEsferico;
    }

    public Double getOeCilindrico() {
        return OeCilindrico;
    }

    public void setOeCilindrico(Double oeCilindrico) {
        OeCilindrico = oeCilindrico;
    }

    public Double getOeEixo() {
        return OeEixo;
    }

    public void setOeEixo(Double oeEixo) {
        OeEixo = oeEixo;
    }

}
