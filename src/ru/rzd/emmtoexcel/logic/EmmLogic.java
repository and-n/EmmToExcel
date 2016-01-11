package ru.rzd.emmtoexcel.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.rzd.emmtoexcel.DAOEmm;
import ru.rzd.emmtoexcel.EmmToExcelException;

/**
 * Класс отвечающий за логику создания экселевского файла с
 *
 * @author ATonevitskiy
 */
public class EmmLogic {

    /**
     * Список Дорог (зон ответственности).
     */
    public static final String[] ZO = new String[]{"ДВС", "ГОР", "ГВЦ", "КБШ", "КЛГ", "КРАСН",
        "МСК", "ОКТ", "ПРИВ", "СЕВ", "СКВ", "СВРД", "ЮВСТ", "ЮУР", "ВСИБ", "ЗАБ", "ЗСИБ", "Все ЗО"};

    /**
     * Имена столбцов в экселе.
     */
    private static final String[] ColumnNames = new String[]{"ЦТС", "ЗО", "Код услуги", "Система",
        "Система(подробно)", "АРМ", "Ключевые слова", "1 линия поддержки", "Режим работы 1 линии(раб. время)",
        "1 линия поддержки в нерабочее время", "Режим работы 1 линии(нераб. время)",
        "Шаблон объекта АСУ ЕСПП с WEB-формы", "2 линия поддержки",
        "Признак сопровождения (Т-технологтческое; А-администрирование; У-установка)",
        "АС ОЗ (ЗАПРОС)", "Шаблон запроса в АСУ ЕСПП", "АС ОЗ (НАРЯД ПО ЗАПРОСУ)", "Шаблон наряда по запросу в АСУ ЕСПП",
        "Примечания"};

    private SXSSFWorkbook workbook;
    private final DAOEmm dao;

    public EmmLogic() {
        workbook = new SXSSFWorkbook(new XSSFWorkbook());
        dao = new DAOEmm();
    }

    XSSFCellStyle simpleStyle;

    /**
     * Создание шапки листа.
     *
     * @param sheet Лист, в котором нужно сделать шапку.
     */
    private void createHeader(Sheet sheet) {
        Row headRow = sheet.createRow(0);
        XSSFCellStyle style = (XSSFCellStyle) sheet.getWorkbook().createCellStyle();

        style.setFillForegroundColor(new XSSFColor(new java.awt.Color(234, 234, 234)));
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setWrapText(true);
        style.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
        style.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
        style.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
        style.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);

        simpleStyle = (XSSFCellStyle) sheet.getWorkbook().createCellStyle();
        simpleStyle.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
        simpleStyle.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
        simpleStyle.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
        simpleStyle.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
        simpleStyle.setWrapText(true);

        for (int i = 0; i < EmmLogic.ColumnNames.length; i++) {
            Cell cell = headRow.createCell(i);
            cell.setCellStyle(style);
            cell.setCellValue(ColumnNames[i]);
            switch (i) {
                case 0:
                    sheet.setColumnWidth(i, 8 * 255);
                    break;
                case 1:
                    sheet.setColumnWidth(i, 8 * 255);
                    break;
                case 2:
                    sheet.setColumnWidth(i, 8 * 255);
                    break;
                default:
                    sheet.setColumnWidth(i, 25 * 255);
                    break;
            }
        }
    }

    /**
     * Создание листа с определенным именем.
     *
     * @param name Имя листа
     * @return новый лист с определенным именем.
     */
    private Sheet createSheet(String name) {
        Sheet sheet = workbook.createSheet();
        workbook.setSheetName(workbook.getSheetIndex(sheet), name);
        return sheet;
    }

    private Sheet createSheetWithHeader(String name) {
        Sheet sheet = createSheet(name);
        createHeader(sheet);
        return sheet;
    }

    private void addValuesIntoSheet(Sheet sheet, String nameZO) throws EmmToExcelException {
        if (sheet == null || nameZO == null) {
            throw new EmmToExcelException("Пустой параметр строка-" + nameZO + " или лист" + (sheet == null));
        } else {
            try {
                ResultSet result = dao.getInfoByRwRS(nameZO);
                int i = 1;
                while (result.next()) {
                    Row row = sheet.createRow(i++);
                    for (int ind = 0; ind < 18; ind++) {
                        row.createCell(ind).setCellValue(result.getString(ind + 1));
                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(EmmLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void createFileWithData(int[] zoIndexes) throws EmmToExcelException {
        if (zoIndexes != null && zoIndexes.length > 0) {
            for (int index : zoIndexes) {
                if (index != -1) {
                    for (String s : ZO) {
                        Sheet sh = createSheetWithHeader(s);
                        addValuesIntoSheet(sh, s);
                    }
                } else {

                }
            }
        }

    }

}
