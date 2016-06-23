package au.gov.nla.dlir.models.bibdata;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class Record {

    public enum Type{
        BIBLIOGRAPHIC("Bibliographic"), HOLDING("Holdings");

        private static final Map<String, Type> stringToEnum = new HashMap<>();
        static {
            for (Type type : values()){
                stringToEnum.put(type.toString(), type);
            }
        }

        private String code;

        Type(String code) {
            this.code = code;
        }

        public static Type fromString(String symbol){
            return stringToEnum.get(symbol);
        }

        @Override
        public String toString() {
            return code;
        }
    }

    private Leader leader = new Leader();
    private List<DataField> datafield = new ArrayList<>();
    private List<ControlField> controlfield = new ArrayList<>();

    public ControlField getControlFieldByTag(String tag){
        for (ControlField item : controlfield){
            if (StringUtils.equalsIgnoreCase(item.getTag(), tag)){
                return item;
            }
        }
        return null;
    }

    public DataField getFirstDataFieldByTag(String tag){
        for (DataField item : datafield){
            if (StringUtils.equalsIgnoreCase(item.getTag(), tag)){
                return item;
            }
        }
        return null;
    }

    public static List<DataField> getDataFieldsByTag(List<Record> records, String tag){
        List<DataField> result = new ArrayList<>();
        for (Record record : records){
            result.addAll(record.getDataFieldsByTag(tag));
        }
        return result;
    }

    public static List<DataField> getFirstDataFieldByTagForEachRecord(List<Record> records, String tag){
        List<DataField> result = new ArrayList<>();
        for (Record record : records){
            result.add(record.getFirstDataFieldByTag(tag));
        }
        return result;
    }

    public List<DataField> getDataFieldsByTag(String tag){
        List<DataField> result = new ArrayList<>();
        for (DataField item : datafield){
            if (StringUtils.equalsIgnoreCase(item.getTag(), tag)){
                result.add(item);
            }
        }
        return result;
    }

    public List<DataField> getDataFieldsByTag(String tag, Set<String> validInd1s, Set<String> validInd2s){
        List<DataField> result = new ArrayList<>();
        for (DataField item : datafield){
            if (StringUtils.equalsIgnoreCase(item.getTag(), tag)
                    && isValidInd(item.getInd1(), validInd1s)
                    && isValidInd(item.getInd2(), validInd2s)){
                result.add(item);
            }
        }
        return result;
    }

    private boolean isValidInd(String ind, Set<String> validInds) {
        if (validInds == null){
            return true;
        }
        return validInds.contains(ind);
    }

    public Leader getLeader() {
        return leader;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }

    public List<DataField> getDatafield() {
        return datafield;
    }

    public void setDatafield(List<DataField> datafield) {
        this.datafield = datafield;
    }

    public List<ControlField> getControlfield() {
        return controlfield;
    }

    public void setControlfield(List<ControlField> controlfield) {
        this.controlfield = controlfield;
    }

    public Type getType(){
        return Type.fromString(leader.getType());
    }

    public String getLeaderContent(){
        return leader.getContent();
    }

    @Override
    public String toString() {
        return "Record{" +
                "leader=" + leader +
                ", datafield=" + datafield +
                ", controlfield=" + controlfield +
                '}';
    }
}
