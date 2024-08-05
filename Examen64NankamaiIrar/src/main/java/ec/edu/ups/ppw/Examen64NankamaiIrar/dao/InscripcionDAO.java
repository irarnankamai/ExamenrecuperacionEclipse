package ec.edu.ups.ppw.Examen64NankamaiIrar.dao;


import java.util.List;

import ec.edu.ups.ppw.Examen64NankamaiIrar.model.Inscripcion;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class InscripcionDAO {

    @PersistenceContext
    private EntityManager em;

    public void insert(Inscripcion inscripcion) {
        em.persist(inscripcion);
    }

    public void update(Inscripcion inscripcion) {
        em.merge(inscripcion);
    }

    public void delete(Long codigo) {
        Inscripcion inscripcion = this.read(codigo);
        if (inscripcion != null) {
            em.remove(inscripcion);
        }
    }

    public Inscripcion read(Long codigo) {
        return em.find(Inscripcion.class, codigo);
    }

    public List<Inscripcion> getAll() {
        String jpql = "SELECT i FROM Inscripcion i";
        Query query = em.createQuery(jpql, Inscripcion.class);
        return query.getResultList();
    }

    public List<Inscripcion> findByCurso(Long codigoCurso) {
        String jpql = "SELECT i FROM Inscripcion i WHERE i.curso.codigo = :codigoCurso";
        Query query = em.createQuery(jpql, Inscripcion.class);
        query.setParameter("codigoCurso", codigoCurso);
        return query.getResultList();
    }
}