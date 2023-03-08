package com.dcg.pdc.controller;

import com.dcg.pdc.biz.PdcBiz;
import com.dcg.pdc.vo.JDbookVO;
import com.dcg.pdc.vo.JdUrlVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("pdc")
public class PdcController {

    @Autowired
    private PdcBiz pdcBiz;

    /**
     * 同步CIP库数据，不传时间，同步所有的
     * @param date
     */
    @GetMapping("insertCIp")
    public void insertCIp(@RequestParam(value = "date",required = false) String date){
        pdcBiz.insertCIp(date);
    }

    /**
     * 同步ISBN库数据，不传时间，同步所有的
     * @param date
     */
    @GetMapping("insertIsbn")
    public void insertIsbn(@RequestParam(value = "date",required = false) String date){
        pdcBiz.insertIsbn(date);
    }

    /**
     * 获取销售数据
     * @param month
     */
    @GetMapping("getSaleData")
    public void getSaleData(@RequestParam(value = "month",required = false) String month,
                            @RequestParam(value = "startId",required=false) String startId){
        pdcBiz.getSaleData(month,startId);
        System.out.println("getSaleData拉取结束");
    }

    /**
     * 获取作者数据
     * @param
     */
    @GetMapping("getAuthorData")
    public void getAuthorData(@RequestParam(required = false) String startId){
        pdcBiz.getAuthorData4Control(startId);
    }


    /**
     * 根据ISBN填充jdurl
     */
    @GetMapping("insertJDurl4Isbn")
    public void insertJDurl4Isbn(){
        pdcBiz.insertJDurl4Isbn();
    }

    /**
     * 根据ISBN填充jdurl
     */
    @GetMapping("insertJDurl4Cip")
    public void insertJDurl4Cip(){
        pdcBiz.insertJDurl4Cip();
    }


    /**
     * 测试
     */
    @GetMapping("deal")
    public void deal(){
        pdcBiz.deal();
    }


    /**
     * 处理isbn库的topic
     */
    @GetMapping("dealIsbnTopic")
    public void dealIsbnTopic(){
        pdcBiz.dealIsbnTopic();
    }


    /**
     * topic入库
     */
    @GetMapping("dealTopics")
    public void dealTopics(){
        pdcBiz.dealTopics();
    }




    /**
     * 京东图书分类处理
     */
    @GetMapping("dealBookType")
    public void dealBookType(){
        pdcBiz.dealBookType();
    }

    /**
     * 获取京东图书爬虫路径
     */
    @GetMapping("getJdUrl")
    public List<JdUrlVO> getJdUrl(){
          return   pdcBiz.getJdUrl();
    }

    /**
     * 京东图书爬虫返回数据处理
     */
    @GetMapping("insertJd")
    public void insertJd(@RequestParam("id")int id ,@RequestParam("firstName")String firstName ,@RequestParam("secondName")String secondName  ,@RequestParam("discount")String discount){
        pdcBiz.insertJd(id,firstName,secondName,discount);
    }


    /**
     * 京东图书爬虫返回数据处理
     */
    @GetMapping("insertJdv2")
    public void insertJdv2(@RequestBody JDbookVO jDbookVO ){
        pdcBiz.insertJdv2(jDbookVO);
    }


    /**
     * 清洗ISBN和CIP库，插入到 dim_isbncip_mapping
     */
    @GetMapping("cleanISBNandCIp")
    public void cleanISBNandCIp(){
        pdcBiz.cleanISBNandCIp();
    }

    /**
     * 清洗ISBN和CIP库，插入到 dim_isbncip_mapping
     */
    @GetMapping("getToken")
    public String getToken4Control(){
        return pdcBiz.getToken4Control();
    }

    @GetMapping("checkPdcsale")
    public String checkPdcsale(@RequestParam("file") MultipartFile file) {
        Long startTime = System.currentTimeMillis();
        pdcBiz.checkPdcsale(file);
        return "成功执行接口文件:<br/>" +   "\n" + "用时" + (System.currentTimeMillis() - startTime)/1000 + "秒";
    }

}
