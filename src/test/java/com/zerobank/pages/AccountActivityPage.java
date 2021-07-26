package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountActivityPage extends BasePage {

    @FindBy(id = "aa_accountId")
    public WebElement accountTypes;

    @FindBy(id ="aa_type" )
    public WebElement type;

    @FindBy(xpath = "//div[@id='all_transactions_for_account']/table/thead/tr/th")
    public List<WebElement> transactionsColumn;

    @FindBy(xpath = "//a[contains(text(), 'Find Transactions')]")
    public WebElement findTransactionsTab;

    @FindBy(id = "aa_fromDate")
    public WebElement dateFrom;

    @FindBy(id = "aa_toDate")
    public WebElement dateTo;

    @FindBy(id= "aa_description")
    public WebElement descriptionBox;

    @FindBy(css = "[type='submit']")
    public WebElement findButton;

    @FindBy (xpath = "//div[@id='filtered_transactions_for_account']/table/tbody/tr/td[1]")
    public List<WebElement>transactionDates;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']/table/tbody/tr/td[2]")
    public List<WebElement>descriptionsColumn;

    @FindBy (xpath = "//div[@id='filtered_transactions_for_account']//th[contains(text(),'Date')]")
    public WebElement datesHeader;

    @FindBy(xpath = "//div[contains(@id,'filtered')]/table/tbody/tr")
    public List<WebElement> dates;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']/table/tbody/tr/td[4]")
    public List<WebElement> withdrawalsColumn;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']/table/tbody/tr/td[3]")
    public List<WebElement> depositColumn;


    public void getTransactions(String fromDate, String toDate) {
        dateFrom.sendKeys(fromDate);
        dateTo.sendKeys(toDate);
        findButton.click();
    }

    /*public boolean verifyTransactionDates() throws ParseException {
        boolean flag=true;
        int rowNum= dates.size();
        List<String> transactionDates=new ArrayList<>();

        SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd");
        List<Date> d=new ArrayList<>();

        for (int i=0; i<rowNum; i++){
            transactionDates.add(Driver.get().findElement(By.xpath("//div[contains(@id,'filtered')]/table/tbody/tr["+(i+1)+"]/td[1]")).getText());
            d.add(date.parse(transactionDates.get(i)));
        }

        Date dateFirst=date.parse("2012-08-31");
        Date dateLast=date.parse("2012-09-07");
        for (int i = 0; i < d.size(); i++) {
            if(!(d.get(i).after(dateFirst) && d.get(i).before(dateLast))){
                System.out.println(d.get(i));
                flag=false;
                break;
            }
        }

        for (int i=0; i<d.size()-1; i++){
            for (int j = i+1; j < d.size(); j++) {
                if(d.get(i).compareTo(d.get(j))<0){
                    flag=false;
                    System.out.println(d.get(i)+" is not more recent than "+d.get(j));
                    break;
                }
            }
        }
        return flag;
    }

    public AccountActivityPage() {
        PageFactory.initElements(Driver.get(), this);
    }*/
}
