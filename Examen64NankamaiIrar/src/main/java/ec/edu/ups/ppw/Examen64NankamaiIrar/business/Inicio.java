package ec.edu.ups.ppw.Examen64NankamaiIrar.business;


import java.time.LocalDate;
import java.util.List;

import ec.edu.ups.ppw.Examen64NankamaiIrar.dao.CursoDAO;
import ec.edu.ups.ppw.Examen64NankamaiIrar.dao.InscripcionDAO;
import ec.edu.ups.ppw.Examen64NankamaiIrar.model.Curso;
import ec.edu.ups.ppw.Examen64NankamaiIrar.model.Inscripcion;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class Inicio {

    @Inject
    private CursoDAO daoCurso;

    @Inject
    private InscripcionDAO daoInscripcion;

    @PostConstruct
    public void init() {
        System.out.println("Hola Mundo EJB");

        // Crear y guardar cursos
        Curso curso1 = new Curso();
        curso1.setNombre("Matemáticas Avanzadas");
        curso1.setCupo(30);  
        curso1.setFechaInicio(LocalDate.now());  
        daoCurso.insert(curso1);

        Curso curso2 = new Curso();
        curso2.setNombre("Programación en Java");
        curso2.setCupo(25);  
        curso2.setFechaInicio(LocalDate.now());  
        daoCurso.insert(curso2);

        Curso curso3 = new Curso();
        curso3.setNombre("Historia Universal");
        curso3.setCupo(20);  
        curso3.setFechaInicio(LocalDate.now());  
        daoCurso.insert(curso3);

        // Crear y guardar inscripciones
        Inscripcion inscripcion1 = new Inscripcion();
        inscripcion1.setCedulaAlumno("1450170350");
        inscripcion1.setNombreAlumno("Irar");
        inscripcion1.setApellidoAlumno("Nankamai");
        inscripcion1.setFechaInscripcion(LocalDate.now());  
        inscripcion1.setCurso(curso1);  // Asociar con curso1
        daoInscripcion.insert(inscripcion1);

        Inscripcion inscripcion2 = new Inscripcion();
        inscripcion2.setCedulaAlumno("1450170351");
        inscripcion2.setNombreAlumno("Lucía");
        inscripcion2.setApellidoAlumno("Torres");
        inscripcion2.setFechaInscripcion(LocalDate.now());  
        inscripcion2.setCurso(curso2);  // Asociar con curso2
        daoInscripcion.insert(inscripcion2);

        Inscripcion inscripcion3 = new Inscripcion();
        inscripcion3.setCedulaAlumno("1450170352");
        inscripcion3.setNombreAlumno("Juan");
        inscripcion3.setApellidoAlumno("Pérez");
        inscripcion3.setFechaInscripcion(LocalDate.now());  
        inscripcion3.setCurso(curso3);  
        daoInscripcion.insert(inscripcion3);

        // Imprimir datos de cursos
        System.out.println("DATOS DE CURSO");
        List<Curso> cursos = daoCurso.getAll();
        for (Curso c : cursos) {
            System.out.println("Codigo: " + c.getCodigo() + " Nombre: " + c.getNombre() + " Cupo: " + c.getCupo() + " Fecha Inicio: " + c.getFechaInicio());
        }

        // Imprimir datos de inscripciones
        System.out.println("DATOS DE INSCRIPCION");
        List<Inscripcion> inscripciones = daoInscripcion.getAll();
        for (Inscripcion i : inscripciones) {
            System.out.println("Cedula Alumno: " + i.getCedulaAlumno() + " Nombre: " + i.getNombreAlumno() + " Apellido: " + i.getApellidoAlumno() + " Fecha Inscripción: " + i.getFechaInscripcion() + " Curso: " + i.getCurso().getNombre());
        }
    }
}