package com.distribuidas.recetas.email;

public interface EmailClient {

    void ForgotPassword(String code, String email);

    void NewRegister(String email);
    
    void ValidarAlumno(String code, String email);

}
