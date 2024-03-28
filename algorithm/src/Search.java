import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @Project personal_exec
 * @Author: xiaoyinglan
 * @Date: 2023/09/26/21:35
 * @Description: 查询指定目录下指定命名格式的文件
 * @Version 1.0
 */
public class Search {


    public static void main(String[] args) throws Exception {
        String proNames = "4px aae add adwlcrack aj alkjwl alwl analysis ane aneky anntocrack anpost antk aolcrack assembler auodex ax axwlcrack ay aycacrack bbd bdtcrack betwl betwlcrack beuropecrack bfay biz-event biz-service-impl biz-shared biz-task bjxkycrack bjxkycrack2 bjy blsyzcrack blyz blz bn brcrack btwl btwlcrack ca cdek cevawlcrack cfwl cgcrack cgsgjcrack chtwlcrack cjexpress ckycrack cloudprint cloudprod cn cncy cnd cnex cnpexcrack cnsd cnxlm coecrack common common-merchant-dal common-service-facade common-service-integration common-util consignor core-model core-service correos cstd ctg ctwl dbl dblcrack dblky dblroute ddw dekun demo deutschepost dhl dhl_decrack dhl_glbcrack dhlcrack dhlcrackjs djkjwl dlg dlgj dmlcrack dnwl dongjincrack douyin drlcrack drlcrack2 dsf dswl dswlcrack dtwlcrack dyj easyExpress efspost ekm electronorder ems emscrack epost eps etong ewe expeditors fast fastcrack fcbox fedex fedexcrack fedexnew fedexzg fgyzcrack flyzcrack fnwlcrack fq ftcrack ftd ftdcrack fwx fzgj fzgjcrack gtky gto gtsd guangfaadapter hbkdcrack hdkdcrack hdwl hhtt hhttcrack hisensecrack hjwl hlwl hlysd hmj hmjcrack hoau hqkycrack hqsy hqsycrack hrwl hsll hssy htky htkycrack htkyky htwl huilin56 hwfyp hyh iadlyyzcrack jadcrack jcex jd jd3c jdcrack jdky jdwl jdzh jgsd jgwl jldt jp jpkd jrhywlcrack jswl jtsd jtsdc jyd jym jym2 jysd jywl kd100 kdn kdn17track kdn51tracking kdnet kdnkd100 kdy kfw khfd klop ksdwl kysy lb lhkds lht lhtnew lyt md mdsms mgkd myibcrack newgisticscrack newl nezha nsfcrack one7trackcrack onlinerecord padtf pdd pj polarexpress posten postnl pushtrack qfkd qfkdcrack qyhy qyzy rfdcrack rht rlcarriers rlgcrack rqcrack rrs rrscrack sad sasapush sbd sendcn sf sfcrack sfd sfgj sfjscrack sfnew sfoly sfoly2 sfoly3 sfoly4 sfoly5 sfoly6 sfoly7 sfoly8 sfsubscribe sfwl shjsd shldhy shwlcrack shyzcrack skynet sms snwl snwl_new spb sqwlcrack ss stcrack sto stocrack stooly stosubscribe stwl stwlcrack stwlnew sunshinecrack superb sure suyd56 swch swishipcrack sx syjhe synshipcrack tbzs test tester tjdgjwl tjexcrack tjs tjscrack tlwl tnt tntcrack trackmore txwlcrack tywl uapex uapexnew ubi ubonexcrack uc uccrack uluckex ups upscrack uspscrack vctrans vop web-home wjsd wjwlcrack wtp wx xcwlcrack xdexpress xfex xgyzcrack xhwlcrack xiaobi xkgj xlobo yad ybg ybgcrack ycwl ycwlcrack yd ydcrack ydcrackyj ydgj ydky ydkycrack ydlyzcrack ydroute yf yfhexcrack yfsd ygh ygyzcrack yhjl yhxgjsd yhxgjsdcrack yj yjd yl ylfwl ymdd YMSY ymsycrack ynztsy youcwl ysdf ytkd yto yto-crawler ytogj yundx ywwl ywwlcrack yxwl yysdcrack yzbk yzemsroute yzemssubscribe yzpy yzpycrack yzpycrackzdxt yzt yztsy zcy zeny zenycrack zhkd zhn zhwl zjs zjscrack zjsocrcrack zsky ztky zto zto3c zto8c ztocbatch ztocrack ztogj ztoky ztsycrack ztwl ztwlcrack zy_bmcrack zy_xiyj zyex zyfycrack zykd zykdcrack zyky zysfcrack zysfgj zyzoomcrack zzsy";
        String[] projects = proNames.split(" ");
        String directoryPath = "D:\\idea_workspace\\huangboke\\logisticsfront\\";
        String fileSuffix = "\\biz-service-impl\\src\\main\\resources\\META-INF\\spring\\biz-service-impl.xml";
        String searchString = "1007";

        for (String proj : projects) {
            String path = directoryPath + proj + fileSuffix;
            File file = new File(path);
            if (!file.exists()) {
                continue;
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                if (line.contains(searchString)) {
                    found = true;
                    // System.out.println(proj + " " + line);
                    System.out.println(proj + "->" + line.substring(Math.max(line.indexOf('-') - 5, 0)));
                    break;
                }
            }
            br.close();
        }
    }
}
