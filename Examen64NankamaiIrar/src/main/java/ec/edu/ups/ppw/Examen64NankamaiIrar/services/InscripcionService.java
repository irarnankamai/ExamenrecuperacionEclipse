package ec.edu.ups.ppw.Examen64NankamaiIrar.services;
import java.util.List;

import ec.edu.ups.ppw.Examen64NankamaiIrar.business.GestionInscripcion;
import ec.edu.ups.ppw.Examen64NankamaiIrar.model.Inscripcion;
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

@Path("/inscripcion")
public class InscripcionService {

    @Inject
    private GestionInscripcion gInscripcion;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Inscripcion inscripcion) {
        try {
            gInscripcion.createInscripcion(inscripcion);
            return Response.ok(inscripcion).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en DB")).build();
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Inscripcion inscripcion) {
        try {
            gInscripcion.updateInscripcion(inscripcion);
            return Response.ok(inscripcion).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@QueryParam("codigo") Long codigo) {
        try {
            gInscripcion.deleteInscripcion(codigo);
            return Response.ok(new Respuesta(Respuesta.OK, "Inscripción eliminada correctamente")).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en DB")).build();
        }
    }

    @GET 
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Inscripcion get(@PathParam("codigo") Long codigo) {
        try {
            return gInscripcion.getInscripcion(codigo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Inscripcion> list() {
        return gInscripcion.getInscripciones();
    }

    @GET
    @Path("/curso/{codigoCurso}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Inscripcion> findByCurso(@PathParam("codigoCurso") Long codigoCurso) {
        try {
            return gInscripcion.findByCurso(codigoCurso);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}