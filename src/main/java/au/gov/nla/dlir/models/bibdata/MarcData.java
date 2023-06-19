package au.gov.nla.dlir.models.bibdata;

import java.util.ArrayList;
import java.util.List;

public class MarcData {
    private List<Record> record = new ArrayList<>();

    public List<Record> getRecord() {
        return record;
    }

    public void setRecord(List<Record> record) {
        this.record = record;
    }

    /**
     * Get bibliographic record
     * @return
     */
    public Record getBibliography(){
        List<Record> records = getRecordsByType(Record.Type.BIBLIOGRAPHIC);
        if (records.size() > 0){ //Shouldn't be > 1
            return records.get(0);
        }
        return null;
    }

    public List<Record> getHoldings(){
        return getRecordsByType(Record.Type.HOLDING);
    }

    private List<Record> getRecordsByType(Record.Type recordType){
        List<Record> result = new ArrayList<>();
        for (Record item : record){
            if (item.getType() == recordType){
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "MarcData{" +
                "record=" + record +
                '}';
    }
}
