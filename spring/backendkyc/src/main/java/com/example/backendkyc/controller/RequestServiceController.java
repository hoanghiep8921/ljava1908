package com.example.backendkyc.controller;

import com.example.backendkyc.model.FACService;
import com.example.backendkyc.model.RequestService;
import com.example.backendkyc.payload.*;
import com.example.backendkyc.reposiroty.RequestServiceRepository;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.*;

import static com.example.backendkyc.utils.Constant.LOG_FORMAT;
import static com.example.backendkyc.utils.Utils.buildLogTag;

@Controller
@RequestMapping("/request")
public class RequestServiceController {

    private static final Logger LOGGER = LogManager.getLogger(RequestServiceController.class);
    private static final Gson gson = new Gson();
    private static ModelMapper modelMapper = new ModelMapper();

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
        List<RequestService> list = new ArrayList<>();
        Long count = 0L;
        try{
            Date from = Utils.getStartDay(fromDate);
            Date to = Utils.getEndDay(toDate);
            list = requestServiceImpl.searchRequest(from,to,clientId,requestId,pageable);
            count = requestServiceImpl.countSearchRequest(from,to,clientId,requestId);

            int index = start + 1;
            if (!Comparator.isEqualNullOrEmpty(list)) {
                for(RequestService r : list){
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
    public ModelAndView getListView(HttpServletRequest request,Principal principal) {
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
        Optional<RequestService> optionalRequestService = requestServiceRepository.findById(id);
        if(!optionalRequestService.isPresent()){
            return mv;
        }
        requestService = optionalRequestService.get();

        mv.addObject("requestService",requestService);
        mv.addObject("facServiceDTO",requestService.getFacService());
        mv.addObject("nlpServiceDTO",requestService.getNlpService());
        mv.addObject("ocrServiceDTO",requestService.getOcrService());
        mv.addObject("pprServiceDTO",requestService.getPprService());

        LOGGER.debug(LOG_FORMAT, tag, "Return view: {}", mv.getViewName());
        return mv;
    }



//    @RequestMapping(value = "/export", method = RequestMethod.GET)
//    @ResponseBody
//    public void exportExcelTerminalByCategory(HttpServletRequest request, Principal principal,
//                                              HttpServletResponse response,
//                                              @RequestParam("cardNumber") String cardNumber,
//                                              @RequestParam("authorizationCode") String authorizationCode,
//                                              @RequestParam("billId") String billId,
//                                              @RequestParam("bank") String bank,
//                                              @RequestParam("type") Integer type,
//                                              @RequestParam("status") Integer status,
//                                              @RequestParam(value = "fromDate", required = false) String fromDate,
//                                              @RequestParam(value = "toDate", required = false) String toDate) throws Exception {
//
//        String tag = buildLogTag(request, principal, "Export Excel");
//        LOGGER.debug(LOG_FORMAT, tag, "Export list request success");
//
//        List<RequestDetail> listData = requestService.findAll(cardNumber,authorizationCode,billId,bank,type,status,fromDate,toDate,0,0);
//
//        LOGGER.debug(LOG_FORMAT, tag, "Create file excel");
//        XSSFWorkbook workbook = new XSSFWorkbook();
//        XSSFSheet sheet = workbook.createSheet("Báo cáo tổng hợp yêu cầu");
//        // Create cell font and format
//        XSSFFont font = workbook.createFont();
//        font.setFontHeightInPoints((short) 12);
//        font.setFontName("TIMES");
//        font.setBold(true);
//        //set info font
//        XSSFCellStyle style = workbook.createCellStyle();
//        style.setFont(font);
//
//        Row firstRow = sheet.createRow(0);
//        Cell firstCel1 = firstRow.createCell(0);
//        firstCel1.setCellValue("STT");
//        firstCel1.setCellStyle(style);
//
//        Cell firstCel2 = firstRow.createCell(1);
//        firstCel2.setCellValue("Mã GD");
//        firstCel2.setCellStyle(style);
//
//        Cell firstCel3 = firstRow.createCell(2);
//        firstCel3.setCellValue("Số chuẩn chi");
//        firstCel3.setCellStyle(style);
//
//        Cell firstCel4 = firstRow.createCell(3);
//        firstCel4.setCellValue("Mã đơn hàng");
//        firstCel4.setCellStyle(style);
//
//        Cell firstCel5 = firstRow.createCell(4);
//        firstCel5.setCellValue("Số hóa đơn");
//        firstCel5.setCellStyle(style);
//
//        Cell firstCel6 = firstRow.createCell(5);
//        firstCel6.setCellValue("MID");
//        firstCel6.setCellStyle(style);
//
//        Cell firstCel7 = firstRow.createCell(6);
//        firstCel7.setCellValue("Ngân hàng");
//        firstCel7.setCellStyle(style);
//
//        Cell firstCel8 = firstRow.createCell(7);
//        firstCel8.setCellValue("Kênh thanh toán");
//        firstCel8.setCellStyle(style);
//
//        Cell firstCel9 = firstRow.createCell(8);
//        firstCel9.setCellValue("Số thẻ");
//        firstCel9.setCellStyle(style);
//
//        Cell firstCel10 = firstRow.createCell(9);
//        firstCel10.setCellValue("Loại hoàn tiền");
//        firstCel10.setCellStyle(style);
//
//        Cell firstCel11 = firstRow.createCell(10);
//        firstCel11.setCellValue("Số tiền hoàn");
//        firstCel11.setCellStyle(style);
//
//        Cell firstCel12 = firstRow.createCell(11);
//        firstCel12.setCellValue("Tổng tiền");
//        firstCel12.setCellStyle(style);
//
//        Cell firstCel13 = firstRow.createCell(12);
//        firstCel13.setCellValue("Loại tiền");
//        firstCel13.setCellStyle(style);
//
//        Cell firstCel14 = firstRow.createCell(13);
//        firstCel14.setCellValue("Thời gian settlement");
//        firstCel14.setCellStyle(style);
//
//        Cell firstCel15 = firstRow.createCell(14);
//        firstCel15.setCellValue("Thời gian tạo hoàn");
//        firstCel15.setCellStyle(style);
//
//        Cell firstCel16= firstRow.createCell(15);
//        firstCel16.setCellValue("Thời gian duyệt hoàn");
//        firstCel16.setCellStyle(style);
//
//        Cell firstCel17 = firstRow.createCell(16);
//        firstCel17.setCellValue("Trạng thái");
//        firstCel17.setCellStyle(style);
//
//        int rowNum = 1;
//        for (RequestDetail report : listData) {
//            int stt = rowNum++;
//            Row row = sheet.createRow(stt);
//            Cell cell1 = row.createCell(0);
//            cell1.setCellValue(stt);
//
//            Cell cell2 = row.createCell(1);
//            cell2.setCellValue(report.getRequestId());
//
//            Cell cell3 = row.createCell(2);
//            cell3.setCellValue(report.getAuthorizationCode());
//
//            Cell cell4 = row.createCell(3);
//            cell4.setCellValue(report.getMerchantOrderNumber());
//
//            Cell cell5 = row.createCell(4);
//            cell5.setCellValue(report.getInvoiceNumber());
//
//            Cell cell6 = row.createCell(5);
//            cell6.setCellValue(report.getMid());
//
//            Cell cell7 = row.createCell(6);
//            cell7.setCellValue(report.getSourceBankCode());
//
//            Cell cell8 = row.createCell(7);
//            cell8.setCellValue(report.getChannelName());
//
//            Cell cell9 = row.createCell(8);
//            cell9.setCellValue(report.getCardNumber());
//
//            Cell cell10 = row.createCell(9);
//            cell10.setCellValue(report.getType() == 1 ? "Một phần" : "Toàn phần");
//
//            Cell cell11 = row.createCell(10);
//            cell11.setCellValue(report.getRefundAmount());
//
//            Cell cell12 = row.createCell(11);
//            cell12.setCellValue(report.getTransactionAmount());
//
//            Cell cell13 = row.createCell(12);
//            cell13.setCellValue(report.getTransactionCcy());
//
//            DateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//
//            Cell cell14 = row.createCell(13);
//            Date settlementDate = new Date(report.getSettlementTime().getTime());
//            cell14.setCellValue(f.format(settlementDate));
//
//            Cell cell15 = row.createCell(14);
//            Date requestTime = new Date(report.getRequestTime().getTime());
//            cell15.setCellValue(f.format(requestTime));
//
//            Cell cell16 = row.createCell(15);
//            Date updateTimeStatus = new Date(report.getUpdateTimeStatus().getTime());
//            cell16.setCellValue(f.format(updateTimeStatus));
//
//            Cell cell17 = row.createCell(16);
//            if(report.getStatus() == 1){
//                cell17.setCellValue("Chờ duyệt");
//            }else if(report.getStatus() == 2){
//                cell17.setCellValue("Đã duyệt");
//            }else {
//                cell17.setCellValue("Từ chối duyệt");
//            }
//        }
//        try {
//            Date date = new Date();
//            SimpleDateFormat ft
//                    = new SimpleDateFormat("dd.MM.yyyy  hh:mm:ss a  ");
//            String fileName = "List_Request_" + ft.format(date) + ".xlsx";
//            response.setContentType("application/vnd.ms-excel");
//            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
//            workbook.write(response.getOutputStream());
//            workbook.close();
//        } catch (FileNotFoundException e) {
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


}
