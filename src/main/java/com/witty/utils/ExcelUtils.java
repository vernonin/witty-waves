package com.witty.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ExcelUtils {

    /**
     * 读取Excel文件并将数据存储到List中。
     *
     * @param fileName 文件路径
     * @param clazz    数据模型类
     * @param <T>      泛型类型
     * @return 包含Excel数据的List
     */
    public static  <T> List<T> readExcelToList(String fileName, Class<T> clazz) {
        List<T> dataList = new ArrayList<>();

        try {
            ClassPathResource classPathResource = new ClassPathResource(fileName);
            String fileFullPath = classPathResource.getFile().getAbsolutePath();

            EasyExcel.read(fileFullPath, clazz, new ExcelListener<>(dataList)).sheet().doRead();

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }

        return dataList;
    }

    /**
     * 监听器类，用于收集读取的数据。
     *
     * @param <T> 泛型类型
     */
    public static class ExcelListener<T> extends AnalysisEventListener<T> {
        private final List<T> dataList;

        public ExcelListener(List<T> dataList) {
            this.dataList = dataList;
        }

        @Override
        public void invoke(T dataModel, AnalysisContext analysisContext) {
            dataList.add(dataModel);
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext analysisContext) {

        }
    }

    /**
     * 将List中的数据写入到Excel文件中。
     *
     * @param fileName 文件路径
     * @param clazz    数据模型类
     * @param dataList 数据列表
     * @param <T>      泛型类型
     */
    public static <T> void writeListToExcel(String fileName, Class<T> clazz, List<T> dataList) {
        // 创建Excel写入器
        ExcelWriter writeWorkbook = EasyExcel.write(fileName, clazz)
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy()) // 设置列宽策略
                .build();

        // 添加工作表
        WriteSheet writeSheet = EasyExcel.writerSheet("数据表").build();

        // 写入数据
        writeWorkbook.write(dataList, writeSheet);

        // 关闭写入器
        writeWorkbook.finish();
    }
}
