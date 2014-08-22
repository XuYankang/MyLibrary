package leetcode;

import java.util.*;

/**
 * Created by jacob on 14-8-20.
 */
public class WordBreakII {
    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        HashSet<String> set = new HashSet<String>(Arrays.asList(new String[]{"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"}));

        WordBreakII wordBreak = new WordBreakII();

        String s1 = "cofjdnfdnjbejdhbkhechoeindgmkeloaibeffoacbieekebbfimhdehmncdcajhknidl";
        HashSet<String> set1 = new HashSet<String>(Arrays.asList(new String[]{"khjhhagijlickgjob", "ajhknidl", "khech", "kjigndmcl", "mbmodglgbahcmdcdoea", "lnllaflae", "enhakibofef", "gjhegnfhlibiog", "ajlfkmccbahbbggn", "inbanhdomnnghdj", "ghigcndibhmeojchbbogkgb", "cdebhjjifcnmmmccoj", "majcemhhdg", "ccfhclceoh", "ljfjlaghjehk", "mljn", "anifljijkdhociken", "fogabkbbd", "cjahcbienajcgakjjig", "kkfffg", "jchelakgio", "mkkaklj", "obehecobkolile", "eejne", "ndoeic", "fbfnkehm", "e", "mam", "hdbibbfijcnlomabemombog", "lo", "egbklbihgangemjb", "jmckjbkbodfknffbchfgie", "hldlkfclidhfalmlonfj", "diabnkcbadjfmncenihfhk", "lamnnbhbaak", "cgjmekgfkogclha", "nifaifhkbl", "eimgallmelmi", "mchglmn", "fladoo", "admmdklfogkafedhnkikell", "nfceebenebjgffillm", "bacnnmhilkfkffflhdjkhb", "fdmbgmckefhenhn", "cofjdnfdnjbej", "lcmooada", "iikimdf", "aoloadmajamljdcbfeo", "jhoebchekagjlellllm", "dh", "agk", "nlgb", "ldihehjafnkcakofebgloam", "cbgkafkljdaea", "jillnbnglddhdjaf", "bjnhobhaalaanijcblhfjfj", "difdoaj", "mfmcgmaekia", "dofkioedciimljhdeehd", "kegnobengjbbiko", "aamlocelnmib", "oeemgcnfamlmdljfdmflfjj", "eff", "klblolckacndmangjm", "kieec", "ldljcjchn", "blbeg", "minibhaoegameolbchfdmd", "aahofmcngcdle", "lgihd", "mmmkj", "eoajcgncdafj", "ehgkknkefkgkmfbnkfgn", "jnniindkohgjdnbjj", "mjgkooiklknbnohbn", "cddhoglffhikhf", "hkojnkclkfjdkno", "bhamagfa", "cclfechbhkkbikjnfiam", "caihcen", "ddo", "cndgo", "mmecggd", "k", "cnccdoiflnincgacakdoffkdg", "eadblmgaioccedaabjfli", "jielegjn", "kmcnckacoifjamh", "ljladkigjjcklnfjagdbbm", "na", "nblkbmcmmlible", "aobkbkeljbhm", "jinalibnjhghkdegejfkhojmb", "eahacl", "chefiggjndcnmlhfelbffea", "nbekmjcgjhbnm", "hkgabejjogecnlnollhdmc", "kc", "lhifcackehclg", "c", "fcna", "docgijgankik", "b", "kfmnoenngjhbkjdbbdb", "fmajfjg", "imaalcbeibmondaen", "loaibeffoacbieekebhmncdc", "mchdeedmhmimjeg", "oebgcilngjfalebeonbgjmhb", "igaieibkhklncikm", "lkmhimcj", "ahfehlfbimgbgc", "hemaimhfnigmfnabco", "l", "jahkbcdonia", "i", "bfimhde", "ciekchnoolgkjnijekjehcagl", "iob", "gjldfmnaldnclofg", "bbghhfbmknflddiabgj", "gholddmbmnhii", "iodn", "cckkmijgcdjkglfd", "njmdahlgbloimibfdco", "cjdekg", "oeindgmke", "mbdcgebgdk", "jlddkmoe", "oegbiannddkmhibjokkm", "loaejecbcondlgaeenbjlokjg", "dlchahdimcdjobkfoce", "haamgab", "fkbj", "aggodojjglicnf", "gahadoafofdbeieihklfg", "aembllfaiggee", "ljnjfhknfjf", "lhkobdkmnkmaf", "ilgcde", "nghclbilaiombcidj", "igamidcjibblokkmjkhnha", "ceiikahhicgbdlhlo", "hdcfnig", "fbbignkajdjgn", "ogjkbcccdldmea", "ihnoenlokk", "blk", "aifhjmimhnggogajflkgc", "jfoiif"}));


        //boolean result = wordBreak.wordBreak(s, set);
        List<String> strings = wordBreak.wordBreak(s1, set1);
        System.out.println(strings);
        //System.out.println(result);
    }

    /**
     * Given a string s and a dictionary of words dict,
     * add spaces in s to construct a sentence where each word is a valid dictionary word.
     * <p/>
     * Return all such possible sentences.
     * <p/>
     * For example, given
     * s = "catsanddog",
     * dict = ["cat", "cats", "and", "sand", "dog"].
     * <p/>
     * A solution is ["cats and dog", "cat sand dog"].
     *
     * @param s
     * @param dict
     * @return
     */
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> result = new ArrayList<String>();

        if (s == null || s.length() == 0 || dict == null || dict.size() == 0) {
            return result;
        }

        boolean[] possiblity = new boolean[s.length()];
        ArrayList<Item>[] wordStore = new ArrayList[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ArrayList<Item> list = new ArrayList<Item>();
            for (String word : dict) {
                if (i < word.length() - 1) {
                    continue;
                }
                if (s.substring(i + 1 - word.length(), i + 1 - word.length() + word.length()).equals(word)) {
                    Item item = new Item();
                    item.word = word;
                    possiblity[i] = true;
                    if (i - word.length() == -1) {
                        item.i = -1;
                    } else if (possiblity[i - word.length()]) {
                        item.i = i - word.length();
                    }
                    list.add(item);
                }

            }
            wordStore[i] = list;
        }


        //System.out.println(Arrays.asList(wordStore));
        String current = "";
        print(wordStore, current, result, s.length() - 1, s);

        return result;

    }

    private void print(ArrayList<Item>[] wordStore, String current, List<String> result, int index, String s) {

        if (wordStore[index] == null) {
            return;
        }
        for (Item item : wordStore[index]) {
            if (item.i == -1) {
                String temp = (item.word + " " + current).trim();
                if (temp.replace(" ", "").length() == s.length()) {
                    result.add(temp);
                }
            } else {
                current = item.word + " " + current;
                print(wordStore, current, result, item.i, s);
                current = current.substring(item.word.length() + 1);
            }
        }


    }

    class Item {
        int i;
        String word;

        @Override
        public String toString() {
            return "Item{" +
                    "i=" + i +
                    ", word='" + word + '\'' +
                    '}';
        }
    }
}
