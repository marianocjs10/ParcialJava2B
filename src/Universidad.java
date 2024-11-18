import java.util.ArrayList;

public class Universidad {
    private String cuit;
    private String razonSocial;
    private double valorHoraCatedra;
    private ArrayList<Docente>docentes;
    //---------------------------------

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public double getValorHoraCatedra() {
        return valorHoraCatedra;
    }

    public void setValorHoraCatedra(double valorHoraCatedra) {
        this.valorHoraCatedra = valorHoraCatedra;
    }

    public ArrayList<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(ArrayList<Docente> docentes) {
        this.docentes = docentes;
    }

}
