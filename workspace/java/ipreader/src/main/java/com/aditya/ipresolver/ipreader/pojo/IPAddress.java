package com.aditya.ipresolver.ipreader.pojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

@Repository
public class IPAddress {
    
    private Map<String, Integer> ipAddressStore = new HashMap<String, Integer>();

    public Map<String, Integer> getIPAddresses() {
        return ipAddressStore;
    }

    public void saveIPAddress(String key) {
        int val = 0;
        if(ipAddressStore.containsKey(key)) {
            val = ipAddressStore.get(key);
        }
        val +=1;
        ipAddressStore.put(key, val);
    }

    public void clear() {
        if(ipAddressStore==null||ipAddressStore.isEmpty()) {
            return;
        }
        ipAddressStore.clear();
    }

    

}
