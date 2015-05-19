package org.surfnet.example.api.scratch;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.surfnet.example.api.model.Student;
import org.surfnet.example.api.oauth.JsonPrincipalService;




public class AuthTest {

       public static void main(String[] args) {

        /////////////////////////////////////////////////////
        //1. Obtain UnAuthorized "Request Token"

        ////////////////////////////////////////////////////

        /////////////////////////////////////////////////////
        //2. User (who uses client Application calling IVR Api Service) Authorizes Token

        ////////////////////////////////////////////////////

        /////////////////////////////////////////////////////
        //3. Exchange "Request Token" for "Access Token"

        ////////////////////////////////////////////////////

        JsonPrincipalService service = new JsonPrincipalService();

        Student principal = service.getPrincipal(new UsernamePasswordCredentials("foo8", "doen-not-matter"));

        System.out.println(principal.getIdentifier());
        System.out.println();



       }
}
