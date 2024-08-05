package ec.edu.ups.ppw.Examen64NankamaiIrar.services;
import java.util.List;

import ec.edu.ups.ppw.Examen64NankamaiIrar.business.GestionCurso;
import ec.edu.ups.ppw.Examen64NankamaiIrar.model.Curso;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/curso")
public class CursoService {

    @Inject
    private GestionCurso gCurso;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Curso curso) {
        try {
            gCurso.createCurso(curso);
            return Response.ok(curso).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en DB")).build();
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Curso curso) {
        try {
            gCurso.updateCurso(curso);
            return Response.ok(curso).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@QueryParam("codigo") Long codigo) {
        try {
            gCurso.deleteCurso(codigo);
            return Response.ok(new Respuesta(Respuesta.OK, "Curso eliminado correctamente")).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en DB")).build();
        }
    }

    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Curso get(@PathParam("codigo") Long codigo) {
        try {
            return gCurso.getCurso(codigo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Curso> list() {
        return gCurso.getCursos();
    }
}