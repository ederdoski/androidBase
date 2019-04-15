package com.videoteca.androidtv.interfaces;

import com.orhanobut.logger.Logger;

import java.util.List;

public abstract class HTTPResponse {

    private static boolean debug = true;

    public void onSuccess(List<?> result){};

    public void onSuccess(Object result){};

    public void onSuccess(String result){};

    public void onForbidden(Object result){
        Logger.e("HTTPResponse", "FORBIDDEN");
    }

    public void onException(Exception e){
        Logger.e("HTTPResponse", String.valueOf(e));
    }

    public void onError(String data){
        Logger.e("HTTPResponse",data);
    }


}
