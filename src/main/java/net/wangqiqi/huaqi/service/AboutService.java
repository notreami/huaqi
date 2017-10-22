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
public class AboutService {
    private static final String[] imgSrcs = {"images/team-1.jpg", "images/team-2.jpg", "images/team-3.jpg", "images/team-4.jpg"};
    private static final String[] titles = {"ENGAGEMENT RINGS", "RINGS", "BANGLES", "EAR RINGS"};
    private static final String[] descriptions = {"Fusce et nibh eget odio cursus consectetur",
            "Fusce et nibh eget odio cursus consectetur",
            "Fusce et nibh eget odio cursus consectetur",
            "Fusce et nibh eget odio cursus consectetur"};

    public void wrapModelAndView(ModelAndView modelAndView) {
        List<CategoryMode> categoryModeList = new ArrayList<>();
        for (int i = 0; i < imgSrcs.length; i++) {
            CategoryMode categoryMode = new CategoryMode();
            categoryMode.setImgSrc(imgSrcs[i]);
            categoryMode.setTitle(titles[i]);
            categoryMode.setDescription(descriptions[i]);
            categoryModeList.add(categoryMode);
        }
        modelAndView.addObject("categoryModeList", categoryModeList);

    }
}
