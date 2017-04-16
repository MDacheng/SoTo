package com.mdc.web;

import com.mdc.domain.Background;
import com.mdc.domain.User;
import com.mdc.service.BackgroundService;
import com.mdc.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

/**
 * Created by mengdacheng on 2017/4/8.
 */
@Controller
public class BackgroundController {

    @Autowired
    private BackgroundService backgroundService;

    @RequestMapping("/search.html")
    public ModelAndView search(HttpServletRequest request){
        try{
            String keyword = new String(request.getParameter("keyword").getBytes("iso-8859-1"), "utf-8");
            System.out.println(keyword);
            List<Background> backgrounds = backgroundService.getBackgroundByKeyword(keyword, 1);
            System.out.println(backgrounds.size());
            request.getSession().setAttribute("keyword", keyword);
            request.getSession().setAttribute("group", 1);
            request.getSession().setAttribute("backgrounds", backgrounds);
        }catch(UnsupportedEncodingException ex){
            ex.printStackTrace();
        }
        return new ModelAndView("main");
    }

    @RequestMapping("refresh.html")
    public String refresh(HttpServletRequest request, ModelMap modelMap){
        Integer group = (Integer)request.getSession().getAttribute("group");
        String keyword = request.getSession().getAttribute("keyword").toString();
        List<Background> backgrounds = backgroundService.getBackgroundByKeyword(keyword, group+1);
        modelMap.addAttribute("backgrounds", backgrounds);
        request.getSession().setAttribute("group", group+1);
        return "main";
    }

    @RequestMapping("/image.html")
    public void getImage(HttpServletRequest request, HttpServletResponse response){
        String url = request.getParameter("imgUrl");
        try{
            ImageUtil.writeImage(url, response.getOutputStream());
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    @RequestMapping("/orign.html")
    public ModelAndView viewOrign(HttpServletRequest request){
        String url = request.getParameter("imgUrl");
        request.getSession().setAttribute("orimg", url);
        return new ModelAndView("orimg");
    }

    @RequestMapping("/download.html")
    public String download(HttpServletRequest request, HttpServletResponse response){
        String url= request.getParameter("imgUrl");
        backgroundService.download((User) request.getSession().getAttribute("user"));
        String[] args = url.split("\\/");
        response.setHeader("content-disposition", "attachment;filename=" + args[args.length-1]);
        try{
            ImageUtil.writeImage(url, response.getOutputStream());
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return "main";
    }
}
