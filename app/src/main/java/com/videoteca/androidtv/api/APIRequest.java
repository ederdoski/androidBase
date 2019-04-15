package com.videoteca.androidtv.api;

import com.videoteca.androidtv.interfaces.HTTPResponse;

import java.util.List;

public class APIRequest {

    private static Integer[] aResponsesSucces    = { 200, 201, 204 };
    private static Integer[] aResponsesForbidden = { 401, 403, 422 };
    private static Integer[] aResponsesError     = { 404, 405 };

    private static void httpManager(int response, List<?> listResult, String error, HTTPResponse httpResponse) {

        boolean onError = true;

        for (Integer aResponsesSucce : aResponsesSucces) {
            if (aResponsesSucce.equals(response)) {
                httpResponse.onSuccess(listResult);
                onError = false;
            }
        }

        for (Integer anAResponsesForbidden : aResponsesForbidden) {
            if (anAResponsesForbidden.equals(response)) {
                httpResponse.onForbidden(listResult);
                onError = false;
            }
        }

        for (Integer anAResponsesError : aResponsesError) {
            if (anAResponsesError.equals(response)) {
                httpResponse.onError(error);
                onError = false;
            }
        }

        if (onError){
            httpResponse.onError(error);
        }

    }

    private static void httpManager(int response, Object objResult, String error, HTTPResponse httpResponse){

        boolean onError = true;

        for (Integer aResponsesSucce : aResponsesSucces) {
            if (aResponsesSucce.equals(response)) {
                httpResponse.onSuccess(objResult);
                onError = false;
            }
        }

        for (Integer anAResponsesForbidden : aResponsesForbidden) {
            if (anAResponsesForbidden.equals(response)) {
                httpResponse.onForbidden(objResult);
                onError = false;
            }
        }

        for (Integer anAResponsesError : aResponsesError) {
            if (anAResponsesError.equals(response)) {
                httpResponse.onError(error);
                onError = false;
            }
        }

        if (onError){
            httpResponse.onError(error);
        }
    }

    private static void httpManager(int response, String result, String error, HTTPResponse httpResponse){

        boolean onError = true;

        for (Integer aResponsesSucce : aResponsesSucces) {
            if (aResponsesSucce.equals(response)) {
                httpResponse.onSuccess(result);
                onError = false;
            }
        }

        for (Integer anAResponsesForbidden : aResponsesForbidden) {
            if (anAResponsesForbidden.equals(response)) {
                httpResponse.onForbidden(result);
                onError = false;
            }
        }

        for (Integer anAResponsesError : aResponsesError) {
            if (anAResponsesError.equals(response)) {
                httpResponse.onError(error);
                onError = false;
            }
        }

        if (onError){
            httpResponse.onError(error);
        }
    }
}
