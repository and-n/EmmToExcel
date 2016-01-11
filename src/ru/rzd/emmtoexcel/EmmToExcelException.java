/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rzd.emmtoexcel;

/**
 * Ошибка возникающая в работе программы.
 *
 * @author ATonevitskiy
 */
public class EmmToExcelException extends Exception {

    public EmmToExcelException() {
        super();
    }

    public EmmToExcelException(String message) {
        super(message);
    }

    public EmmToExcelException(Throwable cause) {
        super(cause);
    }

    public EmmToExcelException(String message, Throwable cause) {
        super(message, cause);
    }

}
