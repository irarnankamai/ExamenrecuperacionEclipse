package ec.edu.ups.ppw.Examen64NankamaiIrar.business;

import java.util.List;

import ec.edu.ups.ppw.Examen64NankamaiIrar.dao.CursoDAO;
import ec.edu.ups.ppw.Examen64NankamaiIrar.model.Curso;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionCurso {

    @Inject
    private CursoDAO cursoDAO;

    public Curso getCurso(Long codigo) throws Exception {
        Curso curso = cursoDAO.findByCodigo(codigo); // Usa findByCodigo en lugar de read
        if (curso == null) {
            throw new Exception("Curso no existe");
        }
        return curso;
    }

    public List<Curso> getCursos() {
        return cursoDAO.getAll();
    }

    public void createCurso(Curso curso) throws Exception {
        if (curso.getNombre() == null || curso.getNombre().isEmpty()) {
            throw new Exception("Nombre del curso es obligatorio");
        }
        cursoDAO.insert(curso);
    }

    public void updateCurso(Curso curso) throws Exception {
        if (curso.getCodigo() == null) {
            throw new Exception("Código del curso es obligatorio para actualizar");
        }
        Curso existingCurso = cursoDAO.findByCodigo(curso.getCodigo());
        if (existingCurso == null) {
            throw new Exception("Curso no existe");
        }
        cursoDAO.update(curso); // Asegúrate de que el método update esté implementado en CursoDAO
    }

    public void deleteCurso(Long codigo) throws Exception {
        Curso curso = cursoDAO.findByCodigo(codigo); // Usa findByCodigo en lugar de read
        if (curso == null) {
            throw new Exception("Curso no existe");
        }
        cursoDAO.delete(codigo); // Asegúrate de que el método delete esté implementado en CursoDAO
    }
}