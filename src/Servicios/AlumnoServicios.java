package Servicios;

import Entidades.Alumno;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class AlumnoServicios {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    DecimalFormat df = new DecimalFormat("###,###.##");
    Double[] arrayNotas = new Double[3];
    ArrayList<Alumno> listaAlumnos = new ArrayList<>();
    Alumno a1 = new Alumno();

    public Alumno crearAlumno() {

//        System.out.println("Tamaño arrayNotas " + arrayNotas.length);
        System.out.println("Ingresa el nombre del alumno");
        a1.setNombre(sc.next());
        a1.setNombre(a1.getNombre().substring(0, 1).toUpperCase() + a1.getNombre().substring(1).toLowerCase());
        listaAlumnos.add(a1);

        for (int i = 0; i < arrayNotas.length; i++) {
            System.out.println("Ingresa la nota n° " + (i + 1) + " de " + a1.getNombre());
            arrayNotas[i] = sc.nextDouble();
        }
        a1.setNotas(arrayNotas);

        String resp;
        boolean salir = false;

        do {
            System.out.println("¿Deseas añadir otro alumno? S/N");
            resp = sc.next();
            while (!resp.equalsIgnoreCase("s") && !resp.equalsIgnoreCase("n")) {
                System.out.println("Respuesta inválida. Debe ser S o N");
                resp = sc.next();
            }
            if (resp.equalsIgnoreCase("s")) {

                agregarMasAlumnos();

            } else {
                salir = true;
            }
        } while (!salir);


        System.out.println("Los alumnos registrados hasta este momento son:");

        for (int i = 0; i < listaAlumnos.size(); i++) {
            System.out.println(listaAlumnos.get(i).getNombre());
        }

        System.out.println("Escribe el nombre del alumno del que quieres ver el promedio");
        String nombreAlumno = sc.next();
        nombreAlumno = nombreAlumno.substring(0, 1).toUpperCase() + nombreAlumno.substring(1).toLowerCase();

        for (int i = 0; i < listaAlumnos.size(); i++) {
            if (listaAlumnos.get(i).getNombre().equalsIgnoreCase(nombreAlumno)) {
                notaFinal(i);
            } else {
                System.out.println("El alumno llamado " + nombreAlumno + " no se encuentra en la lista :(");
            }
        }



        return a1;

    }

    public void agregarMasAlumnos() {

        Alumno a1 = new Alumno();
        
        System.out.println("Ingresa el nombre del alumno");
        a1.setNombre(sc.next());
        a1.setNombre(a1.getNombre().substring(0, 1).toUpperCase() + a1.getNombre().substring(1).toLowerCase());
        listaAlumnos.add(a1);

        for (int i = 0; i < arrayNotas.length; i++) {
            System.out.println("Ingresa la nota n° " + (i + 1) + " de " + a1.getNombre());
            arrayNotas[i] = sc.nextDouble();
        }
        a1.setNotas(arrayNotas);

    }

    public void notaFinal(int posicionAlumno) {

        double sumaNotas = 0;

        for (int i = 0; i < arrayNotas.length; i++) {
            sumaNotas += listaAlumnos.get(posicionAlumno).getNotas()[i];
            System.out.println(listaAlumnos.get(posicionAlumno).getNotas()[i]);
        }

        double promedioNotas = sumaNotas / arrayNotas.length;
        System.out.println(posicionAlumno);

        System.out.println("El promedio de " + listaAlumnos.get(posicionAlumno).getNombre() + " es " + df.format(promedioNotas));


    }

}
