package com.example.IFANOW.service.impl;

import com.example.IFANOW.model.UserEventInfo;
import com.example.IFANOW.repository.db.UserEventInfoRepository;
import com.example.IFANOW.service.UserEventInfoService;
import com.example.IFANOW.utility.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEventInfoServiceImpl implements UserEventInfoService {

    @Autowired
    UserEventInfoRepository userEventInfoRepository;


    @Autowired
    private NotificationService notificationService;


    @Override
        public String submitUserEventInfo(UserEventInfo userEventInfo) {

        List<UserEventInfo> userEventInfos=userEventInfoRepository.findAllById(userEventInfo.getUserid());
         int totalamount=0;
        try{


        for (UserEventInfo userEventInfo1 : userEventInfos) {
            totalamount = totalamount + userEventInfo1.getAmount();
        }

        if(userEventInfos.size()==1){
            notificationService.sendFirstBillPaytNotification("test@gmail.com", "7066882723", "test", 500,
                    100, 1000);
        }
        else if(userEventInfos.size()>=5 && totalamount >=20000){
            notificationService.sendLargeTransactionAlertNotification("test@gmail.com", "7066882723", "test", 500,
                    100, 1000);
        }
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }

       /* else{
            notificationService.sendFeedbackNotification("test@gmail.com", "7066302723", "teju", 500,
                    100, 1000);
        }*/

        return "success";
    }
}
