package au.gov.nla.dlir.util;

import au.gov.nla.dlir.models.Content;
import au.gov.nla.dlir.models.bibdata.MarcData;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Sets;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MarcDataHelperTest {
    private static final String CATALOGUE_URL = "http://catalogue.nla.gov.au/Record/{bibId}?view=json_record";
    private static final String COLLECTION_SERVICE_URL = "http://dl-devel.nla.gov.au/nla-cat/record/{bibId}?format=json&includeSuppressed=false";

    private static final List<String> bibIds = new ArrayList<>();

    @Before
    public void setup() throws IOException {
        InputStream is = ClassLoader.getSystemResourceAsStream("bibid/bib1001-2000.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = br.readLine()) != null){
            bibIds.add(line);
        }
        br.close();
    }

    @Test
    @Ignore
    public void test(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        for (String bibId: bibIds){
            try{
                String catalogueString = new RestTemplate().getForObject(CATALOGUE_URL.replace("{bibId}", bibId), String.class);
                Content oldBib = mapper.readValue(catalogueString, Content.class);
                String collectionServiceString = new RestTemplate().getForObject(COLLECTION_SERVICE_URL.replace("{bibId}", bibId), String.class);
                MarcData marcData = mapper.readValue(collectionServiceString, MarcData.class);
                Content newBib = new MarcDataHelper(marcData).getBibData().getContent();
                assertThat(newBib.getId(), is(oldBib.getId()));
                assertThat("Author incorrect for bib "+bibId, newBib.getAuthor(), is(oldBib.getAuthor()));
                if (newBib.getCallnumber() == null){
                    assertThat("Call number incorrect for bib "+bibId, newBib.getCallnumber(), is(oldBib.getCallnumber()));
                }else{
                    List<String> oldCallNumber = MarcDataHelper.replaceMultipleSpacesWithSingleSpace(oldBib.getCallnumber());
                    List<String> newCallNumber = MarcDataHelper.replaceMultipleSpacesWithSingleSpace(newBib.getCallnumber());
                    Collections.sort(oldCallNumber);
                    Collections.sort(newCallNumber);
                    assertThat("Call number incorrect for bib " + bibId, oldCallNumber, is(newCallNumber));
                }
                assertThat("Cited author incorrect for bib "+bibId, MarcDataHelper.replaceMultipleSpacesWithSingleSpace(newBib.getCitedAuthors()), is(MarcDataHelper.replaceMultipleSpacesWithSingleSpace(oldBib.getCitedAuthors())));
                assertThat("Cited title incorrect for bib "+bibId, newBib.getCitedTitle(), is(oldBib.getCitedTitle()));
                assertThat("Cited year incorrect for bib "+bibId, newBib.getCitedYear(), is(oldBib.getCitedYear()));
                assertThat("Cited publisher name incorrect for bib "+bibId, newBib.getCitedPublisherName(), is(oldBib.getCitedPublisherName()));
                assertThat("Cited publisher place incorrect for bib "+bibId, newBib.getCitedPublisherPlace(), is(oldBib.getCitedPublisherPlace()));
                assertThat("Title incorrect for bib "+bibId, newBib.getTitle(), is(oldBib.getTitle()));
                if (newBib.getPublishDates() == null){
                    assertThat("Publish dates incorrect for bib "+bibId, newBib.getPublishDates(), is(oldBib.getPublishDates()));
                }else{
                    List<String> oldPublishDates = MarcDataHelper.replaceMultipleSpacesWithSingleSpace(oldBib.getPublishDates());
                    List<String> newPublishDates = MarcDataHelper.replaceMultipleSpacesWithSingleSpace(newBib.getPublishDates());
                    Collections.sort(oldPublishDates);
                    Collections.sort(newPublishDates);
                    assertThat("Publish dates incorrect for bib " + bibId, oldPublishDates, is(newPublishDates));
                }
                assertThat("Description incorrect for bib "+bibId, MarcDataHelper.replaceMultipleSpacesWithSingleSpace(newBib.getDescription()), is(MarcDataHelper.replaceMultipleSpacesWithSingleSpace(oldBib.getDescription())));
                assertThat("Summary incorrect for bib "+bibId, MarcDataHelper.replaceMultipleSpacesWithSingleSpace(newBib.getSummary()), is(MarcDataHelper.replaceMultipleSpacesWithSingleSpace(oldBib.getSummary())));
                assertThat("Bio history incorrect for bib "+bibId, MarcDataHelper.replaceMultipleSpacesWithSingleSpace(newBib.getBioHistories()), is(MarcDataHelper.replaceMultipleSpacesWithSingleSpace(oldBib.getBioHistories())));
                System.out.println("Finished Bib "+bibId);
            }catch (Exception e){
                System.out.println("error when compare bib "+bibId);
                e.printStackTrace();
            }catch (Error e){
                e.printStackTrace();
            }
        }
    }

    @Test
    public void citedPublisherPlace(){
        assertThat("[1988 Aug. 23] [Australia,? :".replaceAll("[^\\[\\]a-zA-Z0-9.,? ]", ""), is("[1988 Aug. 23] [Australia,? "));
    }

    @Test
    public void extractYearAndHyphen(){
        assertThat(MarcDataHelper.extractYearAndHyphen("1943"), is("1943"));
        assertThat(MarcDataHelper.extractYearAndHyphen("April 18th 1805-1873."), is("1805-1873"));
    }

    @Test
    public void titleSlash(){
        assertThat("Teddy count his pots  / by Fred J. Nicoll".replaceAll("[ ]+/", " /"), is("Teddy count his pots / by Fred J. Nicoll"));
    }

    @Test
    public void removeTrailingStringsForCitedTitle(){
        assertThat(MarcDataHelper.removeTrailingStringsForCitedTitle("abc..."), is("abc.."));
        assertThat(MarcDataHelper.removeTrailingStringsForCitedTitle("abc/ "), is("abc"));
        assertThat(MarcDataHelper.removeTrailingStringsForCitedTitle("abc /"), is("abc"));
        assertThat(MarcDataHelper.removeTrailingStringsForCitedTitle("abc. "), is("abc"));
        assertThat(MarcDataHelper.removeTrailingStringsForCitedTitle("abc ."), is("abc"));
    }

    @Test
    public void removeTrailingCharacters(){
        assertThat(MarcDataHelper.removeTrailingCharacters("1943", Sets.newHashSet(',', '.')), is("1943"));
        assertThat(MarcDataHelper.removeTrailingCharacters("1943.,", Sets.newHashSet(',', '.')), is("1943"));
        assertThat(MarcDataHelper.removeTrailingCharacters("1943.", Sets.newHashSet(',', '.')), is("1943"));
        assertThat(MarcDataHelper.removeTrailingCharacters("1943,", Sets.newHashSet(',', '.')), is("1943"));
        assertThat(MarcDataHelper.removeTrailingCharacters("...", Sets.newHashSet(',', '.')), is(""));
    }

    @Test
    public void removeLeadingCharacters(){
        assertThat(MarcDataHelper.removeLeadingCharacters("1943", Sets.newHashSet(',', '.')), is("1943"));
        assertThat(MarcDataHelper.removeLeadingCharacters(".,1943", Sets.newHashSet(',', '.')), is("1943"));
        assertThat(MarcDataHelper.removeLeadingCharacters(".1943", Sets.newHashSet(',', '.')), is("1943"));
        assertThat(MarcDataHelper.removeLeadingCharacters(",1943", Sets.newHashSet(',', '.')), is("1943"));
        assertThat(MarcDataHelper.removeLeadingCharacters("...", Sets.newHashSet(',', '.')), is(""));
    }

    @Test
    public void extractCitedYear(){
        assertThat(MarcDataHelper.extractCitedYear("1943"), is("1943"));
        assertThat(MarcDataHelper.extractCitedYear("April 18th 1943 - 1998"), is("1943"));
        assertThat(MarcDataHelper.extractCitedYear("[19--?]."), is("[19--?]"));
        assertThat(MarcDataHelper.extractCitedYear("[193-?];"), is("[193-?]"));
        assertThat(MarcDataHelper.extractCitedYear("196-?    ]."), is("196-? ]"));
        assertThat(MarcDataHelper.extractCitedYear("191-]"), is("191-]"));
        assertThat(MarcDataHelper.extractCitedYear("1917-[19-?]"), is("1917"));
        assertThat(MarcDataHelper.extractCitedYear("-1989"), is("1989"));
    }

    @Test
    public void containsValidCitedAuthor(){
        assertThat(MarcDataHelper.containsValidCharactersAndPunctuations("w123."), is(true));
        assertThat(MarcDataHelper.containsValidCharactersAndPunctuations("w, 12"), is(true));
        assertThat(MarcDataHelper.containsValidCharactersAndPunctuations("w#123"), is(true));
        assertThat(MarcDataHelper.containsValidCharactersAndPunctuations("dsf%&@"), is(true));
        assertThat(MarcDataHelper.containsValidCharactersAndPunctuations("Xü, Jiaxing"), is(true));
        assertThat(MarcDataHelper.containsValidCharactersAndPunctuations("à Paris."), is(true));
        assertThat(MarcDataHelper.containsValidCharactersAndPunctuations("Ibárruri, Dolores."), is(true));
        assertThat(MarcDataHelper.containsValidCharactersAndPunctuations("Alton, Eduard d’"), is(true));
        assertThat(MarcDataHelper.containsValidCharactersAndPunctuations("Aitangjüshi."), is(true));
        assertThat(MarcDataHelper.containsValidCharactersAndPunctuations("Polverel, François."), is(true));
        assertThat(MarcDataHelper.containsValidCharactersAndPunctuations("Petrescu-Dîmbovița, Mircea."), is(true));
        assertThat(MarcDataHelper.containsValidCharactersAndPunctuations("©1993"), is(true));
        assertThat(MarcDataHelper.containsValidCharactersAndPunctuations("許家惺"), is(false));
        //System.out.println(Integer.toHexString((int) "́".charAt(0)));
    }
}
