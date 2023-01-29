package com.example.project3.Service;

import com.example.project3.Pojo.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService {

    private final MerchantStockService merchantStockService;
    private final MerchantService merchantService;
    private final ProductService productService;

    ArrayList<User> userList = new ArrayList<>();

    public ArrayList<User> getUser() {
        return userList;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public boolean updateUser(User user, int id) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == (id)) {
                userList.set(i, user);
                return true;
            }
        }
        return false;
    }

    public boolean deleteUser(int id) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == (id)) {
                userList.remove(i);
                return true;
            }
        }
        return false;
    }

    /////////////////////////////////////////////////////////////
    //get product ID
    public int productid(int productid) {
        for (int i = 0; i < productService.productArrayList.size(); i++) {
            if (productService.productArrayList.get(i).getId() == productid) {
                return productService.productArrayList.get(i).getId();
            }
        }
        return 0;
    }

    //get merchant ID
    public int merchantid(int merchantid) {
        for (int i = 0; i < merchantService.merchantList.size(); i++) {
            if (merchantService.merchantList.get(i).getId() == merchantid) {
                return merchantService.merchantList.get(i).getId();
            }
        }
        return 0;
    }
    ///////////////////////////////////////////////////////////////////


    //check is product id and merchant id valid or not. if true add stock
    public boolean checkProductIdAndMerchantId(int ProductId, int merchantId, int stock) {
        for (int i = 0; i < merchantStockService.merchantStockList.size(); i++) {
            if (merchantStockService.merchantStockList.get(i).getProductid() == productid(ProductId) && merchantStockService.merchantStockList.get(i).getMerchantid() == merchantid(merchantId)) {
                merchantStockService.merchantStockList.get(i).setStock(merchantStockService.merchantStockList.get(i).getStock() + stock);
                return true;
            }
        }
        return false;
    }
    public boolean isUserCanAddStock(int userid, int productid, int merchantid, int stock) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == (userid)) {
                if (userList.get(i).getRole().equals("Admin")) {
                    if (checkProductIdAndMerchantId(productid, merchantid, stock)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }




    //---------------------------------------------------------------------------------------


    //get price
    public double priceOfProduct(int productid) {
        for (int i = 0; i < productService.productArrayList.size(); i++) {
            if (productService.productArrayList.get(i).getId() == productid) {
                double price = productService.productArrayList.get(i).getPrice();
                return price;
            }
        }
        return -1.0;
    }

    public boolean checkMerchantStock(int ProductId, int merchantId) {
        for (int i = 0; i < merchantStockService.merchantStockList.size(); i++) {
            if (merchantStockService.merchantStockList.get(i).getProductid() == productid(ProductId) && merchantStockService.merchantStockList.get(i).getMerchantid() == merchantid(merchantId)) {
                int stocks = merchantStockService.merchantStockList.get(i).getStock();
                if (stocks > 0) {
                    merchantStockService.merchantStockList.get(i).setStock(stocks - 1);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isUserCanBuyProduct(int userid, int productid, int merchantid) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == userid) {
                if (userList.get(i).getRole().equals("Customer")) {
                    double price = priceOfProduct(productid);
                    if (userList.get(i).getBalance() >= price && price != -1.0) {
                        if (checkMerchantStock(productid, merchantid)) {
                            userList.get(i).setBalance(userList.get(i).getBalance() - price);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

}
