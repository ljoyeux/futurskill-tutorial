package fr.futurskill.tutorial.rs;

import org.apache.commons.io.IOUtils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Path("/img")
public class ImageService {

    @GET
    @Produces("image/jpeg")
    public Response img() {
        InputStream is = ImageService.class.getResourceAsStream("/troll-web.jpg");
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            IOUtils.copy(is, os);
        } catch (IOException e) {
        }

        return Response.ok().entity(os.toByteArray()).build();
    }

}
