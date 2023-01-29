package com.example.project3.Service;

import com.example.project3.Pojo.Merchant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantService {

    ArrayList<Merchant> merchantList = new ArrayList<>();

    public ArrayList<Merchant> getMerchant() {
        return merchantList;
    }

    public void addMerchant(Merchant merchant) {
        merchantList.add(merchant);
    }

    public boolean updateMerchant(Merchant merchant, int id) {
        for (int i = 0; i < merchantList.size(); i++) {
            if (merchantList.get(i).getId() == (id)) {
                merchantList.set(i, merchant);
                return true;
            }
        }
        return false;
    }

    public boolean deleteMerchant(int id) {
        for (int i = 0; i < merchantList.size(); i++) {
            if (merchantList.get(i).getId() == (id)) {
                merchantList.remove(i);
                return true;
            }
        }
        return false;
    }


    //=====================================================
    public boolean isMerchantid(int id) {
        for (int i = 0; i < merchantList.size(); i++) {
            if (merchantList.get(i).getId() == (id)) {
                return true;
            }
        }
        return false;
    }

}
