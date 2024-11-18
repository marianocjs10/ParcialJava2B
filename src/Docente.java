public class Docente {
    private String nombreCompleto;
    private int legajo;
    private double antiguedad;
    private Catedra catedra;
    //----------------------------

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public double getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(double antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Catedra getCatedra() {
        return catedra;
    }

    public void setCatedra(Catedra catedra) {
        this.catedra = catedra;
    }
    //-----------------------------------------------
    public double salarioDocenteCalculado(Universidad univ){
        return univ.getValorHoraCatedra() * this.catedra.getHorasCatedra() + (((univ.getValorHoraCatedra() * this.catedra.getHorasCatedra())* this.antiguedad)/100);
    }

}
