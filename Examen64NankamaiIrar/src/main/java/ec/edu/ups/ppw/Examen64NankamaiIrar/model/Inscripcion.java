package ec.edu.ups.ppw.Examen64NankamaiIrar.model;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "TBL_INSCRIPCION")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ins_codigo")
    private Long codigo;

    @Column(name = "ins_cedula_alumno")
    private String cedulaAlumno;

    @Column(name = "ins_nombre_alumno")
    private String nombreAlumno;

    @Column(name = "ins_apellido_alumno")
    private String apellidoAlumno;

    @Column(name = "ins_fecha_inscripcion")
    @Temporal(TemporalType.DATE)
    private LocalDate fechaInscripcion;

    @ManyToOne
    @JoinColumn(name = "cur_codigo")
    private Curso curso;

    // Getters y Setters
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getCedulaAlumno() {
        return cedulaAlumno;
    }

    public void setCedulaAlumno(String cedulaAlumno) {
        this.cedulaAlumno = cedulaAlumno;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getApellidoAlumno() {
        return apellidoAlumno;
    }

    public void setApellidoAlumno(String apellidoAlumno) {
        this.apellidoAlumno = apellidoAlumno;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
