package cn.gdj.test.pojo;

public class PowerOnAttribValue {
    private String attribId;

    private Integer setSeqNo;

    private String representTypeId;

    private Integer representCategoryNo;

    private String valueText;

    public PowerOnAttribValue(String attribId, Integer setSeqNo, String representTypeId, Integer representCategoryNo, String valueText) {
        this.attribId = attribId;
        this.setSeqNo = setSeqNo;
        this.representTypeId = representTypeId;
        this.representCategoryNo = representCategoryNo;
        this.valueText = valueText;
    }

    public PowerOnAttribValue() {
        super();
    }

    public String getAttribId() {
        return attribId;
    }

    public void setAttribId(String attribId) {
        this.attribId = attribId == null ? null : attribId.trim();
    }

    public Integer getSetSeqNo() {
        return setSeqNo;
    }

    public void setSetSeqNo(Integer setSeqNo) {
        this.setSeqNo = setSeqNo;
    }

    public String getRepresentTypeId() {
        return representTypeId;
    }

    public void setRepresentTypeId(String representTypeId) {
        this.representTypeId = representTypeId == null ? null : representTypeId.trim();
    }

    public Integer getRepresentCategoryNo() {
        return representCategoryNo;
    }

    public void setRepresentCategoryNo(Integer representCategoryNo) {
        this.representCategoryNo = representCategoryNo;
    }

    public String getValueText() {
        return valueText;
    }

    public void setValueText(String valueText) {
        this.valueText = valueText == null ? null : valueText.trim();
    }
}