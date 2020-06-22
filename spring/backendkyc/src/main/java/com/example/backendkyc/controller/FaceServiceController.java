package com.example.backendkyc.controller;

import com.example.backendkyc.model.FACService;
import com.example.backendkyc.model.RequestService;
import com.example.backendkyc.payload.*;
import com.example.backendkyc.reposiroty.FACServiceRepository;
import com.example.backendkyc.reposiroty.RequestServiceRepository;
import com.example.backendkyc.service.FacServiceImpl;
import com.example.backendkyc.service.RequestServiceImpl;
import com.example.backendkyc.utils.Comparator;
import com.example.backendkyc.utils.Utils;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.example.backendkyc.utils.Constant.LOG_FORMAT;
import static com.example.backendkyc.utils.Utils.buildLogTag;

@Controller
@RequestMapping("/face")
public class FaceServiceController {

    private static final Logger LOGGER = LogManager.getLogger(FaceServiceController.class);
    private static final Gson gson = new Gson();
    private static ModelMapper modelMapper = new ModelMapper();

    @Autowired
    FacServiceImpl facServiceImpl;
    @Autowired
    FACServiceRepository facServiceRepository;

    @Autowired
    RequestServiceImpl requestServiceImpl;
    @Autowired
    RequestServiceRepository requestServiceRepository;

    @RequestMapping("/search")
    @ResponseBody
    public DataTableResponse search(HttpServletRequest request,
                                    @RequestParam("clientId") String clientId,
                                    @RequestParam("requestId") String requestId,
                                    @RequestParam(value = "fromDate", required = false) String fromDate,
                                    @RequestParam(value = "toDate", required = false) String toDate,
                                    @RequestParam("draw") int draw,
                                    @RequestParam("length") int length,
                                    @RequestParam("start") int start,
                                    Principal principal) {
        String tag = buildLogTag(request, principal, "Search request");
        LOGGER.debug(LOG_FORMAT + "clientId: {}, requestId: {},fromDate: {}," +
                        " toDate: {},draw :{} ,length :{} , start: {}", tag, "Search request. ",
                clientId, requestId,fromDate,toDate,draw,length,start);

        Pageable pageable = PageRequest.of(start / length, length);
        List<FACService> list = new ArrayList<>();
        Long count = 0L;
        try{
            Date from = Utils.getStartDay(fromDate);
            Date to = Utils.getEndDay(toDate);
            list = facServiceImpl.searchFaceRequest(from,to,clientId,requestId,pageable);
            count = requestServiceImpl.countSearchRequest(from,to,clientId,requestId);

            int index = start + 1;
            if (!Comparator.isEqualNullOrEmpty(list)) {
                for(FACService r : list){
                    r.setIndex(index);
                    index++;
                }
            }
        }catch (Exception e){
            LOGGER.error("Error while export program :" + e.getMessage());
        }
        return DataTableParser.parse(list, draw, count.intValue());
    }


    @RequestMapping("/list")
    public ModelAndView getListView(HttpServletRequest request, Principal principal) {
        String tag = buildLogTag(request, principal, "List request");
        LOGGER.debug(LOG_FORMAT, tag, "List request view");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("request/list_request");
        LOGGER.debug(LOG_FORMAT, tag, "Return view: {}", mv.getViewName());
        return mv;
    }

    @RequestMapping("/detail/{id}")
    public ModelAndView getDetailView(HttpServletRequest request,Principal principal,
                                      @PathVariable("id") Integer id) {
        String tag = buildLogTag(request, principal, "Detail request");
        LOGGER.debug(LOG_FORMAT, tag, "Detail request view");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("request/detail_request");
        RequestService requestService = null;

        LOGGER.debug(LOG_FORMAT, tag, "Return view: {}", mv.getViewName());
        return mv;
    }

}
