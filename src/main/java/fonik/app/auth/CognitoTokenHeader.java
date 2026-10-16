package fonik.app.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CognitoTokenHeader{

    @JsonProperty("kid")
    private String kid;

    @JsonProperty("alg")
    private String alg;

    /**
     * Return kid
     * @return kid
     */

    public String getKid(){
        return kid;
    }

    /**
     * Return alg
     * @return alg
     */
    public String getAlg(){
        return alg;
    }
}
