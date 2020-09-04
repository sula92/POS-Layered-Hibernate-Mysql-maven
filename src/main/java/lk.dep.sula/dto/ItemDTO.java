package lk.dep.sula.dto;

public class ItemDTO {
    String itemCode;
    String description;
    String qty;
    String uprice;

    public ItemDTO() {
    }

    public ItemDTO(String itemCode, String description, String qty, String uprice) {
        this.itemCode = itemCode;
        this.description = description;
        this.qty = qty;
        this.uprice = uprice;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getUprice() {
        return uprice;
    }

    public void setUprice(String uprice) {
        this.uprice = uprice;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "itemCode='" + itemCode + '\'' +
                ", description='" + description + '\'' +
                ", qty='" + qty + '\'' +
                ", uprice='" + uprice + '\'' +
                '}';
    }
}
