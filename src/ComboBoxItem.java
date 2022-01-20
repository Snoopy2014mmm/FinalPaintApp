public class ComboBoxItem {
    private int limit;
    private String labelName;

    public ComboBoxItem(int limit, String labelName){
        this.limit = limit;
        this.labelName = labelName;
    }
    public String toString(){
        return this.labelName;
    }

    public int getLimit() {
        return this.limit;
    }
}
