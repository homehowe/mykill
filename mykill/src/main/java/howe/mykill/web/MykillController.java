package howe.mykill.web;

import howe.mykill.dto.Exposer;
import howe.mykill.dto.MykillExecution;
import howe.mykill.dto.MykillResult;
import howe.mykill.entity.Mykill;
import howe.mykill.enums.MykillStatEnum;
import howe.mykill.exception.RepeatKillException;
import howe.mykill.exception.MykillCloseException;
import howe.mykill.service.MykillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by codingBoy on 16/11/28.
 */
@Component
@RequestMapping("/mykill")//url:模块/资源/{}/细分 
public class MykillController
{
    @Autowired
    private MykillService mykillService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model)
    {
        //list.jsp+mode=ModelAndView
        //获取列表页
        List<Mykill> list=mykillService.getMykillList();
        model.addAttribute("list",list);
        return "list";
    }

    @RequestMapping(value = "/{mykillId}/detail",method = RequestMethod.GET)
    public String detail(@PathVariable("mykillId") Long mykillId, Model model)
    {
        if (mykillId == null)
        {
            return "redirect:/mykill/list";
        }

        Mykill mykill=mykillService.getById(mykillId);
        if (mykill==null)
        {
            return "forward:/mykill/list";
        }

        model.addAttribute("mykill",mykill);

        return "detail";
    }

    //ajax ,json暴露秒杀接口的方法
    @RequestMapping(value = "/{mykillId}/exposer",
                    method = RequestMethod.GET,
                    produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public MykillResult<Exposer> exposer(@PathVariable("mykillId") Long mykillId)
    {
        MykillResult<Exposer> result;
        try{
            Exposer exposer=mykillService.exportMykillUrl(mykillId);
            result=new MykillResult<Exposer>(true,exposer);
        }catch (Exception e)
        {
            e.printStackTrace();
            result=new MykillResult<Exposer>(false,e.getMessage());
        }

        return result;
    }

    @RequestMapping(value = "/{mykillId}/{md5}/execution",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public MykillResult<MykillExecution> execute(@PathVariable("mykillId") Long mykillId,
                                                   @PathVariable("md5") String md5,
                                                   @CookieValue(value = "userPhone",required = false) Long userPhone)
    {
        if (userPhone==null)
        {
            return new MykillResult<MykillExecution>(false,"未注册");
        }
        MykillResult<MykillExecution> result;

        try {
            MykillExecution execution = mykillService.executeMykill(mykillId, userPhone, md5);
            return new MykillResult<MykillExecution>(true, execution);
        }catch (RepeatKillException e1)
        {
            MykillExecution execution=new MykillExecution(mykillId, MykillStatEnum.REPEAT_KILL);
            return new MykillResult<MykillExecution>(true,execution);
        }catch (MykillCloseException e2)
        {
            MykillExecution execution=new MykillExecution(mykillId, MykillStatEnum.END);
            return new MykillResult<MykillExecution>(true,execution);
        }
        catch (Exception e)
        {
            MykillExecution execution=new MykillExecution(mykillId, MykillStatEnum.INNER_ERROR);
            return new MykillResult<MykillExecution>(true,execution);
        }

    }

    //获取系统时间
    @RequestMapping(value = "/time/now",method = RequestMethod.GET)
    @ResponseBody
    public MykillResult<Long> time()
    {
        Date now=new Date();
        return new MykillResult<Long>(true,now.getTime());
    }
}























