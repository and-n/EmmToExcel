package ru.rzd.emmtoexcel.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public static final String[] ZO = new String[]{"Все ЗО", "ДВС", "ГОР", "ГВЦ", "КБШ", "КЛГ", "КРАСН",
        "МСК", "ОКТ", "ПРИВ", "СЕВ", "СКВ", "СВРД", "ЮВСТ", "ЮУР", "ВСИБ", "ЗАБ", "ЗСИБ"};

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
                System.out.println(nameZO + " " + i);
            } catch (SQLException ex) {
                Logger.getLogger(EmmLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void createFileWithData(int[] zoIndexes) throws EmmToExcelException, IOException {
        workbook = new SXSSFWorkbook(new XSSFWorkbook());
        if (zoIndexes != null && zoIndexes.length > 0) {
            for (int index : zoIndexes) {
                if (index == -1) {
                    for (String s : ZO) {
                        Sheet sh = createSheetWithHeader(s);
                        addValuesIntoSheet(sh, s);
                    }
                    Path p = saveFileLocal(workbook);
// TODO не забыть разкоментить строку сохранения на шару!!!                   
// copyToShared(p);
                    return;
                } else {

                }
            }
            Path saveFileLocal = saveFileLocal(workbook);
            System.out.println("save file " + saveFileLocal.toString());
        }

    }

    private Path saveFileLocal(SXSSFWorkbook workbook) throws FileNotFoundException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String fileName = "ЭММ " + sdf.format(date);
        String folder = "Result";
        new File(folder).mkdir();

        if (!folder.isEmpty()) {
            FileOutputStream fos
                    = new FileOutputStream(folder + File.separator + fileName + ".xlsx", false);
            workbook.write(fos);
            workbook.close();
            fos.close();
            System.out.println("save local");
        }
        return Paths.get(folder + File.separator + fileName + ".xlsx");
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void copyToShared(Path local) {
        String sharedFolder = "\\\\dvgd-sp-02.dvgd.oao.rzd\\sites\\espp-disp\\Shared Documents\\Резерв маршрутизации";
//        new File(sharedFolder).mkdir();
        try {
            Path p = Files.copy(local,
                    Paths.get(sharedFolder + File.separator + local.getFileName().toString()), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("SAVE shared " + sharedFolder);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Не могу сохранить на портал");
        }
    }

}
