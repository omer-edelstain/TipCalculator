package il.ac.huji.tipcalculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class TipCalculatorActivity extends ActionBarActivity {
    private final double TIP_PERCENTAGE = 12/100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tip_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void CalculateTip(View view) {
        //
        String strBillSum = ((EditText) findViewById(R.id.edtBillAmount)).getText().toString();
        if (strBillSum.replaceAll("\\s+","") == "")
        {
            AlertDialog.Builder alrtCalcBuilder = new AlertDialog.Builder(this);
            alrtCalcBuilder.setTitle("Tip calculator error");
            alrtCalcBuilder.setMessage("Must enter bill sum to execute tip calculation");

        }
        else
        {
            CheckBox chkShouldRoundControl = (CheckBox) findViewById(R.id.chkRound);
            double dblSum = Double.parseDouble(strBillSum);
            double dblResTip = dblSum * TIP_PERCENTAGE;
            dblResTip = chkShouldRoundControl.isChecked()? Math.round(dblResTip):dblResTip;
            TextView txtTipRes = (TextView) findViewById(R.id.txtTipResult);
            txtTipRes.setText(String.format("%s $%f",txtTipRes.getText().toString(),dblResTip));
        }

    }
}
