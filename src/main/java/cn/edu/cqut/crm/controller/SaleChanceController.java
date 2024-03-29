package cn.edu.cqut.crm.controller;

import cn.edu.cqut.crm.model.SaleChance;
import cn.edu.cqut.crm.service.SaleChanceService;
import cn.edu.cqut.crm.util.ReturnObject;
import cn.edu.cqut.crm.util.ReturnUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SaleChanceController {
    @Autowired
    private SaleChanceService saleChanceService;

    @RequestMapping(value = "/SaleChance/addSaleChance",method =RequestMethod.POST)
    public Map<String, String> addSaleChance(SaleChance saleChance){
        saleChanceService.addSaleChance(saleChance);
        Map<String, String> map = new HashMap<String,String>();
        map.put("result", "新增销售机会成功");
        return map;
    }

    /**
     * 销售机会分页查询功能
     * @param page 当前页号
     * @param rows 页面容量
     * @return 返回销售机会列表
     */
    @RequestMapping(value = "/saleChance/{page}/{rows}", method = RequestMethod.GET)
    public ReturnObject<Object> getAllSaleChance(@PathVariable() int page, @PathVariable() int rows) {
        PageHelper.startPage(page, rows);
        List<SaleChance> saleChances = saleChanceService.getAllSaleChance();
        PageInfo<SaleChance> pageInfo = new PageInfo<>(saleChances);
        long total = pageInfo.getTotal();
        return ReturnUtil.success("查询成功", saleChances, total);
    }

    @RequestMapping(value = "/saleChance/success", method = RequestMethod.PUT)
    public ReturnObject<Object> developSuccess(SaleChance saleChance) {
        Map<String, Object> map = saleChanceService.developSuccess(saleChance);
        return ReturnUtil.success("操作成功", map);
    }

    @RequestMapping(value = "/saleChance/failed", method = RequestMethod.PUT)
    public ReturnObject<Object> developFailed(SaleChance saleChance) {
        saleChanceService.developFailed(saleChance);
        return ReturnUtil.success("操作成功", null);
    }

    @RequestMapping(value = "/SaleChance/{chanceId}",method = RequestMethod.DELETE)
    public Map<String, String> removeSaleChance(@PathVariable() Integer chanceId) {
//        System.out.println(chanceId);
        saleChanceService.removeSaleChance(chanceId);
        Map<String, String> map = new HashMap<String, String>();
        map.put("result", "删除客户成功");
        //System.out.println("aaaa");
        return map;
    }

    @RequestMapping(value = "/SaleChance",method = RequestMethod.PUT)
    public void changeSaleChance(SaleChance saleChance){
        saleChanceService.changeSaleChance(saleChance);
    }

    @RequestMapping(value = "/SaleChance/addSendPerson",method = RequestMethod.PUT)
    public ReturnObject<Object> addSendPerson(SaleChance saleChance){
        System.out.println(saleChance.getChanceStatus());
        saleChanceService.addSendPerson(saleChance);
        return ReturnUtil.success("指派成功", null);

    }

}
