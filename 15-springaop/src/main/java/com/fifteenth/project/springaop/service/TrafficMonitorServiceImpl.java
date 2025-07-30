package com.fifteenth.project.springaop.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service
public class TrafficMonitorServiceImpl implements TrafficMonitorService {

    @Override
    public String getTrafficStatus() {
        
        return getTrafficStatus(false);

    }
    
    @Override
    public String getTrafficStatus(boolean isException) throws RuntimeException {
        
        // simulate an exception
        if (isException) {
            throw new RuntimeException("Exception occured while fetching Traffic Status");
        }

        // simulate a delay
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    
        return "Too much traffic, service might delay!";

    }

}
