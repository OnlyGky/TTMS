package com.springboot.richttms.pojo.evaluate;

public class Evaluate {
    private Integer evaluateId;
    private Integer cId;
    private Integer mId;
    private String evaluateContext;
    private Integer evaluateRole;

    public Evaluate() {
    }

    public Evaluate(Integer evaluateId, Integer cId, Integer mId, String evaluateContext, Integer evaluateRole) {
        this.evaluateId = evaluateId;
        this.cId = cId;
        this.mId = mId;
        this.evaluateContext = evaluateContext;
        this.evaluateRole = evaluateRole;
    }

    public Integer getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(Integer evaluateId) {
        this.evaluateId = evaluateId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getEvaluateContext() {
        return evaluateContext;
    }

    public void setEvaluateContext(String evaluateContext) {
        this.evaluateContext = evaluateContext;
    }

    public Integer getEvaluateRole() {
        return evaluateRole;
    }

    public void setEvaluateRole(Integer evaluateRole) {
        this.evaluateRole = evaluateRole;
    }
}
