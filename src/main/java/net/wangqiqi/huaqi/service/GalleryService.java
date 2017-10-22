package net.wangqiqi.huaqi.service;

import lombok.extern.slf4j.Slf4j;
import net.wangqiqi.huaqi.model.view.CategoryMode;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by notreami on 17/10/22.
 */
@Slf4j
@Service
public class GalleryService {
    private static final String[] imgSrcs = {"images/w1.jpg","images/w2.jpg","images/w3.jpg","images/w4.jpg","images/w5.jpg","images/w6.jpg","images/w7.jpg","images/w8.jpg","images/w1.jpg"};

    public void wrapModelAndView(ModelAndView modelAndView) {
        List<CategoryMode> categoryModeList = new ArrayList<>();
        for (int i = 0; i < imgSrcs.length; i++) {
            CategoryMode categoryMode = new CategoryMode();
            categoryMode.setImgSrc(imgSrcs[i]);
            categoryModeList.add(categoryMode);
        }
        modelAndView.addObject("categoryModeList", categoryModeList);

    }
}
