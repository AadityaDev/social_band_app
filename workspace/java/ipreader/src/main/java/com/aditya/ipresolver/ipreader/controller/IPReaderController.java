package com.aditya.ipresolver.ipreader.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aditya.ipresolver.ipreader.IPAddressDTO;
import com.aditya.ipresolver.ipreader.component.IPReaderComponent;

@RestController
public class IPReaderController {
    
    @Autowired
    private IPReaderComponent ipReaderComponent;

    @PostMapping(path = "/request")
    public ResponseEntity requesHandled(@RequestBody IPAddressDTO ipAddress) {
        System.out.println("IPAddress: "+ipAddress.getIpAddress());
        ipReaderComponent.saveIPAddress(ipAddress.getIpAddress());
        return ResponseEntity.ok().body(ipAddress.getIpAddress());
    }

    @GetMapping(path = "/top")
    public ResponseEntity<Map> top() {
        if(ipReaderComponent.retrieveIPAddresses()!=null||ipReaderComponent.retrieveIPAddresses().size()>0) {
            return ResponseEntity.ok().body(ipReaderComponent.retrieveIPAddresses());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/top100")
    public ResponseEntity<Map> top100() {
        if(ipReaderComponent.retrieveIPAddresses()!=null||ipReaderComponent.retrieveIPAddresses().size()>0) {
            return ResponseEntity.ok().body(ipReaderComponent.getTop100IPAddresses());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/clear")
    public ResponseEntity clear() {
        ipReaderComponent.clear();
        return ResponseEntity.ok().build();
    }

}
