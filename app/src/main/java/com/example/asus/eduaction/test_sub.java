package com.example.asus.eduaction;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class test_sub extends AppCompatActivity {
    RadioGroup a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,a18,a19,a20,a21,a22,a23,a24,a25,a26,a27,a28,a29;
    RadioGroup a30,a31,a32,a33,a34,a35,a36,a37,a38,a39,a40,a41,a42,a43,a44,a45,a46,a47,a48,a49,a50,a51,a52,a53,a54,a55,a56,a57,a58,a59;
    RadioGroup a60,a61,a62,a63,a64,a65,a66,a67,a68,a69,a70,a71,a72,a73,a74,a75,a76,a77,a78,a79,a80,a81,a82,a83,a84,a85,a86,a87,a88,a89,a90,a91,a92,a93;
    RadioButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
    RadioButton b10,b11,b12,b13,b14,b15,b16,b17,b18,b19;
    RadioButton b20,b21,b22,b23,b24,b25,b26,b27,b28,b29;
    RadioButton b30,b31,b32,b33,b34,b35,b36,b37,b38,b39;
    RadioButton b40,b41,b42,b43,b44,b45,b46,b47,b48,b49;
    RadioButton b50,b51,b52,b53,b54,b55,b56,b57,b58,b59;
    RadioButton b60,b61,b62,b63,b64,b65,b66,b67,b68,b69;
    RadioButton b70,b71,b72,b73,b74,b75,b76,b77,b78,b79;
    RadioButton b80,b81,b82,b83,b84,b85,b86,b87,b88,b89;
    RadioButton b90,b91,b92,b93,b94,b95,b96,b97,b98,b99;
    RadioButton b100,b101,b102,b103,b104,b105,b106,b107,b108,b109;
    RadioButton b110,b111,b112,b113,b114,b115,b116,b117,b118,b119;
    RadioButton b120,b121,b122,b123,b124,b125,b126,b127,b128,b129;
    RadioButton b130,b131,b132,b133,b134,b135,b136,b137,b138,b139;
    RadioButton b140,b141,b142,b143,b144,b145,b146,b147,b148,b149;
    RadioButton b150,b151,b152,b153,b154,b155,b156,b157,b158,b159;
    RadioButton b160,b161,b162,b163,b164,b165,b166,b167,b168,b169;
    RadioButton b170,b171,b172,b173,b174,b175,b176,b177,b178,b179;
    RadioButton b180,b181,b182,b183,b184,b185,b186;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_sub);
        init();
        button=(Button)findViewById(R.id.button);
        final AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int NACK=0;
                int judge=0,perceive=0,thinking=0,feeling=0,sensing=0,intuition=0,extroversion=0,introversion=0;
                switch (a1.getCheckedRadioButtonId()){
                    case R.id.radioButton1:judge++;break;
                    case R.id.radioButton2:perceive++;break;
                    default:NACK++;
                }
                switch (a2.getCheckedRadioButtonId()){
                    case R.id.radioButton3:sensing++;break;
                    case R.id.radioButton4:intuition++;break;
                    default:NACK++;
                }
                switch (a3.getCheckedRadioButtonId()){
                    case R.id.radioButton5:extroversion++;break;
                    case R.id.radioButton6:introversion++;break;
                    default:NACK++;
                }
                switch (a4.getCheckedRadioButtonId()){
                    case R.id.radioButton7:judge++;break;
                    case R.id.radioButton8:perceive++;break;
                    default:NACK++;
                }
                switch (a5.getCheckedRadioButtonId()){
                    case R.id.radioButton9:intuition++;break;
                    case R.id.radioButton10:sensing++;break;
                    default:NACK++;
                }
                switch (a6.getCheckedRadioButtonId()){
                    case R.id.radioButton11:feeling++;break;
                    case R.id.radioButton12:thinking++;break;
                    default:NACK++;
                }
                switch (a7.getCheckedRadioButtonId()){
                    case R.id.radioButton13:extroversion++;break;
                    case R.id.radioButton14:introversion++;break;
                    default:NACK++;
                }
                switch (a8.getCheckedRadioButtonId()){
                    case R.id.radioButton15:perceive++;break;
                    case R.id.radioButton16:judge++;break;
                    default:NACK++;;
                }
                switch (a9.getCheckedRadioButtonId()){
                    case R.id.radioButton17:sensing++;break;
                    case R.id.radioButton18:intuition++;break;
                    default:NACK++;
                }
                switch (a10.getCheckedRadioButtonId()){
                    case R.id.radioButton19:extroversion++;break;
                    case R.id.radioButton20:introversion++;break;
                    default:NACK++;
                }
                switch (a11.getCheckedRadioButtonId()){
                    case R.id.radioButton21:intuition++;break;
                    case R.id.radioButton22:sensing++;break;
                    default:NACK++;
                }
                switch (a12.getCheckedRadioButtonId()){
                    case R.id.radioButton23:judge++;break;
                    case R.id.radioButton24:perceive++;break;
                    default:NACK++;
                }
                switch (a13.getCheckedRadioButtonId()){
                    case R.id.radioButton25:introversion++;break;
                    case R.id.radioButton26:extroversion++;break;
                    default:NACK++;
                }
                switch (a14.getCheckedRadioButtonId()){
                    case R.id.radioButton27:judge++;break;
                    case R.id.radioButton28:perceive++;break;
                    default:NACK++;
                }
                switch (a15.getCheckedRadioButtonId()){
                    case R.id.radioButton29:feeling++;break;
                    case R.id.radioButton30:thinking++;break;
                    default:NACK++;
                }
                switch (a16.getCheckedRadioButtonId()){
                    case R.id.radioButton31:introversion++;break;
                    case R.id.radioButton32:extroversion++;break;
                    default:NACK++;
                }
                switch (a17.getCheckedRadioButtonId()){
                    case R.id.radioButton33:perceive++;break;
                    case R.id.radioButton34:judge++;break;
                    default:NACK++;
                }
                switch (a18.getCheckedRadioButtonId()){
                    case R.id.radioButton35:intuition++;break;
                    case R.id.radioButton36:sensing++;break;
                    default:NACK++;
                }
                switch (a19.getCheckedRadioButtonId()){
                    case R.id.radioButton37:extroversion++;break;
                    case R.id.radioButton38:introversion++;break;
                    default:NACK++;
                }
                switch (a20.getCheckedRadioButtonId()){
                    case R.id.radioButton39:judge++;;break;
                    case R.id.radioButton40:perceive++;break;
                    default:NACK++;
                }
                switch (a21.getCheckedRadioButtonId()){
                    case R.id.radioButton41:feeling++;break;
                    case R.id.radioButton42:thinking++;break;
                    default:NACK++;
                }
                switch (a22.getCheckedRadioButtonId()){
                    case R.id.radioButton43:intuition++;break;
                    case R.id.radioButton44:sensing++;break;
                    default:NACK++;
                }
                switch (a23.getCheckedRadioButtonId()){
                    case R.id.radioButton45:extroversion++;break;
                    case R.id.radioButton46:introversion++;break;
                    default:NACK++;
                }
                switch (a24.getCheckedRadioButtonId()){
                    case R.id.radioButton47:perceive++;break;
                    case R.id.radioButton48:judge++;break;
                    default:NACK++;
                }
                switch (a25.getCheckedRadioButtonId()){
                    case R.id.radioButton49:sensing++;break;
                    case R.id.radioButton50:intuition++;break;
                    default:NACK++;
                }
                switch (a26.getCheckedRadioButtonId()){
                    case R.id.radioButton51:introversion++;break;
                    case R.id.radioButton52:extroversion++;break;
                    default:NACK++;
                }
                switch (a27.getCheckedRadioButtonId()){
                    case R.id.radioButton53:intuition++;break;
                    case R.id.radioButton54:sensing++;break;
                    default:NACK++;
                }
                switch (a28.getCheckedRadioButtonId()){
                    case R.id.radioButton55:judge++;break;
                    case R.id.radioButton56:perceive++;break;
                    default:NACK++;
                }
                switch (a29.getCheckedRadioButtonId()){
                    case R.id.radioButton57:feeling++;break;
                    case R.id.radioButton58:thinking++;break;
                    default:NACK++;
                }
                switch (a30.getCheckedRadioButtonId()){
                    case R.id.radioButton59:sensing++;break;
                    case R.id.radioButton60:intuition++;break;
                    default:NACK++;
                }
                switch (a31.getCheckedRadioButtonId()){
                    case R.id.radioButton61:thinking++;break;
                    case R.id.radioButton62:feeling++;break;
                    default:NACK++;
                }
                switch (a32.getCheckedRadioButtonId()){
                    case R.id.radioButton63:extroversion++;break;
                    case R.id.radioButton64:introversion++;break;
                    default:NACK++;
                }
                switch (a33.getCheckedRadioButtonId()){
                    case R.id.radioButton65:thinking++;break;
                    case R.id.radioButton66:feeling++;break;
                    default:NACK++;
                }
                switch (a34.getCheckedRadioButtonId()){
                    case R.id.radioButton67:sensing++;break;
                    case R.id.radioButton68:intuition++;break;
                    default:NACK++;
                }
                switch (a35.getCheckedRadioButtonId()){
                    case R.id.radioButton69:thinking++;break;
                    case R.id.radioButton70:feeling++;break;
                    default:NACK++;
                }
                switch (a36.getCheckedRadioButtonId()){
                    case R.id.radioButton71:judge++;break;
                    case R.id.radioButton72:perceive++;break;
                    default:NACK++;
                }
                switch (a37.getCheckedRadioButtonId()){
                    case R.id.radioButton73:feeling++;break;
                    case R.id.radioButton74:thinking++;break;
                    default:NACK++;
                }
                switch (a38.getCheckedRadioButtonId()){
                    case R.id.radioButton75:introversion++;break;
                    case R.id.radioButton76:extroversion++;break;
                    default:NACK++;
                }
                switch (a39.getCheckedRadioButtonId()){
                    case R.id.radioButton77:sensing++;break;
                    case R.id.radioButton78:intuition++;break;
                    default:NACK++;
                }
                switch (a40.getCheckedRadioButtonId()){
                    case R.id.radioButton79:feeling++;break;
                    case R.id.radioButton80:thinking++;break;
                    default:NACK++;
                }
                switch (a41.getCheckedRadioButtonId()){
                    case R.id.radioButton81:judge++;break;
                    case R.id.radioButton82:perceive++;break;
                    default:NACK++;
                }
                switch (a42.getCheckedRadioButtonId()){
                    case R.id.radioButton83:introversion++;break;
                    case R.id.radioButton84:extroversion++;break;
                    default:NACK++;
                }
                switch (a43.getCheckedRadioButtonId()){
                    case R.id.radioButton85:thinking++;break;
                    case R.id.radioButton86:feeling++;break;
                    default:NACK++;
                }
                switch (a44.getCheckedRadioButtonId()){
                    case R.id.radioButton87:intuition++;break;
                    case R.id.radioButton88:sensing++;break;
                    default:NACK++;
                }
                switch (a45.getCheckedRadioButtonId()){
                    case R.id.radioButton89:thinking++;break;
                    case R.id.radioButton90:feeling++;break;
                    default:NACK++;
                }
                switch (a46.getCheckedRadioButtonId()){
                    case R.id.radioButton91:intuition++;break;
                    case R.id.radioButton92:sensing++;break;
                    default:NACK++;
                }
                switch (a47.getCheckedRadioButtonId()){
                    case R.id.radioButton93:thinking++;break;
                    case R.id.radioButton94:feeling++;break;
                    default:NACK++;
                }
                switch (a48.getCheckedRadioButtonId()){
                    case R.id.radioButton95:intuition++;break;
                    case R.id.radioButton96:sensing++;break;
                    default:NACK++;
                }
                switch (a49.getCheckedRadioButtonId()){
                    case R.id.radioButton97:thinking++;break;
                    case R.id.radioButton98:feeling++;break;
                    default:NACK++;
                }
                switch (a50.getCheckedRadioButtonId()){
                    case R.id.radioButton99:sensing++;break;
                    case R.id.radioButton100:intuition++;break;
                    default:NACK++;
                }
                switch (a51.getCheckedRadioButtonId()){
                    case R.id.radioButton101:feeling++;break;
                    case R.id.radioButton102:thinking++;break;
                    default:NACK++;
                }
                switch (a52.getCheckedRadioButtonId()){
                    case R.id.radioButton103:sensing++;break;
                    case R.id.radioButton104:intuition++;break;
                    default:NACK++;
                }
                switch (a53.getCheckedRadioButtonId()){
                    case R.id.radioButton105:feeling++;break;
                    case R.id.radioButton106:thinking++;break;
                    default:NACK++;
                }
                switch (a54.getCheckedRadioButtonId()){
                    case R.id.radioButton107:sensing++;break;
                    case R.id.radioButton108:intuition++;break;
                    default:NACK++;
                }
                switch (a55.getCheckedRadioButtonId()){
                    case R.id.radioButton109:perceive++;break;
                    case R.id.radioButton110:judge++;break;
                    default:NACK++;
                }
                switch (a56.getCheckedRadioButtonId()){
                    case R.id.radioButton111:thinking++;break;
                    case R.id.radioButton112:feeling++;break;
                    default:NACK++;
                }
                switch (a57.getCheckedRadioButtonId()){
                    case R.id.radioButton113:introversion++;break;
                    case R.id.radioButton114:extroversion++;break;
                    default:NACK++;
                }
                switch (a58.getCheckedRadioButtonId()){
                    case R.id.radioButton115:thinking++;break;
                    case R.id.radioButton116:feeling++;break;
                    default:NACK++;
                }
                switch (a59.getCheckedRadioButtonId()){
                    case R.id.radioButton117:perceive++;break;
                    case R.id.radioButton118:judge++;break;
                    default:NACK++;
                }
                switch (a60.getCheckedRadioButtonId()){
                    case R.id.radioButton119:sensing++;break;
                    case R.id.radioButton120:intuition++;break;
                    default:NACK++;
                }
                switch (a61.getCheckedRadioButtonId()){
                    case R.id.radioButton121:thinking++;break;
                    case R.id.radioButton122:feeling++;break;
                    default:NACK++;
                }
                switch (a62.getCheckedRadioButtonId()){
                    case R.id.radioButton123:extroversion++;break;
                    case R.id.radioButton124:introversion++;break;
                    default:NACK++;
            }
                switch (a63.getCheckedRadioButtonId()){
                    case R.id.radioButton125:sensing++;break;
                    case R.id.radioButton126:intuition++;break;
                    default:NACK++;
                }
                switch (a64.getCheckedRadioButtonId()){
                    case R.id.radioButton127:judge++;break;
                    case R.id.radioButton128:perceive++;break;
                    default:NACK++;
                }
                switch (a65.getCheckedRadioButtonId()){
                    case R.id.radioButton129:intuition++;break;
                    case R.id.radioButton130:sensing++;break;
                    default:NACK++;
                }
                switch (a66.getCheckedRadioButtonId()){
                    case R.id.radioButton131:thinking++;break;
                    case R.id.radioButton132:feeling++;break;
                    default:NACK++;
                }
                switch (a67.getCheckedRadioButtonId()){
                    case R.id.radioButton133:intuition++;break;
                    case R.id.radioButton134:sensing++;break;
                    default:NACK++;
                }
                switch (a68.getCheckedRadioButtonId()){
                    case R.id.radioButton135:introversion++;break;
                    case R.id.radioButton136:extroversion++;break;
                    default:NACK++;
                }
                switch (a69.getCheckedRadioButtonId()){
                    case R.id.radioButton137:intuition++;break;
                    case R.id.radioButton138:sensing++;break;
                    default:NACK++;
                }
                switch (a70.getCheckedRadioButtonId()){
                    case R.id.radioButton139:feeling++;break;
                    case R.id.radioButton140:thinking++;break;
                    default:NACK++;
                }
                switch (a71.getCheckedRadioButtonId()){
                    case R.id.radioButton141:intuition++;break;
                    case R.id.radioButton142:sensing++;break;
                    default:NACK++;
                }
                switch (a72.getCheckedRadioButtonId()){
                    case R.id.radioButton143:feeling++;break;
                    case R.id.radioButton144:thinking++;break;
                    default:NACK++;
                }
                switch (a73.getCheckedRadioButtonId()){
                    case R.id.radioButton145:sensing++;break;
                    case R.id.radioButton146:intuition++;break;
                    default:NACK++;
                }
                switch (a74.getCheckedRadioButtonId()){
                    case R.id.radioButton147:extroversion++;break;
                    case R.id.radioButton148:introversion++;break;
                    default:NACK++;
                }
                switch (a75.getCheckedRadioButtonId()){
                    case R.id.radioButton149:thinking++;break;
                    case R.id.radioButton150:feeling++;break;
                    default:NACK++;
                }
                switch (a76.getCheckedRadioButtonId()){
                    case R.id.radioButton151:judge++;break;
                    case R.id.radioButton152:perceive++;break;
                    default:NACK++;
                }
                switch (a77.getCheckedRadioButtonId()){
                    case R.id.radioButton153:introversion++;break;
                    case R.id.radioButton154:extroversion++;break;
                    default:NACK++;
                }
                switch (a78.getCheckedRadioButtonId()){
                    case R.id.radioButton155:perceive++;break;
                    case R.id.radioButton156:judge++;break;
                    default:NACK++;
                }
                switch (a79.getCheckedRadioButtonId()){
                    case R.id.radioButton157:extroversion++;break;
                    case R.id.radioButton158:introversion++;break;
                    default:NACK++;
                }
                switch (a80.getCheckedRadioButtonId()){
                    case R.id.radioButton159:perceive++;break;
                    case R.id.radioButton160:judge++;break;
                    default:NACK++;
                }
                switch (a81.getCheckedRadioButtonId()){
                    case R.id.radioButton161:extroversion++;break;
                    case R.id.radioButton162:introversion++;break;
                    default:NACK++;
                }
                switch (a82.getCheckedRadioButtonId()){
                    case R.id.radioButton163:intuition++;break;
                    case R.id.radioButton164:sensing++;break;
                    default:NACK++;
                }
                switch (a83.getCheckedRadioButtonId()){
                    case R.id.radioButton165:extroversion++;break;
                    case R.id.radioButton166:introversion++;break;
                    default:NACK++;
                }
                switch (a84.getCheckedRadioButtonId()){
                    case R.id.radioButton167:perceive++;break;
                    case R.id.radioButton168:break;
                    default:NACK++;
                }
                switch (a85.getCheckedRadioButtonId()){
                    case R.id.radioButton169:introversion++;break;
                    case R.id.radioButton170:extroversion++;break;
                    default:NACK++;
                }
                switch (a86.getCheckedRadioButtonId()){
                    case R.id.radioButton171:judge++;break;
                    case R.id.radioButton172:perceive++;break;
                    default:NACK++;
                }
                switch (a87.getCheckedRadioButtonId()){
                    case R.id.radioButton173:thinking++;break;
                    case R.id.radioButton174:feeling++;break;
                    default:NACK++;
                }
                switch (a88.getCheckedRadioButtonId()){
                    case R.id.radioButton175:perceive++;break;
                    case R.id.radioButton176:judge++;break;
                    default:NACK++;
                }
                switch (a89.getCheckedRadioButtonId()){
                    case R.id.radioButton177:feeling++;break;
                    case R.id.radioButton178:thinking++;break;
                    default:NACK++;
                }
                switch (a90.getCheckedRadioButtonId()){
                    case R.id.radioButton179:perceive++;break;
                    case R.id.radioButton180:judge++;break;
                    default:NACK++;
                }
                switch (a91.getCheckedRadioButtonId()){
                    case R.id.radioButton181:introversion++;break;
                    case R.id.radioButton182:extroversion++;break;
                    default:NACK++;
                }
                switch (a92.getCheckedRadioButtonId()){
                    case R.id.radioButton183:sensing++;break;
                    case R.id.radioButton184:intuition++;break;
                    default:NACK++;
                }
                switch (a93.getCheckedRadioButtonId()){
                    case R.id.radioButton185:perceive++;break;
                    case R.id.radioButton186:judge++;break;
                    default:NACK++;
                }
                if(NACK!=0){
                    builder.setTitle("结果");
                    builder.setMessage("有未完成的题目");
                    AlertDialog alert=builder.create();
                    alert.show();
                }
                else {
                    String[] type = new String[4];
                    if ((perceive - judge) < 0) {
                        type[3] = "P";
                    } else {
                        type[3] = "J";
                    }
                    if ((sensing - intuition) < 0) {
                        type[1] = "S";
                    } else {
                        type[1] = "N";
                    }
                    if ((introversion - extroversion) < 0) {
                        type[0] = "I";
                    } else {
                        type[0] = "E";
                    }
                    if ((feeling - thinking) < 0) {
                        type[2] = "F";
                    } else {
                        type[2] = "T";
                    }
                    Intent intent = new Intent();
                    intent.setClass(test_sub.this, resultActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("DATA", type);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                }
               /* int compare=0;
                    if(Math.abs(perceive-judge)<6){
                           compare=(perceive-judge)/22*10;
                           if(compare>0)
                    }*/

               /* builder.setTitle("结果");
                builder.setMessage("p"+perceive+"j"+judge+"s"+sensing+"i"+intuition+"e"+extroversion+"i"+introversion+"f"+feeling+"t"+thinking);
                AlertDialog alert=builder.create();
                alert.show();*/

            }
        });
    }
    void init(){
        a1=(RadioGroup)findViewById(R.id.answer1);
        a2=(RadioGroup)findViewById(R.id.answer2);
        a3=(RadioGroup)findViewById(R.id.answer3);
        a4=(RadioGroup)findViewById(R.id.answer4);
        a5=(RadioGroup)findViewById(R.id.answer5);
        a6=(RadioGroup)findViewById(R.id.answer6);
        a7=(RadioGroup)findViewById(R.id.answer7);
        a8=(RadioGroup)findViewById(R.id.answer8);
        a9=(RadioGroup)findViewById(R.id.answer9);
        a10=(RadioGroup)findViewById(R.id.answer10);
        a11=(RadioGroup)findViewById(R.id.answer11);
        a12=(RadioGroup)findViewById(R.id.answer12);
        a13=(RadioGroup)findViewById(R.id.answer13);
        a14=(RadioGroup)findViewById(R.id.answer14);
        a15=(RadioGroup)findViewById(R.id.answer15);
        a16=(RadioGroup)findViewById(R.id.answer16);
        a17=(RadioGroup)findViewById(R.id.answer17);
        a18=(RadioGroup)findViewById(R.id.answer18);
        a19=(RadioGroup)findViewById(R.id.answer19);
        a20=(RadioGroup)findViewById(R.id.answer20);
        a21=(RadioGroup)findViewById(R.id.answer21);
        a22=(RadioGroup)findViewById(R.id.answer22);
        a23=(RadioGroup)findViewById(R.id.answer23);
        a24=(RadioGroup)findViewById(R.id.answer24);
        a25=(RadioGroup)findViewById(R.id.answer25);
        a26=(RadioGroup)findViewById(R.id.answer26);
        a27=(RadioGroup)findViewById(R.id.answer27);
        a28=(RadioGroup)findViewById(R.id.answer28);
        a29=(RadioGroup)findViewById(R.id.answer29);
        a30=(RadioGroup)findViewById(R.id.answer30);
        a31=(RadioGroup)findViewById(R.id.answer31);
        a32=(RadioGroup)findViewById(R.id.answer32);
        a33=(RadioGroup)findViewById(R.id.answer33);
        a34=(RadioGroup)findViewById(R.id.answer34);
        a35=(RadioGroup)findViewById(R.id.answer35);
        a36=(RadioGroup)findViewById(R.id.answer36);
        a37=(RadioGroup)findViewById(R.id.answer37);
        a38=(RadioGroup)findViewById(R.id.answer38);
        a39=(RadioGroup)findViewById(R.id.answer39);
        a40=(RadioGroup)findViewById(R.id.answer40);
        a41=(RadioGroup)findViewById(R.id.answer41);
        a42=(RadioGroup)findViewById(R.id.answer42);
        a43=(RadioGroup)findViewById(R.id.answer43);
        a44=(RadioGroup)findViewById(R.id.answer44);
        a45=(RadioGroup)findViewById(R.id.answer45);
        a46=(RadioGroup)findViewById(R.id.answer46);
        a47=(RadioGroup)findViewById(R.id.answer47);
        a48=(RadioGroup)findViewById(R.id.answer48);
        a49=(RadioGroup)findViewById(R.id.answer49);
        a50=(RadioGroup)findViewById(R.id.answer50);
        a51=(RadioGroup)findViewById(R.id.answer51);
        a52=(RadioGroup)findViewById(R.id.answer52);
        a53=(RadioGroup)findViewById(R.id.answer53);
        a54=(RadioGroup)findViewById(R.id.answer54);
        a55=(RadioGroup)findViewById(R.id.answer55);
        a56=(RadioGroup)findViewById(R.id.answer56);
        a57=(RadioGroup)findViewById(R.id.answer57);
        a58=(RadioGroup)findViewById(R.id.answer58);
        a59=(RadioGroup)findViewById(R.id.answer59);
        a60=(RadioGroup)findViewById(R.id.answer60);
        a61=(RadioGroup)findViewById(R.id.answer61);
        a62=(RadioGroup)findViewById(R.id.answer62);
        a63=(RadioGroup)findViewById(R.id.answer63);
        a64=(RadioGroup)findViewById(R.id.answer64);
        a65=(RadioGroup)findViewById(R.id.answer65);
        a66=(RadioGroup)findViewById(R.id.answer66);
        a67=(RadioGroup)findViewById(R.id.answer67);
        a68=(RadioGroup)findViewById(R.id.answer68);
        a69=(RadioGroup)findViewById(R.id.answer69);
        a70=(RadioGroup)findViewById(R.id.answer70);
        a71=(RadioGroup)findViewById(R.id.answer71);
        a72=(RadioGroup)findViewById(R.id.answer72);
        a73=(RadioGroup)findViewById(R.id.answer73);
        a74=(RadioGroup)findViewById(R.id.answer74);
        a75=(RadioGroup)findViewById(R.id.answer75);
        a76=(RadioGroup)findViewById(R.id.answer76);
        a77=(RadioGroup)findViewById(R.id.answer77);
        a78=(RadioGroup)findViewById(R.id.answer78);
        a79=(RadioGroup)findViewById(R.id.answer79);
        a80=(RadioGroup)findViewById(R.id.answer80);
        a81=(RadioGroup)findViewById(R.id.answer81);
        a82=(RadioGroup)findViewById(R.id.answer82);
        a83=(RadioGroup)findViewById(R.id.answer83);
        a84=(RadioGroup)findViewById(R.id.answer84);
        a85=(RadioGroup)findViewById(R.id.answer85);
        a86=(RadioGroup)findViewById(R.id.answer86);
        a87=(RadioGroup)findViewById(R.id.answer87);
        a88=(RadioGroup)findViewById(R.id.answer88);
        a89=(RadioGroup)findViewById(R.id.answer89);
        a90=(RadioGroup)findViewById(R.id.answer90);
        a91=(RadioGroup)findViewById(R.id.answer91);
        a92=(RadioGroup)findViewById(R.id.answer92);
        a93=(RadioGroup)findViewById(R.id.answer93);
        b1=(RadioButton)findViewById(R.id.radioButton1);
        b2=(RadioButton)findViewById(R.id.radioButton2);
        b3=(RadioButton)findViewById(R.id.radioButton3);
        b4=(RadioButton)findViewById(R.id.radioButton4);
        b5=(RadioButton)findViewById(R.id.radioButton5);
        b6=(RadioButton)findViewById(R.id.radioButton6);
        b7=(RadioButton)findViewById(R.id.radioButton7);
        b8=(RadioButton)findViewById(R.id.radioButton8);
        b9=(RadioButton)findViewById(R.id.radioButton9);
        b10=(RadioButton)findViewById(R.id.radioButton10);
        b11=(RadioButton)findViewById(R.id.radioButton11);
        b12=(RadioButton)findViewById(R.id.radioButton12);
        b13=(RadioButton)findViewById(R.id.radioButton13);
        b14=(RadioButton)findViewById(R.id.radioButton14);
        b15=(RadioButton)findViewById(R.id.radioButton15);
        b16=(RadioButton)findViewById(R.id.radioButton16);
        b17=(RadioButton)findViewById(R.id.radioButton17);
        b18=(RadioButton)findViewById(R.id.radioButton18);
        b19=(RadioButton)findViewById(R.id.radioButton19);
        b20=(RadioButton)findViewById(R.id.radioButton20);
        b21=(RadioButton)findViewById(R.id.radioButton21);
        b22=(RadioButton)findViewById(R.id.radioButton22);
        b23=(RadioButton)findViewById(R.id.radioButton23);
        b24=(RadioButton)findViewById(R.id.radioButton24);
        b25=(RadioButton)findViewById(R.id.radioButton25);
        b26=(RadioButton)findViewById(R.id.radioButton26);
        b27=(RadioButton)findViewById(R.id.radioButton27);
        b28=(RadioButton)findViewById(R.id.radioButton28);
        b29=(RadioButton)findViewById(R.id.radioButton29);
        b30=(RadioButton)findViewById(R.id.radioButton30);
        b31=(RadioButton)findViewById(R.id.radioButton31);
        b32=(RadioButton)findViewById(R.id.radioButton32);
        b33=(RadioButton)findViewById(R.id.radioButton33);
        b34=(RadioButton)findViewById(R.id.radioButton34);
        b35=(RadioButton)findViewById(R.id.radioButton35);
        b36=(RadioButton)findViewById(R.id.radioButton36);
        b37=(RadioButton)findViewById(R.id.radioButton37);
        b38=(RadioButton)findViewById(R.id.radioButton38);
        b39=(RadioButton)findViewById(R.id.radioButton39);
        b40=(RadioButton)findViewById(R.id.radioButton40);
        b41=(RadioButton)findViewById(R.id.radioButton41);
        b42=(RadioButton)findViewById(R.id.radioButton42);
        b43=(RadioButton)findViewById(R.id.radioButton43);
        b44=(RadioButton)findViewById(R.id.radioButton44);
        b45=(RadioButton)findViewById(R.id.radioButton45);
        b46=(RadioButton)findViewById(R.id.radioButton46);
        b47=(RadioButton)findViewById(R.id.radioButton47);
        b48=(RadioButton)findViewById(R.id.radioButton48);
        b49=(RadioButton)findViewById(R.id.radioButton49);
        b50=(RadioButton)findViewById(R.id.radioButton50);
        b51=(RadioButton)findViewById(R.id.radioButton51);
        b52=(RadioButton)findViewById(R.id.radioButton52);
        b53=(RadioButton)findViewById(R.id.radioButton53);
        b54=(RadioButton)findViewById(R.id.radioButton54);
        b55=(RadioButton)findViewById(R.id.radioButton55);
        b56=(RadioButton)findViewById(R.id.radioButton56);
        b57=(RadioButton)findViewById(R.id.radioButton57);
        b58=(RadioButton)findViewById(R.id.radioButton58);
        b59=(RadioButton)findViewById(R.id.radioButton59);
        b60=(RadioButton)findViewById(R.id.radioButton60);
        b61=(RadioButton)findViewById(R.id.radioButton61);
        b62=(RadioButton)findViewById(R.id.radioButton62);
        b63=(RadioButton)findViewById(R.id.radioButton63);
        b64=(RadioButton)findViewById(R.id.radioButton64);
        b65=(RadioButton)findViewById(R.id.radioButton65);
        b66=(RadioButton)findViewById(R.id.radioButton66);
        b67=(RadioButton)findViewById(R.id.radioButton67);
        b68=(RadioButton)findViewById(R.id.radioButton68);
        b69=(RadioButton)findViewById(R.id.radioButton69);
        b70=(RadioButton)findViewById(R.id.radioButton70);
        b71=(RadioButton)findViewById(R.id.radioButton71);
        b72=(RadioButton)findViewById(R.id.radioButton72);
        b73=(RadioButton)findViewById(R.id.radioButton73);
        b74=(RadioButton)findViewById(R.id.radioButton74);
        b75=(RadioButton)findViewById(R.id.radioButton75);
        b76=(RadioButton)findViewById(R.id.radioButton76);
        b77=(RadioButton)findViewById(R.id.radioButton77);
        b78=(RadioButton)findViewById(R.id.radioButton78);
        b79=(RadioButton)findViewById(R.id.radioButton79);
        b80=(RadioButton)findViewById(R.id.radioButton80);
        b81=(RadioButton)findViewById(R.id.radioButton81);
        b82=(RadioButton)findViewById(R.id.radioButton82);
        b83=(RadioButton)findViewById(R.id.radioButton83);
        b84=(RadioButton)findViewById(R.id.radioButton84);
        b85=(RadioButton)findViewById(R.id.radioButton85);
        b86=(RadioButton)findViewById(R.id.radioButton86);
        b87=(RadioButton)findViewById(R.id.radioButton87);
        b88=(RadioButton)findViewById(R.id.radioButton88);
        b89=(RadioButton)findViewById(R.id.radioButton89);
        b90=(RadioButton)findViewById(R.id.radioButton90);
        b91=(RadioButton)findViewById(R.id.radioButton91);
        b92=(RadioButton)findViewById(R.id.radioButton92);
        b93=(RadioButton)findViewById(R.id.radioButton93);
        b94=(RadioButton)findViewById(R.id.radioButton94);
        b95=(RadioButton)findViewById(R.id.radioButton95);
        b96=(RadioButton)findViewById(R.id.radioButton96);
        b97=(RadioButton)findViewById(R.id.radioButton97);
        b98=(RadioButton)findViewById(R.id.radioButton98);
        b99=(RadioButton)findViewById(R.id.radioButton99);
        b100=(RadioButton)findViewById(R.id.radioButton100);
        b101=(RadioButton)findViewById(R.id.radioButton101);
        b102=(RadioButton)findViewById(R.id.radioButton102);
        b103=(RadioButton)findViewById(R.id.radioButton103);
        b104=(RadioButton)findViewById(R.id.radioButton104);
        b105=(RadioButton)findViewById(R.id.radioButton105);
        b106=(RadioButton)findViewById(R.id.radioButton106);
        b107=(RadioButton)findViewById(R.id.radioButton107);
        b108=(RadioButton)findViewById(R.id.radioButton108);
        b109=(RadioButton)findViewById(R.id.radioButton109);
        b110=(RadioButton)findViewById(R.id.radioButton110);
        b111=(RadioButton)findViewById(R.id.radioButton111);
        b112=(RadioButton)findViewById(R.id.radioButton112);
        b113=(RadioButton)findViewById(R.id.radioButton113);
        b114=(RadioButton)findViewById(R.id.radioButton114);
        b115=(RadioButton)findViewById(R.id.radioButton115);
        b116=(RadioButton)findViewById(R.id.radioButton116);
        b117=(RadioButton)findViewById(R.id.radioButton117);
        b118=(RadioButton)findViewById(R.id.radioButton118);
        b119=(RadioButton)findViewById(R.id.radioButton119);
        b120=(RadioButton)findViewById(R.id.radioButton120);
        b121=(RadioButton)findViewById(R.id.radioButton121);
        b122=(RadioButton)findViewById(R.id.radioButton122);
        b123=(RadioButton)findViewById(R.id.radioButton123);
        b124=(RadioButton)findViewById(R.id.radioButton124);
        b125=(RadioButton)findViewById(R.id.radioButton125);
        b126=(RadioButton)findViewById(R.id.radioButton126);
        b127=(RadioButton)findViewById(R.id.radioButton127);
        b128=(RadioButton)findViewById(R.id.radioButton128);
        b129=(RadioButton)findViewById(R.id.radioButton129);
        b130=(RadioButton)findViewById(R.id.radioButton130);
        b131=(RadioButton)findViewById(R.id.radioButton131);
        b132=(RadioButton)findViewById(R.id.radioButton132);
        b133=(RadioButton)findViewById(R.id.radioButton133);
        b134=(RadioButton)findViewById(R.id.radioButton134);
        b135=(RadioButton)findViewById(R.id.radioButton135);
        b136=(RadioButton)findViewById(R.id.radioButton136);
        b137=(RadioButton)findViewById(R.id.radioButton137);
        b138=(RadioButton)findViewById(R.id.radioButton138);
        b139=(RadioButton)findViewById(R.id.radioButton139);
        b140=(RadioButton)findViewById(R.id.radioButton140);
        b141=(RadioButton)findViewById(R.id.radioButton141);
        b142=(RadioButton)findViewById(R.id.radioButton142);
        b143=(RadioButton)findViewById(R.id.radioButton143);
        b144=(RadioButton)findViewById(R.id.radioButton144);
        b145=(RadioButton)findViewById(R.id.radioButton145);
        b146=(RadioButton)findViewById(R.id.radioButton146);
        b147=(RadioButton)findViewById(R.id.radioButton147);
        b148=(RadioButton)findViewById(R.id.radioButton148);
        b149=(RadioButton)findViewById(R.id.radioButton149);
        b150=(RadioButton)findViewById(R.id.radioButton150);
        b151=(RadioButton)findViewById(R.id.radioButton151);
        b152=(RadioButton)findViewById(R.id.radioButton152);
        b153=(RadioButton)findViewById(R.id.radioButton153);
        b154=(RadioButton)findViewById(R.id.radioButton154);
        b155=(RadioButton)findViewById(R.id.radioButton155);
        b156=(RadioButton)findViewById(R.id.radioButton156);
        b157=(RadioButton)findViewById(R.id.radioButton157);
        b158=(RadioButton)findViewById(R.id.radioButton158);
        b159=(RadioButton)findViewById(R.id.radioButton159);
        b160=(RadioButton)findViewById(R.id.radioButton160);
        b161=(RadioButton)findViewById(R.id.radioButton161);
        b162=(RadioButton)findViewById(R.id.radioButton162);
        b163=(RadioButton)findViewById(R.id.radioButton163);
        b164=(RadioButton)findViewById(R.id.radioButton164);
        b165=(RadioButton)findViewById(R.id.radioButton165);
        b166=(RadioButton)findViewById(R.id.radioButton166);
        b167=(RadioButton)findViewById(R.id.radioButton167);
        b168=(RadioButton)findViewById(R.id.radioButton168);
        b169=(RadioButton)findViewById(R.id.radioButton169);
        b170=(RadioButton)findViewById(R.id.radioButton170);
        b171=(RadioButton)findViewById(R.id.radioButton171);
        b172=(RadioButton)findViewById(R.id.radioButton172);
        b173=(RadioButton)findViewById(R.id.radioButton173);
        b174=(RadioButton)findViewById(R.id.radioButton174);
        b175=(RadioButton)findViewById(R.id.radioButton175);
        b176=(RadioButton)findViewById(R.id.radioButton176);
        b177=(RadioButton)findViewById(R.id.radioButton177);
        b178=(RadioButton)findViewById(R.id.radioButton178);
        b179=(RadioButton)findViewById(R.id.radioButton179);
        b180=(RadioButton)findViewById(R.id.radioButton180);
        b181=(RadioButton)findViewById(R.id.radioButton181);
        b182=(RadioButton)findViewById(R.id.radioButton182);
        b183=(RadioButton)findViewById(R.id.radioButton183);
        b184=(RadioButton)findViewById(R.id.radioButton184);
        b185=(RadioButton)findViewById(R.id.radioButton185);
        b186=(RadioButton)findViewById(R.id.radioButton186);
    }
}
