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
public class IndexService {
    private static final String[] imgSrcs = {"images/c1.jpg", "images/c2.jpg", "images/c3.jpg", "images/c4.jpg", "images/c5.jpg", "images/c6.jpg"};
    private static final String[] titles = {"ANTIQUE PIECE", "ANTIQUE PIECE", "ANTIQUE PIECE", "ANTIQUE PIECE", "ANTIQUE PIECE", "ANTIQUE PIECE"};
    private static final String[] descriptions = {"Accusantium Dolor", "Accusantium Dolor", "Accusantium Dolor", "Accusantium Dolor", "Accusantium Dolor", "Accusantium Dolor"};

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
