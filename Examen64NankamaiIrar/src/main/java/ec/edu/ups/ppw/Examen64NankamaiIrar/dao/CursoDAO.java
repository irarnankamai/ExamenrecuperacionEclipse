package ec.edu.ups.ppw.Examen64NankamaiIrar.dao;

import java.util.List;

import ec.edu.ups.ppw.Examen64NankamaiIrar.model.Curso;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;


@Stateless
public class CursoDAO {

    @PersistenceContext
    private EntityManager em;

    public void insert(Curso curso) {
        em.persist(curso);
    }

    public Curso findByCodigo(Long codigo) {
        return em.find(Curso.class, codigo);
    }

    public List<Curso> getAll() {
        TypedQuery<Curso> query = em.createQuery("SELECT c FROM Curso c", Curso.class);
        return query.getResultList();
    }

    public void update(Curso curso) {
        em.merge(curso);
    }

    public void delete(Long codigo) {
        Curso curso = findByCodigo(codigo);
        if (curso != null) {
            em.remove(curso);
        }
    }
}