package au.gov.nla.dlir.util;


import au.gov.nla.dlir.models.BibData;
import au.gov.nla.dlir.models.Content;
import au.gov.nla.dlir.models.bibdata.*;
import com.google.common.base.Joiner;
import com.google.common.collect.Sets;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarcDataHelper {
    private static final Joiner SPACE_JOINER = Joiner.on(" ").skipNulls();

    private BibData bibData;
    private Content content;
    private Record bibliographyRecord;
    private List<Record> holdingRecords;

    public MarcDataHelper(MarcData marcData) {
        if (marcData != null){
            bibliographyRecord = marcData.getBibliography();
            holdingRecords = marcData.getHoldings();
            if (bibliographyRecord != null){
                bibData = new BibData();
                content = bibData.getContent();
                populate();
            }
        }
    }

    public static BibData convertFromMarc(MarcData marcData){
        return new MarcDataHelper(marcData).getBibData();
    }

    private void populate(){
        populateBibId();
        populateCallNumber();
        populateAuthor();
        populateCitedAuthor();
        populateCitedTitle();
        populateCitedYear();
        populateCitedPublisherName();
        populateCitedPublisherPlace();
        populateTitle();
        populatePublishDates();
        populateDescription();
        poplulateBioHistory();
        populateSummary();
    }

    private void populateBibId(){
        ControlField controlFieldTag001 = bibliographyRecord.getControlFieldByTag("001");
        if (controlFieldTag001 != null){
            content.setId(controlFieldTag001.getContent());
        }
    }

    private void populateCallNumber() {
        List<String> result = new ArrayList<>();
        result.addAll(getDataFieldValueWithReplacements(Record.getFirstDataFieldByTagForEachRecord(holdingRecords, "852"), Sets.newHashSet('k', 'h', 'i', 'm')));
        if (CollectionUtils.isNotEmpty(result)) {
            List<String> replaced = removeTrailingCharacters(toUpperCase(result), Sets.newHashSet('.', ' ', ';'));
            content.setCallnumber(replaced);
        }
    }

    private void populateAuthor() {
        List<String> result = new ArrayList<>();
        //Only one 1xx field is allowed
        result.addAll(getDataFieldValueWithReplacements(toList(bibliographyRecord.getFirstDataFieldByTag("100")), Sets.newHashSet('a', 'c', 'd', 'q')));
        if (CollectionUtils.isEmpty(result)){
            result.addAll(getDataFieldValueWithReplacements(toList(bibliographyRecord.getFirstDataFieldByTag("110")), Sets.newHashSet('a', 'b', 'c', 'd')));
        }
        if (CollectionUtils.isEmpty(result)) {
            result.addAll(getDataFieldValueWithReplacements(toList(bibliographyRecord.getFirstDataFieldByTag("111")), Sets.newHashSet('a', 'c', 'd', 'n')));
        }
        if (CollectionUtils.isNotEmpty(result)) {
            List<String> replaced = replaceMultipleSpacesWithSingleSpace(result);
            String author = removeTrailingCharacters(replaced, Sets.newHashSet(',', '.', ' ')).get(0).trim();
            if (StringUtils.isNotBlank(author)){
                content.setAuthor(author);
            }
        }
    }

    private void populateCitedAuthor() {
        List<String> result = new ArrayList<>();
        //Only one 1xx field is allowed
        result.addAll(removeTrailingCommaWithDotOrAddTrailingDot(getDataFieldValueWithReplacements(toList(bibliographyRecord.getFirstDataFieldByTag("100")), Sets.newHashSet('a'))));
        if (CollectionUtils.isEmpty(result)) {
            result.addAll(removeTrailingCommaWithDotOrAddTrailingDot(getDataFieldValueWithReplacements(toList(bibliographyRecord.getFirstDataFieldByTag("110")), Sets.newHashSet('a', 'b', 'c', 'd', 'e'))));
        }
        if (CollectionUtils.isEmpty(result)) {
            result.addAll(removeTrailingCommaWithDotOrAddTrailingDot(getDataFieldValueWithReplacements(toList(bibliographyRecord.getFirstDataFieldByTag("111")), Sets.newHashSet('a', 'b'))));
        }
        result.addAll(removeTrailingCommaWithDotOrAddTrailingDot(getDataFieldValueWithReplacements(bibliographyRecord.getDataFieldsByTag("700"), Sets.newHashSet('a'))));
        result.addAll(removeTrailingCommaWithDotOrAddTrailingDot(getDataFieldValueWithReplacements(bibliographyRecord.getDataFieldsByTag("710"), Sets.newHashSet('a', 'b', 'c', 'd', 'e'))));
        result.addAll(removeTrailingCommaWithDotOrAddTrailingDot(getDataFieldValueWithReplacements(bibliographyRecord.getDataFieldsByTag("711"), Sets.newHashSet('a', 'b'))));
        if (CollectionUtils.isNotEmpty(result)) {
            List<String> replaced = replaceMultipleSpacesWithSingleSpace(result);
            replaced = removeNonLatinCharacters(replaced);
            content.setCitedAuthors(replaced);
        }
    }

    private void populateCitedTitle() {
        List<String> result = getDataFieldValueWithReplacements(toList(bibliographyRecord.getFirstDataFieldByTag("245")), Sets.newHashSet('a', 'b'));
        if (CollectionUtils.isNotEmpty(result)) {
            List<String> replaced = replaceMultipleSpacesWithSingleSpace(result);
            content.setCitedTitle(removeTrailingStringsForCitedTitle(replaced.get(0)));
        }
    }

    private void populateCitedYear() {
        List<String> result = new ArrayList<>();
        result.addAll(getDataFieldValueWithReplacements(bibliographyRecord.getDataFieldsByTag("260"), Sets.newHashSet('c')));
        if (CollectionUtils.isEmpty(result)){
            result.addAll(getDataFieldValueWithReplacements((bibliographyRecord.getDataFieldsByTag("264", null, Sets.newHashSet("1", "2", "4"))), Sets.newHashSet('c')));
        }
        result = removeNonLatinCharacters(result);
        if (CollectionUtils.isNotEmpty(result)) {
            String year = result.get(0);
            if (StringUtils.isNotBlank(year)){
                year = extractCitedYear(year);
                if (StringUtils.isNotBlank(year)){
                    content.setCitedYear(year);
                }
            }
        }
    }

    private void populateCitedPublisherName() {
        List<String> result = getDataFieldValueWithReplacements(bibliographyRecord.getDataFieldsByTag("260"), Sets.newHashSet('b'));
        if (CollectionUtils.isEmpty(result)){
            result.addAll(getDataFieldValueWithReplacements((bibliographyRecord.getDataFieldsByTag("264", null, Sets.newHashSet("1", "2", "4"))), Sets.newHashSet('b')));
        }
        if (CollectionUtils.isNotEmpty(result)) {
            String name = result.get(0).replaceAll("[ ]+", " ");
            if (containsValidPublisherName(name)){
                name = removeLeadingCharacters(name, Sets.newHashSet(',', '.', ' ', ';'));
                name = removeTrailingCharacters(name, Sets.newHashSet(',', '.', ' ', ';', '/'));
                if (StringUtils.isNotBlank(name)){
                    content.setCitedPublisherName(name);
                }
            }
        }
    }

    private void populateCitedPublisherPlace() {
        List<String> result = getDataFieldValueWithReplacements(bibliographyRecord.getDataFieldsByTag("260"), Sets.newHashSet('a'));
        if (CollectionUtils.isEmpty(result)){
            result.addAll(getDataFieldValueWithReplacements((bibliographyRecord.getDataFieldsByTag("264", null, Sets.newHashSet("1", "2", "4"))), Sets.newHashSet('a')));
        }
        if (CollectionUtils.isNotEmpty(result)) {
            List<String> replaced = replaceMultipleSpacesWithSingleSpace(removeNonLatinCharacters(result));
            String place = removeTrailingCharacters(replaced, Sets.newHashSet(',', '.', ' ', ';', ':')).get(0);
            if (StringUtils.isNotBlank(place)){
                content.setCitedPublisherPlace(place);
            }

        }
    }

    private void populateTitle() {
        List<String> result = getDataFieldValueWithReplacements(toList(bibliographyRecord.getFirstDataFieldByTag("245")), Sets.newHashSet('a', 'b', 'c', 'f', 'h', 'n', 'p'));
        if (CollectionUtils.isNotEmpty(result)) {
            List<String> replaced = replaceMultipleSpacesWithSingleSpace(result);
            replaced = removeLeadingCharacters(replaced, Sets.newHashSet('.', ' '));
            content.setTitle(removeTrailingCharacters(replaced, Sets.newHashSet(',', '.', ' ', ';', '/')).get(0));
        }
    }

    private void populatePublishDates() {
        List<String> result = getDataFieldValueWithReplacements(bibliographyRecord.getDataFieldsByTag("260"), Sets.newHashSet('a', 'b', 'c'));
        result.addAll(getDataFieldValueWithReplacements(bibliographyRecord.getDataFieldsByTag("264", null, Sets.newHashSet("0", "1", "2", "4")), Sets.newHashSet('a','b','c')));
        if (CollectionUtils.isNotEmpty(result)) {
            List<String> replaced = removeNonLatinCharacters(replaceMultipleSpacesWithSingleSpace(result));
            content.setPublishDates(removeTrailingCharacters(replaced, Sets.newHashSet(',', '.', ' ', ';', '/')));
        }
    }

    private void populateDescription() {
        List<String> result = getDataFieldValueWithReplacements(bibliographyRecord.getDataFieldsByTag("300"), Sets.newHashSet('a', 'b', 'c', 'e', 'f', 'g'));
        if (CollectionUtils.isNotEmpty(result)) {
            content.setDescription(result);
        }
    }

    private void poplulateBioHistory() {
        List<String> result = getDataFieldValueWithReplacements(bibliographyRecord.getDataFieldsByTag("545"), null, Sets.newHashSet('u'));
        if (CollectionUtils.isNotEmpty(result)) {
            List<String> replaced = replaceMultipleSpacesWithSingleSpace(result);
            content.setBioHistories(replaced);
        }
    }

    private void populateSummary() {
        List<String> result = getDataFieldValueWithReplacements(bibliographyRecord.getDataFieldsByTag("520"), Sets.newHashSet('a'));
        if (CollectionUtils.isNotEmpty(result)) {
            List<String> replaced = removeNonLatinCharacters(replaceMultipleSpacesWithSingleSpace(result));
            content.setSummary(replaced);
        }
    }

    private boolean containsValidPublisherName(String name) {
        List<String> invalidPublisherNames = Arrays.asList("s.n", "publisher not identified");
        for (String invalid : invalidPublisherNames){
            if (name.toLowerCase().contains(invalid)){
                return false;
            }
        }
        return true;
    }

    private static List<DataField> toList(DataField dataField){
        return dataField != null ? Collections.singletonList(dataField) : new ArrayList<DataField>(0);
    }

    private static List<String> getDataFieldValueWithReplacements(List<DataField> dataFields, Set<Character> includedSubfieldCodes){
        return getDataFieldValueWithReplacements(dataFields, includedSubfieldCodes, null);
    }

    private static List<String> getDataFieldValueWithReplacements(List<DataField> dataFields, Set<Character> includedSubfieldCodes,
                                                                  Set<Character> ignoredSubfieldCodes){
        List<String> result = new ArrayList<>();
        for (DataField dataFieldItem : dataFields){
            List<String> subfieldValues = new ArrayList<>();
            for (Subfield subfieldItem : dataFieldItem.getSubfield()){
                if (subfieldItem.getCode() != null && isValidSubfieldCode(subfieldItem.getCode().charAt(0), includedSubfieldCodes, ignoredSubfieldCodes)) {
                    subfieldValues.add(subfieldItem.getContent() != null ? subfieldItem.getContent() : "");
                }
            }
            if (CollectionUtils.isNotEmpty(subfieldValues)) {
                result.add(SPACE_JOINER.join(subfieldValues));
            }
        }
        return result;
    }

    private static boolean isValidSubfieldCode(char code, Set<Character> includedSubfieldCodes, Set<Character> excludedSubfieldCodes) {
        if (includedSubfieldCodes == null && excludedSubfieldCodes == null){
            return true;
        }
        if (includedSubfieldCodes != null){
            return includedSubfieldCodes.contains(code);
        }
        return !excludedSubfieldCodes.contains(code);
    }

    private static List<String> removeTrailingCommaWithDotOrAddTrailingDot(List<String> strs){
        List<String> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(strs)) {
            for (String str : strs) {
                String tmp = removeTrailingComma(str).trim();
                if (!tmp.endsWith(".")) {
                    tmp += ".";
                }
                result.add(tmp);
            }
        }
        return result;
    }

    private List<String> removeNonLatinCharacters(List<String> strs) {
        List<String> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(strs)){
            for (String str : strs){
                if (containsValidCharactersAndPunctuations(str)){
                    result.add(str);
                }
            }
        }
        return result;
    }

    private static String removeTrailingComma(String str){
        return removeTrailingString(str, Collections.singletonList(","));
    }

    private static String removeTrailingString(String str, List<String> endStrings){
        for (String endString : endStrings){
            if (str.endsWith(endString)){
                return str.substring(0, str.length()-1);
            }
        }
        return str;
    }

    /**
     * CJK (Chinese, Japanese, Korean) characters are considered invalid
     * @param str
     * @return
     */
    protected static boolean containsValidCharactersAndPunctuations(String str){
        //http://jrgraphix.net/research/unicode_blocks.php
        String pattern = "[\\u0020-\\u036F\\u2000-\\u303F]+";
        return str.matches(pattern);
    }

    protected static List<String> replaceMultipleSpacesWithSingleSpace(List<String> strs){
        List<String> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(strs)){
            for (String str : strs){
                result.add(str.replaceAll("[ ]+", " "));
            }
        }
        return result;
    }

    private static List<String> removeTrailingCharacters(List<String> strs, Set<Character> chs){
        List<String> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(strs)) {
            for (String str : strs) {
                result.add(removeTrailingCharacters(str, chs));
            }
        }
        return result;
    }

    protected static String removeTrailingCharacters(String str, Set<Character> chs){
        int index = str.length() - 1;
        while (index >= 0){
            if (chs.contains(str.charAt(index))){
                index--;
            }else{
                break;
            }
        }
        return str.substring(0, index + 1);
    }

    private static List<String> removeLeadingCharacters(List<String> strs, Set<Character> chs){
        List<String> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(strs)) {
            for (String str : strs) {
                result.add(removeLeadingCharacters(str, chs));
            }
        }
        return result;
    }

    private static List<String> toUpperCase(List<String> strs){
        List<String> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(strs)) {
            for (String str : strs) {
                result.add(str.toUpperCase());
            }
        }
        return result;
    }

    protected static String removeLeadingCharacters(String str, Set<Character> chs){
        int index = 0;
        while (index < str.length()){
            if (chs.contains(str.charAt(index))){
                index++;
            }else{
                break;
            }
        }
        return str.substring(index);
    }

    protected static String extractYearAndHyphen(String str){
        StringBuilder result = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        for (int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if (Character.isDigit(c) || c == '-'){
                tmp.append(c);
            }else {
                if (tmp.length() >= 4){
                    result.append(tmp);
                }
                tmp = new StringBuilder();
            }
        }
        if (tmp.length() >= 4){
            result.append(tmp);
        }
        return result.toString();
    }

    protected static String removeTrailingStringsForCitedTitle(String str){
        int index = str.length() - 1;
        boolean removedDot = false;
        while (index >= 0){
            if (str.charAt(index) == '.'){
                if (removedDot){
                    break;
                }else{
                    index--;
                    removedDot = true;
                }
            }else if (Sets.newHashSet('/', ' ').contains(str.charAt(index))){
                index--;
            }else{
                break;
            }
        }
        return str.substring(0, index + 1);
    }

    protected static String extractCitedYear(String str){
        Pattern p = Pattern.compile("\\d{4}");
        Matcher matcher = p.matcher(str);
        if (matcher.find()){
            return matcher.group();
        }
        return removeTrailingCharacters(str.replaceAll("[ ]+", " "), Sets.newHashSet(',', '.', ';', ' '));
    }

    public BibData getBibData() {
        return bibData;
    }
}
