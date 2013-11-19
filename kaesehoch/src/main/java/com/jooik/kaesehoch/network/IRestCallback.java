package com.jooik.kaesehoch.network;

import java.util.List;

/**
 * Common methods to handle (REST) network calls...
 * @param <T>
 */
public interface IRestCallback<T> {
    public void preExecute();
    public void postExecute(List<T> response);
    public String inExecute();
    public void cancelExecute();
}
