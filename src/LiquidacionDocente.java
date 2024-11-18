import java.util.ArrayList;
import java.util.Scanner;

public class LiquidacionDocente {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Catedra>catedrasCarrera = new ArrayList<>();
        Catedra cat = new Catedra(10,"Analisis Matematico", 8);
        catedrasCarrera.add(cat);
        cat = new Catedra (20, "Algoritmos", 4);
        catedrasCarrera.add(cat);
        cat = new Catedra (30, "Paradigmas de la Computación", 6);
        catedrasCarrera.add(cat);
        cat = new Catedra (40, "Inteligencia Artificial", 12);
        catedrasCarrera.add(cat);

        Universidad universidad = new Universidad();
        ingresarUniversidad(universidad);
        ArrayList <Docente> docentes = new ArrayList<>();
        crearYCargarDocentes(docentes, catedrasCarrera);
        universidad.setDocentes(docentes);
        mostrarInformacion(universidad);
    }
    public static void ingresarUniversidad(Universidad universidad){
        System.out.println();
        System.out.println("----- Datos de Universidad -----");
        System.out.println();
        while(true) {
            System.out.print("Ingrese el cuit de la universidad: ");
            String cuit = sc.nextLine();
            if (cuit.length() == 11) {
                universidad.setCuit(cuit);
                break;
            } else {
                System.out.println("El cuit debe tener 11 digitos. Vuelva a intentar...");
            }
        }
        while(true) {
            System.out.print("Ingrese la razon social de la universidad: ");
            String razonSocial = sc.nextLine();
            if (!razonSocial.isEmpty()) {
                universidad.setRazonSocial(razonSocial);
                break;
            } else {
                System.out.println("La razon social no puede estar vacía. Vuelva a intentar...");
            }
        }
        while(true) {
            System.out.print("Ingrese el valor de la hora catedra: ");
            double valorHoraCatedra = Double.parseDouble(sc.nextLine());
            if (valorHoraCatedra>0) {
                universidad.setValorHoraCatedra(valorHoraCatedra);
                break;
            } else {
                System.out.println("El valor de la hora catedra debe ser mayor que cero. Vuelva a intentar...");
            }
        }
    }
    public static void crearYCargarDocentes(ArrayList<Docente>docentes, ArrayList<Catedra>catedrasCarrera){
        boolean salir=false;
        while(!salir){
            Docente docente = new Docente();
            System.out.println();
            System.out.println("----- Creación y Carga de Docentes -----");
            System.out.println();
            do {
                System.out.print("Ingrese el nombre completo: ");
                String nombreCompleto = sc.nextLine();
                System.out.print("Ingrese el legajo: ");
                int legajo = Integer.parseInt(sc.nextLine());
                if(!nombreCompleto.isEmpty() && legajo!=0) {
                    boolean existe=false;
                    for(Docente i: docentes){
                        if(i.getLegajo()==legajo){
                            existe=true;
                            break;
                        }
                    }
                    if(existe){
                        System.out.println("El legajo ingresado ya fue cargado anteriormente. Vuelva a intentar...");
                    }else{
                        docente.setNombreCompleto(nombreCompleto);
                        docente.setLegajo(legajo);
                        break;
                    }
                }else{
                    System.out.println("EL nombre y el legajo no pueden estar vacíos. Vuelva a intentar...");
                }
            }while(true);
            do {
                System.out.print("Ingrese la antiguedad: ");
                double antiguedad =Double.parseDouble(sc.nextLine());
                if(antiguedad >=0 && antiguedad<120) {
                    docente.setAntiguedad(antiguedad);
                    break;
                }else{
                    System.out.println("La antiguedad debe ser mayor o igual 0 y menor que 120. Vuelva a intentar...");
                }
            }while(true);
            boolean encontrado=false;
            do {
                System.out.print("Ingrese el código de la catedra: ");
                int codigoCatedra = Integer.parseInt(sc.nextLine());
                for(Catedra i: catedrasCarrera){
                    if(i.getCodigo()==codigoCatedra){
                        docente.setCatedra(i);
                        encontrado=true;
                        break;
                    }
                }
                if(!encontrado){
                    System.out.println("El código ingresado no existe. Vuelva a intentar...");
                }else{
                    String respuesta;
                    System.out.println("Desea cargar otro docente?\nSI - NO");
                    respuesta=sc.nextLine();
                    if(respuesta.equalsIgnoreCase("no")){
                        docentes.add(docente);
                        salir=true;
                        break;
                    }else{
                        docentes.add(docente);
                        System.out.println("---------------------------------");
                        break;
                    }
                }
            }while(true);
        }
    }
    public static void mostrarInformacion(Universidad universidad){
        System.out.println();
        System.out.println("Universidad: "+universidad.getRazonSocial().toUpperCase());
        System.out.println("CUIT: "+universidad.getCuit());
        System.out.println("---------- Docentes ----------");
        for(Docente i: universidad.getDocentes()) {
            System.out.println();
            System.out.println("Nombre Completo: "+i.getNombreCompleto());
            System.out.println("Catedra: "+i.getCatedra().getDenominacion());
            System.out.println("Salario: "+i.salarioDocenteCalculado(universidad));
            System.out.println("-----------------------------------");
        }
    }
}