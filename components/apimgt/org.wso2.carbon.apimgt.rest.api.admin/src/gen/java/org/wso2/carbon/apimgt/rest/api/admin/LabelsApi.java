package org.wso2.carbon.apimgt.rest.api.admin;

import org.wso2.carbon.apimgt.rest.api.admin.factories.LabelsApiServiceFactory;

import io.swagger.annotations.ApiParam;

import org.wso2.carbon.apimgt.rest.api.admin.dto.ErrorDTO;

import org.wso2.msf4j.Microservice;
import org.wso2.msf4j.Request;
import org.osgi.service.component.annotations.Component;

import java.io.InputStream;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.*;

@Component(
    name = "org.wso2.carbon.apimgt.rest.api.admin.LabelsApi",
    service = Microservice.class,
    immediate = true
)
@Path("/api/am/admin/v1.[\\d]+/labels")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the labels API")
@javax.annotation.Generated(value = "org.wso2.maven.plugins.JavaMSF4JServerCodegen", date = "2017-04-28T10:42:38.625+05:30")
public class LabelsApi implements Microservice  {
   private final LabelsApiService delegate = LabelsApiServiceFactory.getLabelsApi();

    @DELETE
    @Path("/{labelId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete a Label", notes = "This operation can be used to delete an existing label. `DELETE https://127.0.0.1:9443/api/am/admin/v1.0/labels/12` ", response = void.class, tags={ "Label (Individual)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK. Resource successfully deleted. ", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found. Resource to be deleted does not exist. ", response = void.class) })
    public Response labelsLabelIdDelete(@ApiParam(value = "Id of the label ",required=true) @PathParam("labelId") String labelId
,@ApiParam(value = "Validator for conditional requests; based on ETag. " )@HeaderParam("If-Match") String ifMatch
,@ApiParam(value = "Validator for conditional requests; based on Last Modified header. " )@HeaderParam("If-Unmodified-Since") String ifUnmodifiedSince
, @Context Request request)
    throws NotFoundException {
        return delegate.labelsLabelIdDelete(labelId,ifMatch,ifUnmodifiedSince, request);
    }
}
