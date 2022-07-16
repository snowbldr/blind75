package me.kmtn.blind75;

import java.util.List;
import java.util.Map;

import static me.kmtn.blind75.Util.stringListFromString;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/word-break/
public class Problem35_LC139_WordBreak {

    static boolean wordBreak(String s, List<String> wordDict) {
        return quickWordBreak(s, wordDict, 0, new boolean[s.length()]);
    }

    static boolean quickWordBreak(String s, List<String> wordDict, int startIndex, boolean[] visited) {
        if(s.length()== startIndex){
            return true;
        }

        if(visited[startIndex]) {
            return false;
        }

        visited[startIndex] = true;

        for(String word : wordDict){
            if(s.startsWith(word, startIndex) && quickWordBreak(s, wordDict, startIndex+word.length(), visited)){
                return true;
            }
        }
        return false;
    }

    static boolean findWordBreak(String s, List<String> wordDict, Map<String, Boolean> results) {
        if(results.containsKey(s)){
            return results.get(s);
        }
        boolean res = false;
        for(String word : wordDict){
            int i = s.indexOf(word);
            if(i > -1){
                if(word.length() == s.length()){
                    res = true;
                    break;
                }
                boolean found = true;
                if(i>0){
                    found = findWordBreak(s.substring(0, i), wordDict, results);
                }
                if(i+word.length() < s.length()){
                    found = found && findWordBreak(s.substring(i+word.length()), wordDict, results);
                }
                if(found){
                    res = true;
                    break;
                }
            }
        }
        results.put(s, res);
        return res;
    }


    public static void main(String[] args) {
        assertThat(wordBreak(
                "fohhemkkaecojceoaejkkoedkofhmohkcjmkggcmnami", stringListFromString("[\n" +
                "\"kfomka\",\n" +
                "\"hecagbngambii\",\n" +
                "\"anobmnikj\",\n" +
                "\"c\",\n" +
                "\"nnkmfelneemfgcl\",\n" +
                "\"ah\",\n" +
                "\"bgomgohl\",\n" +
                "\"lcbjbg\",\n" +
                "\"ebjfoiddndih\",\n" +
                "\"hjknoamjbfhckb\",\n" +
                "\"eioldlijmmla\",\n" +
                "\"nbekmcnakif\",\n" +
                "\"fgahmihodolmhbi\",\n" +
                "\"gnjfe\",\n" +
                "\"hk\",\n" +
                "\"b\",\n" +
                "\"jbfgm\",\n" +
                "\"ecojceoaejkkoed\",\n" +
                "\"cemodhmbcmgl\",\n" +
                "\"j\",\n" +
                "\"gdcnjj\",\n" +
                "\"kolaijoicbc\",\n" +
                "\"liibjjcini\",\n" +
                "\"lmbenj\",\n" +
                "\"eklingemgdjncaa\",\n" +
                "\"m\",\n" +
                "\"hkh\",\n" +
                "\"fblb\",\n" +
                "\"fk\",\n" +
                "\"nnfkfanaga\",\n" +
                "\"eldjml\",\n" +
                "\"iejn\",\n" +
                "\"gbmjfdooeeko\",\n" +
                "\"jafogijka\",\n" +
                "\"ngnfggojmhclkjd\",\n" +
                "\"bfagnfclg\",\n" +
                "\"imkeobcdidiifbm\",\n" +
                "\"ogeo\",\n" +
                "\"gicjog\",\n" +
                "\"cjnibenelm\",\n" +
                "\"ogoloc\",\n" +
                "\"edciifkaff\",\n" +
                "\"kbeeg\",\n" +
                "\"nebn\",\n" +
                "\"jdd\",\n" +
                "\"aeojhclmdn\",\n" +
                "\"dilbhl\",\n" +
                "\"dkk\",\n" +
                "\"bgmck\",\n" +
                "\"ohgkefkadonafg\",\n" +
                "\"labem\",\n" +
                "\"fheoglj\",\n" +
                "\"gkcanacfjfhogjc\",\n" +
                "\"eglkcddd\",\n" +
                "\"lelelihakeh\",\n" +
                "\"hhjijfiodfi\",\n" +
                "\"enehbibnhfjd\",\n" +
                "\"gkm\",\n" +
                "\"ggj\",\n" +
                "\"ag\",\n" +
                "\"hhhjogk\",\n" +
                "\"lllicdhihn\",\n" +
                "\"goakjjnk\",\n" +
                "\"lhbn\",\n" +
                "\"fhheedadamlnedh\",\n" +
                "\"bin\",\n" +
                "\"cl\",\n" +
                "\"ggjljjjf\",\n" +
                "\"fdcdaobhlhgj\",\n" +
                "\"nijlf\",\n" +
                "\"i\",\n" +
                "\"gaemagobjfc\",\n" +
                "\"dg\",\n" +
                "\"g\",\n" +
                "\"jhlelodgeekj\",\n" +
                "\"hcimohlni\",\n" +
                "\"fdoiohikhacgb\",\n" +
                "\"k\",\n" +
                "\"doiaigclm\",\n" +
                "\"bdfaoncbhfkdbjd\",\n" +
                "\"f\",\n" +
                "\"jaikbciac\",\n" +
                "\"cjgadmfoodmba\",\n" +
                "\"molokllh\",\n" +
                "\"gfkngeebnggo\",\n" +
                "\"lahd\",\n" +
                "\"n\",\n" +
                "\"ehfngoc\",\n" +
                "\"lejfcee\",\n" +
                "\"kofhmoh\",\n" +
                "\"cgda\",\n" +
                "\"de\",\n" +
                "\"kljnicikjeh\",\n" +
                "\"edomdbibhif\",\n" +
                "\"jehdkgmmofihdi\",\n" +
                "\"hifcjkloebel\",\n" +
                "\"gcghgbemjege\",\n" +
                "\"kobhhefbbb\",\n" +
                "\"aaikgaolhllhlm\",\n" +
                "\"akg\",\n" +
                "\"kmmikgkhnn\",\n" +
                "\"dnamfhaf\",\n" +
                "\"mjhj\",\n" +
                "\"ifadcgmgjaa\",\n" +
                "\"acnjehgkflgkd\",\n" +
                "\"bjj\",\n" +
                "\"maihjn\",\n" +
                "\"ojakklhl\",\n" +
                "\"ign\",\n" +
                "\"jhd\",\n" +
                "\"kndkhbebgh\",\n" +
                "\"amljjfeahcdlfdg\",\n" +
                "\"fnboolobch\",\n" +
                "\"gcclgcoaojc\",\n" +
                "\"kfokbbkllmcd\",\n" +
                "\"fec\",\n" +
                "\"dljma\",\n" +
                "\"noa\",\n" +
                "\"cfjie\",\n" +
                "\"fohhemkka\",\n" +
                "\"bfaldajf\",\n" +
                "\"nbk\",\n" +
                "\"kmbnjoalnhki\",\n" +
                "\"ccieabbnlhbjmj\",\n" +
                "\"nmacelialookal\",\n" +
                "\"hdlefnbmgklo\",\n" +
                "\"bfbblofk\",\n" +
                "\"doohocnadd\",\n" +
                "\"klmed\",\n" +
                "\"e\",\n" +
                "\"hkkcmbljlojkghm\",\n" +
                "\"jjiadlgf\",\n" +
                "\"ogadjhambjikce\",\n" +
                "\"bglghjndlk\",\n" +
                "\"gackokkbhj\",\n" +
                "\"oofohdogb\",\n" +
                "\"leiolllnjj\",\n" +
                "\"edekdnibja\",\n" +
                "\"gjhglilocif\",\n" +
                "\"ccfnfjalchc\",\n" +
                "\"gl\",\n" +
                "\"ihee\",\n" +
                "\"cfgccdmecem\",\n" +
                "\"mdmcdgjelhgk\",\n" +
                "\"laboglchdhbk\",\n" +
                "\"ajmiim\",\n" +
                "\"cebhalkngloae\",\n" +
                "\"hgohednmkahdi\",\n" +
                "\"ddiecjnkmgbbei\",\n" +
                "\"ajaengmcdlbk\",\n" +
                "\"kgg\",\n" +
                "\"ndchkjdn\",\n" +
                "\"heklaamafiomea\",\n" +
                "\"ehg\",\n" +
                "\"imelcifnhkae\",\n" +
                "\"hcgadilb\",\n" +
                "\"elndjcodnhcc\",\n" +
                "\"nkjd\",\n" +
                "\"gjnfkogkjeobo\",\n" +
                "\"eolega\",\n" +
                "\"lm\",\n" +
                "\"jddfkfbbbhia\",\n" +
                "\"cddmfeckheeo\",\n" +
                "\"bfnmaalmjdb\",\n" +
                "\"fbcg\",\n" +
                "\"ko\",\n" +
                "\"mojfj\",\n" +
                "\"kk\",\n" +
                "\"bbljjnnikdhg\",\n" +
                "\"l\",\n" +
                "\"calbc\",\n" +
                "\"mkekn\",\n" +
                "\"ejlhdk\",\n" +
                "\"hkebdiebecf\",\n" +
                "\"emhelbbda\",\n" +
                "\"mlba\",\n" +
                "\"ckjmih\",\n" +
                "\"odfacclfl\",\n" +
                "\"lgfjjbgookmnoe\",\n" +
                "\"begnkogf\",\n" +
                "\"gakojeblk\",\n" +
                "\"bfflcmdko\",\n" +
                "\"cfdclljcg\",\n" +
                "\"ho\",\n" +
                "\"fo\",\n" +
                "\"acmi\",\n" +
                "\"oemknmffgcio\",\n" +
                "\"mlkhk\",\n" +
                "\"kfhkndmdojhidg\",\n" +
                "\"ckfcibmnikn\",\n" +
                "\"dgoecamdliaeeoa\",\n" +
                "\"ocealkbbec\",\n" +
                "\"kbmmihb\",\n" +
                "\"ncikad\",\n" +
                "\"hi\",\n" +
                "\"nccjbnldneijc\",\n" +
                "\"hgiccigeehmdl\",\n" +
                "\"dlfmjhmioa\",\n" +
                "\"kmff\",\n" +
                "\"gfhkd\",\n" +
                "\"okiamg\",\n" +
                "\"ekdbamm\",\n" +
                "\"fc\",\n" +
                "\"neg\",\n" +
                "\"cfmo\",\n" +
                "\"ccgahikbbl\",\n" +
                "\"khhoc\",\n" +
                "\"elbg\",\n" +
                "\"cbghbacjbfm\",\n" +
                "\"jkagbmfgemjfg\",\n" +
                "\"ijceidhhajmja\",\n" +
                "\"imibemhdg\",\n" +
                "\"ja\",\n" +
                "\"idkfd\",\n" +
                "\"ndogdkjjkf\",\n" +
                "\"fhic\",\n" +
                "\"ooajkki\",\n" +
                "\"fdnjhh\",\n" +
                "\"ba\",\n" +
                "\"jdlnidngkfffbmi\",\n" +
                "\"jddjfnnjoidcnm\",\n" +
                "\"kghljjikbacd\",\n" +
                "\"idllbbn\",\n" +
                "\"d\",\n" +
                "\"mgkajbnjedeiee\",\n" +
                "\"fbllleanknmoomb\",\n" +
                "\"lom\",\n" +
                "\"kofjmmjm\",\n" +
                "\"mcdlbglonin\",\n" +
                "\"gcnboanh\",\n" +
                "\"fggii\",\n" +
                "\"fdkbmic\",\n" +
                "\"bbiln\",\n" +
                "\"cdjcjhonjgiagkb\",\n" +
                "\"kooenbeoongcle\",\n" +
                "\"cecnlfbaanckdkj\",\n" +
                "\"fejlmog\",\n" +
                "\"fanekdneoaammb\",\n" +
                "\"maojbcegdamn\",\n" +
                "\"bcmanmjdeabdo\",\n" +
                "\"amloj\",\n" +
                "\"adgoej\",\n" +
                "\"jh\",\n" +
                "\"fhf\",\n" +
                "\"cogdljlgek\",\n" +
                "\"o\",\n" +
                "\"joeiajlioggj\",\n" +
                "\"oncal\",\n" +
                "\"lbgg\",\n" +
                "\"elainnbffk\",\n" +
                "\"hbdi\",\n" +
                "\"femcanllndoh\",\n" +
                "\"ke\",\n" +
                "\"hmib\",\n" +
                "\"nagfahhljh\",\n" +
                "\"ibifdlfeechcbal\",\n" +
                "\"knec\",\n" +
                "\"oegfcghlgalcnno\",\n" +
                "\"abiefmjldmln\",\n" +
                "\"mlfglgni\",\n" +
                "\"jkofhjeb\",\n" +
                "\"ifjbneblfldjel\",\n" +
                "\"nahhcimkjhjgb\",\n" +
                "\"cdgkbn\",\n" +
                "\"nnklfbeecgedie\",\n" +
                "\"gmllmjbodhgllc\",\n" +
                "\"hogollongjo\",\n" +
                "\"fmoinacebll\",\n" +
                "\"fkngbganmh\",\n" +
                "\"jgdblmhlmfij\",\n" +
                "\"fkkdjknahamcfb\",\n" +
                "\"aieakdokibj\",\n" +
                "\"hddlcdiailhd\",\n" +
                "\"iajhmg\",\n" +
                "\"jenocgo\",\n" +
                "\"embdib\",\n" +
                "\"dghbmljjogka\",\n" +
                "\"bahcggjgmlf\",\n" +
                "\"fb\",\n" +
                "\"jldkcfom\",\n" +
                "\"mfi\",\n" +
                "\"kdkke\",\n" +
                "\"odhbl\",\n" +
                "\"jin\",\n" +
                "\"kcjmkggcmnami\",\n" +
                "\"kofig\",\n" +
                "\"bid\",\n" +
                "\"ohnohi\",\n" +
                "\"fcbojdgoaoa\",\n" +
                "\"dj\",\n" +
                "\"ifkbmbod\",\n" +
                "\"dhdedohlghk\",\n" +
                "\"nmkeakohicfdjf\",\n" +
                "\"ahbifnnoaldgbj\",\n" +
                "\"egldeibiinoac\",\n" +
                "\"iehfhjjjmil\",\n" +
                "\"bmeimi\",\n" +
                "\"ombngooicknel\",\n" +
                "\"lfdkngobmik\",\n" +
                "\"ifjcjkfnmgjcnmi\",\n" +
                "\"fmf\",\n" +
                "\"aoeaa\",\n" +
                "\"an\",\n" +
                "\"ffgddcjblehhggo\",\n" +
                "\"hijfdcchdilcl\",\n" +
                "\"hacbaamkhblnkk\",\n" +
                "\"najefebghcbkjfl\",\n" +
                "\"hcnnlogjfmmjcma\",\n" +
                "\"njgcogemlnohl\",\n" +
                "\"ihejh\",\n" +
                "\"ej\",\n" +
                "\"ofn\",\n" +
                "\"ggcklj\",\n" +
                "\"omah\",\n" +
                "\"hg\",\n" +
                "\"obk\",\n" +
                "\"giig\",\n" +
                "\"cklna\",\n" +
                "\"lihaiollfnem\",\n" +
                "\"ionlnlhjckf\",\n" +
                "\"cfdlijnmgjoebl\",\n" +
                "\"dloehimen\",\n" +
                "\"acggkacahfhkdne\",\n" +
                "\"iecd\",\n" +
                "\"gn\",\n" +
                "\"odgbnalk\",\n" +
                "\"ahfhcd\",\n" +
                "\"dghlag\",\n" +
                "\"bchfe\",\n" +
                "\"dldblmnbifnmlo\",\n" +
                "\"cffhbijal\",\n" +
                "\"dbddifnojfibha\",\n" +
                "\"mhh\",\n" +
                "\"cjjol\",\n" +
                "\"fed\",\n" +
                "\"bhcnf\",\n" +
                "\"ciiibbedklnnk\",\n" +
                "\"ikniooicmm\",\n" +
                "\"ejf\",\n" +
                "\"ammeennkcdgbjco\",\n" +
                "\"jmhmd\",\n" +
                "\"cek\",\n" +
                "\"bjbhcmda\",\n" +
                "\"kfjmhbf\",\n" +
                "\"chjmmnea\",\n" +
                "\"ifccifn\",\n" +
                "\"naedmco\",\n" +
                "\"iohchafbega\",\n" +
                "\"kjejfhbco\",\n" +
                "\"anlhhhhg\"\n" +
                "]"))).isTrue();
        assertThat(wordBreak("applepenapple", stringListFromString("[\"apple\",\"pen\"]"))).isTrue();
        assertThat(wordBreak("leetcode", stringListFromString("[\"leet\",\"code\"]"))).isTrue();
        assertThat(wordBreak("catsandog", stringListFromString("[\"cats\",\"dog\",\"sand\",\"and\",\"cat\"]"))).isFalse();
    }
}
