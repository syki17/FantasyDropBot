package com.apps.jakub.fantasydropbot.Calls;

public class TokenCallBody {
    private String redirect_uri;
    private String code;
    private String grant_type;

    public TokenCallBody(String redirect_uri,String code, String grant_type ){
    this.code = code;
    this.grant_type = grant_type;
    this.redirect_uri = redirect_uri;


    }
    public String getRedirect_uri() {
        return redirect_uri;
    }

    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

}
