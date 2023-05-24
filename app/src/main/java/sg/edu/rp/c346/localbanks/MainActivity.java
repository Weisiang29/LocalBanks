package sg.edu.rp.c346.localbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView textDBS;
TextView textOCBC;
TextView textUOB;
    boolean English=true;
    String textClicked="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textDBS=findViewById(R.id.textDBS);
        textOCBC=findViewById(R.id.textOCBC);
        textUOB=findViewById(R.id.textUOB);
        registerForContextMenu(textDBS);
        registerForContextMenu(textOCBC);
        registerForContextMenu(textUOB);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.language_main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {

            textDBS.setText(this.getString(R.string.bankNameEng1));
            textOCBC.setText(this.getString(R.string.bankNameEng2));
            textUOB.setText(this.getString(R.string.bankNameEng3));
            English=true;
            return true;
        } else if (id == R.id.ChineseSelection) {
            textDBS.setText(this.getString(R.string.bankNameChi1));
            textOCBC.setText(this.getString(R.string.bankNameChi2));
            textUOB.setText(this.getString(R.string.bankNameChi3));
            English=false;

            return true;
        } else {
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();        }



        return super.onOptionsItemSelected(item);
    }
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v==textDBS){
            textClicked="DBS";
        }
        else if(v==textOCBC){
            textClicked="OCBC";
        }
        else if(v==textUOB){
            textClicked = "UOB";
        }
        getMenuInflater().inflate(R.menu.navigaton_main, menu);
    }

    public boolean onContextItemSelected(MenuItem item) {
        int id= item.getItemId();
        if (textClicked.equalsIgnoreCase("DBS")){
            if (id == R.id.WebsiteSelection) {
                String output = this.getString(R.string.bankUrl1);
                Intent intentCall= new Intent(Intent.ACTION_VIEW, Uri.parse(output));
                startActivity(intentCall);
                return true;
            } else if (id == R.id.DialSelection) {
                String text = this.getString(R.string.bankCNum1);
                long output=Long.parseLong(text);
                Intent intentCall= new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+output));
                startActivity(intentCall);

                return true;
            }
            else if (id==R.id.Favourite){
                String text= this.getString(R.string.bankNameEng1);
                SpannableString ss= new SpannableString(text);
                ForegroundColorSpan Red= new ForegroundColorSpan(Color.RED);
                if(id==R.id.EnglishSelection){
                    if(English==true){
                        ss.setSpan(Red,0,4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        textDBS.setText(ss);
                        textDBS.setTypeface(null, Typeface.BOLD);
                    }
                    else{
                        ss.setSpan(Red,0,4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        textDBS.setText(ss);

                    }
                }


            }


        }
        else if (textClicked.equalsIgnoreCase("OCBC")){
            if (id == R.id.WebsiteSelection) {
                String output = this.getString(R.string.bankUrl2);
                Intent intentCall= new Intent(Intent.ACTION_VIEW, Uri.parse(output));
                startActivity(intentCall);
                return true;
            } else if (id == R.id.DialSelection) {
                String text = this.getString(R.string.bankCNum2);
                long output=Long.parseLong(text);
                Intent intentCall= new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+output));
                startActivity(intentCall);

                return true;
            }
            else if (id==R.id.Favourite){
                String text= this.getString(R.string.bankNameEng2);
                SpannableString ss= new SpannableString(text);
                String text2=this.getString(R.string.bankNameChi2);
                SpannableString ss2= new SpannableString(text2);


                ForegroundColorSpan Red= new ForegroundColorSpan(Color.RED);
                if(English==true){
                    ss.setSpan(Red,0,4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    textOCBC.setText(ss);
                    textOCBC.setTypeface(null, Typeface.BOLD);
                }
                else{
                    ss.setSpan(Red,0,4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    textOCBC.setText(ss2);

                }

            }


        }
        else if (textClicked.equalsIgnoreCase("UOB")){
            if (id == R.id.WebsiteSelection) {
                String output = this.getString(R.string.bankUrl3);
                Intent intentCall= new Intent(Intent.ACTION_VIEW, Uri.parse(output));
                startActivity(intentCall);
                return true;
            } else if (id == R.id.DialSelection) {
                String text = this.getString(R.string.bankCNum3);
                long output=Long.parseLong(text);
                Intent intentCall= new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+output));
                startActivity(intentCall);

                return true;
            }
            else if (id==R.id.Favourite){
                String text= this.getString(R.string.bankNameEng3);
                SpannableString ss= new SpannableString(text);
                ForegroundColorSpan Red= new ForegroundColorSpan(Color.RED);
                if(English==true){
                    ss.setSpan(Red,0,4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    textOCBC.setText(ss);
                    textDBS.setTypeface(null, Typeface.BOLD);
                }
                else{
                    ss.setSpan(Red,0,4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    textOCBC.setText(ss);

                }

            }


        }

        return super.onContextItemSelected(item); //pass menu item to the superclass implementation

    }






}