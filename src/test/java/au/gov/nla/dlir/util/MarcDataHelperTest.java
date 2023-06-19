package au.gov.nla.dlir.util;

import com.google.common.collect.Sets;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MarcDataHelperTest {
    private static final String CATALOGUE_URL = "http://staffcat.nla.gov.au/Record/{bibId}?view=json_record";
    private static final String COLLECTION_SERVICE_URL = "http://dl-devel.nla.gov.au/nla-cat/record/{bibId}?format=json&includeSuppressed=false";

    private static final List<String> bibIds = new ArrayList<>();

    @BeforeEach
    public void setup() throws IOException {
        InputStream is = ClassLoader.getSystemResourceAsStream("bibid/bib1-5k.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = br.readLine()) != null){
            bibIds.add(line);
        }
        br.close();
    }


    private static List<String> trimList(List<String> strs){
        List<String> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(strs)){
            for(String str : strs){
                result.add(str.trim());
            }
        }
        return result;
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
    public void containsValidCharactersAndPunctuations(){
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
        assertThat(MarcDataHelper.containsValidCharactersAndPunctuations("許家惺"), is(false)); //Chinese not allowed
        assertThat(MarcDataHelper.containsValidCharactersAndPunctuations("สรรพสิริ วิรยศิริ."), is(false)); //Thai not allowed
    }
}
