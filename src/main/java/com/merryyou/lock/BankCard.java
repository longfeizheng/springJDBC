package com.merryyou.lock;

/**
 * Created on 2016/5/1 0001.
 *
 * @author zlf
 * @since 1.0
 */
public class BankCard {
    private String cardid = "XZ456789";
    private int balance = 10000;
    public String getCardid() {
        return cardid;
    }
    public void setCardid(String cardid) {
        this.cardid = cardid;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
}
