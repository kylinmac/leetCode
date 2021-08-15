package com.mc.code;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

/**
 * @author macheng
 * @date 2020/12/24 13:30
 */
public class FileDownload {

    public static void main(String[] args) throws IOException {
        yuanyangExcel();

    }

    private static void yuanyangExcel() throws IOException {
        InputStream resourceAsStream = FileDownload.class.getClassLoader().getResourceAsStream("API渠道对接.xlsx");
        // 建立链接从请求中获取数据
        String agentCode = "8611000368";
        String agentCom = "86110004000034";
        String manageCom = "8611004";
        ExcelReader reader = ExcelUtil.getReader(resourceAsStream);
        FileOutputStream fileOutputStream = new FileOutputStream("result.xlsx");
        List<Sheet> sheets = reader.getSheets();
        Sheet x = sheets.get(0);
        Iterator<Row> rowIterator = x.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Cell cell = row.getCell(0);
                switch (cell.getStringCellValue()) {
                    case "代理人编码":
                        row.getCell(2).setCellValue("tChannel.getAgentCode()");
                        break;
                    case "代理机构编码":
                        row.getCell(2).setCellValue("tChannel.getAgentCom()");
                        break;
                    case "管理机构编码":
                        row.getCell(2).setCellValue("tChannel.getManageCom()");
                        break;
                    default:
                        break;
                }
        }
        ExcelWriter write = new ExcelWriter(x);
        write.flush(fileOutputStream);
        fileOutputStream.close();
    }


    private static HttpURLConnection getHttpURLConnection() throws IOException {
        // 统一资源
        URL url = new URL("https://int-public.oss-cn-beijing.aliyuncs.com/ryl/excel/ybmbdr.xls");
        // http的连接类
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        //设置超时
        httpURLConnection.setConnectTimeout(1000 * 5);
        // 设置字符编码
        httpURLConnection.setRequestProperty("Charset", "UTF-8");
        return httpURLConnection;
    }
}