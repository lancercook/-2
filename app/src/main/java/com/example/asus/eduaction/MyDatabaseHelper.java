package com.example.asus.eduaction;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by asus on 2019/5/21.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_PROVINCE = "create table province("
            + "name text, "
            + "score81 integer, "
            + "score82 integer, "
            + "score71 integer, "
            + "score72 integer, "
            + "credit integer, "//1代表理科，2代表文科
            + "score61 integer, "
            + "score62 integer)";
    public static final String CREATE_COLLEGE = "create table college("
            + "school text, "
            + "province text, "
            + "score_first integer, "
            + "score_second integer, "
            + "score_third integer, "
            + "potion_first integer, "
            + "potion_second integer, "
            + "potion_third integer, "
            + "admit text)";
    public static final String CREATE_NORMAL = "create table normal("
            + "w_school text, "
            + "province text, "
            + "f_school text, "
            + "mbti text, "
            + "s_school text)";
    public static final String CREATE_MBTI = "create table mbti("
            + "type text, "
            + "hot1 text, "
            + "hot2 text, "
            + "hot3 text, "
            + "hot4 text, "
            + "hot5 text)";
    public static final String CREATE_HISTORY = "create table history("
            + "province text, "
            + "num integer, "
            + "credit text, "
            + "hot1 text, "
            + "hot2 text, "
            + "hot3 text, "
            + "hot4 text, "
            + "hot5 text)";
    private Context mContext;

    public MyDatabaseHelper(Context context, String name,
                            SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PROVINCE);
        db.execSQL(CREATE_COLLEGE);
        db.execSQL(CREATE_NORMAL);
        db.execSQL(CREATE_MBTI);
        db.execSQL(CREATE_HISTORY);
        init(db);
        initcol(db);
        initmbti(db);
        writenormal(db);
        inithistory(db);
        Toast.makeText(mContext,"Create succeeded",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    private void writenormal(SQLiteDatabase db){
        ContentValues values = new ContentValues();
        values.put("province", "");
        values.put("w_school", "");
        values.put("f_school", "");
        values.put("s_school", "");
        values.put("mbti", "暂无");
        db.insert("normal", null, values);
    }
    private void writembti(SQLiteDatabase db,String type,String hot1,String hot2,String hot3,String hot4,String hot5){
        ContentValues values = new ContentValues();
        values.put("type", type);
        values.put("hot1", hot1);
        values.put("hot2", hot2);
        values.put("hot3", hot3);
        values.put("hot4", hot4);
        values.put("hot5", hot5);
        db.insert("mbti", null, values);
    }
    private void writehistory(SQLiteDatabase db,String province,int num,String credit,String hot1,String hot2,String hot3,String hot4,String hot5){
        ContentValues values = new ContentValues();
        values.put("province", province);
        values.put("credit",credit);
        values.put("num",num);
        values.put("hot1", hot1);
        values.put("hot2", hot2);
        values.put("hot3", hot3);
        values.put("hot4", hot4);
        values.put("hot5", hot5);
        db.insert("history", null, values);
    }
    private void writeschool(SQLiteDatabase db,String school,String province,int first,int second,int third,int p1,int p2,int p3,String admit){
        ContentValues values = new ContentValues();
        values.put("school", school);
        values.put("province", province);
        values.put("score_first", first);
        values.put("score_second", second);
        values.put("score_third",third);
        values.put("potion_first", p1);
        values.put("potion_second", p2);
        values.put("potion_third",p3);
        values.put("admit",admit);
        db.insert("college", null, values);
    }
    private void writeprovince(SQLiteDatabase db,String name,int credit,int score81,int score82,int score71,int score72,int score61,int score62){
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("credit", credit);
        values.put("score81", score81);
        values.put("score82", score82);
        values.put("score71",score71);
        values.put("score72",score72);
        values.put("score61",score61);
        values.put("score62",score62);
        db.insert("province", null, values);
    }
    void init(SQLiteDatabase db){
        writeprovince(db,"吉林",1,533,405,507,379,530,402);
        writeprovince(db,"北京",1,532,432,537,439,548,494);
        writeprovince(db,"重庆",1,524,428,492,395,525,416);
        writeprovince(db,"河北",1,511,358,485,326,525,364);
        writeprovince(db,"山西",1,516,432,481,400,519,438);
        writeprovince(db,"辽宁",1,517,368,480,350,498,373);
        writeprovince(db,"黑龙江",1,472,353,455,335,486,369);
        writeprovince(db,"江苏",1,336,285,331,269,353,315);
        writeprovince(db,"浙江",1,588,490,577,480,600,439);
        writeprovince(db,"安徽",1,505,432,487,413,518,473);
        writeprovince(db,"江西",1,527,447,503,422,529,445);
        writeprovince(db,"福建",1,490,378,441,333,465,352);
        writeprovince(db,"河南",1,499,374,484,342,523,447);
        writeprovince(db,"湖北",1,512,375,484,345,512,350);
        writeprovince(db,"湖南",1,513,450,505,424,517,439);
        writeprovince(db,"四川",1,546,458,511,436,532,453);
        writeprovince(db,"陕西",1,474,425,449,397,470,423);
        writeprovince(db,"甘肃",1,483,436,460,408,490,435);
        writeprovince(db,"北京",2,576,488,555,468,583,532);
        writeprovince(db,"重庆",2,524,434,525,436,527,435);
        writeprovince(db,"河北",2,559,441,517,395,535,416);
        writeprovince(db,"山西",2,546,476,518,452,518,460);
        writeprovince(db,"辽宁",2,553,461,532,428,525,417);
        writeprovince(db,"吉林",2,542,432,528,412,531,413);
        writeprovince(db,"黑龙江",2,490,406,481,400,481,401);
        writeprovince(db,"江苏",2,337,281,333,281,355,325);
        writeprovince(db,"浙江",2,588,490,577,480,600,439);
        writeprovince(db,"安徽",2,550,486,515,440,521,482);
        writeprovince(db,"江西",2,568,496,533,458,523,450);
        writeprovince(db,"福建",2,551,446,489,380,501,403);
        writeprovince(db,"河南",2,547,436,516,389,517,458);
        writeprovince(db,"湖北",2,561,441,528,406,520,403);
        writeprovince(db,"湖南",2,569,526,548,485,530,476);
        writeprovince(db,"四川",2,553,492,537,470,540,480);
        writeprovince(db,"陕西",2,518,467,509,457,511,460);
        writeprovince(db,"甘肃",2,502,456,505,458,504,455);
    }
    void initcol(SQLiteDatabase db){
        writeschool(db,"福州大学","福建",550,544,570,1796,2155,1597,"文科");
        writeschool(db,"福州大学","福建",529,534,555,12184,14860,9895,"理科");
        writeschool(db,"中国海洋大学","山东",552,578,576,1715,998,1349,"文科");
        writeschool(db,"中国海洋大学","山东",558,590,578,8019,6422,6463,"理科");
        writeschool(db,"中国石油大学","山东",552,544,561,2631,2155,2038,"文科");
        writeschool(db,"中国石油大学","山东",570,567,548,10330,10578,11051,"理科");
        writeschool(db,"华中科技大学","湖北",0,0,0,0,0,0,"文科");
        writeschool(db,"华中科技大学","湖北",621,639,624,2036,1793,1987,"理科");
        writeschool(db,"武汉理工大学","湖北",530,551,565,2914,1816,1838,"文科");
        writeschool(db,"武汉理工大学","湖北",558,563,569,8019,10098,7707,"理科");
        writeschool(db,"华中师范大学","湖北",535,562,570,2582,1299,1597,"文科");
        writeschool(db,"华中师范大学","湖北",566,579,571,7027,7805,7434,"理科");
        writeschool(db,"中南财经政法大学","湖北",577,586,577,825,589,1312,"文科");
        writeschool(db,"中南财经政法大学","湖北",622,629,587,1982,2516,5368,"理科");
        writeschool(db,"中南大学","湖南",556,574,582,1527,902,1137,"文科");
        writeschool(db,"中南大学","湖南",572,608,586,6324,4388,5485,"理科");
        writeschool(db,"西安交通大学","陕西",570,587,591,1026,560,850,"文科");
        writeschool(db,"西安交通大学","陕西",636,649,638,1229,1186,1220,"理科");
        writeschool(db,"西北工业大学","陕西",557,558,574,1492,1468,1424,"文科");
        writeschool(db,"西北工业大学","陕西",602,625,607,3395,2828,3262,"理科");
        writeschool(db,"西安电子科技大学","陕西",0,0,0,0,0,0,"文科");
        writeschool(db,"西安电子科技大学","陕西",582,589,576,5236,6541,6736,"理科");
        writeschool(db,"北京理工大学","北京",588,573,590,565,929,887,"文科");
        writeschool(db,"北京理工大学","北京",624,645,635,1858,1399,1347,"理科");
        writeschool(db,"北京邮电大学","北京",0,0,0,0,0,0,"文科");
        writeschool(db,"北京邮电大学","北京",619,639,617,2167,1793,2495,"理科");
        writeschool(db,"中国政法大学","北京",598,585,611,384,614,383,"文科");
        writeschool(db,"中国政法大学","北京",614,636,625,2481,1990,1925,"理科");
        writeschool(db,"华北电力大学","北京",558,560,566,1461,1384,1788,"文科");
        writeschool(db,"华北电力大学","北京",539,586,589,10683,6922,5113,"理科");
        writeschool(db,"对外经济贸易大学","北京",599,533,627,368,2806,172,"文科");//shanchu
        writeschool(db,"对外经济贸易大学","北京",642,651,640,977,1097,1136,"理科");
        writeschool(db,"北京外国语大学","北京",615,588,610,176,540,403,"文科");
        writeschool(db,"北京外国语大学","北京",638,639,637,1138,1793,1260,"理科");
        writeschool(db,"吉林大学","吉林",561,559,574,1328,1430,1424,"文科");
        writeschool(db,"吉林大学","吉林",590,584,589,5423,4929,5238,"理科");
        writeschool(db,"哈尔滨工业大学","黑龙江",566,569,580,1159,1065,1205,"文科");
        writeschool(db,"哈尔滨工业大学","黑龙江",620,630,619,2097,2428,2331,"理科");
        writeschool(db,"太原理工大学","山西",0,0,0,0,0,0,"文科");
        writeschool(db,"太原理工大学","山西",515,533,526,14548,15056,15126,"理科");
        writeschool(db,"大连海事大学","辽宁",582,573,577,705,929,1312,"文科");
        writeschool(db,"大连海事大学","辽宁",605,618,610,3152,3403,3037,"理科");
        writeschool(db,"中国科技大学","安徽",0,0,0,0,0,0,"文科");
        writeschool(db,"中国科技大学","安徽",660,670,661,428,405,441,"理科");
        writeschool(db,"合肥工业大学","安徽",0,0,0,0,0,0,"文科");
        writeschool(db,"合肥工业大学","安徽",507,531,525,16012,15418,15332,"理科");
        writeschool(db,"大连理工大学","辽宁",530,561,575,2914,1335,1385,"文科");
        writeschool(db,"大连理工大学","辽宁",594,619,596,4090,3319,4329,"理科");
        writeschool(db,"武汉大学","湖北",599,597,610,368,368,403,"文科");
        writeschool(db,"武汉大学","湖北",632,642,627,1424,1603,1791,"理科");
        writeschool(db,"中北大学","山西",532,534,542,2769,2743,3177,"文科");
        writeschool(db,"中北大学","山西",517,540,531,14179,13812,14140,"理科");
        writeschool(db,"哈尔滨理工大学","黑龙江",493,485,510,5697,6667,5679,"文科");
        writeschool(db,"哈尔滨理工大学","黑龙江",525,547,552,12830,12623,10384,"理科");
        writeschool(db,"南京大学","江苏",582,573,577,705,929,1312,"文科");
        writeschool(db,"南京大学","江苏",605,618,610,3152,3403,3037,"理科");
        writeschool(db,"北京大学","北京",670,692,680,234,150,118,"理科");
        writeschool(db,"北京大学","北京",640,635,650,46,44,35,"文科");
        writeschool(db,"重庆大学","重庆",565,605,595,7141,4671,4457,"理科");
        writeschool(db,"重庆大学","重庆",570,571,587,1026,998,973,"文科");
        writeschool(db,"华北电力大学","河北",551,572,525,8998,8775,15332,"理科");
        writeschool(db,"华北电力大学","河北",540,535,565,2298,2672,1838,"文科");
        writeschool(db,"浙江大学","浙江",668,676,667,271,216,315,"理科");
        writeschool(db,"浙江大学","浙江",618,617,620,146,140,149,"文科");
        writeschool(db,"安徽大学","安徽",542,543,530,10245,13309,14320,"理科");
        writeschool(db,"安徽大学","安徽",547,531,560,1961,2953,2077,"文科");
        writeschool(db,"厦门大学","福建",625,647,628,1797,1293,1735,"理科");
        writeschool(db,"厦门大学","福建",602,597,600,327,368,612,"文科");
        writeschool(db,"南昌大学","江西",524,565,550,13010,9784,10714,"理科");
        writeschool(db,"南昌大学","江西",531,554,550,2914,1664,2694,"文科");
        writeschool(db,"山东大学","山东",594,615,600,4090,4671,3918,"理科");
        writeschool(db,"山东大学","山东",542,578,578,2185,790,1269,"文科");
        writeschool(db,"郑州大学","河南",540,564,555,10551,9929,9895,"理科");
        writeschool(db,"郑州大学","河南",550,552,570,1796,1772,1597,"文科");
        writeschool(db,"湖南大学","湖南",605,596,576,3152,5661,6463,"理科");
        writeschool(db,"湖南大学","湖南",587,574,592,893,902,1137,"文科");
        writeschool(db,"四川大学","四川",602,614,594,3395,3780,4566,"理科");
        writeschool(db,"四川大学","四川",582,583,592,705,663,822,"文科");
        writeschool(db,"西北大学","陕西",549,557,552,9294,11035,10384,"理科");
        writeschool(db,"西北大学","陕西",551,548,567,1785,1961,1747,"文科");
        writeschool(db,"兰州大学","甘肃",586,586,575,4852,6922,6888,"理科");
        writeschool(db,"兰州大学","甘肃",559,559,572,1410,1430,1505,"文科");
        writeschool(db,"清华大学","北京",689,690,690,47,50,40,"理科");
        writeschool(db,"清华大学","北京",670,666,657,13,17,23,"文科");
        writeschool(db,"中国人民大学","北京",621,678,651,2036,216,723,"理科");
        writeschool(db,"中国人民大学","北京",621,612,633,125,173,120,"文科");
        writeschool(db,"北京航空航天大学","北京",665,634,648,331,2123,823,"理科");
        writeschool(db,"北京航空航天大学","北京",591,598,610,504,342,403,"文科");
        writeschool(db,"复旦大学","上海",671,686,685,221,95,70,"理科");
        writeschool(db,"复旦大学","上海",639,626,636,46,84,96,"文科");
        writeschool(db,"同济大学","上海",646,658,653,834,796,663,"理科");
        writeschool(db,"同济大学","上海",601,601,653,341,287,35,"文科");
        writeschool(db,"南开大学","天津",637,651,644,1182,1097,974,"理科");
        writeschool(db,"南开大学","天津",630,610,612,78,188,370,"文科");
        writeschool(db,"东北师范大学","吉林",549,583,559,9294,7288,9238,"理科");
        writeschool(db,"东北师范大学","吉林",541,582,577,2243,682,1312,"文科");
        writeschool(db,"延边大学","吉林",396,407,410,41348,45729,44713,"理科");
        writeschool(db,"延边大学","吉林",421,430,441,13144,12764,13736,"文科");
        writeschool(db,"电子科技大学","四川",609,614,620,2854,3780,2260,"理科");
        writeschool(db,"电子科技大学","四川",0,0,0,0,0,0,"文科");
    }
    void initmbti(SQLiteDatabase db){
        writembti(db,"ISTJ","金融学","医学","土木工程学","会计学","地质学");
        writembti(db,"ISFJ","金融学","医学","社会学","历史学","心理学");
        writembti(db,"INFJ","艺术系","传媒类","护理学","城市规划类","心理学");
        writembti(db,"INTJ","经济金融类","商务管理类","数学","生物化学","城市规划");
        writembti(db,"ISTP","经济金融类","法学","数学","生物学","哲学");
        writembti(db,"ISFP","社会法学","艺术类","小语种类","护理学","哲学");
        writembti(db,"INFP","管理学","医药科学","音乐类","小语种","历史学");
        writembti(db,"INTP","计算机类","经济金融类","化学","物理学","历史学");
        writembti(db,"ESTP","计算机类","医药科学","艺术类","生物学","环境科学");
        writembti(db,"ESFP","社会科学","护理学","生物学","病理学","语言科学");
        writembti(db,"ENFP","化学","教育类","英语","艺术类","市场学");
        writembti(db,"ENTP","计算机类","经济学","机械类","市场学","历史类");
        writembti(db,"ESTJ","机械类","经济类","会计学","音乐类","政治");
        writembti(db,"ESFJ","教育类","护理学","语言科学","市场类","心理学");
        writembti(db,"ENFJ","管理学","英语","市场学","心理学","城市规划");
        writembti(db,"ENTJ","经济学","管理类","商务类","政治类","教育类");
    }
    void inithistory(SQLiteDatabase db){
        writehistory(db,"黑龙江",612,"理科","吉林大学","哈尔滨工业大学","华中科技大学","","");
        writehistory(db,"吉林",594,"理科","吉林大学","太原理工大学","大连海事大学","","");
        writehistory(db,"湖北",595,"理科","吉林大学","华中科技大学","武汉理工大学","武汉科技大学","华东师范大学");
        writehistory(db,"安徽",639,"理科","吉林大学","中国科技大学","合肥工业大学","","");
        writehistory(db,"安徽",636,"理科","吉林大学","中国海洋大学","合肥工业大学","","");
        writehistory(db,"河南",610,"理科","吉林大学","大连理工大学","武汉大学","","");
        writehistory(db,"山东",595,"理科","中北大学","哈尔滨理工大学","昆明理工大学","","");
        writehistory(db,"江苏",373,"理科","吉林大学","南京大学","河海大学","","");
        writehistory(db,"河南",609,"理科","吉林大学","东北大学","中国海洋大学","","");
        writehistory(db,"山东",544,"理科","曲阜师范大学","青岛科技大学","山东师范大学","","");
        writehistory(db,"天津",615,"理科","吉林大学","西北工业大学","西安电子科技大学","","");
        writehistory(db,"湖北",592,"理科","吉林大学","暨南大学","西安电子大学","","");
        writehistory(db,"重庆",641,"理科","吉林大学","四川大学","电子科技大学","","");
        writehistory(db,"山东",641,"理科","华中科技大学","西北工业大学","电子科技大学","","");
        writehistory(db,"山东",560,"文科","四川大学","兰州大学","郑州大学","","");
        writehistory(db,"山东",698,"理科","复旦大学","北京大学","北京理工大学","","");
        writehistory(db,"山东",641,"理科","山东大学","南京大学","四川大学","","");
        writehistory(db,"山东",659,"理科","南开大学","同济大学","厦门大学","","");
        writehistory(db,"山东",610,"理科","中南大学","西安交通大学","山东大学","","");
        writehistory(db,"福建",541,"理科","中南大学","福州大学","安徽大学","","");
        writehistory(db,"天津",641,"理科","南开大学","北京理工大学","北京邮电大学","","");
        writehistory(db,"山东",560,"理科","中国海洋大学","山东大学","中国海洋大学","","");
        writehistory(db,"山东",641,"理科","华中科技大学","西北工业大学","电子科技大学","","");
        writehistory(db,"吉林",560,"文科","东北师范大学","郑州大学","延边大学","","");
        writehistory(db,"山东",698,"理科","清华大学","浙江大学","厦门大学","","");
        writehistory(db,"山东",641,"理科","山东大学","重庆大学","四川大学","","");
        writehistory(db,"山东",659,"理科","北京航空航天大学","南开大学","中国人民大学","","");
        writehistory(db,"山东",610,"理科","中南大学","西安交通大学","山东大学","","");
        writehistory(db,"陕西",541,"理科","太原理工大学","合肥工业大学","哈尔滨理工大学","","");
        writehistory(db,"天津",641,"理科","南开大学","北京理工大学","北京邮电大学","","");
        writehistory(db,"山东",560,"理科","东北师范大学","华北电力大学","中北大学","","");
        writehistory(db,"甘肃",563,"理科","西北工业大学","重庆大学","兰州大学","","");
        writehistory(db,"甘肃",563,"理科","西北大学","西北工业大学","太原理工大学","","");
        writehistory(db,"江西",575,"理科","南昌大学","大连理工大学","安徽大学","","");
        writehistory(db,"北京",623,"理科","中国政法大学","对外经济贸易大学","北京外国语大学","","");
        writehistory(db,"黑龙江",612,"理科","吉林大学","哈尔滨工业大学","华中科技大学","","");
        writehistory(db,"吉林",594,"理科","吉林大学","太原理工大学","大连海事大学","","");
        writehistory(db,"湖北",595,"理科","吉林大学","华中科技大学","武汉理工大学","武汉科技大学","华东师范大学");
        writehistory(db,"安徽",639,"理科","吉林大学","中国科技大学","合肥工业大学","","");
        writehistory(db,"安徽",636,"理科","吉林大学","中国海洋大学","合肥工业大学","","");
        writehistory(db,"河南",610,"理科","吉林大学","大连理工大学","武汉大学","","");
        writehistory(db,"山东",595,"理科","中北大学","哈尔滨理工大学","昆明理工大学","","");
        writehistory(db,"江苏",373,"理科","吉林大学","南京大学","河海大学","","");
        writehistory(db,"河南",609,"理科","吉林大学","东北大学","中国海洋大学","","");
        writehistory(db,"山东",544,"理科","曲阜师范大学","青岛科技大学","山东师范大学","","");
        writehistory(db,"天津",615,"理科","吉林大学","西北工业大学","西安电子科技大学","","");
        writehistory(db,"湖北",592,"理科","吉林大学","暨南大学","西安电子大学","","");
        writehistory(db,"重庆",641,"理科","吉林大学","四川大学","电子科技大学","","");
        writehistory(db,"山东",641,"理科","华中科技大学","西北工业大学","电子科技大学","","");
        writehistory(db,"山东",560,"文科","四川大学","兰州大学","郑州大学","","");
        writehistory(db,"山东",698,"理科","复旦大学","北京大学","北京理工大学","","");
        writehistory(db,"山东",641,"理科","山东大学","南京大学","四川大学","","");
        writehistory(db,"山东",659,"理科","南开大学","同济大学","厦门大学","","");
        writehistory(db,"山东",610,"理科","中南大学","西安交通大学","山东大学","","");
        writehistory(db,"福建",541,"理科","中南大学","福州大学","安徽大学","","");
        writehistory(db,"天津",641,"理科","南开大学","北京理工大学","北京邮电大学","","");
        writehistory(db,"山东",560,"理科","中国海洋大学","山东大学","中国海洋大学","","");
        writehistory(db,"山东",641,"理科","华中科技大学","西北工业大学","电子科技大学","","");
        writehistory(db,"吉林",560,"文科","东北师范大学","郑州大学","延边大学","","");
        writehistory(db,"山东",698,"理科","清华大学","浙江大学","厦门大学","","");
        writehistory(db,"山东",641,"理科","山东大学","重庆大学","四川大学","","");
        writehistory(db,"山东",659,"理科","北京航空航天大学","南开大学","中国人民大学","","");
        writehistory(db,"山东",610,"理科","中南大学","西安交通大学","山东大学","","");
        writehistory(db,"陕西",541,"理科","太原理工大学","合肥工业大学","哈尔滨理工大学","","");
        writehistory(db,"天津",641,"理科","南开大学","北京理工大学","北京邮电大学","","");
        writehistory(db,"山东",560,"理科","东北师范大学","华北电力大学","中北大学","","");
        writehistory(db,"甘肃",563,"理科","西北工业大学","重庆大学","兰州大学","","");
        writehistory(db,"甘肃",563,"理科","西北大学","西北工业大学","太原理工大学","","");
        writehistory(db,"江西",575,"理科","南昌大学","大连理工大学","安徽大学","","");
        writehistory(db,"黑龙江",612,"理科","吉林大学","哈尔滨工业大学","华中科技大学","","");
        writehistory(db,"吉林",594,"理科","吉林大学","太原理工大学","大连海事大学","","");
        writehistory(db,"湖北",595,"理科","吉林大学","华中科技大学","武汉理工大学","武汉科技大学","华东师范大学");
        writehistory(db,"安徽",639,"理科","吉林大学","中国科技大学","合肥工业大学","","");
        writehistory(db,"安徽",636,"理科","吉林大学","中国海洋大学","合肥工业大学","","");
        writehistory(db,"河南",610,"理科","吉林大学","大连理工大学","武汉大学","","");
        writehistory(db,"山东",595,"理科","中北大学","哈尔滨理工大学","昆明理工大学","","");
        writehistory(db,"江苏",373,"理科","吉林大学","南京大学","河海大学","","");
        writehistory(db,"河南",609,"理科","吉林大学","东北大学","中国海洋大学","","");
        writehistory(db,"山东",544,"理科","曲阜师范大学","青岛科技大学","山东师范大学","","");
        writehistory(db,"天津",615,"理科","吉林大学","西北工业大学","西安电子科技大学","","");
        writehistory(db,"湖北",592,"理科","吉林大学","暨南大学","西安电子大学","","");
        writehistory(db,"重庆",641,"理科","吉林大学","四川大学","电子科技大学","","");
        writehistory(db,"山东",641,"理科","华中科技大学","西北工业大学","电子科技大学","","");
        writehistory(db,"山东",560,"文科","四川大学","兰州大学","郑州大学","","");
        writehistory(db,"山东",698,"理科","复旦大学","北京大学","北京理工大学","","");
        writehistory(db,"山东",641,"理科","山东大学","南京大学","四川大学","","");
        writehistory(db,"山东",659,"理科","南开大学","同济大学","厦门大学","","");
        writehistory(db,"山东",610,"理科","中南大学","西安交通大学","山东大学","","");
        writehistory(db,"福建",541,"理科","中南大学","福州大学","安徽大学","","");
        writehistory(db,"天津",641,"理科","南开大学","北京理工大学","北京邮电大学","","");
        writehistory(db,"山东",560,"理科","中国海洋大学","山东大学","中国海洋大学","","");
        writehistory(db,"山东",641,"理科","华中科技大学","西北工业大学","电子科技大学","","");
        writehistory(db,"吉林",560,"文科","东北师范大学","郑州大学","延边大学","","");
        writehistory(db,"山东",698,"理科","清华大学","浙江大学","厦门大学","","");
        writehistory(db,"山东",641,"理科","山东大学","重庆大学","四川大学","","");
        writehistory(db,"山东",659,"理科","北京航空航天大学","南开大学","中国人民大学","","");
        writehistory(db,"山东",610,"理科","中南大学","西安交通大学","山东大学","","");
        writehistory(db,"陕西",541,"理科","太原理工大学","合肥工业大学","哈尔滨理工大学","","");
        writehistory(db,"天津",641,"理科","南开大学","北京理工大学","北京邮电大学","","");
        writehistory(db,"山东",560,"理科","东北师范大学","华北电力大学","中北大学","","");
        writehistory(db,"甘肃",563,"理科","西北工业大学","重庆大学","兰州大学","","");
        writehistory(db,"甘肃",563,"理科","西北大学","西北工业大学","太原理工大学","","");
        writehistory(db,"江西",575,"理科","南昌大学","大连理工大学","安徽大学","","");
        writehistory(db,"北京",623,"理科","中国政法大学","对外经济贸易大学","北京外国语大学","","");
        writehistory(db,"北京",623,"理科","中国政法大学","对外经济贸易大学","北京外国语大学","","");
    }
}

