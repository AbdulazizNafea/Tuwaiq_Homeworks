package com.example.project3.Service;


import com.example.project3.Pojo.MerchantStock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MerchantStockService {

    private final ProductService productService;
    private final MerchantService merchantService;


    ArrayList<MerchantStock> merchantStockList = new ArrayList<>();

    public ArrayList<MerchantStock> getMerchantStock() {
        return merchantStockList;
    }

    public void addMerchantStock(MerchantStock merchantStock) {
        merchantStockList.add(merchantStock);
    }

    public boolean updateMerchantStock(MerchantStock merchantStock, int id) {
        for (int i = 0; i < merchantStockList.size(); i++) {
            if (merchantStockList.get(i).getId() == (id)) {
                merchantStockList.set(i, merchantStock);
                return true;
            }
        }
        return false;
    }

    public boolean deleteMerchantStock(int id) {
        for (int i = 0; i < merchantStockList.size(); i++) {
            if (merchantStockList.get(i).getId() == (id)) {
                merchantStockList.remove(i);
                return true;
            }
        }
        return false;
    }

}