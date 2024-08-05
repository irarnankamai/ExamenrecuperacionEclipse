package ec.edu.ups.ppw.Examen64NankamaiIrar.business;

import java.util.List;

import ec.edu.ups.ppw.Examen64NankamaiIrar.dao.InscripcionDAO;
import ec.edu.ups.ppw.Examen64NankamaiIrar.model.Inscripcion;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionInscripcion {

    @Inject
    private InscripcionDAO inscripcionDAO;

    public Inscripcion getInscripcion(Long codigo) throws Exception {
        Inscripcion inscripcion = inscripcionDAO.read(codigo);
        if (inscripcion == null) {
            throw new Exception("Inscripción no existe");
        }
        return inscripcion;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripcionDAO.getAll();
    }

    public void createInscripcion(Inscripcion inscripcion) throws Exception {
        if (inscripcion.getCedulaAlumno() == null || inscripcion.getCedulaAlumno().isEmpty()) {
            throw new Exception("Cédula del alumno es obligatoria");
        }
        inscripcionDAO.insert(inscripcion);
    }

    public void updateInscripcion(Inscripcion inscripcion) throws Exception {
        if (inscripcion.getCodigo() == null) {
            throw new Exception("Inscripción no existe");
        }
        inscripcionDAO.update(inscripcion);
    }

    public void deleteInscripcion(Long codigo) throws Exception {
        Inscripcion inscripcion = inscripcionDAO.read(codigo);
        if (inscripcion == null) {
            throw new Exception("Inscripción no existe");
        }
        inscripcionDAO.delete(codigo);
    }

    public List<Inscripcion> findByCurso(Long codigoCurso) throws Exception {
        return inscripcionDAO.findByCurso(codigoCurso);
    }
}
