/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emmtoexcel.logic;

import java.util.Objects;

/**
 * Строка электронной матрицы маршрутизации
 *
 * @author ATonevitskiy
 */
public class MatrixString {

    private String Cts;
    private String ZO;
    private String Code;
    private String System;
    private String SystemFullInfo;
    private String ARM;
    private String KeyWord;
    private String WorkedFirstLine;
    private String WorkTimeFirstLine;
    private String UnWorkedFirstLine;
    private String UnworkTimeFirstLine;
    private String WebTemplate;
    private String SecondLine;
    private String HelpType;
    private String ASOZ;
    private String ESPPTemplate;
    private String Naryad;
    private String ESPPNaryad;
    private String Info;

    public MatrixString() {
    }

    public MatrixString(String Cts, String ZO, String Code, String System, String SystemFullInfo, String ARM, String Key_word, String WorkedFirstLine, String WorkTimeFirstLine, String UnWorkedFirstLine, String UnworkTimeFirstLine, String WebTemplate, String SecondLine, String HelpType, String ASOZ, String ESPPTemplate, String Naryad, String ESPPNaryad, String Info) {
        this.Cts = Cts;
        this.ZO = ZO;
        this.Code = Code;
        this.System = System;
        this.SystemFullInfo = SystemFullInfo;
        this.ARM = ARM;
        this.KeyWord = Key_word;
        this.WorkedFirstLine = WorkedFirstLine;
        this.WorkTimeFirstLine = WorkTimeFirstLine;
        this.UnWorkedFirstLine = UnWorkedFirstLine;
        this.UnworkTimeFirstLine = UnworkTimeFirstLine;
        this.WebTemplate = WebTemplate;
        this.SecondLine = SecondLine;
        this.HelpType = HelpType;
        this.ASOZ = ASOZ;
        this.ESPPTemplate = ESPPTemplate;
        this.Naryad = Naryad;
        this.ESPPNaryad = ESPPNaryad;
        this.Info = Info;
    }

    public String getCts() {
        return Cts;
    }

    public void setCts(String Cts) {
        this.Cts = Cts;
    }

    public String getZO() {
        return ZO;
    }

    public void setZO(String ZO) {
        this.ZO = ZO;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getSystem() {
        return System;
    }

    public void setSystem(String System) {
        this.System = System;
    }

    public String getSystemFullInfo() {
        return SystemFullInfo;
    }

    public void setSystemFullInfo(String SystemFullInfo) {
        this.SystemFullInfo = SystemFullInfo;
    }

    public String getARM() {
        return ARM;
    }

    public void setARM(String ARM) {
        this.ARM = ARM;
    }

    public String getKeyWord() {
        return KeyWord;
    }

    public void setKeyWord(String Key_word) {
        this.KeyWord = Key_word;
    }

    public String getWorkedFirstLine() {
        return WorkedFirstLine;
    }

    public void setWorkedFirstLine(String WorkedFirstLine) {
        this.WorkedFirstLine = WorkedFirstLine;
    }

    public String getWorkTimeFirstLine() {
        return WorkTimeFirstLine;
    }

    public void setWorkTimeFirstLine(String WorkTimeFirstLine) {
        this.WorkTimeFirstLine = WorkTimeFirstLine;
    }

    public String getUnWorkedFirstLine() {
        return UnWorkedFirstLine;
    }

    public void setUnWorkedFirstLine(String UnWorkedFirstLine) {
        this.UnWorkedFirstLine = UnWorkedFirstLine;
    }

    public String getUnworkTimeFirstLine() {
        return UnworkTimeFirstLine;
    }

    public void setUnworkTimeFirstLine(String UnworkTimeFirstLine) {
        this.UnworkTimeFirstLine = UnworkTimeFirstLine;
    }

    public String getWebTemplate() {
        return WebTemplate;
    }

    public void setWebTemplate(String WebTemplate) {
        this.WebTemplate = WebTemplate;
    }

    public String getSecondLine() {
        return SecondLine;
    }

    public void setSecondLine(String SecondLine) {
        this.SecondLine = SecondLine;
    }

    public String getHelpType() {
        return HelpType;
    }

    public void setHelpType(String HelpType) {
        this.HelpType = HelpType;
    }

    public String getASOZ() {
        return ASOZ;
    }

    public void setASOZ(String ASOZ) {
        this.ASOZ = ASOZ;
    }

    public String getESPPTemplate() {
        return ESPPTemplate;
    }

    public void setESPPTemplate(String ESPPTemplate) {
        this.ESPPTemplate = ESPPTemplate;
    }

    public String getNaryad() {
        return Naryad;
    }

    public void setNaryad(String Naryad) {
        this.Naryad = Naryad;
    }

    public String getESPPNaryad() {
        return ESPPNaryad;
    }

    public void setESPPNaryad(String ESPPNaryad) {
        this.ESPPNaryad = ESPPNaryad;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String Info) {
        this.Info = Info;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.Cts);
        hash = 47 * hash + Objects.hashCode(this.ZO);
        hash = 47 * hash + Objects.hashCode(this.Code);
        hash = 47 * hash + Objects.hashCode(this.System);
        hash = 47 * hash + Objects.hashCode(this.SystemFullInfo);
        hash = 47 * hash + Objects.hashCode(this.ARM);
        hash = 47 * hash + Objects.hashCode(this.KeyWord);
        hash = 47 * hash + Objects.hashCode(this.WorkedFirstLine);
        hash = 47 * hash + Objects.hashCode(this.WorkTimeFirstLine);
        hash = 47 * hash + Objects.hashCode(this.UnWorkedFirstLine);
        hash = 47 * hash + Objects.hashCode(this.UnworkTimeFirstLine);
        hash = 47 * hash + Objects.hashCode(this.WebTemplate);
        hash = 47 * hash + Objects.hashCode(this.SecondLine);
        hash = 47 * hash + Objects.hashCode(this.HelpType);
        hash = 47 * hash + Objects.hashCode(this.ASOZ);
        hash = 47 * hash + Objects.hashCode(this.ESPPTemplate);
        hash = 47 * hash + Objects.hashCode(this.Naryad);
        hash = 47 * hash + Objects.hashCode(this.ESPPNaryad);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MatrixString other = (MatrixString) obj;
        if (!Objects.equals(this.Cts, other.Cts)) {
            return false;
        }
        if (!Objects.equals(this.ZO, other.ZO)) {
            return false;
        }
        if (!Objects.equals(this.Code, other.Code)) {
            return false;
        }
        if (!Objects.equals(this.System, other.System)) {
            return false;
        }
        if (!Objects.equals(this.SystemFullInfo, other.SystemFullInfo)) {
            return false;
        }
        if (!Objects.equals(this.ARM, other.ARM)) {
            return false;
        }
        if (!Objects.equals(this.KeyWord, other.KeyWord)) {
            return false;
        }
        if (!Objects.equals(this.WorkedFirstLine, other.WorkedFirstLine)) {
            return false;
        }
        if (!Objects.equals(this.WorkTimeFirstLine, other.WorkTimeFirstLine)) {
            return false;
        }
        if (!Objects.equals(this.UnWorkedFirstLine, other.UnWorkedFirstLine)) {
            return false;
        }
        if (!Objects.equals(this.UnworkTimeFirstLine, other.UnworkTimeFirstLine)) {
            return false;
        }
        if (!Objects.equals(this.WebTemplate, other.WebTemplate)) {
            return false;
        }
        if (!Objects.equals(this.SecondLine, other.SecondLine)) {
            return false;
        }
        if (!Objects.equals(this.HelpType, other.HelpType)) {
            return false;
        }
        if (!Objects.equals(this.ASOZ, other.ASOZ)) {
            return false;
        }
        if (!Objects.equals(this.ESPPTemplate, other.ESPPTemplate)) {
            return false;
        }
        if (!Objects.equals(this.Naryad, other.Naryad)) {
            return false;
        }
        if (!Objects.equals(this.ESPPNaryad, other.ESPPNaryad)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MatrixString{" + "Cts=" + Cts + ", ZO=" + ZO
                + ", Code=" + Code + ", System=" + System + ", SystemFullInfo="
                + SystemFullInfo + ", ARM=" + ARM + ", KeyWord=" + KeyWord
                + ", WorkedFirstLine=" + WorkedFirstLine + ", WorkTimeFirstLine="
                + WorkTimeFirstLine + ", UnWorkedFirstLine=" + UnWorkedFirstLine
                + ", UnworkTimeFirstLine=" + UnworkTimeFirstLine + ", WebTemplate="
                + WebTemplate + ", SecondLine=" + SecondLine + ", HelpType="
                + HelpType + ", ASOZ=" + ASOZ + ", ESPPTemplate=" + ESPPTemplate
                + ", Naryad=" + Naryad + ", ESPPNaryad=" + ESPPNaryad + ", Info=" + Info + '}';
    }

}
