package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.inject.Inject;
import models.CrashBasicInformationModel;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by jessicacotrina on 10/12/16.
 */
public class CrashBasicInformation extends Controller {

    @Inject
    private FormFactory formFactory;

    public Result insertCrashBasicInformation(){

        try {

            CrashBasicInformationModel crashBasicInformationModel = new CrashBasicInformationModel();
            crashBasicInformationModel = formFactory.form(CrashBasicInformationModel.class).bindFromRequest().get();
            ObjectNode result = Json.newObject();
            ObjectNode wrapper = Json.newObject();
            long operation = crashBasicInformationModel.addCrashBasicInformation(crashBasicInformationModel);
            if(operation > 0){
                result.put("message", "Agregado con éxito");
                result.put("CrashId", operation);
                wrapper.set("success", result);

                return ok(wrapper);
            }else{
                result.put("message", "No se pudo agregar");
                wrapper.set("error", result);
                return ok(wrapper);
            }
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
            return badRequest("Error interno de operación");
        }
    }

    public Result CrashBasicInformationUpdate(){

        CrashBasicInformationModel crashBasicInformation =  formFactory.form(CrashBasicInformationModel.class).bindFromRequest().get();
        crashBasicInformation.idCrashBasicInformation = Integer.valueOf(session().get("idCrashBasicInformation"));
        ObjectNode wrapper = Json.newObject();
        ObjectNode msg = Json.newObject();
        int result = crashBasicInformation.updateCrashBasicInformation(crashBasicInformation);

        if(result == 1){
            msg.put("message","updated sucessfully");
            wrapper.set("success", msg);
            return ok(wrapper);
        }else{
            msg.put("message","can not update");
            wrapper.set("error", msg);
            return badRequest(wrapper);
        }
    }




}
