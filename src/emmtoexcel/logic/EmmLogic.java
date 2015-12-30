package emmtoexcel.logic;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author ATonevitskiy
 */
public class EmmLogic {

    public static final String[] ZO = new String[]{"ДВС", "ГОР", "ГВЦ", "КБШ", "КЛГ", "КРАСН",
        "МСК", "ОКТ", "ПРИВ", "СЕВ", "СКВ", "СВРД", "ЮВСТ", "ЮУР", "ВСИБ", "ЗАБ", "ЗСИБ", "Все ЗО"};

    private static final String[] ColumnNames = new String[]{"ЦТС", "ЗО", "Код услуги", "Система",
        "Система(подробно)", "АРМ", "Ключевые слова", "1 линия поддержки", "Режим работы 1 линии(раб. время)",
        "1 линия поддержки в нерабочее время", "Режим работы 1 линии(нераб. время)",
        "Шаблон объекта АСУ ЕСПП с WEB-формы", "2 линия поддержки",
        "Признак сопровождения (Т-технологтческое; А-администрирование; У-установка)",
        "АС ОЗ (ЗАПРОС)", "Шаблон запроса в АСУ ЕСПП", "АС ОЗ (НАРЯД ПО ЗАПРОСУ)", "Шаблон наряда по запросу в АСУ ЕСПП",
        "Примечания"};

    private SXSSFWorkbook workbook;

    public EmmLogic() {
        workbook = new SXSSFWorkbook(new XSSFWorkbook());
    }

    private void createHeader(Sheet sheet) {
        Row headRow = sheet.createRow(0);
        XSSFCellStyle style;
        style = (XSSFCellStyle) sheet.getWorkbook().createCellStyle();
        style.setFillForegroundColor(new XSSFColor(new java.awt.Color(234, 234, 234)));
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setWrapText(true);

        for (int i = 0; i < EmmLogic.ColumnNames.length; i++) {
            Cell cell = headRow.createCell(i);
            cell.setCellStyle(style);
            cell.setCellValue(ColumnNames[i]);
            switch (i) {
                case 0:
                    sheet.setColumnWidth(i, 8 * 255);
                case 1:
                    sheet.setColumnWidth(i, 8 * 255);
                case 2:
                    sheet.setColumnWidth(i, 8 * 255);
                default:
                    sheet.setColumnWidth(i, 25 * 255);
            }
        }
    }

    private Sheet createSheet(String name) {
        Sheet sheet = workbook.createSheet();
        workbook.setSheetName(workbook.getSheetIndex(sheet), name);
        createHeader(sheet);
        return sheet;
    }

}
