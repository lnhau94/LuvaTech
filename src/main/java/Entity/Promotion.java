package Entity;

import java.sql.Date;
import java.util.ArrayList;

public class Promotion {
    private String promotionId;
    private String promotionName;
    private Date startDay;
    private Date endDay;

    private ArrayList<PromotionDetails> details;

    public Promotion() {
    }

    public Promotion(String promotionId, String promotionName, Date startDay, Date endDay, ArrayList<PromotionDetails> details) {
        this.promotionId = promotionId;
        this.promotionName = promotionName;
        this.startDay = startDay;
        this.endDay = endDay;
        this.details = details;
    }

    public String getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(String promotionId) {
        this.promotionId = promotionId;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }

    public ArrayList<PromotionDetails> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<PromotionDetails> details) {
        this.details = details;
    }
}
