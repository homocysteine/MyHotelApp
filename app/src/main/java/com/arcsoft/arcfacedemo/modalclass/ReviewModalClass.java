package com.arcsoft.arcfacedemo.modalclass;

public class ReviewModalClass {

    String review_name;
    String review_date;
    String review_desc;

    public ReviewModalClass(){


    }

    public ReviewModalClass(String review_name, String review_date, String review_desc) {
        this.review_name = review_name;
        this.review_date = review_date;
        this.review_desc = review_desc;
    }

    public String getReview_name() {
        return review_name;
    }

    public void setReview_name(String review_name) {
        this.review_name = review_name;
    }

    public String getReview_date() {
        return review_date;
    }

    public void setReview_date(String review_date) {
        this.review_date = review_date;
    }

    public String getReview_desc() {
        return review_desc;
    }

    public void setReview_desc(String review_desc) {
        this.review_desc = review_desc;
    }
}
