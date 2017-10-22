package net.wangqiqi.huaqi.controller;

import lombok.extern.slf4j.Slf4j;
import net.wangqiqi.huaqi.model.response.CommonResponse;
import net.wangqiqi.huaqi.service.AboutService;
import net.wangqiqi.huaqi.service.GalleryService;
import net.wangqiqi.huaqi.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by notreami on 17/10/11.
 */
@Slf4j
@RestController
//@RequestMapping("/ui")
public class UIController {
    @Autowired
    private IndexService indexService;
    @Autowired
    private AboutService aboutService;
    @Autowired
    private GalleryService galleryService;
    //Model ModelAndView
    @RequestMapping("/")
    public ModelAndView home() {
        return index();
    }

    @RequestMapping("/index.html")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("homeTitle", "Home");
        modelAndView.addObject("indexBannerContainer", true);

        indexService.wrapModelAndView(modelAndView);
        return modelAndView;
    }

    @RequestMapping("/about.html")
    public ModelAndView about() {
        ModelAndView modelAndView = new ModelAndView("about");
        modelAndView.addObject("homeTitle", "About");
        modelAndView.addObject("aboutBannerContainer", "active");

        aboutService.wrapModelAndView(modelAndView);
        return modelAndView;
    }

    @RequestMapping("/jewellery.html")
    public ModelAndView jewellery() {
        ModelAndView modelAndView = new ModelAndView("jewellery");
        modelAndView.addObject("homeTitle", "Jewellery");
        modelAndView.addObject("jewelleryBannerContainer", "active");
        return modelAndView;
    }

    @RequestMapping("/typography.html")
    public ModelAndView typography() {
        ModelAndView modelAndView = new ModelAndView("typography");
        modelAndView.addObject("homeTitle", "Typography");
        modelAndView.addObject("typographyBannerContainer", "active");
        return modelAndView;
    }

    @RequestMapping("/gallery.html")
    public ModelAndView gallery() {
        ModelAndView modelAndView = new ModelAndView("gallery");
        modelAndView.addObject("homeTitle", "Gallery");
        modelAndView.addObject("galleryBannerContainer", "active");

        galleryService.wrapModelAndView(modelAndView);
        return modelAndView;
    }

    @RequestMapping("/error.html")
    public ModelAndView error() {
        ModelAndView modelAndView = new ModelAndView("sys-error");
        return modelAndView;
    }
}
